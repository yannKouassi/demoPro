package book.persistence;

import book.model.BookEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

//couche persistance ou repository
@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {

    public BookEntity findByNameAndPages(String name, Integer pages);
}
