package tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test
    @Tag("Browser Change")
    void systemPropertiesTest() {
        String browser = System.getProperty("browser","chrome");
        System.out.println(browser);
    }
}
