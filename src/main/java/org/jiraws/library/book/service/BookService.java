package org.jiraws.library.book.service;

import io.micrometer.common.util.StringUtils;
import org.apache.coyote.BadRequestException;
import org.jiraws.library.book.model.BookEntity;
import org.jiraws.library.book.model.exception.BookCreationException;
import org.jiraws.library.book.persistence.BookRepository;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.Optional;

//couche métier
@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService ( BookRepository bookRepository )  {
        this.bookRepository = bookRepository;
    }

    public BookEntity createBook(String isbn, String bookName , Integer bookPages,Integer year,String description) throws BookCreationException{

        if ( isbn==null || StringUtils.isBlank ( isbn ) ){
            throw new BookCreationException ("L'isbn du livre est obligatoire");
        }
        if(!BookService.isValidIsbn13 ( isbn )){
            throw new BookCreationException ("L'isbn du livre est invalide");
        }

        if(bookName==null || StringUtils.isBlank ( bookName )){
            throw new BookCreationException ("Le nom du livre est obligatoire");
        }
        if(bookPages==null || bookPages<1 ){
            throw new BookCreationException ("Le nombre de pages du livre est obligatoire et ne doit etre inferieur a 0");
        }

        if(year==null || year >Year.now ().getValue () ){
            throw  new BookCreationException ( "L'année de parution du livre est obligatoire et doit etre inferieur a "+Year.now ().getValue ( ) );
        }

        // TODO : Update fetch method

            BookEntity existingBook= bookRepository.findByIsbn ( isbn );

            if(existingBook!=null) {
                throw  new BookCreationException ( "le livre existe déja" );

            }
            // TODO : Update creation
            BookEntity bookEntity = BookEntity.builder ( )
                    .isbn ( isbn )
                    .name ( bookName )
                    .pages ( bookPages )
                    .year ( year )
                    .description ( description )
                    .build ( );

            bookRepository.save ( bookEntity );

            return bookEntity ;


         }



    // TODO : Decommenter apres
    public static boolean isValidIsbn13(String isbn) {
        if (isbn == null) {
            return false;
        }

        // Supprimer tous les tirets
        String cleanIsbn = isbn.replaceAll("-", "");

        // Vérifier que la chaîne contient exactement 13 chiffres
        if (!cleanIsbn.matches("\\d{13}")) {
            return false;
        }

        return true;
    }

}
