package org.jiraws.library.book.persistence;

import org.jiraws.library.book.model.BookEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

//couche persistance ou repository
@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {

    public BookEntity findByNameAndPages(String name, Integer pages);

    public BookEntity findByIsbn ( String isbn );
}
