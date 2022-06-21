package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectConfig {

    private Logger log = LoggerFactory.getLogger(AspectConfig.class);

    @Before(value = "execution(* com.example.demo.controller.HelloController.findByLang(..))")
    public void logStatementFindByLangBefore(JoinPoint joinPoint) {
        log.info("Executing finding a word language pair.");
    }

    @After(value = "execution(* com.example.demo.controller.HelloController.findByLang(..))")
    public void logStatementFindByLangAfter(JoinPoint joinPoint) {
        log.info("Complete execution of finding a word language pair.");
    }

    @Before(value = "execution(* com.example.demo.controller.HelloController.secureHello(..))")
    public void logStatementBeforeSecureHello(JoinPoint joinPoint) {
        log.info("Executing accessing a secure endpoint '/hello'.");
    }

    @After(value = "execution(* com.example.demo.controller.HelloController.secureHello (..))")
    public void logStatementAfterSecureHello(JoinPoint joinPoint) {
        log.info("Complete execution of accessing a secure endpoint '/hello'.");
    }

    @Before(value = "execution(* com.example.demo.controller.HtmlHelloController.getAdminPage(..))")
    public void logStatementBeforeAdmin(JoinPoint joinPoint) {
        log.info("Executing accessing admin page.");
    }

    @After(value = "execution(* com.example.demo.controller.HtmlHelloController.getAdminPage (..))")
    public void logStatementAfterAdmin(JoinPoint joinPoint) {
        log.info("Complete execution of accessing admin page.");
    }

    @Before(value = "execution(* com.example.demo.controller.HtmlHelloController.saveHello(..))")
    public void logStatementBeforeSave(JoinPoint joinPoint) {
        log.info("Executing saving word language pair.");
    }

    @After(value = "execution(* com.example.demo.controller.HtmlHelloController.saveHello (..))")
    public void logStatementAfterSave(JoinPoint joinPoint) {
        log.info("Complete execution of saving word language pair.");
    }
}
