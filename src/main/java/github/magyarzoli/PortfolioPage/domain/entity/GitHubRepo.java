package github.magyarzoli.PortfolioPage.domain.entity;

import github.magyarzoli.ImageLoader;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * GitHubRepo, which represents a GitHub repository and its associated information. This class contains various
 * attributes and methods related to a GitHub repository.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GitHubRepo {

    /**
     * This annotation marks the id field as the primary key of the entity.
     * This annotation indicates that the id field will be generated automatically using an identity-based strategy.
     * This is commonly used for auto-incrementing primary keys in databases that support it.
     * This field represents the unique identifier for the GitHub repository entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * This field represents the name of the GitHub repository.
     */
    private String name;

    /**
     * This field represents the description of the GitHub repository.
     */
    private String description;

    /**
     * This field represents the folder path where repository images are stored.
     */
    private String imageFolder;

    /**
     * This field represents the link to the GitHub repository.
     */
    private String link;

    /**
     * This field represents the features of the GitHub repository.
     */
    //@Column(columnDefinition = "TEXT")
    private String features;

    /**
     * This field represents the license associated with the GitHub repository.
     */
    private String license;

    /**
     * This annotation establishes a many-to-one relationship between GitHubRepo and Author entities. It indicates
     * that an Author can have multiple GitHub repositories, but each GitHub repository is associated with a
     * single author. This field holds the reference to the Author associated with the GitHub repository.
     */
    @ManyToOne
    private Author author;

    /**
     * This annotation establishes a one-to-many relationship between GitHubRepo and Example entities. It indicates
     * that a GitHubRepo can have multiple associated examples. This field holds a list of references to the
     * associated examples.
     */
    @OneToMany(mappedBy = "repo")
    private List<Example> example;

    /**
     * This annotation establishes a one-to-many relationship between GitHubRepo and Language entities. It indicates
     * that a GitHubRepo can have multiple associated languages. This field holds a list of references to the
     * associated languages.
     */
    @OneToMany(mappedBy = "repo")
    private List<Language> languages;

    /**
     * getImages() method is defined within the GitHubRepo entity class. This method is used to retrieve a list of
     * image names associated with the repository's image folder.
     * <ul>
     *     <li>This line invokes the {@code loadImagesNameList} method from the {@code ImageLoader} class, passing the
     *     {@code imageFolder} attribute of the current GitHubRepo instance. This method presumably loads and returns
     *     a list of image names associated with the specified image folder.</li>
     *     <li>This line returns the list of image names obtained from the {@code ImageLoader.loadImagesNameList}
     *     method call.</li>
     * </ul>
     * {@code getImages()} method is used to retrieve a list of image names associated with the repository's image
     * folder. This method allows you to access the names of images related to the repository, which can be useful
     * for displaying images on a user interface or for other purposes in your application. The actual implementation
     * and behavior of the ImageLoader class, including the method loadImagesNameList, would determine how the list of
     * image names is obtained and how images are loaded.
     * @return      List of image names associated with the repository's image folder.
     * @see         github.magyarzoli.ImageLoader#loadImagesNameList(String) loadImagesNameList(String)
     */
    public List<String> getImages() {
        return ImageLoader.loadImagesNameList(imageFolder);
    }

    /**
     * {@code getRepositoryImage()} method is defined within the GitHubRepo entity class. This method aims to retrieve
     * the image representing the repository by iterating through a list of image names obtained from the
     * {@code ImageLoader.loadImagesNameList(imageFolder)} method call.
     * <ul>
     *     <li> This line invokes the {@code loadImagesNameList} method from the {@code ImageLoader} class, passing the
     *     {@code imageFolder} attribute of the current GitHubRepo instance. This method presumably loads and returns a
     *     list of image names associated with the specified image folder.</li>
     *     <li>This loop iterates through each image name in the list obtained from the previous step.</li>
     *     <li>Inside the loop, this condition checks if the image name's prefix (before the dot) is equal to
     *     "repository". This suggests that the method is looking for an image with a specific naming pattern,
     *     likely related to representing the repository itself.</li>
     *     <li>If the condition is met (i.e., an image with the specified prefix is found), the method returns the
     *     name of that image.</li>
     *     <li>If no image with the specified prefix is found in the loop, the method returns null.</li>
     * </ul>
     * {@code getRepositoryImage()} method is used to retrieve the name of an image associated with the repository,
     * where the image's filename starts with "repository". This image is presumably intended to represent the
     * repository visually. If such an image is found, its name is returned; otherwise, null is returned. The actual
     * implementation and behavior of the ImageLoader class, including the method loadImagesNameList, would determine
     * how the list of image names is obtained and how images are loaded.
     * @return      If the condition is met (i.e., an image with the specified prefix is found),
     *              the method returns the name of that image.
     * @see         github.magyarzoli.ImageLoader#loadImagesNameList(String) loadImagesNameList(String)
     */
    public String getRepositoryImage() {
        for (String repositoryImage : ImageLoader.loadImagesNameList(imageFolder)) {
            if (repositoryImage.split("\\.")[0].equals("repository")) {
                return repositoryImage;
            }
        }
        return null;
    }

    /**
     * {@code shortImageFolder()} method is defined within the GitHubRepo entity class. This method is used to extract
     * a portion of the imageFolder path by removing the prefix "/static".
     * <ul>
     *     <li>This line splits the {@code imageFolder} string using "/static" as the delimiter. The result is an
     *     array of strings containing two parts: the part before "/static" and the part after "/static".</li>
     *     <li>This index is used to access the second part of the split array, which is the portion of the
     *     {@code imageFolder} string after "/static".</li>
     *     <li>This line returns the portion of the {@code imageFolder} string that comes after "/static". This
     *     effectively removes the "/static" prefix from the image folder path.</li>
     * </ul>
     * {@code shortImageFolder()} method is used to obtain a modified version of the imageFolder path by removing the
     * "/static" prefix. The returned string can be used to reference image files without the "/static" part. This
     * method can be particularly useful when constructing URLs for serving static content in web applications.
     * @return
     */
    public String shortImageFolder() {
        return imageFolder.split("/static")[1];
    }
}