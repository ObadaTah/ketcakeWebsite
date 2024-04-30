package ps.ketcake.website.DataInit;

import java.security.SecureRandom;

import com.github.javafaker.Faker;

// @Component
public class RandomDataGenerator {

    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Faker faker = new Faker();

    private static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMERIC_CHARACTERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+";

    private static final int MIN_USERNAME_LENGTH = 4;
    private static final int MAX_USERNAME_LENGTH = 15;

    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MAX_PASSWORD_LENGTH = 20;

    public static String generateRandomUsername() {
        return generateRandomString(MIN_USERNAME_LENGTH, MAX_USERNAME_LENGTH, LOWERCASE_CHARACTERS);
    }

    public static String generateRandomFirstName() {
        return faker.name().firstName();
    }

    public static Integer generateRandomPrice() {
        return faker.number().numberBetween(18, 100);
    }

    public static String generateRandomLastName() {

        return faker.name().lastName();
    }

    public static String generateRandomUniversityName() {
        return faker.university().name();
    }

    public static String generateRandomEmail(String firstName, String lastName) {
        return faker.internet().emailAddress();
    }

    public static Boolean generateRandomIsVerified() {
        return faker.bool().bool();
    }

    public static String generateRandomPassword() {
        return generateRandomString(MIN_PASSWORD_LENGTH, MAX_PASSWORD_LENGTH,
                LOWERCASE_CHARACTERS + UPPERCASE_CHARACTERS + NUMERIC_CHARACTERS + SPECIAL_CHARACTERS);
    }

    public static String generateRandomWords() {
        return generateRandomString(5, 30,
                LOWERCASE_CHARACTERS + UPPERCASE_CHARACTERS);
    }

    public static String generateRandomBio() {
        return faker.backToTheFuture().character();
    }

    public static String generateRandomPhoneNumber() {
        String phoneNumber = faker.phoneNumber().cellPhone().toString();
        return phoneNumber;
    }

    public static String generateRandomRealUsername() {
        return faker.name().username();
    }

    public static String generateRandomCharacterName() {
        return faker.gameOfThrones().character();
    }

    public static String generateRandomFieldOfWork() {
        return faker.job().field();
    }

    private static String generateRandomString(int minLength, int maxLength, String characters) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = minLength + secureRandom.nextInt(maxLength - minLength + 1);
        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(characters.length());
            stringBuilder.append(characters.charAt(randomIndex));
        }
        return stringBuilder.toString();
    }

}
