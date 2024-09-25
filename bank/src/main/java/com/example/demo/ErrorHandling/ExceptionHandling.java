package com.example.demo.ErrorHandling;

import com.example.demo.Response.CustomResponse;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandling{

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException e) {
        CustomResponse customResponse = new CustomResponse(
                HttpStatus.BAD_REQUEST.value(), e.getMessage(), null
        );
        return  ResponseEntity.badRequest().body(customResponse);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<?> handleException(Exception e) {

        CustomResponse customResponse = new CustomResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null
        );
        return  ResponseEntity.internalServerError().body(customResponse);
    }



//    @ExceptionHandler(UnauthorizedException.class) // Example of a custom exception
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    public ResponseEntity<?> handleUnauthorizedException(Exception e) {
//        CustomResponse customResponse = new CustomResponse(
//                HttpStatus.UNAUTHORIZED.value(), e.getMessage(), null
//        );
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(customResponse);
//    }
//
//    @ExceptionHandler(Exception.class) // Example of a custom exception
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseEntity<CustomResponse> handleNotFoundException(Exception e) {
//        CustomResponse customResponse = new CustomResponse(
//                HttpStatus.NOT_FOUND.value(), e.getMessage(), null
//        );
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customResponse);
//    }
//
//    @ExceptionHandler(Exception.class) // Example of a custom exception
//    @ResponseStatus(HttpStatus.CONFLICT)
//    public ResponseEntity<CustomResponse> handleConflictException(Exception e) {
//        CustomResponse customResponse = new CustomResponse(
//                HttpStatus.CONFLICT.value(), e.getMessage(), null
//        );
//        return ResponseEntity.status(HttpStatus.CONFLICT).body(customResponse);
//    }
//
//    @ExceptionHandler(Exception.class) // Example of a custom exception
//    @ResponseStatus(HttpStatus.FORBIDDEN)
//    public ResponseEntity<CustomResponse> handleForbiddenException(Exception e) {
//        CustomResponse customResponse = new CustomResponse(
//                HttpStatus.FORBIDDEN.value(), e.getMessage(), null
//        );
//        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(customResponse);
//    }
}
