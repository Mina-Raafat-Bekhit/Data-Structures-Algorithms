/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task.data;

/**
 *
 * @author Mega Store
 */
public class Node {

    String data ;
    Node next ; 
    Node prev ;

    public Node(String x){
    
        data = x ;
        next = null ;
        prev = null ;
    
    }
}
