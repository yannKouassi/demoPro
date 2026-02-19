package book.service;

import book.model.BookEntity;
import book.persistence.BookRepository;
import org.springframework.stereotype.Service;
//couche métier
@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService ( BookRepository bookRepository ) {
        this.bookRepository = bookRepository;
    }

    public String createBook(String bookName , Integer bookPages){
            BookEntity existingBook= bookRepository.findByNameAndPages ( bookName , bookPages );



            if(existingBook==null) {

                BookEntity bookEntity = BookEntity.builder ( )
                        .name ( bookName )
                        .pages ( bookPages )
                        .build ( );

                bookRepository.save ( bookEntity );

                return "Le livre a été crée";

            }
            else {
                return "Le livre existe déja";
            }

    }
}
