package github.magyarzoli.PortfolioPage.domain.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Contact will be used to bind properties from the Spring configuration that start with the prefix "contact".
 * In this case, it's used to bind properties related to contact form fields.
 * Spring will map these properties to the corresponding fields in the Contact class. Similar to the previous example,
 * you can then inject instances of the Contact class into other parts of your application, like controllers or
 * services, and use the contact form field labels or placeholders as needed.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@ConfigurationProperties(prefix = "contact")
@Component
@Data
public class Contact {

    /**
     * This field represents the placeholder or label for the "Enter Your Name" input field in a contact form.
     */
    private String name;

    /**
     * This field represents the placeholder or label for the "Enter Your Email" input field in a contact form.
     */
    private String email;

    /**
     * This field represents the placeholder or label for the "Enter Your Subject" input field in a contact form.
     */
    private String subject;

    /**
     * This field represents the placeholder or label for the "Enter Your Message" textarea field in a contact form.
     */
    private String message;
}