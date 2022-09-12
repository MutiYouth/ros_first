package com.weng.ros_first.ros_integrate.pkt.psi.impl;

import com.intellij.psi.util.PsiTreeUtil;
import com.weng.ros_first.ros_integrate.pkt.psi.ROSPktField;
import com.weng.ros_first.ros_integrate.pkt.psi.ROSPktFieldFrag;
import org.jetbrains.annotations.NotNull;
import com.weng.ros_first.ros_integrate.pkt.psi.ROSPktFieldBase;
import com.weng.ros_first.ros_integrate.pkt.psi.ROSPktSection;

import java.util.List;
import java.util.stream.Collectors;

/**
 * a utility class holding {@link ROSPktSection} implementations
 * @author Noam Dori
 */
class ROSPktSectionUtil {
    /**
     * gets all available (and valid) fields in this section.
     *
     * @param section          the section to search for fields
     * @param queryClass       the class of which to search. If limited to complete fields, use
     *                         {@link ROSPktField}
     *                         if fragments need be searched use {@link ROSPktFieldFrag}.
     *                         if you want both, use {@link com.weng.ros_first.ros_integrate.pkt.psi.ROSPktFieldBase}
     * @param includeConstants whether or not constant fields should be included
     * @return a list of all available fields in this section in textual order.
     */
    @NotNull
    static <T extends ROSPktFieldBase> List<T> getFields(ROSPktSection section, Class<T> queryClass,
                                                         boolean includeConstants) {
        List<T> ret = PsiTreeUtil.getChildrenOfTypeAsList(section, queryClass);
        if (includeConstants) {
            return ret;
        }
        return ret.stream().filter(field -> field.getConst() == null).collect(Collectors.toList());
    }
}
