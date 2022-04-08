package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.util;


public class menuPage extends util {
    @FindBy(linkText = "Generate Card Number") protected WebElement lnkGenerarTargeta;
    @FindBy(css ="#nav > a:nth-child(2)") protected  WebElement lnkGenerarTargeta2;
    @FindBy(xpath = "//nav/a[@href='cardnumber.php']") protected WebElement getLnkGenerarTarget3;

    public menuPage() {
        PageFactory.initElements(driver,this);
    }
    public void clickGenerarTargeta(){
        wait.until(ExpectedConditions.elementToBeClickable(lnkGenerarTargeta));
        lnkGenerarTargeta.click();

    }
}
