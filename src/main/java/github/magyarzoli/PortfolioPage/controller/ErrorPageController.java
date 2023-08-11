package github.magyarzoli.PortfolioPage.controller;

import github.magyarzoli.PortfolioPage.service.HomeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Date;
import java.util.Map;

@Controller
public class ErrorPageController
implements ErrorController {

    private static final String ERROR_PATH = "/error";

    private ErrorAttributes errorAttributes;
    private HomeService service;

    @Autowired
    public void setErrorAttributes(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @Autowired
    public void setService(HomeService service) {
        this.service = service;
    }

    @RequestMapping(ERROR_PATH)
    public String error(Model model, HttpServletRequest request) {
        ServletWebRequest servletWebRequest = new ServletWebRequest(request);
        Map<String, Object> error = this.errorAttributes.getErrorAttributes(servletWebRequest, ErrorAttributeOptions.defaults());
        model.addAttribute("timestamp", error.get("timestamp"));
        model.addAttribute("error", error.get("error"));
        model.addAttribute("path", error.get("path"));
        model.addAttribute("status", error.get("status"));
        model.addAttribute("author", service.getSpecificAuthor("Magyar Zoltan"));
        model.addAttribute("pageTitle", service.getAuthors());
        model.addAttribute("navbar", service.getNavbar());
        model.addAttribute("developed", service.getPropertiesValues().getDeveloped());
        model.addAttribute("date", new Date());
        return "error";
    }

    public String getErrorPath() {
        return ERROR_PATH;
    }
}