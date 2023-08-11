package github.magyarzoli.PortfolioPage.repository;

import github.magyarzoli.PortfolioPage.domain.entity.IconLink;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This interface extends the CrudRepository interface provided by Spring Data JPA. The CrudRepository interface
 * provides basic CRUD (Create, Read, Update, Delete) operations on entities.
 * This indicates that IconLinkRepository handles entities of type IconLink, and the primary key of IconLink is of
 * type Long.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@Service
public interface IconLinkRepository
extends CrudRepository<IconLink, Long> {

    /**
     * This method is an override of the {@code findAll()} method from the
     * {@link org.springframework.data.repository.CrudRepository CrudRepository} interface. It returns a list of all
     * icon links in the repository.
     * @return      List of all icon links in the repository.
     */
    @Override
    List<IconLink> findAll();

    /**
     * This annotation is used to define a custom query using JPQL (Java Persistence Query Language). The query
     * retrieves all IconLink entities and orders them by their icon property in descending order.
     * This is a custom query method with dynamic sorting. It fetches the top N IconLink entities based on the specified
     * {@link org.springframework.data.domain.PageRequest PageRequest} object, ordered by icon in descending order.
     * @param       pageRequest is within a chosen range.
     * @return      It fetches the top N IconLink entities.
     */
    @Query("SELECT g FROM IconLink g ORDER BY g.icon DESC")
    List<IconLink> findTopNByOrderByIconDesc(PageRequest pageRequest);
}