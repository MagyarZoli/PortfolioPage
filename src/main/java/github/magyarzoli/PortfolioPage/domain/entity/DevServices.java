package github.magyarzoli.PortfolioPage.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DevServices. This class represents a development service, possibly associated with an author.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DevServices {

    /**
     * This annotation marks the id field as the primary key of the entity.
     * This annotation indicates that the id field will be generated automatically using an identity-based strategy.
     * This is commonly used for auto-incrementing primary keys in databases that support it.
     * This field represents the unique identifier for the development service entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * This field represents the title of the development service.
     */
    private String title;

    /**
     * This field represents the text or description of the development service.
     */
    private String text;

    /**
     * This field represents the icon associated with the development service.
     */
    private String icon;

    /**
     * This annotation establishes a many-to-one relationship between DevServices and Author entities. It indicates
     * that an Author can have multiple development services, but each development service is associated with a single
     * author. This field holds the reference to the Author associated with the development service.
     */
    @ManyToOne
    private Author author;
}