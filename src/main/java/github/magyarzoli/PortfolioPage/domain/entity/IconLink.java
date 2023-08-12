package github.magyarzoli.PortfolioPage.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * IconLink. This class represents a link with an associated icon, possibly related to an author.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IconLink {

    /**
     * This annotation marks the id field as the primary key of the entity.
     * This annotation indicates that the id field will be generated automatically using an identity-based strategy.
     * This is commonly used for auto-incrementing primary keys in databases that support it.
     * This field represents the unique identifier for the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * This field represents the URL link associated with the icon.
     */
    private String link;

    /**
     * This field represents the icon associated with the link.
     */
    private String icon;

    /**
     * This annotation establishes a many-to-one relationship between IconLink and Author entities. It indicates that
     * an Author can have multiple icon links, but each icon link is associated with a single author.
     * This field holds the reference to the Author associated with the icon link.
     */
    @ManyToOne
    private Author author;
}