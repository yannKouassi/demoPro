package org.jiraws.library.configuration;


import org.apache.coyote.BadRequestException;
import org.jiraws.library.book.model.exception.BookCreationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Gère toutes les exceptions génériques
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProblemDetail> catchAny( Exception ex) {
        // Crée le ProblemDetail avec le statut HTTP 500
        ProblemDetail pd = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        pd.setTitle("Erreur interne du serveur");
        pd.setDetail(ex.getMessage()); // détail de l'exception

        // Retourne la réponse avec ProblemDetail en body
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(pd);
    }


    @ExceptionHandler(BookCreationException.class)
    public ResponseEntity<ProblemDetail> catchBookCreation( BookCreationException ex) {
        // Crée le ProblemDetail avec le statut HTTP 500
        ProblemDetail pd = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pd.setDetail(ex.getMessage()); // détail de l'exception
        // Retourne la réponse avec ProblemDetail en body
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(pd);
    }
}