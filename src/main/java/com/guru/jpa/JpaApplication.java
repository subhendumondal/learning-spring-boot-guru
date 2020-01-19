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
			Author eric = new Author("Eric", "Rowan");
			Author roman = new Author("Roman", "Reign");

			Publisher wwePublication = new Publisher("Tata McCgrawhill", "23 Basnta Nagar, Delhi NCR");
			publisherRepository.save(wwePublication);

			Book wwe = new Book("WWE Playback", "WWE0012", wwePublication);

			eric.getBooks().add(wwe);
			roman.getBooks().add(wwe);

			wwe.getAuthors().add(eric);
			wwe.getAuthors().add(roman);

			authorsRepository.save(eric);
			authorsRepository.save(roman);
			booksRepository.save(wwe);

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
