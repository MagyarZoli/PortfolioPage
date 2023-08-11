package github.magyarzoli.PortfolioPage.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phoneNumber;
    private String about;
    private String image;
    private String address;

    @OneToMany(mappedBy = "author")
    private List<GitHubRepo> repos;

    @OneToMany(mappedBy = "author")
    private List<Skill> skills;

    @OneToMany(mappedBy = "author")
    private List<DevServices> devServices;

    @OneToMany(mappedBy = "author")
    private List<IconLink> iconLinks;
}