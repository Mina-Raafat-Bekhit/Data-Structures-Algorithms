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
public class Stack {
    
    Node head ;
    Node tail ; 
    
    StackNode headt ;

    public Stack(){
    
        head = null ;
        tail = null ;
    
    }
    public void push(String x){
    
        Node n = new Node(x);
        if(n != null){
        
            if(head == null){
            
                head = n ;
                tail = n ;
            
            }else{
            
                n.next = head ;
                head = n ;
                
            }
        }
    
    }
     public void pusht(Nodet x){
    
        if (x == null) return;
        StackNode newNode = new StackNode(x);
        newNode.next = headt;
        headt = newNode;
    
    }
    public Nodet popt(){
    
        if (headt != null) {
            Nodet temp = headt.treeNode;
            headt = headt.next;
            return temp;
        }
        return null;
        
    }
    public String pop(){
    
        if(head != null){
        
            String s = head.data ;
            head = head.next ;
            return s ;
        }else{System.out.println("Stack is empty");
        return null ;
        }
    
    }
    public String top(){
    
        if(head != null){
        
            String s = head.data ;
            return s ;
        }else{System.out.println("Stack is empty");
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
    public boolean isemptyt() {
        return headt == null;
    }
}
class StackNode {
    Nodet treeNode;
    StackNode next;
    public StackNode(Nodet treeNode) { this.treeNode = treeNode; }
}