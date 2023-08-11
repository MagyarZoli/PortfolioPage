package github.magyarzoli.PortfolioPage.repository;

import github.magyarzoli.PortfolioPage.domain.entity.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This interface extends the CrudRepository interface provided by Spring Data JPA. The CrudRepository interface
 * provides basic CRUD (Create, Read, Update, Delete) operations on entities.
 * This indicates that LanguageRepository handles entities of type Language, and the primary key of Language is of
 * type Long.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@Service
public interface LanguageRepository
extends CrudRepository<Language, Long> {

    /**
     * This method is an override of the {@code findAll()} method from the
     * {@link org.springframework.data.repository.CrudRepository CrudRepository} interface. It returns a list of all
     * programming languages in the repository.
     * @return      List of all programming languages in the repository.
     */
    @Override
    List<Language> findAll();

    /**
     * This is a custom query method. It fetches a list of Language entities based on the repoId provided as an
     * argument.
     * @param       repoId provided as an argument.
     * @return      list of Language entities
     */
    List<Language> findByRepoId(Long repoId);
}