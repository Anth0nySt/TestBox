package utils;

import com.github.javafaker.Faker;

public class TestData {

    public static Faker faker = new Faker();

    public static String currentAddress = faker.address().fullAddress();

    public static String  email = faker.internet().emailAddress();

    public static String firstName = faker.name().firstName();

    public static String lastName = faker.name().lastName();
}
