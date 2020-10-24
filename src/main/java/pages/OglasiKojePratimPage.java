package pages;

import org.openqa.selenium.WebElement;

public class OglasiKojePratimPage extends BasePage {
    private String cenaSection = "//section[text()=\"Cena\"]";
    public WebElement getCenaSection(){
        return findElement(cenaSection);
    }
}
