// Codey Webb

import java.util.ArrayList;
import java.util.LinkedList;

public class Main
{
    public static void main(String[] args) {
        //Node node = new Node("Chad");
        BST tree = new BST();


        // Create nodes with values
        // tree.Insert("e");
        // tree.Insert("b");
        // tree.Insert("a");
        // tree.Insert("c");
        // tree.Insert("g");
        // tree.Insert("f");
        // tree.Insert("h");
        // tree.Insert("d");

        // Create nodes and add them to tree
        BSTNode e = new BSTNode("e");
        BSTNode b = new BSTNode("b");
        BSTNode a = new BSTNode("a");
        BSTNode c = new BSTNode("c");
        BSTNode g = new BSTNode("g");
        BSTNode f = new BSTNode("f");
        BSTNode h = new BSTNode("h");
        BSTNode d = new BSTNode("d");
        tree.Insert(e);
        tree.Insert(b);
        tree.Insert(a);
        tree.Insert(c);
        tree.Insert(g);
        tree.Insert(f);
        tree.Insert(h);
        tree.Insert(d);

        // Test breadthFirstTraversal and print the values of the nodes
        ArrayList<LinkedList<BSTNode>> results = tree.breadthFirstTraversal();
        for (LinkedList<BSTNode> linkedList : results) {
            for (BSTNode node : linkedList) {
                System.out.print(node.value + " ");
            }
            System.out.println();
        }

        // Test if there is a path between nodes
        System.out.println(tree.hasPath(a, d)); // false
        System.out.println(tree.hasPath(e, e)); // true
        System.out.println(tree.hasPath(e, h)); // true

        // Test count internal nodes
        System.out.println(tree.countInternalNodes()); // Should be 4
    }
}