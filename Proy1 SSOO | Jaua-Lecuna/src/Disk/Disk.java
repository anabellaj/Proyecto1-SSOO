/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Disk;
import Workers.WorkerTypes;
import java.util.concurrent.Semaphore;


/**
 * 
 * @author ani
 */
public class Disk {
    
    //total number of resources produced
    private int motherboard = 0;
    private int cpu = 0;
    private int ram = 0;
    private int powerSupply = 0;
    private int gpu = 0;
    private int computer = 0;
    private int gpuComputer = 0;
    
    //maximum inventory
    private int maxMotherboard = 25;
    private int maxCpu = 20;
    private int maxRam = 55;
    private int maxPowerSupply = 35;
    private int maxGpu = 10;
    
    //semaphore
    private Semaphore produced;  
    private Semaphore assembleComputer;
    private Semaphore daysCounter; 
    private Semaphore costs; 
    
    //workers' status
    private int directorStatus; //1 working; 0 watching PM
    private int projectManagerStatus; //1 watching anime; 0 working
    private int faults; //faults given to the PM by the director 
    
    //expenses
    private float costMotherboard=0;
    private float costCpu=0;
    private float costRam=0;
    private float costPowerSupply = 0;
    private float costGpu = 0;
    private float costAssemble=0;
    private float costProjectManager=0;
    private float costDirector = 0;
    
    private float earnings; 
    private float netProfit; //earnings-totalCosts
    private int salaryFault; //money lost by the PM due to watching anime
    private float totalCosts; 
  
    
    private int daysCountdown;
    private int computerSinceGpuComputer =0; //amount of regular computers produced since the last computer with a gpu

    public Disk(int daysCountdown) {
        this.daysCountdown = daysCountdown;
        this.produced = new Semaphore(1); //Only 1 person can access the resource at the same time
        this.assembleComputer = new Semaphore(1);
        this.daysCounter = new Semaphore(1);
        this.costs = new Semaphore(1);
        this.directorStatus = 0;
        this.projectManagerStatus = 1;
        this.faults = 0;
        this.earnings = 0;
        this.netProfit = 0;
        this.salaryFault = 100;
    }
    
    public void addProduct(WorkerTypes type){
        switch (type){
            // MotherboardProducer(0), CpuProducer(1), PowerSupplyProducer(2), RamProducer(3), GpuProducer(4) 
            case MotherboardProducer:
                this.setMotherboard((this.getMotherboard()< this.getMaxMotherboard())? this.getMotherboard()+ 1: this.getMotherboard());
                break;
            case CpuProducer:
                this.setCpu((this.getCpu() < this.getMaxCpu())? this.getCpu()+ 1: this.getCpu());
                break;
            case PowerSupplyProducer:
                this.setPowerSupply((this.getPowerSupply()< this.getMaxPowerSupply())? this.getPowerSupply() + 1: this.getPowerSupply());
                break;
            case RamProducer:
                this.setRam((this.getRam()< this.getMaxRam())? this.getRam()+ 1: this.getRam());
                break;
            case GpuProducer:
                this.setGpu((this.getGpu()< this.getMaxGpu())? this.getGpu()+ 1: this.getGpu());
                break;
    }
    }

    /**
     * @return the number of motherboards produced
     */
    public int getMotherboard() {
        return motherboard;
    }

    /**
     * @param motherboard the number of motherboards to set 
     */
    public void setMotherboard(int motherboard) {
        this.motherboard = motherboard;
    }

    /**
     * @return the number of CPUs produced
     */
    public int getCpu() {
        return cpu;
    }

    /**
     * @param cpu the number of CPUs to set 
     */
    public void setCpu(int cpu) {
        this.cpu = cpu;
    }

    /**
     * @return the number of RAMs produced
     */
    public int getRam() {
        return ram;
    }

    /**
     * @param ram the number of RAMs to set 
     */
    public void setRam(int ram) {
        this.ram = ram;
    }

    /**
     * @return the number of power supplies produced
     */    
    public int getPowerSupply() {
        return powerSupply;
    }

    /**
     * @param powerSupply the number of power supplies to set 
     */
    public void setPowerSupply(int powerSupply) {
        this.powerSupply = powerSupply;
    }

    /**
     * @return the number of GPUs produced
     */    
    public int getGpu() {
        return gpu;
    }

    /**
     * @param gpu the number of GPUs to set 
     */
    public void setGpu(int gpu) {
        this.gpu = gpu;
    }

    /**
     * @return the number of computers produced
     */    
    public int getComputer() {
        return computer;
    }

    /**
     * @param computer the number of computers to set 
     */
    public void setComputer(int computer) {
        this.computer = computer;
    }

    /**
     * @return the number of computers with GPU produced
     */   
    public int getGpuComputer() {
        return gpuComputer;
    }

    /**
     * @param gpuComputer the number of computers with GPU to set 
     */
    public void setGpuComputer(int gpuComputer) {
        this.gpuComputer = gpuComputer;
    }

    /**
     * @return the max number of motherboards that can be stored
     */
    public int getMaxMotherboard() {
        return maxMotherboard;
    }

    /**
     * @param maxMotherboard the max number of motherboards to set 
     */
    public void setMaxMotherboard(int maxMotherboard) {
        this.maxMotherboard = maxMotherboard;
    }

    /**
     * @return the max number of CPUs that can be stored
     */
    public int getMaxCpu() {
        return maxCpu;
    }

    /**
     * @param maxCpu the max number of CPUs to set 
     */
    public void setMaxCpu(int maxCpu) {
        this.maxCpu = maxCpu;
    }

    /**
     * @return the max number of RAMs that can be stored
     */
    public int getMaxRam() {
        return maxRam;
    }

    /**
     * @param maxRam the max number of RAMs to set 
     */
    public void setMaxRam(int maxRam) {
        this.maxRam = maxRam;
    }

    /**
     * @return the max number of power supplies that can be stored
     */
    public int getMaxPowerSupply() {
        return maxPowerSupply;
    }

    /**
     * @param maxPowerSupply the max number of power supplies to set 
     */
    public void setMaxPowerSupply(int maxPowerSupply) {
        this.maxPowerSupply = maxPowerSupply;
    }

    /**
     * @return the max number of GPUs that can be stored
     */
    public int getMaxGpu() {
        return maxGpu;
    }

    /**
     * @param maxGpu the max number of GPUs to set 
     */
    public void setMaxGpu(int maxGpu) {
        this.maxGpu = maxGpu;
    }

    /**
     * @return the resources produced
     */
    public Semaphore getProduced() {
        return produced;
    }

    /**
     * @param setProduced set the state of the semaphore
     */
    public void setProduced(Semaphore produced) {
        this.produced = produced;
    }

    /**
     * @return the assembleComputer
     */
    public Semaphore getAssembleComputer() {
        return assembleComputer;
    }

    /**
     * @param assembleComputer set the state of the semaphore
     */
    public void setAssembleComputer(Semaphore assembleComputer) {
        this.assembleComputer = assembleComputer;
    }

    /**
     * @return the number of days passed
     */
    public Semaphore getDaysCounter() {
        return daysCounter;
    }

    /**
     * @param setDaysCounter set the state of the semaphore
     */
    public void setDaysCounter(Semaphore daysCounter) {
        this.daysCounter = daysCounter;
    }

    /**
     * @return the total costs
     */
    public Semaphore getCosts() {
        return costs;
    }

    /**
     * @param setCosts set the state of the semaphore
     */
    public void setCosts(Semaphore costs) {
        this.costs = costs;
    }

    /**
     * @return the status of the director
     */
    public int getDirectorStatus() {
        return directorStatus;
    }

    /**
     * @param setDirectorStatus set the status of the director
     */
    public void setDirectorStatus(int directorStatus) {
        this.directorStatus = directorStatus;
    }

    /**
     * @return the status of the project manager
     */
    public int getProjectManagerStatus() {
        return projectManagerStatus;
    }

    /**
     * @param setProjectManagerStatus set the status of the PM
     */
    public void setProjectManagerStatus(int projectManagerStatus) {
        this.projectManagerStatus = projectManagerStatus;
    }

    /**
     * @return the number of faults given to the PM by the director
     */
    public int getFaults() {
        return faults;
    }

    /**
     * @param setFaults set the number of faults
     */
    public void setFaults(int faults) {
        this.faults = faults;
    }

    /**
     * @return the cost of the motherboard
     */
    public float getCostMotherboard() {
        return costMotherboard;
    }

    /**
     * @param costMotherboard set the cost of the motherboard
     */
    public void setCostMotherboard(float costMotherboard) {
        this.costMotherboard = costMotherboard;
    }

    /**
     * @return the cost of the CPU
     */
    public float getCostCpu() {
        return costCpu;
    }

    /**
     * @param costCpu set the cost of the CPU
     */
    public void setCostCpu(float costCpu) {
        this.costCpu = costCpu;
    }
    
    /**
     * @return the cost of the RAM
     */
    public float getCostRam() {
        return costRam;
    }

    /**
     * @param costRam set the cost of the RAM
     */
    public void setCostRam(float costRam) {
        this.costRam = costRam;
    }

    /**
     * @return the cost of the power supply
     */
    public float getCostPowerSupply() {
        return costPowerSupply;
    }

    /**
     * @param costPowerSupply set the cost of the power supply
     */
    public void setCostPowerSupply(float costPowerSupply) {
        this.costPowerSupply = costPowerSupply;
    }

    /**
     * @return the cost of the GPU
     */
    public float getCostGpu() {
        return costGpu;
    }

    /**
     * @param costGpu set the cost of the GPU
     */
    public void setCostGpu(float costGpu) {
        this.costGpu = costGpu;
    }

    /**
     * @return the cost of the assembler
     */
    public float getCostAssemble() {
        return costAssemble;
    }

    /**
     * @param costAssemble set the cost of the assembler
     */
    public void setCostAssemble(float costAssemble) {
        this.costAssemble = costAssemble;
    }

    /**
     * @return the cost of the PM
     */
    public float getCostProjectManager() {
        return costProjectManager;
    }

    /**
     * @param costProjectManager set the cost of the PM
     */
    public void setCostProjectManager(float costProjectManager) {
        this.costProjectManager = costProjectManager;
    }

    /**
     * @return the cost of the director
     */
    public float getCostDirector() {
        return costDirector;
    }

    /**
     * @param costDirector set the cost of the director
     */
    public void setCostDirector(float costDirector) {
        this.costDirector = costDirector;
    }

    /**
     * @return the total earnings in sales 
     */
    public float getEarnings() {
        return earnings;
    }

    /**
     * @param earning set the total earning
     */
    public void setEarnings(float earnings) {
        this.earnings = earnings;
    }

    /**
     * @return the total profit (earnings-total cost)
     */
    public float getNetProfit() {
        return netProfit;
    }

    /**
     * @param netProfit the total earnings in sales - minus the total cost
     */
    public void setNetProfit(float netProfit) {
        this.netProfit = netProfit;
    }

    /**
     * @return total salary discounted from the PM
     */
    public int getSalaryFault() {
        return salaryFault;
    }

    /**
     * @param salaryFault set the total salary lost by the PM
     */
    public void setSalaryFault(int salaryFault) {
        this.salaryFault = salaryFault;
    }
/**
     * @return the total costs of production
     */
    public float getTotalCosts() {
        return totalCosts;
    }

    /**
     * @param totalCosts set total cost
     */
    public void setTotalCosts(float totalCosts) {
        this.totalCosts = totalCosts;
    }

    /**
     * @return the number of days left
     */
    public int getDaysCountdown() {
        return daysCountdown;
    }

    /**
     * @param daysCountdown set the number of days left
     */
    public void setDaysCountdown(int daysCountdown) {
        this.daysCountdown = daysCountdown;
    }

    /**
     * @return the numbers of regular computers produced since the last computer with a GPU
     */
    public int getComputerSinceGpuComputer() {
        return computerSinceGpuComputer;
    }

    /**
     * @param setComputerSinceGpuComputer set the total amount of regular computers produced after the last GPU computer
     */
    public void setComputerSinceGpuComputer(int computerSinceGpuComputer) {
        this.computerSinceGpuComputer = computerSinceGpuComputer;
    }
    
    
    
    
    
}
