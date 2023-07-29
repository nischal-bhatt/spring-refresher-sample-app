package nish.guru.boy.bootstrap;

import nish.guru.boy.domain.Author;
import nish.guru.boy.domain.Book;
import nish.guru.boy.domain.Publisher;
import nish.guru.boy.repositories.AuthorRepository;
import nish.guru.boy.repositories.BookRepository;
import nish.guru.boy.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("test");
        eric.setLastName("eric");

        Book ddd = new Book();
        ddd.setTitle("test123");
        ddd.setIsbn("asdsad");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("rod");
        rod.setLastName("rod");

        Book noEJB = new Book();
        noEJB.setIsbn("asdadadaddgfgg");
        noEJB.setTitle("4533");

        Author rodSaved = authorRepository.save(rod);
        Book noEjbsaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEjbsaved);
        dddSaved.getAuthors().add(ericSaved);
        noEjbsaved.getAuthors().add(rodSaved);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("12312321");
        publisher.setAddress("tete");
        Publisher publisher1 = publisherRepository.save(publisher);

        dddSaved.setPublisher(publisher1);
        noEjbsaved.setPublisher(publisher1);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(noEjbsaved);

        Book b = new Book();
        b.setTitle("aloha");
        Publisher p = new Publisher();
        p.setPublisherName("aad");
        Publisher save = publisherRepository.save(p);
        b.setPublisher(save);
        bookRepository.save(b);

        System.out.println("in bootstrap");
        System.out.println("authors" + authorRepository.count());
        System.out.println("books" + bookRepository.count());


        System.out.println(publisherRepository.count());
    }
}
