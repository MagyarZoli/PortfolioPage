package github.magyarzoli.PortfolioPage.controller;

import github.magyarzoli.PortfolioPage.domain.entity.GitHubRepo;
import github.magyarzoli.PortfolioPage.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class HomeController {

    private HomeService service;

    @Autowired
    public void setService(HomeService service) {
        this.service = service;
    }

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

    @RequestMapping("/about")
    public String about(Model model) {
        commonController(model);
        model.addAttribute("aboutIn", service.getSkills());
        model.addAttribute("devServices", service.getDevServices());
        return "about";
    }

    @RequestMapping("/portfolio")
    public String repos(Model model) {
        commonController(model);
        model.addAttribute("row", service.getRepos());
        return "portfolio";
    }

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

    @RequestMapping("/contact")
    public String contact(Model model) {
        commonController(model);
        model.addAttribute("contact", service.getContact());
        model.addAttribute("iconLink", service.getIconLinks());
        return "contact";
    }

    void commonController(Model model) {
        model.addAttribute("author", service.getSpecificAuthor("Magyar Zoltan"));
        model.addAttribute("pageTitle", service.getAuthors());
        model.addAttribute("navbar", service.getNavbar());
        model.addAttribute("developed", service.getPropertiesValues().getDeveloped());
        model.addAttribute("date", new Date());
        model.addAttribute("button", service.getButton());
    }
}