package github.magyarzoli.PortfolioPage.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents a skill, with attributes related to the skill's description and the author who possesses the
 * skill.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Skill {

    /**
     * This annotation marks the id field as the primary key of the entity.
     * This annotation indicates that the id field will be generated automatically using an identity-based strategy.
     * This is commonly used for auto-incrementing primary keys in databases that support it.
     * This field represents the unique identifier for the skill entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * This field represents the description of the skill.
     */
    private String description;

    /**
     * This annotation establishes a many-to-one relationship between Skill and Author entities. It indicates that an
     * Author can have multiple skills, but each skill is associated with a single author.
     * This field holds the reference to the Author associated with the skill.
     */
    @ManyToOne
    private Author author;
}