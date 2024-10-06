/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Companies;

/**
 * Enum class that defines a unique ID for each company 
 * @author ani
 */
public enum CompanyType {
 
    // 0: Apple, 1: Dell
    Apple(0), Dell(1);
    
    private final int id;
    
    private CompanyType(int id){
        this.id = id;
    }

    /**
     * @return the id of the company
     */
    public int getId() {
        return id;
    }
    
}
