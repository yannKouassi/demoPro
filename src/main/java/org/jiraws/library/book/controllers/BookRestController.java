package org.jiraws.library.book.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.jiraws.library.book.dto.BookDTO;
import org.jiraws.library.book.model.BookEntity;
import org.jiraws.library.book.model.exception.BookCreationException;
import org.jiraws.library.book.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


/*  j'ai mis cette annotation pour que quand je lance le projet, le serveur lance le controller
    ma classe  sera considérée comme un controller par le serveur spring boot
 */
//couche présentation


@Slf4j
@RestController
@RequestMapping("/book")
public class BookRestController {

    private final BookService bookService;

    public BookRestController ( BookService bookService ) {
        this.bookService = bookService;
    }

    /*  pour acceder à mon endpoint(point d’accès pour acceder à l'URL)
     *  GET pour la lecture
    * POST pour la creation
    * PUT pour la modification
    * DELETE pour la suppression
     */
    @GetMapping
    public String get(@RequestParam String bookName , @RequestParam Integer bookPages){

       return "OK GET";
    }



    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public  BookDTO.PostOutput post( @Valid @RequestBody BookDTO.PostInput input ) throws BookCreationException {

        // TODO : Update creat book method

        log.info ( input.toString ( ) );
        log.info ( String.valueOf ( input.getBookPages ( )) );
        log.info ( String.valueOf ( input.getYear ( )) );
        log.info ( String.valueOf ( input.getDescription ( )) );
        log.info ( String.valueOf ( input.getIsbn ( )) );
        log.info ( String.valueOf ( input.getBookName ( )) );


        // TODO : Update Getter issues
        BookEntity bookEntity= bookService.createBook (input.getIsbn (), input.getBookName () ,input.getBookPages () ,input.getYear (),input.getDescription () );

        return BookDTO.PostOutput
                .builder ()
                .bookId ( bookEntity.getId () )
                .bookIsbn ( bookEntity.getIsbn () )
                .bookName ( bookEntity.getName () )
                .bookPages ( bookEntity.getPages () )
                .bookYear ( bookEntity.getYear () )
                .bookDescription ( bookEntity.getDescription () )
                .build () ;




    }


}
