package github.magyarzoli.PortfolioPage.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Author. This class represents an author or developer, with various attributes related to their personal information,
 * skills, repositories, and more.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {

    /**
     * This annotation marks the id field as the primary key of the entity.
     * This annotation indicates that the id field will be generated automatically using an identity-based strategy.
     * This is commonly used for auto-incrementing primary keys in databases that support it.
     * This field represents the unique identifier for the author entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * This field represents the name of the author.
     */
    private String name;

    /**
     * This field represents the email address of the author.
     */
    private String email;

    /**
     * This field represents the phone number of the author.
     */
    private String phoneNumber;

    /**
     * This field represents a brief description or bio of the author.
     */
    private String about;

    /**
     * This field represents the image associated with the author.
     */
    private String image;

    /**
     * This field represents the address of the author.
     */
    private String address;

    /**
     * This annotation establishes one-to-many relationships between Author and other entity classes such as
     * GitHubRepo, Skill, DevServices, and IconLink. This field holds a list of references to the repositories
     * associated with the author.
     */
    @OneToMany(mappedBy = "author")
    private List<GitHubRepo> repos;

    /**
     * This annotation establishes one-to-many relationships between Author and other entity classes such as
     * GitHubRepo, Skill, DevServices, and IconLink. This field holds a list of references to the skills
     * associated with the author.
     */
    @OneToMany(mappedBy = "author")
    private List<Skill> skills;

    /**
     * This annotation establishes one-to-many relationships between Author and other entity classes such as
     * GitHubRepo, Skill, DevServices, and IconLink. This field holds a list of references to the development services
     * associated with the author.
     */
    @OneToMany(mappedBy = "author")
    private List<DevServices> devServices;

    /**
     * This annotation establishes one-to-many relationships between Author and other entity classes such as
     * GitHubRepo, Skill, DevServices, and IconLink. This field holds a list of references to the icon links
     * associated with the author.
     */
    @OneToMany(mappedBy = "author")
    private List<IconLink> iconLinks;
}