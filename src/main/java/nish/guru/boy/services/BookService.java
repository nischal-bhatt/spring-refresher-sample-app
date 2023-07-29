package nish.guru.boy.services;

import nish.guru.boy.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
