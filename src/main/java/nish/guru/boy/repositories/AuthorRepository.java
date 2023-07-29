package nish.guru.boy.repositories;

import nish.guru.boy.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
