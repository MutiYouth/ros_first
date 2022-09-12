package com.weng.ros_first.ros_integrate.cmake.ref;

import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;
import com.weng.ros_first.ros_integrate.cmake.CMakeClasses;
import com.weng.ros_first.ros_integrate.pkg.ROSPackageManager;
import com.weng.ros_first.ros_integrate.pkg.psi.ROSPackage;

import java.util.Objects;

public class ROSCmakeReferenceContributor extends PsiReferenceContributor {
    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(CMakeClasses.getCMakeArgClass()),
                new PsiReferenceProvider() {
            @NotNull
            @Override
            public PsiReference [] getReferencesByElement(@NotNull PsiElement element,
                                                                   @NotNull ProcessingContext context) {
                // check if the file this element is part of is part of a package, and promptly check if the file
                // is a CMakeLists.txt file
                if (!element.getContainingFile().getName().equals("CMakeLists.txt")) {
                    return PsiReference.EMPTY_ARRAY;
                }
                if (element.getProject().getService(ROSPackageManager.class).getAllPackages()
                        .stream().anyMatch(pkg -> Objects.equals(pkg.getRoot(ROSPackage.RootType.SHARE),
                                element.getContainingFile().getParent()))) {
                    // check if this is a "project" command then convert it to a reference somehow
                    // platform independent way to check this is a project command
                    if ("project".equals(element.getParent().getParent().getFirstChild().getText())) {
                        return new PsiReference[]{new ROSCmakeToPackageReference(element)};
                    }
                }
                return PsiReference.EMPTY_ARRAY;
            }
        });
    }
}