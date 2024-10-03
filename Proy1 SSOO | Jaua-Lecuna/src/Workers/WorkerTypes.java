/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Workers;

/**
 *
 * @author ani
 */
public enum WorkerTypes {
    
    MotherboardProducer(0), CpuProducer(1), PowerSupplyProducer(2), RamProducer(3), GpuProducer(4), Assembler(5), ProjectManager(6), Director(7);
    
    private final int id;
    
    private WorkerTypes(int id){
        this.id = id;
    }

    /**
     * @returns the id of the corresponding worker 
     */
    public int getId() {
        return id;
    }
     
    
}
