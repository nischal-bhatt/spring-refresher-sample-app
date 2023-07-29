package nish.guru.boy.repositories;

import nish.guru.boy.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {

}
