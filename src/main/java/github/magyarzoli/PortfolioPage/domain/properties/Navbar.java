package github.magyarzoli.PortfolioPage.domain.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Navbar will be used to bind properties from the Spring configuration that start with the prefix "navbar". In
 * this case, it's used to bind properties related to navigation bar items.
 * Spring will map these properties to the corresponding fields in the Navbar class. You can then inject an instance
 * of the Navbar class into other parts of your application, like controllers or views. This allows you to dynamically
 * populate the navigation bar or menu items in your application based on the content specified in the properties.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@ConfigurationProperties(prefix = "navbar")
@Component
@Data
public class Navbar {

    /**
     * These fields represent the labels or names for various navigation bar items, such as "Home", "About Me",
     * "Services", "Portfolio", and "Contact".
     */
    private String home, about, services, portfolio, contact;
}