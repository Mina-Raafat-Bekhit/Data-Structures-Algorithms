/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task.data;

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Mega Store
 */
public class TaskData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");
        try {
            Scanner sc = new Scanner(inputFile);
            PrintWriter writer = new PrintWriter(outputFile);
            if (!sc.hasNextLine()) {
            System.out.println("file is empty");
            writer.close(); 
            sc.close();
            System.exit(0);
            } else { 
                String x = "";    
                while (sc.hasNextLine()){
                x += sc.nextLine();
                }
                System.out.println("tokinz is :-" + "\n");
                Queue q = totokins(x);
                Queue q1 = totokins(x);
                q.print();
                System.out.println("postfix is :-" + "\n");
                Queue q2 = postfix(q);
                Queue q3 = postfix(q1);
                q2.print();
                ExpressionBST myTree = ExpressionBST.buildExpressionTree(q3); 
                System.out.println(" Tree Traversals :-");
                System.out.print("Inorder Traversal: ");
                myTree.inorder(myTree.root);
                System.out.println();
                System.out.print("Preorder Traversal: ");
                myTree.preorder(myTree.root);
                System.out.println();
                System.out.print("Postorder Traversal: ");
                myTree.postorder(myTree.root);
                System.out.println();
                double d = result(q2);
                writer.println(d);
                System.out.println("\n" + "Result printed in the file");
                writer.close(); 
                sc.close();}
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TaskData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Queue totokins( String x ) {
       
       x = x.replaceAll("\\s+", "");
       if(x.isEmpty()) {
           System.out.println("no expression"); 
           System.exit(0);
       }
       if(x.charAt(0) == '+' || x.charAt(0) == '*' || x.charAt(0) == '/' || x.charAt(0) == '%' || x.charAt(0) == '^' || ( x.charAt(0) == '(' && ( x.charAt(1) == '+' || x.charAt(1) == '*' || x.charAt(1) == '/' || x.charAt(1) == '%' || x.charAt(1) == '^' ))){
           System.out.println("cant start with operation"); 
           System.exit(0);
       }
       Queue q = new Queue();
       int i = 0 ;
       int l = x.length() ;
       int open = 0 ;
       int close = 0 ;
        while (i<l) {            
            boolean dot = false ;
            if(x.charAt(i) == '('){open++ ;}
            if(x.charAt(i) == ')'){close++ ;}
            if(Character.isDigit(x.charAt(i)) || (x.charAt(i) == '-' && (i == 0 || x.charAt(i - 1) == '(' || x.charAt(i - 1) == '-' || x.charAt(i - 1) == '+' || x.charAt(i - 1) == '*' || x.charAt(i - 1) == '/' || x.charAt(i - 1) == '%' || x.charAt(i - 1) == '^'))){
                String s = "" + x.charAt(i) ;
                i++ ;
                while (i<l && (Character.isDigit(x.charAt(i)) || x.charAt(i) == '.')){
                
                    if(x.charAt(i)=='.'){if(dot == true){
                        System.out.println("invalid number (ex 3.3.5)");
                        System.exit(0);
                    }else{dot = true ;}}
                    s += x.charAt(i) ;
                    i++ ;
                
                }
                q.EnQueue(s);
            }else if (x.charAt(i) == '-' || x.charAt(i) == '+' || x.charAt(i) == '*' || x.charAt(i) == '/' || x.charAt(i) == '%' || x.charAt(i) == '^' || x.charAt(i) == '(' || x.charAt(i) == ')' ){
                String s = "" + x.charAt(i) ;
                q.EnQueue(s);
                i++ ;
            }else{
                System.out.println("invalid character");
                System.exit(0);
            }
        }
        if(open != close){
            System.out.println("parentheses error");
            System.exit(0);
        }
        return q ;
    }
    public static void fillHashTable(String expression, HashTable ht, String methodType) {
   
    Queue tokens = totokins(expression);
    
    while (!tokens.isempty()) {
        String t = tokens.DeQueue(); 
        if (isNumber(t)) {
            double num = Double.parseDouble(t);
            
            switch (methodType.toLowerCase()) {
                case "linear": ht.insertLinear(num); break;
                case "quadratic": ht.insertQuadratic(num); break;
                case "double": ht.insertDoubleHashing(num); break;
                case "chaining": ht.insertChaining(num); break;
                }
            }
        }
    }
    public static boolean isNumber(String s) {
    if (Character.isDigit(s.charAt(0))) return true;
    if (s.length() > 1 && s.charAt(0) == '-') return true; 
    return false;
    }
    public static Queue postfix(Queue q){
    
        Stack s = new Stack();
        Queue q2 = new Queue();
        
        while(!q.isempty()) {
            String st = q.DeQueue();
            if(Character.isDigit(st.charAt(0)) || st.length() > 1){
                  q2.EnQueue(st);
            }else if(st.equals("(")){s.push(st);}
            else if(st.equals(")")){
                while(!s.top().equals("(")){
                    if(s.isempty()){System.out.println("paranthese error");
                       System.exit(0);
                    }
                    q2.EnQueue(s.pop());
                }
                s.pop();
            }else{
            
                while(!s.isempty() && (priorty(s.top()) >= priorty(st))){
                    q2.EnQueue(s.pop());
                }
                s.push(st);
            }
        }
        while(!s.isempty()){
                q2.EnQueue(s.pop());
        }
    return q2 ;
    }
    public static int priorty(String op) {
    switch (op) {
        case "^":
            return 3;
        case "*":
        case "/":
        case "%":
            return 2;
        case "+":
        case "-":
            return 1;
        default:
            return -1;
    }
}
    public static double result(Queue q){
    
        Stack s = new Stack();
        while (!q.isempty()) {
        
            String st = q.DeQueue();
            if(Character.isDigit(st.charAt(0)) || st.length() > 1){s.push(st);}
            else{
            
                double b = Double.parseDouble(s.pop()) ;
                double a = Double.parseDouble(s.pop()) ;
                switch(st){
                
                    case "+": 
                        String c1 = Double.toString(a + b) ;
                        s.push(c1);
                        break;
                    case "-":
                        String c2 = Double.toString(a - b) ;
                        s.push(c2);
                        break;
                    case "*":
                        String c3 = Double.toString(a * b) ;
                        s.push(c3);
                        break;
                    case "%":
                        String c4 = Double.toString(a % b) ;
                        s.push(c4);
                        break;
                    case "^":
                        String c5 = Double.toString(Math.pow(a, b)) ;
                        s.push(c5);
                        break;
                    case "/": 
                        if (b == 0) {
                            System.out.println("Error: Division by zero");
                            System.exit(0);
                        } 
                        String c6 = Double.toString(a/b) ;
                        s.push(c6);
                        break;
                }
                
            }
        }
    return Double.parseDouble(s.pop()) ;
    }
}
