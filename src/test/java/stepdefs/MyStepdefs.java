package stepdefs;

import browser.Browser;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import io.github.bonigarcia.wdm.managers.ChromiumDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MyWork;

public class MyStepdefs {
    protected static MyWork myWork;

    @Before
    public void setup() {
        myWork = new MyWork();
        ChromiumDriverManager.chromedriver().setup();
        Browser.getBrowser().manage().window().maximize();
        Browser.getBrowser().get("https://www.kupujemprodajem.com/");

    }

    @Given("^that user clicks on Ulogujte se button$")
    public void thatUserClicksOnUlogujteSeButton() {
        boolean present;

        try {
            myWork.findElement("//*[@class=\"kpBoxCloseButton\"]");
            present = true;
        }
        catch (NoSuchElementException e){
            present = false;
        }
        if (present){
            myWork.homePage().getCloseButtonPopUp().click();
        }

        myWork.homePage().getUlogujteSeButton().click();
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"registerButton\"]")));
    }


    @And("^user clicks on Registrujte se link$")
    public void userClicksOnRegistrujteSeLink() {
        myWork.ulogujteSePage().getRegistrujteSeButton().click();
    }


    @And("^user fills all mandatory fields$")
    public void userFillsAllMandatoryFields() {
        String emailRandomString = RandomStringUtils.randomAlphabetic(10);
        myWork.registrujteSePage().getEmailAdresaField().sendKeys(emailRandomString + "@yopmail.com");
        myWork.registrujteSePage().getLozinkaField().sendKeys("test12345");
        myWork.registrujteSePage().getPomoviteLozinkuField().sendKeys("test12345");

    }

    @And("^user checks two checks boxes$")
    public void userChecksTwoChecksBoxes() {
        myWork.registrujteSePage().getFirstCheckBox().click();
        myWork.registrujteSePage().getSecondCheckBox().click();

    }

    @When("^user clicks on nastavi button$")
    public void userClicksOnNastaviButton() {
        myWork.registrujteSePage().getNastaviButton().click();

    }


    @Then("^proper validation message is shown$")
    public void properValidationMessageIsShown() {
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()=\"Skoro pa gotovo!\"]")));
        Assert.assertEquals("Skoro pa gotovo!", myWork.registrujteSePage().getPositiveRegisterMessage().getText());


    }

    @Given("^that user hover and clicks on Ulogujte se button$")
    public void thatUserHoverAndClicksOnUlogujteSeButton() {
        boolean present;

        try {
            myWork.findElement("//*[@class=\"kpBoxCloseButton\"]");
            present = true;
        }
        catch (NoSuchElementException e){
            present = false;
        }
        if (present){
            myWork.homePage().getCloseButtonPopUp().click();
        }

        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"kpBoxCloseButton\"]"));
        myWork.homePage().getUlogujteSeButton().click();
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"registerButton\"]")));
    }

    @And("^user fills email field with invalid email adress$")
    public void userFillsEmailFieldWithInvalidEmailAdress() {
        String emailRandomString = RandomStringUtils.randomAlphabetic(10);
        myWork.registrujteSePage().getEmailAdresaField().sendKeys(emailRandomString + "yopmailcom");

    }

    @And("^user fills lozinka fields with valid data$")
    public void userFillsLozinkaFieldsWithValidData() {
        myWork.registrujteSePage().getLozinkaField().sendKeys("test12345");
        myWork.registrujteSePage().getPomoviteLozinkuField().sendKeys("test12345");
    }

    @Then("^proper message is shown$")
    public void properMessageIsShown() {
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class=\"kp-error\"])[2]")));
        Assert.assertEquals("Neispravan format e-mail adrese", myWork.registrujteSePage().getNegativeRegisterMessage().getText());

    }


    @And("^user fills email field with valid email adress$")
    public void userFillsEmailFieldWithValidEmailAdress() {
        String emailRandomString = RandomStringUtils.randomAlphabetic(9);
        myWork.registrujteSePage().getEmailAdresaField().sendKeys(emailRandomString + "@yopmail.com");

    }

    @And("^user fills lozinka field with valid data$")
    public void userFillsLozinkaFieldWithValidData() {
        String lozinkaRandomString = RandomStringUtils.randomAlphabetic(10);
        myWork.registrujteSePage().getLozinkaField().sendKeys(lozinkaRandomString);
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"submitButton\"]")));
    }

    @Then("^alert message is shown$")
    public void alertMessageIsShown() {
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@error-name=\"repeated_password_required\"]")));
        Assert.assertEquals("Polje ne može biti prazno", myWork.registrujteSePage().getEmptyPonoviteLozinkuMessage().getText());

    }

    @And("^fills all mandatory fields with valid data$")
    public void fillsAllMandatoryFieldsWithValidData() {
        myWork.ulogujteSePage().getEmailAdresaField().sendKeys("vlada1988@yopmail.com");
        myWork.ulogujteSePage().getLozinkaField().sendKeys("Test12345");


    }

    @When("^clicks on Ulogujte se blue button$")
    public void clicksOnUlogujteSeBlueButton() {
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"kp-button bold\"]")));
        myWork.ulogujteSePage().getUlogujteSeButton().click();
    }

    @Then("^izlogujte se button is shown in header section$")
    public void izlogujteSeButtonIsShownInHeaderSection() {
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href=\"javascript:void(0)\"]")));
        Assert.assertEquals("Izlogujte se", myWork.homePage().getIzlogujteSeButton().getText());

    }

    @Then("^red validation error message is shown$")
    public void redValidationErrorMessageIsShown() {
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@error-name=\"email_format\"]")));
        Assert.assertEquals("Neispravan format e-mail adrese", myWork.ulogujteSePage().getEmailErrorMEssage().getText());
    }


    @Given("^that user clicks on izlogujte se button$")
    public void thatUserClicksOnIzlogujteSeButton() {
        boolean present;

        try {
            myWork.findElement("//*[@class=\"kpBoxCloseButton\"]");
            present = true;
        }
        catch (NoSuchElementException e){
            present = false;
        }
        if (present){
            myWork.homePage().getCloseButtonPopUp().click();

        }
        myWork.homePage().getIzlogujteSeButton().click();
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"email\"]")));
    }

    @And("^user fills email text box field with invalid email adress$")
    public void userFillsEmailTextBoxFieldWithInvalidEmailAdress() {
        String emailRandomString = RandomStringUtils.randomAlphabetic(10);
        myWork.ulogujteSePage().getEmailAdresaField().sendKeys(emailRandomString + "yopmail.com");

    }

    @And("^user fills lozinka field with valid password$")
    public void userFillsLozinkaFieldWithValidPassword() {
        myWork.ulogujteSePage().getLozinkaField().sendKeys("Test12345");
    }


    @And("^user fills email text box field with valid mail adress$")
    public void userFillsEmailTextBoxFieldWithValidMailAdress() {
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"email\"]")));
        myWork.ulogujteSePage().getEmailAdresaField().sendKeys("vlada1988@yopmail.com");
    }

    @And("^user clears lozinka field$")
    public void userClearsLozinkaField() {
        myWork.ulogujteSePage().getLozinkaField().clear();
    }

    @And("^user fills lozinka text box field with invalid password$")
    public void userFillsLozinkaTextBoxFieldWithInvalidPassword() {
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]")));
        String lozinkaRandomString = RandomStringUtils.randomAlphabetic(10);
        myWork.ulogujteSePage().getLozinkaField().sendKeys(lozinkaRandomString);

    }

    @Then("^lozinka validation error message is shown$")
    public void lozinkaValidationErrorMessageIShown() {
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()=\"Pogrešna lozinka\"]")));
        Assert.assertEquals("Pogrešna lozinka", myWork.ulogujteSePage().getLozinkaErrorMessage().getText());
    }

    @Given("^that user again clicks on Ulogujte se button$")
    public void thatUserAgainClicksOnUlogujteSeButton() {
        boolean present;

        try {
            myWork.findElement("//*[@class=\"kpBoxCloseButton\"]");
            present = true;
        }
        catch (NoSuchElementException e){
            present = false;
        }
        if (present){
            myWork.homePage().getCloseButtonPopUp().click();
        }
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href=\"javascript:void(0)\"]")));
        myWork.homePage().getUlogujteSeButton().click();
    }


    @Given("^that user searches for (.*)$")
    public void thatUserSearchesForMobilePhone(String mobilePhone) {
        boolean present;

        try {
            myWork.findElement("//*[@class=\"kpBoxCloseButton\"]");
            present = true;
        }
        catch (NoSuchElementException e){
            present = false;
        }
        if (present){
            myWork.homePage().getCloseButtonPopUp().click();
        }

        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"searchKeywordsInput\"]")));
        myWork.homePage().getSearchField().sendKeys(mobilePhone);
    }

    @When("^user clicks on trazi button$")
    public void userClicksOnTraziButton() {
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='submit[search]'])[2]")));
        myWork.homePage().getTraziButton().click();
    }

    @Then("^proper text should be displayed$")
    public void properTextShouldBeDisplayed() {
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[text()='Cena']")));
        Assert.assertEquals("Cena", myWork.homePage().getCenaSection().getText());

    }

    @Given("^that user types non-existent item in search field$")
    public void thatUserTypesNonExistentItemInSearchField() {
        boolean present;

        try {
            myWork.findElement("//*[@class=\"kpBoxCloseButton\"]");
            present = true;
        }
        catch (NoSuchElementException e){
            present = false;
        }
        if (present){
            myWork.homePage().getCloseButtonPopUp().click();
        }

        String itemRandomString = RandomStringUtils.randomAlphabetic(10);
        myWork.homePage().getSearchField().sendKeys(itemRandomString);
    }

    @Then("^proper result should be shown$")
    public void properResultShouldBeShown() {
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='error']")));
        Assert.assertEquals("Nije pronađen nijedan oglas.", myWork.homePage().getNonExistentItemMessage().getText());
    }

    @Given("^that user clicks on trazi button$")
    public void thatUserClicksOnTraziButton() {
        boolean present;

        try {
            myWork.findElement("//*[@class=\"kpBoxCloseButton\"]");
            present = true;
        }
        catch (NoSuchElementException e){
            present = false;
        }
        if (present){
            myWork.homePage().getCloseButtonPopUp().click();
        }


        myWork.homePage().getTraziButton().click();
    }

    @Then("^certain message is shown$")
    public void certainMessageIsShown() {
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"error\"]")));
        Assert.assertEquals("Pretraga je našla jako veliki broj rezultata. Molimo suzite pretragu (izaberite kategoriju, grupu, itd)!", myWork.homePage().getBlankFieldMessage().getText());

    }

    @Given("^that user enters in a search filed valid data$")
    public void thatUserEntersInASearchFiledValidData() {
        boolean present;

        try {
            myWork.findElement("//*[@class=\"kpBoxCloseButton\"]");
            present = true;
        }
        catch (NoSuchElementException e){
            present = false;
        }
        if (present){
            myWork.homePage().getCloseButtonPopUp().click();
        }
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"searchKeywordsInput\"]")));
        myWork.homePage().getPrihvatamButton().click();
        myWork.homePage().getSearchField().sendKeys("Iphone 11");
    }

    @And("^clicks on second valid article$")
    public void clicksOnSecondValidArticle() {
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class=\"adImgWrapper\"]//img)[2]")));

        myWork.homePage().getSecondValidArticle().click();
    }

    @Then("^user clicks on posaljite poruku on pdp page$")
    public void userClicksOnPosaljitePorukuOnPdpPage() {
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"sendMessageBtn3\"]")));
        myWork.pdpPage().getPosaljitePoruku().click();

    }

    @And("^enters valid credentials on ulogujte se page$")
    public void entersValidCredentialsOnUlogujteSePage() {
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"email\"]")));
        myWork.ulogujteSePage().getEmailAdresaField().sendKeys("vlada1988@yopmail.com");
        myWork.ulogujteSePage().getLozinkaField().sendKeys("Test12345");

    }


    @Then("^proper text is shown$")
    public void properTextIsShown() {
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class=\"current\"])[1]")));
        Assert.assertEquals("Poruke", myWork.pdpPage().getPdpOptionMessage().getText());

    }


    @Given("^that user enters in a search filed new valid data$")
    public void thatUserEntersInASearchFiledNewValidData() {
        boolean present;

        try {
            myWork.findElement("//*[@class=\"kpBoxCloseButton\"]");
            present = true;
        }
        catch (NoSuchElementException e){
            present = false;
        }
        if (present){
            myWork.homePage().getCloseButtonPopUp().click();
        }


        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"searchKeywordsInput\"]")));
        myWork.homePage().getSearchField().sendKeys("Iphone 8");
    }

    @And("^cliks on prati Prati option$")
    public void cliksOnPratiPratiOption() {
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class=\"default\"])[1]")));
        myWork.pdpPage().getPratiOption().click();

    }

    @And("^clicks on Pratim option on left menu side$")
    public void clicksOnPratimOptionOnLeftMenuSide() {
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href=\"https://www.kupujemprodajem.com/user.php?action=favorites\"]")));
        myWork.pdpPage().getLeftSidePratimOption().click();
    }





    @And("^clicks on ocenite$")
    public void clicksOnOcenite() {
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@target1=\"kpreviews\"]//span)[3]")));
        myWork.pdpPage().getOceniteLink().click();
    }
    @Given("^that user seacrhes for (.*)$")
    public void thatUserSeacrhesForPhones(String phones) {
        boolean present;

        try {
            myWork.findElement("//*[@class=\"kpBoxCloseButton\"]");
            present = true;
        }
        catch (NoSuchElementException e){
            present = false;
        }
        if (present){
            myWork.homePage().getCloseButtonPopUp().click();
        }

        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"searchKeywordsInput\"]")));
        myWork.homePage().getSearchField().sendKeys(phones);
    }


    @And("^clicks on ocenite blue button$")
    public void clicksOnOceniteBlueButton() {
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"reviews-header__button\"]")));
        myWork.ocenitePage().getOceniteButton().click();
    }

    @Then("^proper text korisnika ne mozete oceniti is shown$")
    public void properTextKorisnikaNeMozeteOcenitiIsShown() {
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"commentFormHolder\"]/div/p")));
        Assert.assertEquals("Korisnika ne možete oceniti:",myWork.ocenitePage().getOceniteMessage().getText());

    }


    @Then("^cena section is shown$")
    public void cenaSectionIsShown() {
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[text()=\"Cena\"]")));
        Assert.assertEquals("Cena",myWork.oglasiKojePratimPage().getCenaSection().getText());

    }
}


