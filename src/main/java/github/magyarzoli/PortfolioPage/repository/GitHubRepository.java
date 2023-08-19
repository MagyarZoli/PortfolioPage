package github.magyarzoli.PortfolioPage.repository;

import github.magyarzoli.PortfolioPage.domain.entity.GitHubRepo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * This interface extends the CrudRepository interface provided by Spring Data JPA. The CrudRepository interface
 * provides basic CRUD (Create, Read, Update, Delete) operations on entities.
 * This indicates that GitHubRepository handles entities of type GitHubRepo, and the primary key of GitHubRepo is of
 * type Long.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
public interface GitHubRepository
extends CrudRepository<GitHubRepo, Long> {

    /**
     * This method is an override of the findAll() method from the
     * {@link org.springframework.data.repository.CrudRepository CrudRepository} interface. It returns a list of all
     * GitHub repositories in the repository.
     * @return       List of all GitHub repositories in the repository.
     */
    @Override
    List<GitHubRepo> findAll();

    /**
     * This annotation is used to define a custom query using JPQL (Java Persistence Query Language). The query
     * retrieves all GitHubRepo entities and orders them by their name property in descending order.
     * This is a custom query method with dynamic sorting. It fetches the top N GitHubRepo entities based on the
     * specified {@link org.springframework.data.domain.Pageable Pageable} object, ordered by name in descending order.
     * @param       pageable Limit setting based on the specified Pageable object.
     * @return      All GitHubRepo entities and orders them by their name property in descending order.
     */
    @Query("SELECT g FROM GitHubRepo g ORDER BY g.name DESC")
    List<GitHubRepo> findTopNByOrderByNameDesc(Pageable pageable);

    /**
     * This is a custom query method that retrieves a specific GitHubRepo entity by its name.
     * @param       name {@code GitHubRepo} name.
     * @return      Additional information about the GitHub based on the searched GitHubRepo name.
     */
    GitHubRepo findByName(String name);
}