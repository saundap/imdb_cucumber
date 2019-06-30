package Support;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.Normalizer;
import java.util.ArrayList;

public class Action {
    WebDriver driver = null;

    public Action(WebDriver driver){
        this.driver = driver;
    }

    public void clickElementByXPath(String text){
        WebElement link  = driver.findElement(By.xpath("//*[contains(text(), '" + text + "')]"));
        link.click();
    }

    public void dropDownListSelect(String item, String value){
        Select drpCountry = new Select(driver.findElement(By.name(item)));
        drpCountry.selectByVisibleText(value);
    }

    public ArrayList<String> returnElementList(String path){
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<WebElement> elementList  = (ArrayList<WebElement>)driver.findElements(By.xpath(path));
        for (WebElement item: elementList) {
            String normalized = item.getText().trim();
            System.out.println(normalized);
            System.out.println(Normalizer.normalize(normalized, Normalizer.Form.NFD));
            result.add(Normalizer.normalize(normalized, Normalizer.Form.NFD));
        }
        return result;
    }

}
