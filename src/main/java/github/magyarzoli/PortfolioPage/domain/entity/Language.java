package github.magyarzoli.PortfolioPage.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Language. This class represents a programming language, with attributes related to the language name and the
 * GitHub repository associated with that language.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Language {

    /**
     * This annotation marks the id field as the primary key of the entity.
     * This annotation indicates that the id field will be generated automatically using an identity-based strategy.
     * This is commonly used for auto-incrementing primary keys in databases that support it.
     * This field represents the unique identifier for the language entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * This field represents the name of the programming language.
     */
    private String language;

    /**
     * This annotation establishes a many-to-one relationship between Language and GitHubRepo entities. It indicates
     * that a GitHubRepo can have multiple languages associated with it, but each language is associated with a single
     * GitHub repository. This field holds the reference to the GitHubRepo associated with the language.
     */
    @ManyToOne
    private GitHubRepo repo;
}