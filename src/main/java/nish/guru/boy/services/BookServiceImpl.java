package nish.guru.boy.services;

import nish.guru.boy.domain.Book;
import nish.guru.boy.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository  bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return this.bookRepository.findAll();
    }
}
