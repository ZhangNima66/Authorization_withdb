package com.apkkids.config;


import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.intercept.aopalliance.MethodSecurityInterceptor;

@Configuration
public class InterceptorConfig {

    public static final String traceExecution = "execution(* com.apkkids.controller.HomeController.*(..))";


    @Autowired
    private MethodSecurityInterceptor methodSecurityInterceptor;
    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor() {
        //TracingInterceptor interceptor = new TracingInterceptor();
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(traceExecution);

        // 配置增强类advisor
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(pointcut);
        advisor.setAdvice(methodSecurityInterceptor);
        return advisor;
    }
}
