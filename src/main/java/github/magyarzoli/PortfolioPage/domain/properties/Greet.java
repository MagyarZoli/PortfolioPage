package github.magyarzoli.PortfolioPage.domain.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

/**
 * Greet will be used to bind properties from the Spring configuration that start with the prefix "current-greeting".
 * In this case, it's used to bind properties related to different greetings for different times of the day.
 * Spring will map these properties to the corresponding fields in the Greet class. You can then inject an instance
 * of the Greet class into other parts of your application, like controllers or services. Calling the getCurrentGreet()
 * method will return the appropriate greeting based on the current time of day.
 * @since       1.0
 * @author      <a href=https://github.com/MagyarZoli>Magyar Zoltán</a>
 */
@ConfigurationProperties(prefix = "current-greeting")
@Component
@Data
public class Greet {

    /**
     * These fields represent the different greetings for various times of the day.
     */
    private String morning, day, evening, night;

    /**
     * {@code getCurrentGreet} This method calculates the appropriate greeting based on the current time of day.
     * It uses the {@link java.time.LocalTime LocalTime}.{@link java.time.LocalTime#now() now()}
     * .{@link java.time.LocalTime#getHour() getHour()} method to get the current hour of the day and then compares
     * it to predefined time ranges to determine which greeting to return.
     * @return      Which greeting to return.
     */
    public String getCurrentGreet() {
        int currentHour = LocalTime.now().getHour();
        if (currentHour >= 6 && currentHour < 12) {
            return getMorning();
        } else if (currentHour >= 12 && currentHour < 18) {
            return getDay();
        } else if (currentHour >= 18 && currentHour < 22) {
            return getEvening();
        } else {
            return getNight();
        }
    }
}