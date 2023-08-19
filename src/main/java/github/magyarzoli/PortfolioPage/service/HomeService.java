package github.magyarzoli.PortfolioPage.service;

import github.magyarzoli.PortfolioPage.domain.entity.*;
import github.magyarzoli.PortfolioPage.domain.properties.*;
import github.magyarzoli.PortfolioPage.repository.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class part of a larger application and is responsible for interacting with various repositories to retrieve
 * data related to a home or portfolio page. {@link lombok.Data @Data} Lombok library, generates methods like
 * {@code toString()}, {@code equals()}, {@code hashCode()}, and getters and setters for all fields in the class.
 * {@link org.springframework.stereotype.Service @Service} class is a Spring service component and should be
 * automatically discovered by Spring's component scanning.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@Data
@Service
public class HomeService {

    /**
     * GitHubRepository handles entities of type GitHubRepo.
     */
    private GitHubRepository gitHubRepository;

    /**
     * AuthorRepository handles entities of type Author.
     */
    private AuthorRepository authorRepository;

    /**
     * SkillRepository handles entities of type Skill.
     */
    private SkillRepository skillRepository;

    /**
     * DevServicesRepository handles entities of type DevServices.
     */
    private DevServicesRepository devServicesRepository;

    /**
     * IconLinkRepository handles entities of type IconLink.
     */
    private IconLinkRepository iconLinkRepository;

    /**
     * ExampleRepository handles entities of type Example.
     */
    private ExampleRepository exampleRepository;

    /**
     * LanguageRepository handles entities of type Language.
     */
    private LanguageRepository languageRepository;

    /**
     * In properties related to text content on a homepage.
     */
    private Home home;

    /**
     * In properties related to navigation bar items.
     */
    private Navbar navbar;

    /**
     * In the properties related to button labels.
     */
    private Button button;

    /**
     * In properties related to contact form fields.
     */
    private Contact contact;

    /**
     * Properties related to different greetings for different times of the day.
     */
    private Greet greet;

    /**
     * Spring will inject these property values into the corresponding fields in the Values class.
     */
    private Values propertiesValues;

    /**
     * {@link org.springframework.beans.factory.annotation.Autowired @Autowired}, which means that Spring will
     * automatically inject the required dependencies when an instance of {@code HomeService} is created. The
     * constructor takes various repositories, data entities, and other components as parameters.
     * @param       gitHubRepository GitHub's repositories from the database.
     * @param       authorRepository authors from the database.
     * @param       skillRepository skills from the database.
     * @param       devServicesRepository development services from the database.
     * @param       iconLinkRepository icon links from the database.
     * @param       exampleRepository examples from the database.
     * @param       languageRepository programming languages from the database.
     * @param       home properties from the properties file.
     * @param       navbar properties from the properties file.
     * @param       button properties from the properties file.
     * @param       contact properties from the properties file.
     * @param       greet properties from the properties file.
     * @param       propertiesValues properties from the properties file.
     */
    @Autowired
    public HomeService(
            GitHubRepository gitHubRepository, AuthorRepository authorRepository,
            SkillRepository skillRepository, DevServicesRepository devServicesRepository,
            IconLinkRepository iconLinkRepository, ExampleRepository exampleRepository,
            LanguageRepository languageRepository,
            Home home, Navbar navbar,
            Button button, Contact contact,
            Greet greet, Values propertiesValues) {
        this.gitHubRepository = gitHubRepository;
        this.authorRepository = authorRepository;
        this.skillRepository = skillRepository;
        this.devServicesRepository = devServicesRepository;
        this.iconLinkRepository = iconLinkRepository;
        this.exampleRepository = exampleRepository;
        this.languageRepository = languageRepository;
        this.home = home;
        this.navbar = navbar;
        this.button = button;
        this.contact = contact;
        this.greet = greet;
        this.propertiesValues = propertiesValues;
    }

    /**
     * {@code getRepos} method retrieve a list of GitHub repositories, all repositories.
     * @return      List of all GitHub repositories in the repository.
     * @see         github.magyarzoli.PortfolioPage.repository.GitHubRepository#findAll()
     */
    public List<GitHubRepo> getRepos() {
        return gitHubRepository.findAll();
    }

    /**
     * {@code getRepos} method retrieve a list of GitHub repositories, limited number based on the given limit.
     * @param       limit setting based on the specified Pageable object.
     * @return      All GitHubRepo entities and orders them by their name property in descending order.
     * @see         github.magyarzoli.PortfolioPage.repository.GitHubRepository#findTopNByOrderByNameDesc(Pageable)
     *              findTopNByOrderByNameDesc(Pageable)
     */
    public List<GitHubRepo> getRepos(int limit) {
        PageRequest pageRequest = PageRequest.of(0, limit);
        return gitHubRepository.findTopNByOrderByNameDesc(pageRequest);
    }

    /**
     * {@code getSpecificRepo} method retrieves a specific GitHub repository by its name.
     * @param       name GitHubRepo name.
     * @return      Additional information about the GitHub based on the searched GitHubRepo name.
     * @see         github.magyarzoli.PortfolioPage.repository.GitHubRepository#findByName(String) findByName(String)
     */
    public GitHubRepo getSpecificRepo(String name) {
        return gitHubRepository.findByName(name);
    }

    /**
     * {@code getAuthors} method retrieve a list of authors.
     * @return      List of all authors in the repository.
     * @see         github.magyarzoli.PortfolioPage.repository.AuthorRepository#findAll() findAll()
     */
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    /**
     * {@code getAuthors} method retrieve a list of authors a specific author by name.
     * @param       name Author name.
     * @return      Additional information about the author based on the searched author name.
     * @see         github.magyarzoli.PortfolioPage.repository.AuthorRepository#findByName(String) findByName(String)
     */
    public Author getSpecificAuthor(String name) {
        return authorRepository.findByName(name);
    }

    /**
     * {@code getSkills} methods retrieve a list of skills, all skills.
     * @return      List of all skills in the repository.
     * @see         github.magyarzoli.PortfolioPage.repository.SkillRepository#findAll() findAll()
     */
    public List<Skill> getSkills() {
        return skillRepository.findAll();
    }

    /**
     * {@code getSkills} methods retrieve a list of skills, a limited number based on the given limit.
     * @param       limit is within a chosen range.
     * @return      It fetches the top N Skill entities.
     * @see         github.magyarzoli.PortfolioPage.repository.SkillRepository#findTopNByOrderByDescriptionDesc(PageRequest)
     *              findTopNByOrderByDescriptionDesc(PageRequest)
     */
    public List<Skill> getSkills(int limit) {
        PageRequest pageRequest = PageRequest.of(0, limit);
        return skillRepository.findTopNByOrderByDescriptionDesc(pageRequest);
    }

    /**
     * {@code getDevServices} methods retrieve a list of development services, all services.
     * @return      List of all development services in the repository.
     * @see         github.magyarzoli.PortfolioPage.repository.DevServicesRepository#findAll() findAll()
     */
    public List<DevServices> getDevServices() {
        return devServicesRepository.findAll();
    }

    /**
     * {@code getDevServices} methods retrieve a list of development services, a limited number based on the given
     * limit.
     * @param       limit setting based on the specified Pageable object.
     * @return      It fetches the top N DevServices entities.
     * @see         github.magyarzoli.PortfolioPage.repository.DevServicesRepository#findTopNByOrderByTitleDesc(Pageable)
     *              findTopNByOrderByTitleDesc(Pageable)
     */
    public List<DevServices> getDevServices(int limit) {
        PageRequest pageRequest = PageRequest.of(0, limit);
        return devServicesRepository.findTopNByOrderByTitleDesc(pageRequest);
    }

    /**
     * {@code getIconLinks} methods retrieve a list of icon links, all links.
     * @return      List of all icon links in the repository.
     * @see         github.magyarzoli.PortfolioPage.repository.IconLinkRepository#findAll() findAll()
     */
    public List<IconLink> getIconLinks() {
        return iconLinkRepository.findAll();
    }

    /**
     * {@code getIconLinks} methods retrieve a list of icon links, a limited number based on the given limit.
     * @param       limit is within a chosen range.
     * @return      It fetches the top N IconLink entities.
     * @see         github.magyarzoli.PortfolioPage.repository.IconLinkRepository#findTopNByOrderByIconDesc(PageRequest)
     *              findTopNByOrderByIconDesc(PageRequest)
     */
    public List<IconLink> getIconLinks(int limit) {
        PageRequest pageRequest = PageRequest.of(0, limit);
        return iconLinkRepository.findTopNByOrderByIconDesc(pageRequest);
    }

    /**
     * {@code getExamples} methods retrieve a list of examples, all examples.
     * @return      List of all examples in the repository.
     * @see         github.magyarzoli.PortfolioPage.repository.ExampleRepository#findAll() findAll()
     */
    public List<Example> getExamples() {
        return exampleRepository.findAll();
    }

    /**
     * {@code getExamples} methods retrieve a list of examples, examples related to a specific repository.
     * @param       repoId provided as an argument.
     * @return      It fetches a list of Example entities.
     * @see         github.magyarzoli.PortfolioPage.repository.ExampleRepository#findByRepoId(Long) findByRepoId(Long)
     */
    public List<Example> getExamples(Long repoId) {
        return exampleRepository.findByRepoId(repoId);
    }

    /**
     * {@code getLanguages} methods retrieve a list of programming languages, all languages.
     * @return      List of all programming languages in the repository.
     * @see         github.magyarzoli.PortfolioPage.repository.LanguageRepository#findAll() findAll()
     */
    public List<Language> getLanguages() {
        return languageRepository.findAll();
    }

    /**
     * {@code getLanguages} methods retrieve a list of programming languages, languages related to a specific
     * repository.
     * @param       repoId provided as an argument.
     * @return      List of Language entities.
     * @see         github.magyarzoli.PortfolioPage.repository.LanguageRepository#findByRepoId(Long) findByRepoId(Long)
     */
    public List<Language> getLanguages(Long repoId) {
        return languageRepository.findByRepoId(repoId);
    }
}