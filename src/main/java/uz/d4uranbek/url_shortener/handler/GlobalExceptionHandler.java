package uz.d4uranbek.url_shortener.handler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import uz.d4uranbek.url_shortener.dto.AppError;

/**
 * @author D4uranbek
 * @since 08.08.2022
 */
@RestControllerAdvice( "uz.d4uranbek.url_shortener" )
public class GlobalExceptionHandler {

    @ExceptionHandler( { Exception.class } )
    public ResponseEntity<AppError> exceptionHandler( Exception e, WebRequest request ) {
        return new ResponseEntity<>( AppError.builder()
                .message( e.getMessage() )
                .request( request )
                .status( HttpStatus.INTERNAL_SERVER_ERROR )
                .build(), HttpStatus.INTERNAL_SERVER_ERROR );
    }

}
