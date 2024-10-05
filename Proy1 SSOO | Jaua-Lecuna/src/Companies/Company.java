/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Companies;

import Disk.Disk;
import Main.CommonVariables;
import Primitives.List;
import Primitives.Node;
import Workers.Assembler;
import Workers.Director;
import Workers.Producer;
import Workers.ProjectManager;
import Workers.Worker;
import Workers.WorkerTypes;
import java.util.concurrent.Semaphore;
import javax.swing.JOptionPane;

/**
 * Class that defines the requirements and employees of a company
 * @author ani
 */
public class Company {
    
    protected ComputerRequirements requirements;
    protected Disk disk;

    // MotherboardProducer(0), CpuProducer(1), PowerSupplyProducer(2), RamProducer(3), GpuProducer(4), Assembler(5), ProjectManager(6), Director(7);
    private List[] employees = new List[8];

    private int maxEmployees; // Maximum number of employees
    private int numEmployees; // Current number of employees

    public Company(ComputerRequirements requirements, Disk disk, int numMotherboardProd, int numCpuProd, int numPowerSupplyProd, int numRamProd, int numGpuProd, int numAssemblers, int dayLength) {
        this.requirements = requirements;
        this.disk = disk;
        switch (requirements.getCompanyIdentifier()) {
            case Apple ->
                maxEmployees = 15; // 12 + 3 (20221110543)
            case Dell ->
                maxEmployees = 19; // 12 + 6 (20221110326)
        }

        for (int i = 0; i < this.employees.length; i++) {
            employees[i] = new List();
        }
        System.out.println(requirements.getDayLength());
        for (int i = 0; i < numMotherboardProd; i++) {
            employees[0].insert(this.createWorker(disk, WorkerTypes.MotherboardProducer, disk.getProduced(), dayLength));
        }
        for (int i = 0; i < numCpuProd; i++) {
            employees[1].insert(this.createWorker(disk, WorkerTypes.CpuProducer, disk.getProduced(), dayLength));
        }
        for (int i = 0; i < numPowerSupplyProd; i++) {
            employees[2].insert(this.createWorker(disk, WorkerTypes.PowerSupplyProducer, disk.getProduced(), dayLength));
        }
        for (int i = 0; i < numRamProd; i++) {
            employees[3].insert(this.createWorker(disk, WorkerTypes.RamProducer, disk.getProduced(), dayLength));
        }
        for (int i = 0; i < numGpuProd; i++) {
            employees[4].insert(this.createWorker(disk, WorkerTypes.GpuProducer, disk.getProduced(), dayLength));
        }
        for (int i = 0; i < numAssemblers; i++) {
            employees[5].insert(this.createWorker(disk, WorkerTypes.Assembler, disk.getProduced(), dayLength));
        }

        employees[6].insert(this.createWorker(disk, WorkerTypes.ProjectManager, disk.getProduced(), dayLength));
        employees[7].insert(this.createWorker(disk, WorkerTypes.Director, disk.getProduced(), dayLength));

        numEmployees = numMotherboardProd + numCpuProd + numPowerSupplyProd + numRamProd + numGpuProd + numAssemblers;
        
        this.getRequirements().setDayLength(dayLength);
    }

    /**
     * Fires all the employees of a company
     */
    public void endCompany(){
        for (int i = 0; i < employees.length; i++) {
            for (int j = 0; j < employees[i].getSize(); j++) {

                Node temp = employees[i].getNodo(j);

                if (temp != null) {
                   temp.getWorkerInfo().fire();
                }
            }
        }
    }
    
    /**
     * Creates a worker of a company
     * @param disk 
     * @param type
     * @param semaphore
     * @param dayLength
     * @return 
     */
    public Worker createWorker(Disk disk, WorkerTypes type, Semaphore semaphore, int dayLength) {

        // DP = Daily Production
        double motherboardDP = 0;
        double cpuDP = 0;
        double powerSupplyDP = 0;
        double ramDP = 0;
        double gpuDP = 0;
        double assemblerDP = 0;

        switch (this.getRequirements().getCompanyIdentifier()) {
            case Apple: //Carnet 3
                motherboardDP = 0.34f;
                cpuDP = 0.34f;
                powerSupplyDP = 3;
                ramDP = 2;
                gpuDP = 0.34f;
                assemblerDP = 0.5f;
                break;
            case Dell: //Carnet 6
                motherboardDP = 0.25f;
                cpuDP = 0.25f;
                powerSupplyDP = 5;
                ramDP = 1;
                gpuDP = 0.5f;
                assemblerDP = 0.5f;
                break;
        }
        return switch (type) {
            case MotherboardProducer ->
                new Producer(motherboardDP, disk, type, 20, semaphore, dayLength);
            case CpuProducer ->
                new Producer(cpuDP, disk, type, 26, semaphore, dayLength);
            case RamProducer ->
                new Producer(ramDP, disk, type, 40, semaphore, dayLength);
            case PowerSupplyProducer ->
                new Producer(powerSupplyDP, disk, type, 16, semaphore, dayLength);
            case GpuProducer ->
                new Producer(gpuDP, disk, type, 34, semaphore, dayLength);
            case Assembler ->
                new Assembler(this.getRequirements(), this.getRequirements().getRegComputersBtwnGpu(), type, 50, semaphore, dayLength, disk);
            case ProjectManager ->
                new ProjectManager(type, 40, semaphore, dayLength, disk);
            case Director ->
                new Director(type, 100, semaphore, dayLength, disk, this.getRequirements());
            default ->
                null;
        };
    }

    /**
     * Hires a type worker for a company
     * @param type of worker to hire 
     */
    public void hireEmployee(int type) {

        if (this.getNumEmployees() < this.getMaxEmployees()) {
            switch (type) {
                case 0:
                    Producer motherboard = (Producer) this.createWorker(this.getDisk(), WorkerTypes.MotherboardProducer, this.getDisk().getProduced(), this.getRequirements().getDayLength());
                    this.getEmployees()[0].insert(motherboard);
                    break;
                case 1:
                    Producer cpu = (Producer) this.createWorker(this.getDisk(), WorkerTypes.CpuProducer, this.getDisk().getProduced(), this.getRequirements().getDayLength());
                    this.getEmployees()[1].insert(cpu);
                    break;
                case 2:
                    Producer powerSupply = (Producer) this.createWorker(this.getDisk(), WorkerTypes.PowerSupplyProducer, this.getDisk().getProduced(), this.getRequirements().getDayLength());
                    this.getEmployees()[2].insert(powerSupply);
                    break;
                case 3:
                    Producer ramProd = (Producer) this.createWorker(this.getDisk(), WorkerTypes.RamProducer, this.getDisk().getProduced(), this.getRequirements().getDayLength());
                    this.getEmployees()[3].insert(ramProd);
                    break;
                case 4:
                    Producer gpu = (Producer) this.createWorker(this.getDisk(), WorkerTypes.GpuProducer, this.getDisk().getProduced(), this.getRequirements().getDayLength());
                    this.getEmployees()[4].insert(gpu);
                    break;
                case 5:
                    Assembler assembler = (Assembler) this.createWorker(this.getDisk(), WorkerTypes.Assembler, this.getDisk().getProduced(), this.getRequirements().getDayLength());
                    this.getEmployees()[5].insert(assembler);
                    break;

            }
            this.setNumEmployees(this.getNumEmployees() + 1);
        } else {
            JOptionPane.showMessageDialog(null, "Se ha alcanzado el máximo número de empleados");
        }
    }
    
   
    /**
     * Fires a tyoe of worker by deleting it from the employee list
     * @param type of worker to remove
     */
    public void fireEmployee(int type) {
        if (this.getNumEmployees() > 0) {

            boolean eliminado = employees[type].remove();
            if (eliminado) {
                this.setNumEmployees(this.getNumEmployees() - 1);
            } else {
                JOptionPane.showMessageDialog(null, "El empleado no puede ser eliminado");
            }

        }
    }

    /**
     * Updates the time of the simulation for a company
     * @param type the company to modify
     */
     public void updateTimes(CompanyType type) {

        for (int i = 0; i < employees.length; i++) {
            for (int j = 0; j < employees[i].getSize(); j++) {

                Node temp = employees[i].getNodo(j);

                if (temp != null) {
                    switch (type) {
                        case Apple:
                            employees[i].getNodo(j).getWorkerInfo().setDayLength((int) CommonVariables.dayLengthApple);
                            break;
                        case Dell:
                            employees[i].getNodo(j).getWorkerInfo().setDayLength((int) CommonVariables.dayLengthDell);
                            break;

                    }
                }
            }
        }
    }

     /**
      * Gets the computer requirements 
      * @return the computer requirements
      */
    public ComputerRequirements getRequirements() {
        return requirements;
    }

    /**
     * Sets the computer requirements
     * @param requirements to set
     */
    public void setRequirements(ComputerRequirements requirements) {
        this.requirements = requirements;
    }

    /**
     * Gets the data stored in the object disk
     * @return disk
     */
    public Disk getDisk() {
        return disk;
    }

    /**
     * Sets a new disk to replace the old one
     * @param disk to set
     */
    public void setDisk(Disk disk) {
        this.disk = disk;
    }

    /**
     * Gets a list of all the employees of a company
     * @return list of employees
     */
    public List[] getEmployees() {
        return employees;
    }

    /**
     * Sets a list of employees to a company
     * @param employees to set
     */
    public void setEmployees(List[] employees) {
        this.employees = employees;
    }

    /**
     * Gets the maximum number of employees a company can have
     * @return the maximum number of employees
     */
    public int getMaxEmployees() {
        return maxEmployees;
    }

    /**
     * Sets the maximum number of employees a company can have
     * @param maxEmployees number to set
     */
    public void setMaxEmployees(int maxEmployees) {
        this.maxEmployees = maxEmployees;
    }

    /**
     * Gets the actual number of employees in the company
     * @return the number of employees
     */
    public int getNumEmployees() {
        return numEmployees;
    }

    /**
     * Sets the actual number of employees in the company
     * @param numEmployees to set 
     */
    public void setNumEmployees(int numEmployees) {
        this.numEmployees = numEmployees;
    }

   
    
}
