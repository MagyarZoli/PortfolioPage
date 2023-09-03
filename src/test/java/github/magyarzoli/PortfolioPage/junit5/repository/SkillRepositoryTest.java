package github.magyarzoli.PortfolioPage.junit5.repository;

import github.magyarzoli.PortfolioPage.domain.entity.Skill;
import github.magyarzoli.PortfolioPage.repository.SkillRepository;
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
class SkillRepositoryTest {

    @Autowired
    private SkillRepository skillRepository;

    private Skill skill;

    @BeforeEach
    public void setUp() {
        skill = Skill.builder().description("Test").build();
    }

    @Test
    public void saveAllTest() {
        Skill savedSkill = skillRepository.save(skill);
        assertThat(savedSkill).isNotNull();
        assertThat(savedSkill.getId()).isGreaterThan(0);
    }

    @Test
    public void getAllTest() {
        int expected = skillRepository.findAll().size();
        skillRepository.save(skill);
        List<Skill> skills = skillRepository.findAll();
        assertThat(skills).isNotNull();
        assertThat(skills.size()).isGreaterThan(expected);
    }

    @Test
    public void findTopNByOrderByDescriptionDescTest() {
        skillRepository.save(skill);
        List<Skill> skills = skillRepository.findTopNByOrderByDescriptionDesc(
                PageRequest.of(0, 3));
        assertThat(skills).isNotNull();
        assertThat(skills.size()).isEqualTo(3);
    }
}