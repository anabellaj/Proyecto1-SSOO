/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;
import static Companies.CompanyType.Dell;
import Interfaz.AppleTab;
import Interfaz.DellTab;
import Interfaz.MainMenu;
import Interfaz.Menu;

/**
 *
 * @author ani
 */
public class Proy1SSOOJauaLecuna {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Menu menu = new Menu();
//        menu.setVisible(true);
//        menu.setLocationRelativeTo(null);
//        menu.setResizable(false);
//        DellTab DellWindow = new DellTab();
//        
//        menu.getTabPanel().addTab("Dell", DellWindow);
//        
//        

//        MainMenu menu = new MainMenu();
//        menu.setVisible(true);

        MainMenu main = new MainMenu();
        CommonVariables global = new CommonVariables(main);
        main.setVisible(true);
        
        //AppleTab appleTab = new AppleTab();
        //DellTab dellTab = new DellTab(Dell);
//        menu.getTabPanel().addTab("Apple", appleTab);
        //menu.getTabPanel().addTab("Dell", dellTab);
        
    }
    
}
