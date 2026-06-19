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
public class Queue {
    
    Node head ;
    Node tail ; 

    public Queue(){
    
        head = null ;
        tail = null ;
    
    }
    public void EnQueue(String x){
    
        Node n = new Node(x);
        if(n != null){
        
            if(head == null){
            
                head = n ;
                tail = n ;
            
            }else{
            
                tail.next = n ;
                tail = n ;
                
            }
        }
    
    }
    public String DeQueue(){
    
        if(head != null){
        
            String s = head.data ;
            head = head.next ;
            return s ;
        }else{System.out.println("Queue is empty");
        return null ;
        }
    
    }
    
    public void print(){
      Node temp = head ;
        while(temp != null){
        
            System.out.println(temp.data + "\n");
            temp = temp.next ;
        }
    }
    public boolean isempty(){
    
        if(head == null){return true ;}
        else{return false ;}
        
    }
}
