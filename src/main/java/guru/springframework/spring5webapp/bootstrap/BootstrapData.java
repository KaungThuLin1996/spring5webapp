package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository ,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("Aung Myin");
        publisher.setCity("South Dagon");
        publisher.setState("Yangon");
        publisherRepository.save(publisher);
        System.out.println("Started in bootstrap");
        System.out.println("Number of Publishers: " + publisherRepository.count());

        Author sod = new Author("Shwe O", "Daung");
        Book tk = new Book("Three Knights", "123456");
        sod.getBooks().add(tk);
        tk.getAuthors().add(sod);
        tk.setPublisher(publisher);
        publisher.getBooks().add(tk);
        authorRepository.save(sod);
        bookRepository.save(tk);
//        publisherRepository.save(publisher);

        Author pmn = new Author("P Moe", "Nin");
        Book op_100 = new Book("Opportunities 100", "123457");
        pmn.getBooks().add(op_100);
        op_100.getAuthors().add(pmn);
        op_100.setPublisher(publisher);
        publisher.getBooks().add(op_100);
        authorRepository.save(pmn);
        bookRepository.save(op_100);

        publisherRepository.save(publisher);

        System.out.println("Number of templates: " + bookRepository.count());
        System.out.println("Publisher Issue Books: " + publisher.getBooks().size());

    }
}
