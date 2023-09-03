package github.magyarzoli.PortfolioPage.junit5.repository;

import github.magyarzoli.PortfolioPage.domain.entity.Author;
import github.magyarzoli.PortfolioPage.repository.AuthorRepository;
import org.assertj.core.api.Assertions;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    private Author author;

    @BeforeEach
    public void setUp() {
        author = Author.builder().name("Lorem Test").email("teste01@testmail.com")
                .phoneNumber("00 99 123 4567").about("My about...").image("image")
                .address("Country - City").build();
    }

    @Test
    public void saveAllTest() {
        Author savedAuthor = authorRepository.save(author);
        Assertions.assertThat(savedAuthor).isNotNull();
        Assertions.assertThat(savedAuthor.getId()).isGreaterThan(0);
    }

    @Test
    public void getAllTest() {
        int expected = authorRepository.findAll().size();
        authorRepository.save(author);
        List<Author> authors = authorRepository.findAll();
        assertThat(authors).isNotNull();
        assertThat(authors.size()).isGreaterThan(expected);
    }

    @Test
    public void findByNameTest() {
        authorRepository.save(author);
        Author newAuthor = authorRepository.findByName("Lorem Test");
        assertThat(newAuthor).isNotNull();
        MatcherAssert.assertThat(newAuthor.getName(), is(author.getName()));
    }
}