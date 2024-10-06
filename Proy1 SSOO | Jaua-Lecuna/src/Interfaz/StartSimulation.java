/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import Companies.Company;
import Companies.CompanyType;
import static Companies.CompanyType.Apple;
import static Companies.CompanyType.Dell;
import Companies.ComputerRequirements;
import Disk.Disk;
import Disk.FileReader;
import Disk.FileReader.JSONFile;
import Main.CommonVariables;

/**
 *
 * @author ani
 */
public class StartSimulation {
    
    /**
     * Method that starts apple simulation
     */
    public static void startSimApple() {

        ComputerRequirements AppleReq = new ComputerRequirements(CompanyType.Apple);
        FileReader fileAdmin = new FileReader();
        JSONFile fileApple = null;
        Company Apple;
        try {
            fileApple = fileAdmin.getFile(CompanyType.Apple);

        } catch (Exception e) {
        }
        
        // Gets the data from the file if it isn't empty
        if (fileApple != null) {
            Disk AppleDisk = new Disk(fileApple.getDaysBetweenReleases());
            AppleReq.setDaysBetweenReleases(fileApple.getDaysBetweenReleases());
            CommonVariables.setDayLengthApple(fileApple.getDayLength());

            Apple = new Company(AppleReq, AppleDisk, fileApple.getNumMotherboardProducer(), fileApple.getNumCpuProducer(), fileApple.getNumPowerSupplyProducer(), fileApple.getNumRamProducer(), fileApple.getNumGpuProducer(), fileApple.getNumAssemblers(), fileApple.getDayLength());
            CommonVariables.setApple(Apple);
            
        // Sets the data if file is empty 
        } else {
            Disk AppleDisk = new Disk(20);
            AppleReq.setDaysBetweenReleases(10);
            CommonVariables.setDayLengthApple(35000);
            Apple = new Company(AppleReq, AppleDisk, 1,1,1,1,1,1, 350000);
            CommonVariables.setApple(Apple);
        }
        
        AppleTab AppleTab = new AppleTab(Apple);
        
       
        CommonVariables.getMainMenu().getTabPanel().addTab("Apple", AppleTab);
        
        UpdateAppleData update = new UpdateAppleData(AppleTab);
        update.start();
    }
    
    public static void startSimDell() {

        ComputerRequirements DellReq = new ComputerRequirements(CompanyType.Apple);
        FileReader fileReader = new FileReader();
        JSONFile fileDell = null;
        Company Dell;
        try {
            fileDell = fileReader.getFile(CompanyType.Dell);

        } catch (Exception e) {
        }
        if (fileDell != null) {
            Disk DellDisk = new Disk(fileDell.getDaysBetweenReleases());
            DellReq.setDaysBetweenReleases(fileDell.getDaysBetweenReleases());
            System.out.println(fileDell.getDaysBetweenReleases());
            CommonVariables.setDayLengthDell(fileDell.getDayLength());

            Dell = new Company(DellReq, DellDisk, fileDell.getNumMotherboardProducer(), fileDell.getNumCpuProducer(), fileDell.getNumPowerSupplyProducer(), fileDell.getNumRamProducer(), fileDell.getNumGpuProducer(), fileDell.getNumAssemblers(), fileDell.getDayLength());
            
            CommonVariables.setDell(Dell);
           
        } else {
            Disk DellDisk = new Disk(20);
            DellReq.setDaysBetweenReleases(10);
            CommonVariables.setDayLengthDell(35000);
            Dell = new Company(DellReq, DellDisk, 1,1,1,1,1,1, 350000);
            CommonVariables.setDell(Dell);
        }
        Dell.updateTimes(CompanyType.Dell);
        DellTab DellTab = new DellTab(Dell);
        
       
        CommonVariables.getMainMenu().getTabPanel().addTab("Dell", DellTab);
        
        UpdateDellData update = new UpdateDellData(DellTab);
        update.start();
    }
    
    public static void stopApple(){
        for (int i = 0; i < CommonVariables.getMainMenu().getTabPanel().getTabCount(); i++) {
                if(CommonVariables.getMainMenu().getTabPanel().getTitleAt(i).equals("Apple")){
                    AppleTab apple = (AppleTab) CommonVariables.getMainMenu().getTabPanel().getComponentAt(i);
                    apple.getApple().endCompany();
                    break;
                }
            }
    }
    public static void stopDell(){
        for (int i = 0; i < CommonVariables.getMainMenu().getTabPanel().getTabCount(); i++) {
                if(CommonVariables.getMainMenu().getTabPanel().getTitleAt(i).equals("Disney")){
                    DellTab dell = (DellTab) CommonVariables.getMainMenu().getTabPanel().getComponentAt(i);
                    dell.getDell().endCompany();
                    break;
                }
            }
    }
    
}
