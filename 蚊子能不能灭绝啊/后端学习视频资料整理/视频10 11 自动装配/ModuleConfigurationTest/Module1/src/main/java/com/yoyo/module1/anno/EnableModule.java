package com.yoyo.module1.anno;

import com.yoyo.module1.registrar.DRegistrar;
import com.yoyo.module1.selector.CImportSelector;
import com.yoyo.module1.component.A;
import com.yoyo.module1.config.BConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({A.class, BConfiguration.class, CImportSelector.class, DRegistrar.class})
public @interface EnableModule {
}
