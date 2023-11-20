package login;

public class ClientCreatingPage {
    public static final String CLIENT_CREATING_PAGE = "http://localhost:8080/garage/persons/registration";
    public static final String NEW_CLIENT_BUTTON = ".//a[text() = 'Новий клієнт']";
    public static final String NAME_FIELD = ".//input[@id='name']";
    public static final String SURNAME_FIELD = ".//input[@id='surname']";
    public static final String PHONE_NUMBER_FIELD = ".//input[@id='phoneNumber']";
    public static final String SUBMIT_USER_CREATING_BUTTON = ".//button[@type = 'submit' and text() = 'Створити']";
}