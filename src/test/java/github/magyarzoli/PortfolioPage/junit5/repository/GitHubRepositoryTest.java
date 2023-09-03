package github.magyarzoli.PortfolioPage.junit5.repository;

import github.magyarzoli.PortfolioPage.domain.entity.GitHubRepo;
import github.magyarzoli.PortfolioPage.repository.GitHubRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class GitHubRepositoryTest {

    @Autowired
    private GitHubRepository gitHubRepository;

    private GitHubRepo gitHubRepo;

    @BeforeEach
    public void setUp() {
        gitHubRepo = GitHubRepo.builder().name("Test").description("Description")
                .imageFolder("image").link("https://www.test.com/test/")
                .features("Features: ...").license("").build();
    }

    @Test
    public void saveAll() {
        GitHubRepo savedGitHubRepo = gitHubRepository.save(gitHubRepo);
        Assertions.assertThat(savedGitHubRepo).isNotNull();
        Assertions.assertThat(savedGitHubRepo.getId()).isGreaterThan(0);
    }

    @Test
    public void getAllTest() {
        int expected = gitHubRepository.findAll().size();
        gitHubRepository.save(gitHubRepo);
        List<GitHubRepo> gitHubRepos = gitHubRepository.findAll();
        assertThat(gitHubRepos).isNotNull();
        assertThat(gitHubRepos.size()).isGreaterThan(expected);
    }

    @Test
    public void findTopNByOrderByNameDesc() {
        gitHubRepository.save(gitHubRepo);
        List<GitHubRepo> gitHubRepos = gitHubRepository.findTopNByOrderByNameDesc(
                PageRequest.of(0, 3));
        assertThat(gitHubRepos).isNotNull();
    }

    @Test
    public void findByName() {
        gitHubRepository.save(gitHubRepo);
        GitHubRepo gitHubRepo = gitHubRepository.findByName("Test");
        assertThat(gitHubRepo).isNotNull();
    }
}