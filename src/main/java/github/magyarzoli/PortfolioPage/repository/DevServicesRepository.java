package github.magyarzoli.PortfolioPage.repository;

import github.magyarzoli.PortfolioPage.domain.entity.DevServices;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This interface extends the CrudRepository interface provided by Spring Data JPA. The CrudRepository interface
 * provides basic CRUD (Create, Read, Update, Delete) operations on entities.
 * This indicates that DevServicesRepository handles entities of type {@code DevServices}, and the primary key of
 * {@code DevServices} is of type Long.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@Service
public interface DevServicesRepository
extends CrudRepository<DevServices, Long> {

    /**
     * This method is an override of the {@code findAll()} method from the
     * {@link org.springframework.data.repository.CrudRepository CrudRepository} interface. It returns a list of all
     * development services in the repository.
     * @return      List of all development services in the repository.
     */
    @Override
    List<DevServices> findAll();

    /**
     * This annotation is used to define a custom query using JPQL (Java Persistence Query Language). The query
     * retrieves all {@code DevServices} entities and orders them by their title property in descending order.
     * This is a custom query method with a dynamic sorting feature. It fetches the top N {@code DevServices} entities
     * based on the specified {@link org.springframework.data.domain.Pageable Pageable} object, ordered by title in
     * descending order.
     * @param       pageable Limit setting based on the specified Pageable object.
     * @return      It fetches the top N DevServices entities
     */
    @Query("SELECT g FROM DevServices g ORDER BY g.title DESC")
    List<DevServices> findTopNByOrderByTitleDesc(Pageable pageable);
}