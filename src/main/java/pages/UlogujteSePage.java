package pages;

import org.openqa.selenium.WebElement;

public class UlogujteSePage extends BasePage {
    private String registrujteSeButton = "//*[@id=\"registerButton\"]";
    private String emailAdresaField = "//*[@id=\"email\"]";
    private String lozinkaField = "//*[@id=\"password\"]";
    private String ulogujteSeButton = "//*[@class=\"kp-button bold\"]";
    private String emailErrorMessage = "//div[@error-name=\"email_format\"]";
    private String lozinkaErrorMessage = "//b[text()=\"Pogrešna lozinka\"]";
    public WebElement getRegistrujteSeButton(){
        return findElement(registrujteSeButton);
    }
    public WebElement getEmailAdresaField(){
        return findElement(emailAdresaField);
    }
    public WebElement getLozinkaField(){
        return findElement(lozinkaField);
    }
    public WebElement getUlogujteSeButton(){
        return findElement(ulogujteSeButton);
    }
    public WebElement getEmailErrorMEssage(){
        return findElement(emailErrorMessage);
    }
    public WebElement getLozinkaErrorMessage(){
        return findElement(lozinkaErrorMessage);
    }
}
