package github.magyarzoli.PortfolioPage.domain.entity;

import github.magyarzoli.ImageLoader;
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
public class GitHubRepo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String imageFolder;
    private String link;

    //@Column(columnDefinition = "TEXT")
    private String features;
    private String license;

    @ManyToOne
    private Author author;

    @OneToMany(mappedBy = "repo")
    private List<Example> example;

    @OneToMany(mappedBy = "repo")
    private List<Language> languages;

    public List<String> getImages() {
        return ImageLoader.loadImagesNameList(imageFolder);
    }

    public String getRepositoryImage() {
        for (String repositoryImage : ImageLoader.loadImagesNameList(imageFolder)) {
            if (repositoryImage.split("\\.")[0].equals("repository")) {
                return repositoryImage;
            }
        }
        return null;
    }

    public String shortImageFolder() {
        return imageFolder.split("/static")[1];
    }
}
