package pages;

import org.openqa.selenium.WebElement;

public class RegistrujteSePage extends BasePage{
    private String emailAdresaField = "//*[@id=\"email\"]";
    private String lozinkaField = "//*[@id=\"password\"]";
    private String ponoviteLozinkuField = "//*[@id=\"repeatedPassword\"]";
    private String firstCheckBox = "//label[@for=\"consents\"]//span[1]";
    private String secondCheckBox = "//label[@for=\"adult\"]//span[1]";
    private String nastaviButton = "//*[@id=\"submitButton\"]";
    private String positiveRegisterMessage = "//h1[text()=\"Skoro pa gotovo!\"]";
    private String negativeRegisterMessage = "(//div[@class=\"kp-error\"])[2]";
    private String emptyPonoviteLozinkuMessage = "//div[@error-name=\"repeated_password_required\"]";

    public WebElement getEmailAdresaField(){
        return findElement(emailAdresaField);
    }
    public WebElement getLozinkaField(){
        return findElement(lozinkaField);
    }
    public WebElement getPomoviteLozinkuField(){
        return findElement(ponoviteLozinkuField);
    }
    public WebElement getFirstCheckBox(){
        return findElement(firstCheckBox);
    }
    public WebElement getSecondCheckBox(){
        return findElement(secondCheckBox);
    }
    public WebElement getNastaviButton(){
        return findElement(nastaviButton);
    }
    public WebElement getPositiveRegisterMessage(){
        return findElement(positiveRegisterMessage);
    }
    public WebElement getNegativeRegisterMessage(){
        return findElement(negativeRegisterMessage);
    }
    public WebElement getEmptyPonoviteLozinkuMessage(){
        return findElement(emptyPonoviteLozinkuMessage);
    }
}
