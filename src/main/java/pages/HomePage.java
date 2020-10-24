package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
   private String ulogujteSeButton = "//*[@href=\"javascript:void(0)\"]";
   private String closeButtonPopUp = "//*[@class=\"kpBoxCloseButton\"]";
   private String izlogujteSeButton = "//*[@href=\"javascript:void(0)\"]";
   private String searchField = "//*[@id=\"searchKeywordsInput\"]";
   private String cenaSection = "//section[text()=\"Cena\"]";
   private String traziButton = "(//input[@name=\"submit[search]\"])[2]";
   private String nonExistentItemMessage = "//span[@class=\"error\"]";
   private String blankFieldMessage = "//span[@class=\"error\"]";
   private String secondValidArticle = "(//div[@class=\"adImgWrapper\"]//img)[2]";
   private String prihvatamButton = "//*[@class=\"i-understand\"]";
   private String kpLogo= "//a[@title=\"KupujemProdajem\"]//img[1]";


   public WebElement getUlogujteSeButton(){
       return findElement(ulogujteSeButton);
   }
   public WebElement getCloseButtonPopUp(){
       return findElement(closeButtonPopUp);
   }
   public WebElement getIzlogujteSeButton(){
       return findElement(izlogujteSeButton);
   }
   public WebElement getSearchField(){
       return findElement(searchField);
   }
   public WebElement getCenaSection(){
       return findElement(cenaSection);
   }
   public WebElement getTraziButton(){
       return findElement(traziButton);
   }
   public WebElement getNonExistentItemMessage(){
       return findElement(nonExistentItemMessage);
   }
   public WebElement getBlankFieldMessage(){
       return findElement(blankFieldMessage);
   }
   public WebElement getSecondValidArticle(){
       return findElement(secondValidArticle);
   }
   public WebElement getPrihvatamButton(){
       return findElement(prihvatamButton);
   }
   public WebElement getKpLogo(){
       return findElement(kpLogo);
   }




}
