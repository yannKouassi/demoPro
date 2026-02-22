package org.jiraws.library.book.service;

import io.micrometer.common.util.StringUtils;
import org.apache.coyote.BadRequestException;
import org.jiraws.library.book.model.BookEntity;
import org.jiraws.library.book.model.exception.BookCreationException;
import org.jiraws.library.book.persistence.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

//couche métier
@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService ( BookRepository bookRepository )  {
        this.bookRepository = bookRepository;
    }

    public BookEntity createBook( String bookName , Integer bookPages) throws BookCreationException{

        if(bookName==null || StringUtils.isBlank ( bookName )){
            throw new BookCreationException ("Le nom du livre est obligatoire");
        }
        if(bookPages==null || bookPages<1 ){
            throw new BookCreationException ("Le nombre de pages du livre est obligatoire");
        }

            BookEntity existingBook= bookRepository.findByNameAndPages ( bookName , bookPages );

            if(existingBook!=null) {
                throw  new BookCreationException ( "le livre existe déja" );

            }

            BookEntity bookEntity = BookEntity.builder ( )
                    .name ( bookName )
                    .pages ( bookPages )
                    .build ( );

            bookRepository.save ( bookEntity );

            return bookEntity ;


         }
}
