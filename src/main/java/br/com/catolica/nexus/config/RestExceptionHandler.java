package br.com.catolica.nexus.config;
import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import br.com.catolica.nexus.Exception.RecursoNaoEncontrado;
import br.com.catolica.nexus.Exception.RegraDeNegocioException;

@ControllerAdvice

public class RestExceptionHandler {
    private record ErrorResponse(int status, String error, String message, Instant timestamp) {}

   @ExceptionHandler(RecursoNaoEncontrado.class)
    
    public ResponseEntity <ErrorResponse> handleRecursoNaoEncontrado(RecursoNaoEncontrado ex){
         ErrorResponse errorResponse = new ErrorResponse(
            HttpStatus.NOT_FOUND.value(), 
            "Recurso Não Encontrado",
            ex.getMessage(), 
            Instant.now()
        );
        
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RegraDeNegocioException.class)
    public ResponseEntity<ErrorResponse> handleRegraDeNegocio(RegraDeNegocioException ex) {
    
    ErrorResponse errorResponse = new ErrorResponse(
        HttpStatus.BAD_REQUEST.value(), // 400
        "Requisição Inválida",
        ex.getMessage(), 
        Instant.now()
    );
    
    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}