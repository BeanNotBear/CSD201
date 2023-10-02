/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg10_binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author nghin
 */
public class MyBST {

    Node root;

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int val) {
        Node newNode = new Node(val);
        if (root == null) {
            root = newNode;
            return;
        }
        Node cur = root;
        while (true) {
            if (val < cur.val) {
                if (cur.left == null) {
                    cur.left = newNode;
                    break;
                } else {
                    cur = cur.left;
                }
            } else {
                if (cur.right == null) {
                    cur.right = newNode;
                    break;
                } else {
                    cur = cur.right;
                }
            }
        }
    }

    public Node deleteByCopying(Node mRoot, int val) {
        if (mRoot == null) {
            return null;
        }
        if (val < mRoot.val) {
            mRoot.left = deleteByCopying(mRoot.left, val);
            return mRoot;
        } else if (val > mRoot.val) {
            mRoot.right = deleteByCopying(mRoot.right, val);
            return mRoot;
        } else {
            if (mRoot.left == null) {
                return mRoot.right;
            } else if (mRoot.right == null) {
                return mRoot.left;
            } else {
                Node max = mRoot.left;
                while (max.right != null) {
                    max = max.right;
                }
                mRoot.val = max.val;
                mRoot.left = deleteByCopying(mRoot.left, max.val);
                return mRoot;
            }
        }
    }
    
    public Node deleteByMerging(Node mRoot, int val) {
        if(mRoot == null) return null;
        if (val < mRoot.val) {
            mRoot.left = deleteByMerging(mRoot.left, val);
            return mRoot;
        } else if (val > mRoot.val) {
            mRoot.right = deleteByMerging(mRoot.right, val);
            return mRoot;
        } else {
            if (mRoot.left == null) {
                return mRoot.right;
            } else if (mRoot.right == null) {
                return mRoot.left;
            } else {
                Node leftChild = mRoot.left;
                Node min = mRoot.right;
                while (min.left != null) {
                    System.out.println(min.val);                    
                    min = min.left;
                }
                min.left = leftChild;
                mRoot = mRoot.right;
                return mRoot;
            }
        }
    }

    public void preOrder() {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            System.out.print(stack.peek().val + " ");
            Node temp = stack.pop();

            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        System.out.println("");
    }

    public void inOrder() {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
        System.out.println("");
    }

    public void postOrder(Node mRoot) {
        if (mRoot == null) {
            return;
        }
        postOrder(mRoot.left);
        postOrder(mRoot.right);
        System.out.print(mRoot.val + " ");
    }

    public void breathTravesal() {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            System.out.print(queue.peek().val + " ");

            if (queue.peek().left != null) {
                queue.add(queue.peek().left);
            }
            if (queue.peek().right != null) {
                queue.add(queue.peek().right);
            }
            queue.remove();
        }
        System.out.println("");
    }
    
    public int findNumberOfNode() {
        if (root == null) {
            return 0;
        }
        int cnt = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            ++cnt;
            if (queue.peek().left != null) {
                queue.add(queue.peek().left);
            }
            if (queue.peek().right != null) {
                queue.add(queue.peek().right);
            }
            queue.remove();
        }
        return cnt;
    }
    
    private int max(int a, int b) {
        return a >= b ? a : b;
    }
    
    public int findHeightOfTree(Node mRoot) {
        if(mRoot == null) return 0;
        return max(findHeightOfTree(mRoot.left), findHeightOfTree(mRoot.right)) + 1;
    }

    public Node search(int val) {
        if (isEmpty()) {
            return null;
        }
        Node cur = root;
        while (cur != null) {
            if (val < cur.val) {
                cur = cur.left;
            } else if (val > cur.val) {
                cur = cur.right;
            } else {
                return cur;
            }
        }
        return null;
    }

}
