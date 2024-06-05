package com.yoyo.module1.selector;

import com.yoyo.module1.component.C;
import com.yoyo.module1.config.CConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class CImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
            C.class.getName(), CConfiguration.class.getName()
        };
    }
}
