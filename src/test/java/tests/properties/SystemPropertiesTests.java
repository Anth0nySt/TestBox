package tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Tag("Browser Change")
    @Test
    void systemPropertiesTest() {
        String browser = System.getProperty("browser","chrome");
        System.out.println(browser);
    }
}
