/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg10_binarysearchtree;

import java.util.Scanner;
import jdk.nashorn.internal.parser.Lexer;

/**
 *
 * @author nghin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final Scanner sc = new Scanner(System.in);
        MyBST bst = new MyBST();
        bst.insert(10);
        bst.insert(6);
        bst.insert(15);
        bst.insert(2);
        bst.insert(8);
        bst.insert(7);
        bst.insert(13);
        bst.insert(11);
        bst.insert(19);
        
        
        System.out.print("Pre-Order traversal: ");
        bst.preOrder();
        System.out.print("In-Order traversal: ");
        bst.inOrder();
        System.out.print("Post-Order traversal: ");
        bst.postOrder(bst.root);
        System.out.println("");
        System.out.print("Breath traversal:" );
        bst.breathTravesal();
        System.out.println("Height of tree: " + bst.findHeightOfTree(bst.root));
        bst.deleteByMerging(bst.root, 6);
        System.out.print("Pre-Order traversal: ");
        bst.preOrder();
        System.out.print("In-Order traversal: ");
        bst.inOrder();
        System.out.print("Post-Order traversal: ");
        bst.postOrder(bst.root);
        System.out.println("");
        System.out.print("Breath traversal:" );
        bst.breathTravesal();
        
        try {
            int k = Integer.parseInt(sc.nextLine());
            System.out.println(bst.search(k).val);
        } catch (Exception e) {
            System.out.println("Not found");
        }
        
        
    }
    
}
