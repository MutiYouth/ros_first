package com.weng.ros_first.ros_integrate.pkg.xml.ref;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.xml.XmlTag;
import org.jetbrains.annotations.NotNull;
import com.weng.ros_first.ros_integrate.pkg.ROSDepKeyCache;
import com.weng.ros_first.ros_integrate.pkg.psi.ROSPackage;
import com.weng.ros_first.ros_integrate.pkg.ref.ROSPackageReferenceBase;

import java.util.Optional;

/**
 * a class defining the references of {@link com.weng.ros_first.ros_integrate.pkg.xml.ROSPackageXml} to {@link ROSPackage} and its affiliated roots.
 * @author Noam Dori
 */
public class DependencyToPackageReference extends ROSPackageReferenceBase<XmlTag> {
    // note: myElement is the referencing element, and the result of resolve() is the original element (the file).

    /**
     * construct a new reference
     * @param element the referencing element.
     */
    public DependencyToPackageReference(@NotNull XmlTag element) {
        super(element, getTextRange(element));
        pkgName = element.getValue().getText();
    }

    @NotNull
    private static TextRange getTextRange(@NotNull XmlTag element) {
        return element.getValue().getTextRange().shiftLeft(element.getTextOffset());
    }

    @NotNull
    @Override
    protected Optional<ROSPackage> resolvePackage() {
        return super.resolvePackage().map(Optional::of).orElseGet(() -> Optional.ofNullable(myElement.getProject()
                .getService(ROSDepKeyCache.class).findKey(pkgName)));
    }
}
