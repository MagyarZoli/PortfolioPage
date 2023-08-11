package github.magyarzoli.PortfolioPage.repository;

import github.magyarzoli.PortfolioPage.domain.entity.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This interface extends the CrudRepository interface provided by Spring Data JPA. The CrudRepository interface
 * provides basic CRUD (Create, Read, Update, Delete) operations on entities.
 * This indicates that AuthorRepository handles entities of type {@code Author}, and the primary key of {@code Author}
 * is of type Long.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@Service
public interface AuthorRepository
extends CrudRepository<Author, Long> {

    /**
     * This method is an override of the {@code findAll()} method from the
     * {@link org.springframework.data.repository.CrudRepository CrudRepository} interface. It returns a list of all
     * authors in the repository.
     * @return list of all authors in the repository
     */
    @Override
    List<Author> findAll();

    /**
     * This method is a custom query method that retrieves an author by their name. Spring Data JPA will generate the
     * implementation for this method based on the method name.
     * @param       name {@code Author} name.
     * @return      Additional information about the author based on the searched author name.
     */
    Author findByName(String name);
}