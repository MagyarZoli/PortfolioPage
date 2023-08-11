package github.magyarzoli.PortfolioPage.repository;

import github.magyarzoli.PortfolioPage.domain.entity.Skill;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This interface extends the CrudRepository interface provided by Spring Data JPA. The CrudRepository interface
 * provides basic CRUD (Create, Read, Update, Delete) operations on entities.
 * This indicates that SkillRepository handles entities of type Skill, and the primary key of Skill is of type Long.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@Service
public interface SkillRepository
extends CrudRepository<Skill, Long> {

    /**
     * This method is an override of the {@code findAll()} method from the
     * {@link org.springframework.data.repository.CrudRepository CrudRepository} interface. It returns a list of all
     * skills in the repository.
     * @return      List of all skills in the repository.
     */
    @Override
    List<Skill> findAll();

    /**
     * This annotation is used to define a custom query using JPQL (Java Persistence Query Language). The query
     * retrieves all Skill entities and orders them by their description property in descending order.
     * This is a custom query method with dynamic sorting. It fetches the top N Skill entities based on the specified
     * {@link org.springframework.data.domain.PageRequest PageRequest} object, ordered by description in descending
     * order.
     * @param       pageRequest is within a chosen range.
     * @return      It fetches the top N Skill entities.
     */
    @Query("SELECT g FROM Skill g ORDER BY g.description DESC")
    List<Skill> findTopNByOrderByDescriptionDesc(PageRequest pageRequest);

    /**
     * This is a custom query method that retrieves a specific Skill entity by its description.
     * @param       description provided as an argument.
     * @return      Specific Skill entity.
     */
    Skill findByDescription(String description);
}