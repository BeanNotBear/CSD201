/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg10_binarysearchtree;

/**
 *
 * @author nghin
 */
public class Node {
    int val;
    Node left;
    Node right;

    public Node() {
    }
    
    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
}
