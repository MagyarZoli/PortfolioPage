package github.magyarzoli.PortfolioPage.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Spring Framework component that handles exceptions globally within a Spring MVC (Model-View-Controller) application.
 * The {@link org.springframework.web.bind.annotation.ControllerAdvice @ControllerAdvice} annotation is used to
 * indicate that this class provides centralized exception handling for controllers in the application.<br><br>
 * When an exception occurs during the execution of any controller in the Spring MVC application, this handler method
 * will be called, and the exception information will be made available to the "error" view through the model attribute.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@ControllerAdvice
public class ExceptionGeneral {

    /**
     * {@code exceptionHandler} method is the exception handling method.
     * <ul>
     *     <li>This annotation is used on methods within the {@code ExceptionGeneral} class to specify which types of
     *     exceptions the method should handle. In your code, the
     *     {@link org.springframework.web.bind.annotation.ExceptionHandler @ExceptionHandler} annotation is used
     *     without specifying a specific exception type, which means that the method will handle all types
     *     of exceptions.</li>
     *     <li>{@link org.springframework.ui.Model#addAttribute(String, Object) addAttribute()} adds the exception
     *     object {@code ex} to the model with the attribute name "exception". This means that the exception object
     *     can be accessed in the view using the attribute name "exception".</li>
     *     <li>Specifies the view name that should be rendered when an exception occurs and this handler method is
     *     invoked. In this case, the view named "error" will be displayed, and the exception information will be
     *     available in the view through the "exception" attribute.</li>
     * </ul>
     * @param       ex This parameter holds the exception that needs to be handled.
     * @param       model This parameter is used to add attributes to the model, which can be used to pass data to
     *              the view.
     * @return      specifies the view name that should be rendered when an exception occurs and this handler method
     *              is invoked.
     */
    @ExceptionHandler
    public String exceptionHandler(Exception ex, Model model) {
        model.addAttribute("exception", ex);
        return "error";
    }
}