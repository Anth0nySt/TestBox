package tests.properties;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
public class SystemPropertiesTests {

    @Test
    @Tag("browser")
    void systemPropertiesTest() {
        String browser = System.getProperty("browser","chrome");
        System.out.println(browser);
    }

    @Test
    @Tag("resolution")
    void systemPropertiesTest2() {
        Configuration.browserSize = "2560 x 1440";
        String resolution = System.setProperty("browserSize","2560 x 1440");
        System.out.println(resolution);
    }

    @Test
    @Tag("browserVer")
    void systemPropertiesTest3() {
        String browser = System.getProperty("browser","chrome");
        System.out.println(browser);
    }
}
