package github.magyarzoli.PortfolioPage.junit5.repository;

import github.magyarzoli.PortfolioPage.domain.entity.IconLink;
import github.magyarzoli.PortfolioPage.repository.IconLinkRepository;
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
class IconLinkRepositoryTest {

    @Autowired
    private IconLinkRepository iconLinkRepository;

    private IconLink iconLink;

    @BeforeEach
    public void setUp() {
        iconLink = IconLink.builder()
                .icon("Test").link("https://www.test.com/testlink/").build();
    }

    @Test
    public void saveAll() {
        IconLink savedIconLink = iconLinkRepository.save(iconLink);
        Assertions.assertThat(savedIconLink).isNotNull();
        Assertions.assertThat(savedIconLink.getId()).isGreaterThan(0);
    }

    @Test
    public void getAllTest() {
        int expected = iconLinkRepository.findAll().size();
        iconLinkRepository.save(iconLink);
        List<IconLink> iconLinks = iconLinkRepository.findAll();
        assertThat(iconLinks).isNotNull();
        assertThat(iconLinks.size()).isGreaterThan(expected);
    }

    @Test
    public void findTopNByOrderByIconDesc() {
        iconLinkRepository.save(iconLink);
        List<IconLink> iconLinks = iconLinkRepository.findTopNByOrderByIconDesc(
                PageRequest.of(0, 3));
        assertThat(iconLinks).isNotNull();
    }
}