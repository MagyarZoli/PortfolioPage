package github.magyarzoli.PortfolioPage.domain.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Button will be used to bind properties from the Spring configuration that start with the prefix "button". In this
 * case, it's used to bind the properties related to button labels.
 * Spring will automatically map these properties to the corresponding fields in the Button class. This allows you to
 * inject instances of the Button class into other parts of your application, like controllers or services, and use
 * the button labels as needed.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@ConfigurationProperties(prefix = "button")
@Component
@Data
public class Button {

    /**
     * This field represents the label for the "Hire Me" button.
     */
    private String hireMe;

    /**
     * This field represents the label for the "Contact Me" button.
     */
    private String contactMe;

    /**
     * This field represents the label for the "See More" button.
     */
    private String portfolio;

    /**
     * This field represents the label for a "Submit" button, which might be used in a form submission context.
     */
    private String submit;
}