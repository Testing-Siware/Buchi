package pages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import utiles.MethodHandles;

public class InstrumentsPage extends MethodHandles {

    public InstrumentsPage(ChromeDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
}
