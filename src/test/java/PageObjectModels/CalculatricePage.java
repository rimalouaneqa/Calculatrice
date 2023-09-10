package PageObjectModels;

import Utilities.SeleniumLib;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalculatricePage {
    WebDriver driver;
    SeleniumLib seleniumLib;
    public CalculatricePage(WebDriver driver){
        this.driver=driver;
        seleniumLib=new SeleniumLib(driver);
    }


    //locators
    By bouton1 =By.xpath("//*[@id=\"neuf\"]"); // input=9
    By bouton2 =By.xpath("//*[@id=\"cinq\"]");// input=5
    By Add =By.xpath("//*[@id=\"addition\"]");// operation=plus
    By Equalbouton=By.xpath("//*[@id=\"egale\"]");
    By  Result=By.xpath("//*[@id=\"historique_resultat_tableau\"]/tr[2]/td[3]");
    By DateOperation=By.xpath("//*[@id=\"historique_resultat_tableau\"]/tr[2]/td[1]");
    // methods
    public void clickbutton1(){
        seleniumLib.clickbutton(bouton1);
    }
    public void clickbutton2(){
        seleniumLib.clickbutton(bouton2);
    }
    public void clickadd(){
        seleniumLib.clickbutton(Add);
    }
    public void clickequalbutton(){
        seleniumLib.clickbutton(Equalbouton);
    }
    public String getfinalresult(){
        return seleniumLib.gettext(Result);
    }
    public String getoperationtime(){
        return seleniumLib.gettext(DateOperation);
    }


}
