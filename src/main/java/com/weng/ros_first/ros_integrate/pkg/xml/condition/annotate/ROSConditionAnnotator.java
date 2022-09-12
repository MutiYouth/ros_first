package com.weng.ros_first.ros_integrate.pkg.xml.condition.annotate;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import com.weng.ros_first.ros_integrate.pkg.xml.condition.intention.CleanItemQuickFix;
import com.weng.ros_first.ros_integrate.pkg.xml.condition.intention.PrependLogicQuickFix;
import com.weng.ros_first.ros_integrate.pkg.xml.condition.psi.ROSConditionExpr;
import com.weng.ros_first.ros_integrate.pkg.xml.condition.psi.ROSConditionItem;
import com.weng.ros_first.ros_integrate.pkg.xml.condition.psi.ROSConditionToken;

import java.util.List;

/**
 * an annotator enforcing rules within ROS conditions using annotations and intentions.
 * the rules are specified in REP 149: https://www.ros.org/reps/rep-0149.html
 * @author Noam Dori
 */
public class ROSConditionAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof ROSConditionExpr) {
            ROSConditionExpr expr = (ROSConditionExpr) element;
            int exprSequence = 0;
            List<ROSConditionToken> tokens = expr.getTokens();
            for (ROSConditionToken token : tokens) {
                if (token instanceof ROSConditionExpr) {
                    // the parser makes sure the conditions are only recognised as such in valid places.
                    exprSequence++;
                } else {
                    exprSequence = 0;
                }

                if (exprSequence > 1) {
                    holder.newAnnotation(HighlightSeverity.ERROR, "Expressions must be separated by logic operators or comparisons.")
                            .range(token)
                            .withFix(new PrependLogicQuickFix(expr, token))
                            .create();
                }
            }
        }
        if (element instanceof ROSConditionItem) {
            String text = element.getText();
            if (text.startsWith("$")) {
                if (!text.substring(1).replaceAll("[a-zA-Z0-9_]", "").isEmpty()) {
                    holder.newAnnotation(HighlightSeverity.ERROR, "Variables may only contain alphanumerics and underscores.")
                            .range(element)
                            .withFix(new CleanItemQuickFix(element))
                            .create();
                }
            } else {
                if (!text.replaceAll("[-a-zA-Z0-9_]", "").isEmpty()) {
                    holder.newAnnotation(HighlightSeverity.ERROR, "Literals may only contain alphanumerics, underscores, and dashes.")
                            .range(element)
                            .withFix(new CleanItemQuickFix(element))
                            .create();
                }
            }
        }
    }
}
