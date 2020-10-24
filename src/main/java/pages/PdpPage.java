package pages;

import org.openqa.selenium.WebElement;

public class PdpPage extends BasePage {
    private String posaljitePoruku = "//*[@class=\"sendMessageBtn3\"]";
    private String pdpOptionMessage = "(//a[@class=\"current\"])[1]";
    private String pratiOption = "(//span[@class=\"default\"])[1]";
    private String leftSidePratimOption = "//*[@href=\"https://www.kupujemprodajem.com/user.php?action=favorites\"]";
    private String oceniteLink = "(//a[@target1=\"kpreviews\"]//span)[3]";


    public WebElement getPosaljitePoruku(){
        return findElement(posaljitePoruku);
    }
    public WebElement getPdpOptionMessage(){
        return findElement(pdpOptionMessage);
    }
    public WebElement getPratiOption(){return findElement(pratiOption);}
    public WebElement getLeftSidePratimOption(){
        return findElement(leftSidePratimOption);
    }
    public WebElement getOceniteLink(){
        return findElement(oceniteLink);
    }
}
