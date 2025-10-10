package October_2025.potdOct_10_2025;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;


class Node {
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}


public class potdOct_10_2025 {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.right.right = new Node(11);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        //         20
        //       /   \
        //      8     22
        //    /  \     \
        //   4   12    11
        //      /  \
        //     10   14

        ArrayList<Integer> res = zigZagTraversal(root);
        for (int val : res) System.out.print(val + " ");
        System.out.println();
    }

    private static ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        //System.out.println(root.data);
        if(root==null)
            return res;

        Deque<Node> q = new LinkedList<>();
        q.addLast(root);

        boolean flipDir = false;

        while(!q.isEmpty()){

            int n = q.size();

            while(n-->0) {

                if (!flipDir) {// traverse left to right
                    Node curr = q.removeFirst();
                    res.add(curr.data);
                    //System.out.println("!fliptraversal : "+curr.data);
                    if(curr.left!=null) q.addLast(curr.left);
                    if(curr.right!=null) q.addLast(curr.right);
                }
                else { //flipDir==true traverse right to left
                    Node curr = q.removeLast();
                    res.add(curr.data);
                    if(curr.right!=null) q.addFirst(curr.right);
                    if(curr.left!=null) q.addFirst(curr.left);
                }
            }
            flipDir=!flipDir;
        }

        return res;
    }
}
