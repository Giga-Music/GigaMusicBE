package com.pnu.gigamusic.gigamusicbe.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionInterceptor {

    @ExceptionHandler(Exception.class)
    private String handleException(Exception e) {
        log.error(e.getMessage(), e);
        return e.getMessage();
    }

}
