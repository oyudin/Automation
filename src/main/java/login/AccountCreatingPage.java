package login;

public class AccountCreatingPage {
    public static final String ACCOUNT_PAGE = "https://lmsales--stage.sandbox.lightning.force.com/lightning/o/Account/list?filterName=Recent";
    public static final String NEW_ACCOUNT_BUTTON = ".//div[@title = 'New']";
    public static final String PARTNER_ACCOUNT_RADIO_BUTTON = ".//input[@value='0126S000000yvf6QAA']";
    public static final String NEXT_BUTTON = ".//*[@class = ' label bBody' and text() = 'Next']";
    public static final String ACCOUNT_NAME = ".//input[@name= 'Name']";
    public static final String  ACTIVE_ACCOUNT_STATUS = ".//button[@data-value = 'Active']";
    public static final String  ACCOUNT_EMAIL = ".//input[@name= 'Email__c']";
    public static final String  ACCOUNT_WEBSITE = ".//input[@name= 'Email__c']";
    public static final String  SAVE_ACCOUNT_BUTTON = ".//button[@name = 'SaveEdit' and text() = 'Save']]";

}