package github.magyarzoli.PortfolioPage.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Example. This class represents an example, possibly associated with a GitHub repository.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Example {

    /**
     * This annotation marks the id field as the primary key of the entity.
     * This annotation indicates that the id field will be generated automatically using an identity-based strategy.
     * This is commonly used for auto-incrementing primary keys in databases that support it.
     * This field represents the unique identifier for the example entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * This field represents the example itself.
     */
    private String example;

    /**
     * This annotation establishes a many-to-one relationship between Example and GitHubRepo entities. It indicates
     * that a GitHubRepo can have multiple examples associated with it, but each example is associated with a single
     * GitHub repository. This field holds the reference to the GitHubRepo associated with the example.
     */
    @ManyToOne
    private GitHubRepo repo;
}