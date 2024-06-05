package com.yoyo.module2.anno;

import com.yoyo.module2.component.A;
import com.yoyo.module2.config.BConfiguration;
import com.yoyo.module2.registrar.DRegistrar;
import com.yoyo.module2.selector.CImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({ BConfiguration.class, CImportSelector.class, DRegistrar.class})
public @interface EnableModule {
}
