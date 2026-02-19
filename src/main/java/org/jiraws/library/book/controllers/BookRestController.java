package book.controllers;

import lombok.extern.slf4j.Slf4j;
import book.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/*  j'ai mis cette annotation pour que quand je lance le projet, le serveur lance le controller
    ma classe  sera considérée comme un controller par le serveur spring boot
 */
//couche présentation
@Slf4j
@RestController
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
    @GetMapping("/book")
    public String get(@RequestParam String bookName , @RequestParam Integer bookPages){

        log.info ( bookName );
        log.info ( String.valueOf ( bookPages) );

        String response = bookService.createBook ( bookName,bookPages );
        return response;
    }


}
