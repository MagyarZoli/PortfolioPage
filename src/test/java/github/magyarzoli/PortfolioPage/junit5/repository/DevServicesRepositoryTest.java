package github.magyarzoli.PortfolioPage.junit5.repository;

import github.magyarzoli.PortfolioPage.domain.entity.DevServices;
import github.magyarzoli.PortfolioPage.repository.DevServicesRepository;
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
class DevServicesRepositoryTest {

    @Autowired
    private DevServicesRepository devServicesRepository;

    private DevServices devServices;

    @BeforeEach
    public void setUp() {
        devServices = DevServices.builder().title("Title").text("text ....")
                .icon("icon").build();
    }

    @Test
    public void saveAllTest() {
        DevServices savedDevServices = devServicesRepository.save(devServices);
        Assertions.assertThat(devServices).isNotNull();
        Assertions.assertThat(devServices.getId()).isGreaterThan(0);
    }

    @Test
    public void getAllTest() {
        int expected = devServicesRepository.findAll().size();
        devServicesRepository.save(devServices);
        List<DevServices> devServices1 = devServicesRepository.findAll();
        assertThat(devServices1).isNotNull();
        assertThat(devServices1.size()).isGreaterThan(expected);
    }

    @Test
    public void findTopNByOrderByTitleDescTest() {
        devServicesRepository.save(devServices);
        List<DevServices> devServices1 = devServicesRepository.findTopNByOrderByTitleDesc(
                PageRequest.of(0, 3));
        assertThat(devServices1).isNotNull();
    }
}