/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Primitives;

import Workers.Worker;

/**
 * Class that defines a node that contains the information of a worker 
 * @author ani
 */
public class Node {
    
    private Worker workerInfo;
    private Node next;

    public Node(Worker workerInfo) {
        this.workerInfo = workerInfo;
        this.next = null;
    }

    /**
     * Gets the information of the worker 
     * @return the information of the worker 
     */
    public Worker getWorkerInfo() {
        return workerInfo;
    }
    
    /**
     * Sets the information of the worker 
     * @param workerInfo the worker to store inside the node 
     */
    public void setWorkerInfo(Worker workerInfo) {
        this.workerInfo = workerInfo;
    }

    /**
     * Gets the node next to the actual node
     * @return the next node
     */
    public Node getNext() {
        return next;
    }

    /**
     * Sets the next node to the actual node
     * @param next the next node to set
     */
    public void setNext(Node next) {
        this.next = next;
    }

    
}
