package utils;

import com.github.javafaker.Faker;

public class TestData {
    public static Faker faker = new Faker();
    public static String currentAddress = faker.address().fullAddress();
    public static String email = faker.internet().emailAddress();
    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String phoneNumber = faker.number().digits(10);
    public static String state = "NCR";
    public static String city = "Noida";
    public static String gender = faker.options().option("Male","Female","Other");
    public static String subjects = faker.options().option("English", "Chemistry", "Computer Science","Economics","Social Studies","Commerce");
    public static String hobby = faker.options().option("Music","Reading","Sports");
    public static String BirthDayYear = Integer.toString(faker.number().numberBetween(1900, 2100));
    public static String BirthDayMonth = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    public static String BirthDay = Integer.toString(faker.number().numberBetween(10,20));
}
