package com.example.registration.Exception;

import com.example.registration.Dto.ExceptionResponse;
import com.example.registration.Util.ResponseEnum;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GenericException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value= ResourceNotFoundException.class)
    public ResponseEntity<T> resourceNotFound(ResourceNotFoundException re){
        ExceptionResponse er = new ExceptionResponse(ResponseEnum.ResponseCode.NOT_FOUND.code(), re.getMessage(),new Date().toString());
        return new ResponseEntity(er, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<T> exception(Exception ex){
        ExceptionResponse er = new ExceptionResponse(ResponseEnum.ResponseCode.SERVER_ERROR.code(), ex.getMessage(),new Date().toString());
        return new ResponseEntity(er, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
