package github.magyarzoli.PortfolioPage.domain.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Home will be used to bind properties from the Spring configuration that start with the prefix "home". In this
 * case, it's used to bind properties related to text content on a homepage.
 * Spring will map these properties to the corresponding fields in the Home class. You can then inject an instance
 * of the Home class into other parts of your application, like controllers or services. This allows you to dynamically
 * populate the homepage or introduction section of your application with the content specified in the properties.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@ConfigurationProperties(prefix = "home")
@Component
@Data
public class Home {

    /**
     * This field represents the text content that seems to be used for a greeting message on the homepage. It
     * contains HTML markup with various elements, including a line break {@code <br>}, a {@code <span>} element
     * with inner text, and an {@code <i>} element with a CSS class.
     */
    private String helloText;

    /**
     * This field represents the text content describing a role or position, possibly for a developer.
     */
    private String about;
}