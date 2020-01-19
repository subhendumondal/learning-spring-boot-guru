package com.guru.jpa;

import com.guru.jpa.model.Author;
import com.guru.jpa.model.Book;
import com.guru.jpa.model.Publisher;
import com.guru.jpa.repository.AuthorsRepository;
import com.guru.jpa.repository.BooksRepository;
import com.guru.jpa.repository.PublisherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(JpaApplication.class);

	@Autowired
	private AuthorsRepository authorsRepository;
	@Autowired
	private BooksRepository booksRepository;
	@Autowired
	private PublisherRepository publisherRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Hello World");

		try {
			Author seth = new Author("Seth", "Rolins");
			Author roman = new Author("Roman", "Reign");

			Publisher wwePublication = new Publisher("Tata McCgrawhill", "23 Basnta Nagar, Delhi NCR");
			publisherRepository.save(wwePublication);

			Book raw = new Book("Monday Night Raw", "WWE0011", wwePublication);
			Book smackdown = new Book("Smackdown Live", "WWE0012", wwePublication);

			seth.getBooks().add(raw);
			roman.getBooks().add(smackdown);

			raw.getAuthors().add(seth);
			smackdown.getAuthors().add(roman);

			authorsRepository.save(seth);
			authorsRepository.save(roman);
			booksRepository.save(raw);
			booksRepository.save(smackdown);

		}
		catch(NullPointerException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}

		logger.info("WWE Playback Insterted");
	}
}
