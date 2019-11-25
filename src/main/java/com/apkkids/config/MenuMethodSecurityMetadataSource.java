package com.apkkids.config;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.method.AbstractMethodSecurityMetadataSource;
import org.springframework.security.access.method.MethodSecurityMetadataSource;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Collection;

@Component
public class MenuMethodSecurityMetadataSource extends AbstractMethodSecurityMetadataSource implements MethodSecurityMetadataSource {

    public MenuMethodSecurityMetadataSource() {
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Method method, Class<?> aClass) {

        System.out.println("拦截————————————————");
        return SecurityConfig.createList("------------------------");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }
}
