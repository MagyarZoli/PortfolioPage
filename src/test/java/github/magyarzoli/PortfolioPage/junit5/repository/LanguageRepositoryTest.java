package github.magyarzoli.PortfolioPage.junit5.repository;

import github.magyarzoli.PortfolioPage.domain.entity.Language;
import github.magyarzoli.PortfolioPage.repository.LanguageRepository;
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
class LanguageRepositoryTest {

    @Autowired
    private LanguageRepository languageRepository;

    private Language language;

    @BeforeEach
    public void setUp() {
        language = Language.builder().language("Test").build();
    }

    @Test
    public void saveAll() {
        Language savedLanguage = languageRepository.save(language);
        Assertions.assertThat(savedLanguage).isNotNull();
        Assertions.assertThat(savedLanguage.getId()).isGreaterThan(0);
    }

    @Test
    public void getAllTest() {
        int expected = languageRepository.findAll().size();
        languageRepository.save(language);
        List<Language> languages = languageRepository.findAll();
        assertThat(languages).isNotNull();
        assertThat(languages.size()).isGreaterThan(expected);
    }

    @Test
    public void findByRepoId() {
        languageRepository.save(language);
        List<Language> languages = languageRepository.findByRepoId(1L);
        assertThat(languages).isNotNull();
    }
}