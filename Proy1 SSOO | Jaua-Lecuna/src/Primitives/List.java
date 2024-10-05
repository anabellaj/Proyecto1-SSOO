/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Primitives;

import Workers.Worker;
import javax.swing.JOptionPane;

/**
 *
 * @author ani
 */
public class List {
    
    private Node head;
    private Node tail;
    private int size;

    public List() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Checks if the list is empty
     * @return true if empty, else false
     */
    public boolean isEmpty(){
        return getHead()==null;
    }
    
    /**
     * Deletes all the elements of a list
     */
    public void empty(){
        setHead(null);
        setTail(null);
        setSize(0);
    }
    
    /**
     * Adds a node to a list
     * @param workerInfo the information to store inside the node
     */
    public void insert(Worker workerInfo){
        Node newNodo = new Node(workerInfo);
        if(isEmpty()){
            setHead(newNodo);
            setTail(newNodo);
        }else{
            getTail().setNext(newNodo);
            setTail(newNodo);
        }
        setSize(getSize()+1);
        newNodo.getWorkerInfo().start();
    }
    
    /**
     * Fires the first worker of the list by removing the node from the list
     * @return true if the node was removed successfully, else false
     */
    public boolean remove(){
        if(getSize()==1){
            JOptionPane.showMessageDialog(null, "La lista no puede estar vacia");
            return false;
        }else if(getSize()>1){
            getHead().getWorkerInfo().fire();
            setHead(getHead().getNext());
            setSize(getSize()-1);
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Gets a node in a certain position
     * @param position to search
     * @return the node
     */
    public Node getNodo(int position){
        if(position > getSize()){
            return null;
        }else if(position==getSize()){
            return getTail();
        }else{
            Node aux = getHead();
            for (int i = 0; i < position; i++) {
                aux = aux.getNext();
            }
            return aux;
        }
    }
    
    /**
     * Gets the first node of the list
     * @return the first node of the list
     */
    public Node getHead() {
        return head;
    }

    /**
     * Sets the first node of the list
     * @param head node to set
     */
    public void setHead(Node head) {
        this.head = head;
    }

    /**
     * Gets the last node of the list
     * @return the last node of the list
     */
    public Node getTail() {
        return tail;
    }

    /**
     * Sets the last node of the list
     * @param tail node to set
     */
    public void setTail(Node tail) {
        this.tail = tail;
    }

    /**
     * Gets the size of the list
     * @return the size of the list
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets the size of the list
     * @param size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    
    
    
    
}
