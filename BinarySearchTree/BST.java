// Codey Webb


import java.util.ArrayList;
import java.util.LinkedList;

public class BST {
    //data
    BSTNode root;


//==================================================================================
//===========                    Homework Starts                         ===========
//==================================================================================
    // Problem 1
    public ArrayList<LinkedList<BSTNode>> breadthFirstTraversal() { //Running time O(n)
        
        // Create an array list of linked lists to hold the results
        ArrayList<LinkedList<BSTNode>> bfsResults = new ArrayList<LinkedList<BSTNode>>();

        // Starting point for the traversal (at the root level)
        int currentLevel = 0;

        // Create a linked list for the root node and add it to bfsResults
        LinkedList<BSTNode> rootNode = new LinkedList<BSTNode>();
        rootNode.add(root);
        bfsResults.add(currentLevel, rootNode);

        boolean changesMade = true;; // Tracks if there were additions make to future linked lists
        int currentDepth = 0; // Tracks current depth in the tree

        while (changesMade) // Loop continues while changes are made
        {
            changesMade = false; // Sets changes made to false at the start of every loop

            // Get a list of nodes from the previous depth
            LinkedList<BSTNode> previousNodes = bfsResults.get(currentDepth);
            // Initialize a new linked list of nodes
            LinkedList<BSTNode> newLinkedList = new LinkedList<BSTNode>();
            
            // Traverse the previous nodes
            for (BSTNode node : previousNodes)
            {
                if (node.left != null) // If the node has a left
                {
                    newLinkedList.add(node.left);  // Add node to the new LinkedList
                    changesMade = true; // Set changes were made to true
                }
                if (node.right != null)  // If the node has a right
                {
                    newLinkedList.add(node.right); // Add node to the new LinkedList
                    changesMade = true; // Set changes were made to true
                }
            }

            if (!changesMade) // If no changes were made, break the loop
                break;

            currentDepth++; // Go 1 level deeper
            bfsResults.add(currentDepth, newLinkedList); // Add the newLinkedList to the index matching the current depth
        }

        return bfsResults; // Return the result list of linked lists
    }

    // Problem 2
    public int countInternalNodes() 
    {
        return countInternalNodes(root);
    }
    private int countInternalNodes(BSTNode current)
    {
        // If the current node is null or a leaf node, return 0
        if (current == null || (current.left == null && current.right == null)) {
            return 0;
        }

        // Count the current node and recursively call countInternalNodes again
        return 1 + countInternalNodes(current.left) + countInternalNodes(current.right);
    }

    // Problem 3
    public boolean hasPath(BSTNode from, BSTNode to)
    {
        ArrayList<BSTNode> emptyPath = new ArrayList<BSTNode>();

        boolean pathFound = hasPath(from, to, emptyPath);

        return pathFound;
    }
    private boolean hasPath(BSTNode currentNode, BSTNode destinationNode, ArrayList<BSTNode> path)
    {
        // If current or destination Nodes are null, no path exists
        if (currentNode == null || destinationNode == null)
            return false; // return false

        // Else if destination node was found, path was found, return true
        if (currentNode == destinationNode)
            return true;

        // Add current node to the current path
        path.add(currentNode);
        
        // Recursively check the current node's left and right node
        if (hasPath(currentNode.left, destinationNode, path) ||
            hasPath(currentNode.right, destinationNode, path))
            return true;

        return false;
    }


//==================================================================================
//===========                    Homework Ends                           ===========
//==================================================================================
    //methods
    public int NumberOfAllLetters()
    {
        return NumberOfAllLettersHelper(root);
    }

    public int NumberOfAllLettersHelper(BSTNode current)
    {
      if(current==null)
      {
        return 0;
      }
      else
      {
        //divide and conquer then combine
        return current.value.length() +
        NumberOfAllLettersHelper(current.left) +
        NumberOfAllLettersHelper(current.right);
      }
    }



    public int FindHeight()
    {
        return FindHeightHelper(root);
    }

    public int FindHeightHelper(BSTNode current)
    {
        if(current == null)
        {
            return -1;
        }
        else
        {
            return Math.max( FindHeightHelper(current.left), 
                             FindHeightHelper(current.right))+1;
        }
    }

    public int CountNodes() //O(n)
    {
        return CountNodesHelper(root);
    }

    public int CountNodesHelper(BSTNode current) //O(n)
    {
        if(current!=null)
        {
            return CountNodesHelper(current.left)+CountNodesHelper(current.right)+1;
        }
        else
            return 0;
    }


    public int CountLeafNodes()
    {
        return CountLeafNodesHelper(root);
    }

    public int CountLeafNodesHelper(BSTNode current)
    {
        if(current==null)
        {
            return 0;
        }
        else if(current.left == null && current.right == null)
        {
            return 1; //you found a leaf node!
        }
        else
        {
            return CountLeafNodesHelper(current.left)+ CountLeafNodesHelper(current.right);
        }
    }

    //Delete - skip
    //Clear
    public void Clear() //running time O(1)
    {
        root = null;
    }

    //IsEmpty
    public boolean IsEmpty() //running time O(1)
    {
        return root == null;
    }

    //Search
    public BSTNode Search(String valueSearched) //running time O(n)
    {
        BSTNode finger = root;

        while(finger!=null) //does finger point to a node?
        {   
            if(finger.value.equals(valueSearched))  //check its value
            {
                return finger;//found it!
            }
            else if(valueSearched.compareTo(finger.value)<0)
            {
                finger = finger.left;//go left
            }
            else
            {
                finger = finger.right;//go right
            }
        }
        //we get here when finger points to null
        return null;
    }


    public boolean Search2(String value) //running time O(n)
    {
        return Search(value) != null;
    }
    
    //Insert
    public void Insert(String someValue) //running time O(n)
    {
        BSTNode node = new BSTNode(someValue);//create a new node

        if(IsEmpty())
        {
            root = node; //make root point to the new node
            //root =new Node(someValue);
        }
        else
        {
            //start at the root
            BSTNode finger = root;

            while(true) //traverse the tree
            {
                if(someValue.compareTo(finger.value)  <=  0)
                {
                    if(finger.left!=null)//is there a left node???
                    {
                        finger = finger.left; //if there is a left node then move finger to left
                    }
                    else
                    {
                        //if there is no left node then link in new node to the left
                        finger.left = node;
                        break; //done with the loop
                    }
                }
                else
                {
                    if(finger.right!=null)//is there a right node???
                    {
                        finger = finger.right; //if there is a right node then move finger to right
                    }
                    else
                    {
                        //if there is no right node then link in new node to the right
                        finger.right = node;
                        break; //done with the loop
                    }
                }
            }
        }
    }
//Insert
    public void Insert(BSTNode newNode) //running time O(n)
    {
        if(IsEmpty())
        {
            root = newNode;
        }
        else
        {
            //start at the root
            BSTNode finger = root;

            while(true) //traverse the tree
            {
                if(newNode.value.compareTo(finger.value)  <=  0)
                {
                    if(finger.left!=null)//is there a left node???
                    {
                        finger = finger.left; //if there is a left node then move finger to left
                    }
                    else
                    {
                        //if there is no left node then link in new node to the left
                        finger.left = newNode;
                        break; //done with the loop
                    }
                }
                else
                {
                    if(finger.right!=null)//is there a right node???
                    {
                        finger = finger.right; //if there is a right node then move finger to right
                    }
                    else
                    {
                        //if there is no right node then link in new node to the right
                        finger.right = newNode;
                        break; //done with the loop
                    }
                }
            }
        }
    }
    //Max/Min
    public String Max() throws Exception //running time O(n)
    {
        BSTNode finger = root;
        if(IsEmpty())
        {
            throw new Exception("no max in empty tree");
        }
        else
        {
            while(finger.right != null)
            {
                finger = finger.right;
            }

            //finger now points at right most node
            return finger.value;
        }
    }


    //Traversals
    //PreOrder - NLR
    public void PreOrder() //running time O(n)
    {
        PreOrderHelper(root);
    }

     //running time O(n)
    public void PreOrderHelper(BSTNode current) //think of current as "finger"
    {
        if(current!=null)
        {
            System.out.println(current.value); //N - visit the node
            PreOrderHelper(current.left); //L - visit the left subtree
            PreOrderHelper(current.right); //R - visit the left subtree
        }
    }

    //InOrder - LNR
    public void InOrder()
    {
        InOrderHelper(root);
    }

    public void InOrderHelper(BSTNode current) //think of current as "finger"
    {
        if(current!=null)
        {
            InOrderHelper(current.left); //L - visit the left subtree
            System.out.println(current.value); //N - visit the node
            InOrderHelper(current.right); //R - visit the left subtree
        }
    }


    //PostOrder - LRN

    //CountLeafNodes
    //FindHeight
    


    //ctor
}
