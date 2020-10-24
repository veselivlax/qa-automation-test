package pages;

import org.openqa.selenium.WebElement;

public class OcenitePage extends BasePage{
    private String oceniteButton = "//*[@class=\"reviews-header__button\"]";
    private String oceniteMessage = "//*[@id=\"commentFormHolder\"]/div/p";
    public WebElement getOceniteButton(){
        return findElement(oceniteButton);
    }
    public WebElement getOceniteMessage(){
        return findElement(oceniteMessage);
    }
}
