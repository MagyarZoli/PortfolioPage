package github.magyarzoli.PortfolioPage.domain.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Values that uses the @Value annotation to inject values from the Spring configuration.
 * Spring will inject these property values into the corresponding fields in the Values class. You can then use
 * instances of the Values class in other parts of your application, like controllers or views, to access these
 * property values.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@Component
@Data
public class Values {

    /**
     * This annotation is used to inject the value associated with the property key "developed" from the Spring
     * configuration. The property value will be assigned to the {@code developed} field.
     */
    @Value("${developed}")
    private String developed;

    /**
     * This annotation is used to inject the value associated with the property key "exception.portfolio" from the
     * Spring configuration. The property value will be assigned to the {@code exceptionRepo} field.
     */
    @Value("${exception.portfolio}")
    private String exceptionRepo;

    /**
     * This annotation is used to inject the value associated with the property key "picture-this" from the Spring
     * configuration. The property value will be assigned to the {@code pictureThis} field.
     */
    @Value("${picture-this}")
    private String pictureThis;

    /**
     * This annotation is used to inject the value associated with the property key "contact-head" from the Spring
     * configuration. The property value will be assigned to the {@code contactHead} field.
     */
    @Value("${contact-head}")
    private String contactHead;

    /**
     * This annotation is used to inject the value associated with the property key "contact-body" from the Spring
     * configuration. The property value will be assigned to the {@code contactBody} field.
     */
    @Value("${contact-body}")
    private String contactBody;
}