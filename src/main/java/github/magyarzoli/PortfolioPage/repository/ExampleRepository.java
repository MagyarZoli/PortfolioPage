package github.magyarzoli.PortfolioPage.repository;

import github.magyarzoli.PortfolioPage.domain.entity.Example;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This interface extends the CrudRepository interface provided by Spring Data JPA. The CrudRepository interface
 * provides basic CRUD (Create, Read, Update, Delete) operations on entities.
 * This indicates that ExampleRepository handles entities of type Example, and the primary key of Example is of
 * type Long.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@Service
public interface ExampleRepository 
extends CrudRepository<Example, Long> {

    /**
     * This method is an override of the {@code findAll()} method from the
     * {@link org.springframework.data.repository.CrudRepository CrudRepository} interface. It returns a list of all
     * examples in the repository.
     * @return      List of all examples in the repository.
     */
    @Override
    List<Example> findAll();

    /**
     * This is a custom query method. It fetches a list of Example entities based on the repoId provided as an argument.
     * @param       repoId provided as an argument.
     * @return      It fetches a list of Example entities.
     */
    List<Example> findByRepoId(Long repoId);
}