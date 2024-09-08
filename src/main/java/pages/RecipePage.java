package pages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import utiles.MethodHandles;

import javax.swing.plaf.metal.MetalBorders;

public class RecipePage extends MethodHandles {

    //constructor
    public RecipePage(ChromeDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    
}
