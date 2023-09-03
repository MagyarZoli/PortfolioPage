package github.magyarzoli.PortfolioPage.junit5.repository;

import github.magyarzoli.PortfolioPage.domain.entity.Example;
import github.magyarzoli.PortfolioPage.repository.ExampleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class ExampleRepositoryTest {

    @Autowired
    private ExampleRepository exampleRepository;

    private Example example;

    @BeforeEach
    public void setUp() {
        example = Example.builder().example("Example: ...").build();
    }

    @Test
    public void saveAll() {
        Example savedExample = exampleRepository.save(example);
        Assertions.assertThat(savedExample).isNotNull();
        Assertions.assertThat(savedExample.getId()).isGreaterThan(0);
    }

    @Test
    public void getAllTest() {
        int expected = exampleRepository.findAll().size();
        exampleRepository.save(example);
        List<Example> examples = exampleRepository.findAll();
        assertThat(examples).isNotNull();
        assertThat(examples.size()).isGreaterThan(expected);
    }

    @Test
    public void findByRepoId() {
        exampleRepository.save(example);
        List<Example> examples = exampleRepository.findByRepoId(1L);
        assertThat(examples).isNotNull();
    }
}