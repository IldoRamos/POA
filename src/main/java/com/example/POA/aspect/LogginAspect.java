package com.example.POA.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    //Pointcut para todos os metodos de controller
    @Pointcut("within(com.example.POA.controller..*)")
    public  void controllerMethod(){}
    //Pointcut para todos os metodos de serviço
    @Pointcut("within(com.example.POA.service..*)")
    public void serviceMethod(){}

    //Advice que execute antes do metodo (Sucesso)
    @Before("controllerMethod() || serviceMethod()")
    public void logBefore(JoinPoint joinPoint){
        log.info("Iniciando execução de metodo: {} - arg: {}",
                joinPoint.getSignature().getName(), joinPoint.getArgs());
    }
    //Advice que executa depois do metodo (sucesso)
    @AfterReturning(pointcut = "controllerMethod() || serviceMethod()",
            returning = "resultado")
    public void logAfterReturning(JoinPoint joinPoint , Object resultado){
        log.info("Metodo: {} executado com sucesso - Retorno: {}" ,
                joinPoint.getSignature().getName(), resultado);
    }

    //Advice que executa quando ocorre uma exceção
    @AfterThrowing(pointcut = "controllerMethod() || serviceMethod()",
            throwing = "throwable")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable throwable){

        log.info("Exceção no metodo {} - Messagem: {}",
                joinPoint.getSignature().getName(), throwable.getMessage());
    }

}
