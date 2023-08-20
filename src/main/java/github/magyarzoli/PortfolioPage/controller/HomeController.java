package github.magyarzoli.PortfolioPage.controller;

import github.magyarzoli.PortfolioPage.domain.entity.GitHubRepo;
import github.magyarzoli.PortfolioPage.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * This controller handles different HTTP requests and prepares data to be displayed in views, for a web application.
 * The {@link org.springframework.stereotype.Controller @Controller} annotation indicates that this class is a Spring
 * MVC controller, responsible for handling incoming HTTP requests and returning views or data in response.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@Controller
public class HomeController {

    /**
     * The class has a private field service of type {@code HomeService}. This field will be automatically injected
     * using the {@link org.springframework.beans.factory.annotation.Autowired @Autowired} annotation on the setter
     * method.
     */
    private HomeService service;

    /**
     * {@code setServices} method is annotated with {@link org.springframework.beans.factory.annotation.Autowired
     * @Autowired}. This method will be used for dependency injection of the {@code HomeService} instance into the
     * controller. The {@code @Autowired} annotation here indicates that Spring should automatically inject the
     * {@code HomeService} bean into this setter method when creating an instance of {@code HomeController}.
     * @param       service is responsible for interacting with various.
     */
    @Autowired
    public void setService(HomeService service) {
        this.service = service;
    }

    /**
     * The {@link org.springframework.web.bind.annotation.RequestMapping @RequestMapping}{@code ("/")} method in your
     * {@code HomeController} class handles incoming HTTP requests to the root URL ("/") and prepares data to be
     * displayed in the "home" view.
     * <ul>
     *     <li>Invokes the {@code commonController()} method, which populates the {@link org.springframework.ui.Model
     *     Model} object with common attributes that are shared across multiple views.</li>
     *     <li>Adds an attribute named "home" to the {@code Model} object. The value of this attribute is retrieved by
     *     calling the {@code getHome()} method on the {@code service} instance. This method fetches data related to the
     *     home page.</li>
     *     <li>Adds an attribute named "aboutIn" to the {@code Model} object. The value of this attribute is retrieved
     *     by calling the {@code getSkills(5)} method on the {@code service} instance. This method fetches a list of
     *     skills, limiting the result to 5 skills.</li>
     *     <li>Adds an attribute named "devServices" to the {@code Model} object. The value of this attribute is
     *     retrieved by calling the {@code getDevServices(3)} method on the {@code service} instance. This method
     *     fetches a list of development services, limiting the result to 3 services.</li>
     *     <li>Adds an attribute named "row" to the {@code Model} object. The value of this attribute is retrieved by
     *     calling the {@code getRepos(4)} method on the {@code service} instance. This method fetches a list of GitHub
     *     repositories, limiting the result to 4 repositories.</li>
     *     <li>Adds an attribute named "contact" to the {@code Model} object. The value of this attribute is retrieved
     *     by calling the {@code getContact()} method on the service instance. This method fetches data related to
     *     contact information.</li>
     *     <li>Adds an attribute named "iconLink" to the {@code Model} object. The value of this attribute is retrieved
     *     by calling the {@code getIconLinks()} method on the {@code service} instance. This method fetches data
     *     related to icon links.</li>
     *     <li>Adds an attribute named "currentGreet" to the {@code Model} object. The value of this attribute is
     *     retrieved by calling the {@code getGreet()} method on the {@code service} instance. This method fetches data
     *     related to greetings.</li>
     *     <li>Specifies that the method should return the "home" view. The "home" view is a template that will use the
     *     data provided in the {@code Model} object to render the final HTML page.</li>
     * </ul>
     * {@code home()} method in the {@code HomeController} class handles requests to the root URL ("/"). It prepares
     * the {@code Model} object by populating it with common attributes using the {@code commonController()} method,
     * and then adds multiple specific attributes containing data related to the home page, skills, development
     * services, GitHub repositories, contact information, icon links, and greetings. Finally, it returns the name of
     * the view template ("home"), which will be used to render the actual web page with the provided data.
     * @param       model takes a {@code Model} parameter.
     * @return      The name of the view template.
     * @see         github.magyarzoli.PortfolioPage.service.HomeService#getHome() getHome()
     * @see         github.magyarzoli.PortfolioPage.service.HomeService#getSkills(int) getSkills(int)
     * @see         github.magyarzoli.PortfolioPage.service.HomeService#getDevServices(int) getDevServices(int)
     * @see         github.magyarzoli.PortfolioPage.service.HomeService#getRepos(int) etRepos(int)
     * @see         github.magyarzoli.PortfolioPage.service.HomeService#getContact() getContact()
     * @see         github.magyarzoli.PortfolioPage.service.HomeService#getIconLinks() getIconLinks()
     * @see         github.magyarzoli.PortfolioPage.service.HomeService#getGreet() getGreet()
     */
    @RequestMapping("/")
    public String home(Model model) {
        commonController(model);
        model.addAttribute("home", service.getHome());
        model.addAttribute("aboutIn", service.getSkills(5));
        model.addAttribute("devServices", service.getDevServices(3));
        model.addAttribute("row", service.getRepos(4));
        model.addAttribute("contact", service.getContact());
        model.addAttribute("iconLink", service.getIconLinks());
        model.addAttribute("currentGreet", service.getGreet());
        return "home";
    }

    /**
     * The {@link org.springframework.web.bind.annotation.RequestMapping @RequestMapping}{@code ("/about")} method in
     * your {@code HomeController} class handles incoming HTTP requests to the "/about" URL and prepares data to be
     * displayed in the "about" view.
     * <ul>
     *     <li>Invokes the {@code commonController()} method, which populates the {@link org.springframework.ui.Model
     *     Model} object with common attributes that are shared across multiple views.</li>
     *     <li>Adds an attribute named "aboutIn" to the {@code Model} object. The value of this attribute is retrieved
     *     by calling the {@code getSkills()} method on the service instance. This method fetches a list of skills.</li>
     *     <li>Adds an attribute named "devServices" to the {@code Model} object. The value of this attribute is
     *     retrieved by calling the {@code getDevServices()} method on the service instance. This method fetches a list
     *     of development services.</li>
     *     <li>This line specifies that the method should return the "about" view. The "about" view is a template that
     *     will use the data provided in the {@code Model} object to render the final HTML page.</li>
     * </ul>
     * {@code about()} method in the {@code HomeController} class handles requests to the "/about" URL. It prepares the
     * {@code Model} object by populating it with common attributes using the {@code commonController()} method, and
     * then adds specific attributes containing data related to skills and development services. Finally, it returns
     * the name of the view template ("about"), which will be used to render the actual web page with the provided data.
     * @param       model takes a {@code Model} parameter.
     * @return      The name of the view template.
     * @see         github.magyarzoli.PortfolioPage.controller.HomeController#commonController(Model)
     *              commonController(Model)
     * @see         github.magyarzoli.PortfolioPage.service.HomeService#getSkills() getSkills()
     * @see         github.magyarzoli.PortfolioPage.service.HomeService#getDevServices() getDevServices()
     */
    @RequestMapping("/about")
    public String about(Model model) {
        commonController(model);
        model.addAttribute("aboutIn", service.getSkills());
        model.addAttribute("devServices", service.getDevServices());
        return "about";
    }

    /**
     * The {@link org.springframework.web.bind.annotation.RequestMapping @RequestMapping}{@code ("/portfolio")} method
     * in your {@code HomeController} class handles incoming HTTP requests to the "/portfolio" URL and prepares data to
     * be displayed in the "portfolio" view.
     * <ul>
     *     <li>Invokes the {@code commonController()} method, which populates the {@link org.springframework.ui.Model
     *     Model} object with common attributes that are shared across multiple views.</li>
     *     <li>Adds an attribute named "row" to the {@code Model} object. The value of this attribute is retrieved by
     *     calling the {@code getRepos()} method on the {@code service} instance. This method fetches a list of GitHub
     *     repositories.</li>
     *     <li>This line specifies that the method should return the "portfolio" view. The "portfolio" view is a
     *     template that will use the data provided in the Model object to render the final HTML page.</li>
     * </ul>
     * {@code repos()} method in the {@code HomeController} class handles requests to the "/portfolio" URL. It prepares
     * the {@code Model} object by populating it with common attributes using the {@code commonController()} method,
     * and then adds a specific attribute containing a list of GitHub repositories. Finally, it returns the name of the
     * view template ("portfolio"), which will be used to render the actual web page with the provided data.
     * @param       model takes a {@code Model} parameter.
     * @return      The name of the view template.
     * @see         github.magyarzoli.PortfolioPage.controller.HomeController#commonController(Model)
     *              commonController(Model)
     * @see          github.magyarzoli.PortfolioPage.service.HomeService#getRepos() getRepos()
     */
    @RequestMapping("/portfolio")
    public String repos(Model model) {
        commonController(model);
        model.addAttribute("row", service.getRepos());
        return "portfolio";
    }

    /**
     * The {@link org.springframework.web.bind.annotation.RequestMapping @RequestMapping}{@code ("/portfolio/{name}")}
     * method in your {@code HomeController} class handles incoming HTTP requests to URLs like "/portfolio/{name}" where
     * {name} is a path variable representing a repository name. It prepares data to be displayed in the "solo" view.
     * <ul>
     *     <li>The {name} portion in the URL is captured as a path variable, which is then passed to the {@code repo()}
     *     method.</li>
     *     <li>Checks if the {@code name} path variable is {@code null}.</li>
     *     <li>If it is null, it throws an exception using the message obtained from
     *     {@code service.getPropertiesValues().getExceptionRepo()}.</li>
     *     <li>The purpose of this code seems to be handling cases where the {@code name} path variable is missing.</li>
     *     <li>This line invokes the commonController() method, which populates the {@link org.springframework.ui.Model
     *     Model} object with common attributes that are shared across multiple views.</li>
     *     <li>Retrieves specific information about a GitHub repository using the {@code name} captured from the
     *     URL. Stores the retrieved repository object in the repo variable. Extracts the repository's ID from the
     *     {@code repo} object.</li>
     *     <li>Adds an attribute named "portfolio" to the {@code Model} object, containing the repository information
     *     stored in the {@code repo} variable.</li>
     *     <li>Adds an attribute named "examples" to the {@code Model} object, containing a list of examples related to
     *     the repository with the specified {@code id}.</li>
     *     <li>Adds an attribute named "languages" to the {@code Model} object, containing a list of programming
     *     languages related to the repository with the specified {@code id}.</li>
     *     <li>specifies that the method should return the "solo" view. The "solo" view is a template that will use the
     *     data provided in the {@code Model} object to render the final HTML page.</li>
     * </ul>
     * {@code repo()} method in the {@code HomeController} class handles requests to URLs like "/portfolio/{name}". It
     * prepares the {@code Model} object by populating it with common attributes using the {@code commonController()}
     * method. It then fetches specific information about a GitHub repository based on the captured name path variable,
     * retrieves related examples and programming languages, and adds these attributes to the {@code Model} object.
     * Finally, it returns the name of the view template ("solo"), which will be used to render the actual web page
     * with the provided data.
     * @param       name to capture the repository name from the URL, and a
     * @param       model takes a {@code Model} parameter.
     * @return      The name of the view template.
     * @throws      Exception name check throws an exception using the message obtained.
     * @see         github.magyarzoli.PortfolioPage.service.HomeService#getPropertiesValues() getPropertiesValues()
     * @see         github.magyarzoli.PortfolioPage.domain.properties.Values#getExceptionRepo() getExceptionRepo()
     * @see         github.magyarzoli.PortfolioPage.controller.HomeController#commonController(Model)
     *              commonController(Model)
     * @see         github.magyarzoli.PortfolioPage.service.HomeService#getSpecificRepo(String) getSpecificRepo(String)
     * @see         github.magyarzoli.PortfolioPage.domain.entity.GitHubRepo#getId() getId()
     * @see         github.magyarzoli.PortfolioPage.service.HomeService#getExamples(Long) getExamples(Long)
     * @see         github.magyarzoli.PortfolioPage.service.HomeService#getLanguages(Long) getLanguages(Long)
     */
    @RequestMapping("/portfolio/{name}")
    public String repo(@PathVariable(value= "name") String name, Model model)
    throws Exception {
        if (name == null) {
            throw new Exception(service.getPropertiesValues().getExceptionRepo());
        }
        commonController(model);
        GitHubRepo repo = service.getSpecificRepo(name);
        Long id = repo.getId();
        model.addAttribute("portfolio", repo);
        model.addAttribute("examples", service.getExamples(id));
        model.addAttribute("languages", service.getLanguages(id));
        return "solo";
    }

    /**
     * The {@link org.springframework.web.bind.annotation.RequestMapping @RequestMapping}{@code ("/contact")} method
     * in your {@code HomeController} class handles incoming HTTP requests to the "/contact" URL and prepares data to
     * be displayed in the "contact" view.
     * <ul>
     *     <li>Invokes the {@code commonController()} method, which populates the {@link org.springframework.ui.Model
     *     Model} object with common attributes that are shared across multiple views.</li>
     *     <li>Adds an attribute named "contact" to the {@code Model} object. The value of this attribute is retrieved
     *     by calling the {@code getContact()} method on the {@code service} instance. This method likely fetches data
     *     related to contact information.</li>
     *     <li>Adds an attribute named "iconLink" to the {@code Model} object. The value of this attribute is retrieved
     *     by calling the {@code getIconLinks()} method on the {@code service} instance. This method appears to fetch
     *     data related to icon links.</li>
     *     <li>specifies that the method should return the "contact" view. The "contact" view is a template that will
     *     use the data provided in the {@code Model} object to render the final HTML page.</li>
     * </ul>
     * {@code contact()} method in the {@code HomeController} class handles requests to the "/contact" URL. It prepares
     * the {@code Model} object by populating it with common attributes using the {@code commonController()} method,
     * and then adds specific attributes related to contact information and icon links. Finally, it returns the name of
     * the view template ("contact"), which will be used to render the actual web page with the provided data.
     * @param       model takes a {@code Model} parameter.
     * @return      The name of the view template.
     * @see         github.magyarzoli.PortfolioPage.controller.HomeController#commonController(Model)
     *              commonController(Model)
     * @see         github.magyarzoli.PortfolioPage.service.HomeService#getContact() getContact()
     * @see         github.magyarzoli.PortfolioPage.service.HomeService#getIconLinks() getIconLinks()
     */
    @RequestMapping("/contact")
    public String contact(Model model) {
        commonController(model);
        model.addAttribute("contact", service.getContact());
        model.addAttribute("iconLink", service.getIconLinks());
        return "contact";
    }

    /**
     * {@code commonController()} method add common attributes to the {@link org.springframework.ui.Model Model} object,
     * which will be shared across multiple views rendered by the controller's methods.
     * <ul>
     *     <li>Adds an attribute named "author" to the {@code Model} object. The value of this attribute is retrieved
     *     by calling the {@code getSpecificAuthor()} method on the {@code service} instance. This method appears to
     *     fetch information about a specific author named.</li>
     *     <li>Adds an attribute named "pageTitle" to the {@code Model} object. The value of this attribute is
     *     retrieved by calling the {@code getAuthors()} method on the {@code service} instance. This method seems to
     *     fetch a list of authors.</li>
     *     <li>Adds an attribute named "navbar" to the {@code Model} object. The value of this attribute is retrieved
     *     by calling the {@code getNavbar()} method on the {@code service} instance. This method fetches data related
     *     to a navigation bar.</li>
     *     <li>Adds an attribute named "developed" to the {@code Model} object. The value of this attribute is retrieved
     *     by calling the {@code getDeveloped()} method on the {@code propertiesValues} field within the {@code service}
     *     instance. It appears to fetch a value related to the term "developed."</li>
     *     <li>Adds an attribute named "date" to the {@code Model} object. The value of this attribute is set to the
     *     current date and time using the new {@link java.util.Date Date()} constructor.</li>
     *     <li>Adds an attribute named "button" to the {@code Model} object. The value of this attribute is retrieved by
     *     calling the {@code getButton()} method on the {@code service} instance. This method seems to fetch data
     *     related to a button.</li>
     * </ul>
     * {@code commonController()} method helps consolidate common data that is shared among multiple views. By adding
     * these attributes to the {@code Model} object, you make the data available to the view templates, allowing them
     * to access and display this data as needed. This approach follows the DRY (Don't Repeat Yourself) principle by
     * centralizing the retrieval and preparation of common data within a single method.
     * @param       model adds various attributes.
     * @see         github.magyarzoli.PortfolioPage.service.HomeService#getSpecificAuthor(String)
     *              getSpecificAuthor(String)
     * @see         github.magyarzoli.PortfolioPage.service.HomeService#getAuthors() getAuthors()
     * @see         github.magyarzoli.PortfolioPage.service.HomeService#getNavbar() getNavbar()
     * @see         github.magyarzoli.PortfolioPage.service.HomeService#getPropertiesValues() getPropertiesValues()
     * @see         github.magyarzoli.PortfolioPage.domain.properties.Values#getDeveloped() getDeveloped()
     * @see         github.magyarzoli.PortfolioPage.service.HomeService#getButton() getButton()
     */
    void commonController(Model model) {
        model.addAttribute("author", service.getSpecificAuthor("Magyar Zoltan"));
        model.addAttribute("pageTitle", service.getAuthors());
        model.addAttribute("navbar", service.getNavbar());
        model.addAttribute("developed", service.getPropertiesValues().getDeveloped());
        model.addAttribute("date", new Date());
        model.addAttribute("button", service.getButton());
    }
}