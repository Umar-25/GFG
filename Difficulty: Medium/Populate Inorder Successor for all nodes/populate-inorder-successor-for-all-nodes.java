//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node left, right, next;

    public Node(int data) { this.data = data; }
}

class GFG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static Node Inorder(Node root) {
        if (root.left == null) return root;
        return Inorder(root.left);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution obj = new Solution();
            obj.populateNext(root);
            Node ptr = Inorder(root);
            while (ptr != null) {
                System.out.print(ptr.data + "->" +
                                 (ptr.next != null ? ptr.next.data : -1) + " ");

                ptr = ptr.next;
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

/*
class Node {
    int data;
    Node left, right,next;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    private Node prev = null;

    public void populateNext(Node root) {
        if (root == null) return;

        populateNext(root.left);

        if (prev != null) {
            prev.next = root;
        }
        prev = root;

        populateNext(root.right);
    }

    public static void main(String[] args) {
        // Example to test the function
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.right.left = new Node(12);
        root.right.right = new Node(20);

        Solution sol = new Solution();
        sol.populateNext(root);

        // Add code to print or verify the result if necessary
        // For example, print the 'next' of each node in in-order traversal
        printNextPointers(root);
    }

    private static void printNextPointers(Node root) {
        if (root == null) return;

        printNextPointers(root.left);
        System.out.print("Node " + root.data + " next is ");
        if (root.next != null) {
            System.out.println(root.next.data);
        } else {
            System.out.println("null");
        }
        printNextPointers(root.right);
    }
}