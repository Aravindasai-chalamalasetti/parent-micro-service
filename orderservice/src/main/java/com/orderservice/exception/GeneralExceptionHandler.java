package com.orderservice.exception;

import com.orderservice.dto.ExceptionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(ExceptionDTO.class)
    public ResponseEntity<ExceptionDTO> handleGeneralException(ExceptionDTO ex){
        ExceptionDTO exc = new ExceptionDTO();
        exc.setDate(ex.getDate());
        exc.setStatus(ex.getStatus());
        exc.setCustomMessage(ex.getCustomMessage());
        exc.setCustomBody(ex.getCustomBody());
        return new ResponseEntity<>(exc,exc.getStatus());
    }
}
