package github.magyarzoli.PortfolioPage.controller;

import github.magyarzoli.PortfolioPage.domain.properties.Values;
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

/**
 * ErrorPageController and implements the ErrorController interface. The ErrorController interface is used for
 * handling generic error pages in Spring applications.<br><br>
 * {@link org.springframework.stereotype.Controller @Controller} indicates that this class is a Spring MVC controller
 * that handles HTTP requests.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@Controller
public class ErrorPageController
implements ErrorController {

    /**
     * The {@code ERROR_PATH} constant is defined with the value "/error". This path corresponds to the URL endpoint
     * where this error handler will respond.
     */
    private static final String ERROR_PATH = "/error";

    /**
     * Provides access to error attributes which can be logged or presented to the user.
     */
    private ErrorAttributes errorAttributes;

    /**
     * This class responsible for interacting with various repositories and providing methods to retrieve data
     * related to different parts of a home page or application.
     */
    private HomeService service;

    /**
     * {@code getErrorPath} method is required by the
     * {@link  org.springframework.boot.web.servlet.error.ErrorController ErrorController} interface. It returns the
     * value of the {@code ERROR_PATH} constant. This method is used by Spring to determine the path for which this
     * error controller is responsible.
     * @return      The value of the ERROR_PATH constant.
     */
    public String getErrorPath() {
        return ERROR_PATH;
    }

    /**
     * The class has dependencies on the {@code ErrorAttributes} interface.
     * These dependencies are injected into the class using the
     * {@link org.springframework.beans.factory.annotation.Autowired @Autowired} annotation. The
     * {@code setErrorAttributes} methods are annotated with {@code @Autowired} to inject the respective dependencies.
     * @param       errorAttributes Dependencies and Autowiring.
     */
    @Autowired
    public void setErrorAttributes(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    /**
     * The class has dependencies on the {@code HomeService} class.
     * These dependencies are injected into the class using the
     * {@link org.springframework.beans.factory.annotation.Autowired @Autowired} annotation. The
     * {@code setService} methods are annotated with {@code @Autowired} to inject the respective dependencies.
     * @param       service Dependencies and Autowiring.
     */
    @Autowired
    public void setService(HomeService service) {
        this.service = service;
    }

    /**
     * {@code error} method handles requests to the error path ("/error"). It takes in a
     * {@link org.springframework.ui.Model Model} object and a
     * {@link jakarta.servlet.http.HttpServletRequest HttpServletRequest} object as parameters.
     * <ul>
     *     <li>Inside the method, a {@link org.springframework.web.context.request.ServletWebRequest ServletWebRequest}
     *     is created from the given {@code HttpServletRequest} object.</li>
     *     <li>The {@link org.springframework.boot.web.servlet.error.ErrorAttributes ErrorAttributes} instance is used
     *     to retrieve error information using the {@code getErrorAttributes()} method.</li>
     *     <li>Various attributes related to the error (timestamp, error, path, status, etc.) are added to the
     *     {@code Model} using the model.{@link org.springframework.ui.Model#addAttribute(String, Object)
     *     addAttribute()} method.</li>
     *     <li>Additional attributes related to the application's content (author, page title, navbar,
     *     developed, and date) are also added to the {@code Model}.</li>
     * </ul>
     * Finally, the method returns the name of the view template ("error"). This view template is expected to be
     * resolved by a Spring ViewResolver and rendered to display the error information.
     * @param       model Additional attributes related to the application's content. Dependencies and Autowiring.
     * @param       request Dependencies and Autowiring.
     * @return      returns the name of the view template ("error").
     * @see         github.magyarzoli.PortfolioPage.service.HomeService#getSpecificAuthor(String)
     *              getSpecificAuthor(String)
     * @see         github.magyarzoli.PortfolioPage.service.HomeService#getAuthors() getAuthors()
     * @see         github.magyarzoli.PortfolioPage.service.HomeService#getNavbar() getNavbar()
     * @see         github.magyarzoli.PortfolioPage.service.HomeService#getPropertiesValues() getPropertiesValues()
     * @see         github.magyarzoli.PortfolioPage.domain.properties.Values#getDeveloped() getDeveloped()
     */
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
}