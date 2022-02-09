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
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private PublisherRepository publisherRepository;

	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		Publisher tmh=new Publisher("Tata McGraw Hill","Clark Street","Mumbai","Maharashtra","268932");
		publisherRepository.save(tmh);

		Author eric=new Author("Eric","Evans");
		Book ddd=new Book("Domain Driven Design","12133");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);

		ddd.setPublisher(tmh);
		tmh.getBooks().add(ddd);
		authorRepository.save(eric);
		bookRepository.save(ddd);
		publisherRepository.save(tmh);


		Author rod=new Author("Rod","Johnson");
		Book noEJB=new Book("J2EE development without EJB","656526526");
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		noEJB.setPublisher(tmh);
		tmh.getBooks().add(noEJB);
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		publisherRepository.save(tmh);

		System.out.println("Started in Bootstrap");
		System.out.println("Number of Books:"+bookRepository.count());
		System.out.println("Publisher's Number of Books:"+tmh.getBooks().size());
	}
}
