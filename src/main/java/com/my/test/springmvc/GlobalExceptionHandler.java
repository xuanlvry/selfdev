package com.my.test.springmvc;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Chengfei.Sun on 17/03/07.
 */
//@ControllerAdvice
public class GlobalExceptionHandler {
//    @ExceptionHandler(value = {Exception.class})
    public ModelAndView handleException(Exception ex, HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("error");
    }
}
