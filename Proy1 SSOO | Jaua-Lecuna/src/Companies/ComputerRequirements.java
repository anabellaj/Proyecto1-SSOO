/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Companies;

/**
 * Class that defines the hardware required to assemble one regular/GPU computer depending on the company
 * @author ani
 */
public class ComputerRequirements {
    
    private int dayLength=500; //Length of one day in the simulation
    private int daysBetweenReleases=10; // Number of days between computer releases
    
    // Company ID 
    private CompanyType companyIdentifier;
    
    // Parts needed to assemble 1 regular computer
    private int motherboardNeed;
    private int cpuNeed;
    private int ramNeed;
    private int powerSupplyNeed;
    
    // Parts needed to assemble 1 computer with GPU
    private int gpuNeed;
    private int regComputersBtwnGpu; // Number of regular computers made before a GPU computer needs to be made
    
    
    // Earnings 
    private int regComputerEarnings; // Earnings for a regular computer
    private int gpuComputerEarnings; // Earnings for a computer with GPU
    
    public ComputerRequirements(CompanyType companyIdentifier){
        this.companyIdentifier = companyIdentifier;
        switch (companyIdentifier){
            
            // Parts needed to assemble one computer in Apple
            case Apple -> {
                motherboardNeed = 2;
                cpuNeed = 1;
                ramNeed = 4;
                powerSupplyNeed = 4;
                gpuNeed = 2;
                regComputerEarnings = 100000;
                gpuComputerEarnings = 150000;
                regComputersBtwnGpu = 5;
            }
                
            // Parts needed to assemble one computer in Dell
            case Dell -> {
                motherboardNeed = 1;
                cpuNeed = 5;
                ramNeed = 6;
                powerSupplyNeed = 5;
                gpuNeed = 1;
                regComputerEarnings = 80000;
                gpuComputerEarnings = 120000;
                regComputersBtwnGpu = 3;
            }
            
            
        }
    }
    
    
    /**
     * Checks if a  regular computer can be assembled with the available components
     * @param motherboardAv
     * @param cpuAv
     * @param ramAv
     * @param powerSupplyAv
     * @return true if the computer can be assembled, else false
     */
    public boolean checkForReg(int motherboardAv, int cpuAv, int ramAv, int powerSupplyAv ){
    
        return motherboardAv >= this.getMotherboardNeed()&& cpuAv >= this.getCpuNeed()&& ramAv >= this.getRamNeed()&& powerSupplyAv >= this.getPowerSupplyNeed();
    
    }
    
    /**
     * Checks if a  GPU computer can be assembled with the available components
     * @param motherboardAv
     * @param cpuAv
     * @param ramAv
     * @param powerSupplyAv
     * @param gpuAv
     * @return true if the computer can be assembled, else false
     */
    public boolean checkForGpuComputer(int motherboardAv, int cpuAv, int ramAv, int powerSupplyAv, int gpuAv ){
    
        return motherboardAv >= this.getMotherboardNeed()&& cpuAv >= this.getCpuNeed()&& ramAv >= this.getRamNeed()&& powerSupplyAv >= this.getPowerSupplyNeed()&& gpuAv >= this.getGpuNeed();
    
    }

    /**
     * Gets the length of one day inside the simulation
     * @return the length of the day
     */
    public int getDayLength() {
        return dayLength;
    }

    /**
     * Sets the length of one day inside the simulation
     * @param dayLength the length to set 
     */
    public void setDayLength(int dayLength) {
        this.dayLength = dayLength;
    }

    /**
     * Gets the number of days between the releases of different computers
     * @return the length of the day
     */
    public int getDaysBetweenReleases() {
        return daysBetweenReleases;
    }

    /**
     * Gets the number of days between the releases of different computers
     * @param daysBetweenReleases the number of days to set
     */
    public void setDaysBetweenReleases(int daysBetweenReleases) {
        this.daysBetweenReleases = daysBetweenReleases;
    }

    /**
     * Gets the id of the company
     * @return 0 if Apple, 1 if Dell
     */
    public CompanyType getCompanyIdentifier() {
        return companyIdentifier;
    }

    /**
     * Sets the id of the company
     * @param companyIdentifier id to set 
     */
    public void setCompanyIdentifier(CompanyType companyIdentifier) {
        this.companyIdentifier = companyIdentifier;
    }

    /**
     * Gets the number of motherboards required for a computer
     * @return the number of motherboards required
     */
    public int getMotherboardNeed() {
        return motherboardNeed;
    }

    /**
     * Sets the number of motherboards required for a computer
     * @param motherboardNeed the number of motherboards to set
     */
    public void setMotherboardNeed(int motherboardNeed) {
        this.motherboardNeed = motherboardNeed;
    }

    /**
     * Gets the number of CPUs required for a computer
     * @return the number of CPUs required
     */
    public int getCpuNeed() {
        return cpuNeed;
    }

    /**
     * Sets the number of CPUs required for a computer
     * @param cpuNeed the number of CPUs to set
     */
    public void setCpuNeed(int cpuNeed) {
        this.cpuNeed = cpuNeed;
    }

    /**
     * Gets the number of RAM memories required for a computer
     * @return the number of RAM memories required
     */
    public int getRamNeed() {
        return ramNeed;
    }

    /**
     * Sets the number of RAM memories required for a computer
     * @param ramNeed the number of RAM memories to set
     */
    public void setRamNeed(int ramNeed) {
        this.ramNeed = ramNeed;
    }

    /**
     * Gets the number of power supplies required for a computer
     * @return the number of power supplies required
     */
    public int getPowerSupplyNeed() {
        return powerSupplyNeed;
    }

    /**
     * Sets the number of power supplies required for a computer
     * @param powerSupplyNeed the number of power supplies to set
     */
    public void setPowerSupplyNeed(int powerSupplyNeed) {
        this.powerSupplyNeed = powerSupplyNeed;
    }

    /**
     * Gets the number of GPUs required for a computer
     * @return the number of GPUs required
     */
    public int getGpuNeed() {
        return gpuNeed;
    }

    /**
     * Sets the number of GPUs required for a computer
     * @param gpuNeed the number of GPUs to set
     */
    public void setGpuNeed(int gpuNeed) {
        this.gpuNeed = gpuNeed;
    }

    /**
     * Gets the number of regular computers that have to be made before making a GPU computer
     * @return the number of regular computers
     */
    public int getRegComputersBtwnGpu() {
        return regComputersBtwnGpu;
    }

    /**
     * Sets the number of regular computers that have to be made before making a GPU computer
     * @param regComputersBtwnGpu number of computers to set
     */
    public void setRegComputersBtwnGpu(int regComputersBtwnGpu) {
        this.regComputersBtwnGpu = regComputersBtwnGpu;
    }

    /**
     * Gets the earnings of a regular computer
     * @return the earnings of a regular computer
     */
    public int getRegComputerEarnings() {
        return regComputerEarnings;
    }

    /**
     * Sets the earnings of a regular computer
     * @param regComputerEarnings the earnings to set
     */
    public void setRegComputerEarnings(int regComputerEarnings) {
        this.regComputerEarnings = regComputerEarnings;
    }

    /**
     * Gets the earnings of a GPU computer
     * @return the earnings of a GPU computer
     */
    public int getGpuComputerEarnings() {
        return gpuComputerEarnings;
    }

    /**
     * Sets the earnings of a GPU computer
     * @param gpuComputerEarnings the earnings to set
     */
    public void setGpuComputerEarnings(int gpuComputerEarnings) {
        this.gpuComputerEarnings = gpuComputerEarnings;
    }

    
}
