package com.yoyo.module2.selector;

import com.yoyo.module2.component.C;
import com.yoyo.module2.config.CConfiguration;
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
