package com.scaler.projectservicejan31capstone.Exceptions;

import com.scaler.projectservicejan31capstone.DTO.ErrorDTO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NullPointerException.class)
    public ErrorDTO handleNullPointerException(){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setStatus("Failure");
        errorDTO.setMessage("Null Pointer Exception Occured");
        return errorDTO;

    }
}
