package com.njtech.anno;

import com.njtech.imports.MyImportDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//运行时仍可通过反射读取
@Target({ElementType.TYPE})//表示作用范围 可以放到类、接口、枚举、注解上
@Import(MyImportDefinitionRegistrar.class)
public @interface MyMapperScan {
}
