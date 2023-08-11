package github.magyarzoli.PortfolioPage.service;

import github.magyarzoli.PortfolioPage.domain.entity.*;
import github.magyarzoli.PortfolioPage.domain.properties.*;
import github.magyarzoli.PortfolioPage.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {

    private GitHubRepository gitHubRepository;
    private AuthorRepository authorRepository;
    private SkillRepository skillRepository;
    private DevServicesRepository devServicesRepository;
    private IconLinkRepository iconLinkRepository;
    private ExampleRepository exampleRepository;
    private LanguageRepository languageRepository;
    private Home home;
    private Navbar navbar;
    private Button button;
    private Contact contact;
    private Greet greet;

    private Values propertiesValues;

    @Autowired
    public void setGitHubRepository(GitHubRepository gitHubRepository) {
        this.gitHubRepository = gitHubRepository;
    }

    @Autowired
    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Autowired
    public void setSkillRepository(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Autowired
    public void setDevServicesRepository(DevServicesRepository devServicesRepository) {
        this.devServicesRepository = devServicesRepository;
    }

    @Autowired
    public void setIconLinkRepository(IconLinkRepository iconLinkRepository) {
        this.iconLinkRepository = iconLinkRepository;
    }

    @Autowired
    public void setExampleRepository(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }

    @Autowired
    public void setLanguageRepository(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public Home getHome() {
        return home;
    }

    @Autowired
    public void setHome(Home home) {
        this.home = home;
    }

    public Navbar getNavbar() {
        return navbar;
    }

    @Autowired
    public void setNavbar(Navbar navbar) {
        this.navbar = navbar;
    }

    public Button getButton() {
        return button;
    }

    @Autowired
    public void setButton(Button button) {
        this.button = button;
    }

    public Contact getContact() {
        return contact;
    }

    @Autowired
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Greet getGreet() {
        return greet;
    }

    @Autowired
    public void setGreet(Greet greet) {
        this.greet = greet;
    }

    public Values getPropertiesValues() {
        return propertiesValues;
    }

    @Autowired
    public void setPropertiesValues(Values propertiesValues) {
        this.propertiesValues = propertiesValues;
    }

    public List<GitHubRepo> getRepos() {
        return gitHubRepository.findAll();
    }

    public List<GitHubRepo> getRepos(int limit) {
        PageRequest pageRequest = PageRequest.of(0, limit);
        return gitHubRepository.findTopNByOrderByNameDesc(pageRequest);
    }

    public GitHubRepo getSpecificRepo(String name) {
        return gitHubRepository.findByName(name);
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public Author getSpecificAuthor(String name) {
        return authorRepository.findByName(name);
    }

    public List<Skill> getSkills() {
        return skillRepository.findAll();
    }

    public List<Skill> getSkills(int limit) {
        PageRequest pageRequest = PageRequest.of(0, limit);
        return skillRepository.findTopNByOrderByDescriptionDesc(pageRequest);
    }

    public List<DevServices> getDevServices() {
        return devServicesRepository.findAll();
    }

    public List<DevServices> getDevServices(int limit) {
        PageRequest pageRequest = PageRequest.of(0, limit);
        return devServicesRepository.findTopNByOrderByTitleDesc(pageRequest);
    }

    public List<IconLink> getIconLinks() {
        return iconLinkRepository.findAll();
    }

    public List<IconLink> getIconLinks(int limit) {
        PageRequest pageRequest = PageRequest.of(0, limit);
        return iconLinkRepository.findTopNByOrderByIconDesc(pageRequest);
    }

    public List<Example> getExamples() {
        return exampleRepository.findAll();
    }

    public List<Example> getExamples(Long repoId) {
        return exampleRepository.findByRepoId(repoId);
    }

    public List<Language> getLanguages() {
        return languageRepository.findAll();
    }

    public List<Language> getLanguages(Long repoId) {
        return languageRepository.findByRepoId(repoId);
    }
}