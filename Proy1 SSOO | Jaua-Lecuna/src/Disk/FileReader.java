/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Disk;
import Companies.CompanyType;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;

/**
 * Class that reads a file uploaded and gets the simulation data from it 
 * @author ani
 */
public class FileReader {
    
    File fileApple = new File("./src/Disk/AppleInfo.json");
    File fileDell = new File("./src/Disk/DellInfo.json");
    Gson jsonAdmin = new Gson();

    public FileReader() {
    }

    public JSONFile getFile(CompanyType companyType) {

        try {
            File selected = null;
            switch (companyType) {
                case Apple:
                    selected = this.fileApple;
                    break;
                case Dell:
                    selected = this.fileDell;
                    break;
            }

            java.io.FileReader read = new java.io.FileReader(selected);
            JSONFile file = this.jsonAdmin.fromJson(read, JSONFile.class);
            read.close();
            return file;

        } catch (Exception e) {
             return null;
        }
       
    }
    public void saveFile(CompanyType companyType, JSONFile save) {

        try {
            File selected = null;
            switch (companyType) {
                case Apple:
                    selected = this.fileApple;
                    break;
                case Dell:
                    selected = this.fileDell;
                    break;
            }

            FileWriter write = new FileWriter(selected);
            this.jsonAdmin.toJson(save, write);
            write.close();

        } catch (Exception e) {

        }
       
    }

    /**
     * Class that defines the structure of the JSON File
     */
    public class JSONFile {

        private int dayLength;
        private int daysBetweenReleases;
        private int numMotherboardProducer;
        private int numCpuProducer;
        private int numPowerSupplyProducer;
        private int numRamProducer;
        private int numGpuProducer;
        private int numAssemblers;

        public JSONFile() {
        }

        /**
         * Gets the length of the day in the simulation
         * @return the length of the day
         */
        public int getDayLength() {
            return dayLength;
        }

        /**
         * Sets the length of the day in the simulation
         * @param dayLength to set 
         */
        public void setDayLength(int dayLength) {
            this.dayLength = dayLength;
        }

        /**
         * Gets the number of days between computer releases
         * @return the number of days between releases
         */
        public int getDaysBetweenReleases() {
            return daysBetweenReleases;
        }

        /**
         * Sets the number of days between computer releases
         * @param daysBetweenReleases number of days to set 
         */
        public void setDaysBetweenReleases(int daysBetweenReleases) {
            this.daysBetweenReleases = daysBetweenReleases;
        }

        /**
         * Gets the number of motherboard producers in a company
         * @return the number of motherboard producers
         */
        public int getNumMotherboardProducer() {
            return numMotherboardProducer;
        }

        /**
         * Sets the number of motherboard producers in a company
         * @param numMotherboardProducer the number of motherboard producers to set
         */
        public void setNumMotherboardProducer(int numMotherboardProducer) {
            this.numMotherboardProducer = numMotherboardProducer;
        }

        /**
         * Gets the number of CPU producers in a company
         * @return the number of CPU producers
         */
        public int getNumCpuProducer() {
            return numCpuProducer;
        }

        /**
         * Sets the number of CPU producers in a company
         * @param numCpuProducer the number of CPU producers to set
         */
        public void setNumCpuProducer(int numCpuProducer) {
            this.numCpuProducer = numCpuProducer;
        }

        /**
         * Gets the number of power supply producers in a company
         * @return the number of power supply producers
         */
        public int getNumPowerSupplyProducer() {
            return numPowerSupplyProducer;
        }

        /**
         * Sets the number of power supply producers in a company
         * @param numPowerSupplyProducer the number of power supply producers to set
         */
        public void setNumPowerSupplyProducer(int numPowerSupplyProducer) {
            this.numPowerSupplyProducer = numPowerSupplyProducer;
        }

        /**
         * Gets the number of RAM memory producers in a company
         * @return the number of RAM memory producers
         */
        public int getNumRamProducer() {
            return numRamProducer;
        }

        /**
         * Sets the number of RAM memory producers in a company
         * @param numRamProducer the number of RAM memory producers to set
         */
        public void setNumRamProducer(int numRamProducer) {
            this.numRamProducer = numRamProducer;
        }

        /**
         * Gets the number of GPU producers in a company
         * @return the number of GPU producers
         */
        public int getNumGpuProducer() {
            return numGpuProducer;
        }

        /**
         * Sets the number of GPU producers in a company
         * @param numGpuProducer the number of GPU producers to set
         */
        public void setNumGpuProducer(int numGpuProducer) {
            this.numGpuProducer = numGpuProducer;
        }

        /**
         * Gets the number of assemblers in a company
         * @return the number of assemblers in a company
         */
        public int getNumAssemblers() {
            return numAssemblers;
        }

        /**
         * Sets the number of assemblers in a company
         * @param numAssemblers the number of assemblers to set
         */
        public void setNumAssemblers(int numAssemblers) {
            this.numAssemblers = numAssemblers;
        }

        
        
        
        
    
    
    
}
}
