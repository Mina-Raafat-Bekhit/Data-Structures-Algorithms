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
class Nodet {
    String data;
    Nodet left, right;

    public Nodet(String data) {
        this.data = data;
        left = right = null;
    }
}

class ExpressionBST {
    Nodet root;

    public void insert(String data) {
        root = insertRec(root, data);
    }

    private Nodet insertRec(Nodet root, String data) {
        if (root == null) {
            return new Nodet(data);
        }
        if (data.compareTo(root.data) < 0)
            root.left = insertRec(root.left, data);
        else
            root.right = insertRec(root.right, data);
        return root;
    }
    public static ExpressionBST buildExpressionTree(Queue postfixQueue) {
    
        Stack s = new Stack();
    
    while (!postfixQueue.isempty()) {
        String st = postfixQueue.DeQueue();
        Nodet newNode = new Nodet(st);
        
        if (!TaskData.isNumber(st)) {
            newNode.right = s.popt(); 
            newNode.left = s.popt();
        }
        s.pusht(newNode); 
    }
    
    ExpressionBST tree = new ExpressionBST();
    tree.root = s.popt(); 
    return tree;
}

    public void inorder(Nodet node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + "  ");
            inorder(node.right);
        }
    }

    public void preorder(Nodet node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder(Nodet node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }
}