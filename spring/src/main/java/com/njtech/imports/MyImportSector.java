package com.njtech.imports;

import com.njtech.beans.OtherBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class MyImportSector implements ImportSelector {
    @Override
    //参数叫注解媒体数组，改对象内部封装的是当前使用了@Import注解的类上的其他注解的元信息
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        //每一个注解对应多个属性名和属性值
        Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(ComponentScan.class.getName());
//        annotationAttributes.forEach((key,value)->{
//            System.out.println(key+"----"+value);
//        });
        String[] basePackages = (String[]) annotationAttributes.get("basePackages");
        for (String basePackage : basePackages) {
            System.out.println(basePackage);
        }

//        for (String s : annotationAttributes.keySet()) {
//            System.out.println(s+"---"+annotationAttributes.get(s));
//        }

        //返回的数组封装是需要被注册到spring容器中的Bean全限定名
        return new String[]{
                OtherBean.class.getName()
        };
    }
}
