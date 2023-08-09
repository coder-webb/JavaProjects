// Codey Webb

public class DoublyLinkedList {

       //data
       private DSNode head;
       private DSNode tail;
       
   
       //methods
       public DSNode getHead()
       {
           return head;
       }
       //IsEmpty
       public boolean IsEmpty()
       {
           return head == null;
       }

       //AddFirst - using a String
       public void AddFirst(String newValue)
       {
           //create a new node
           DSNode node = new DSNode(newValue);
   
           if(IsEmpty()) // we're adding the first node
           {
               tail = node;
               head = node;
           }
           else{
               //point to new node the head
               node.next = head;
               head.previous = node;
               //make the head point to new node
               head = node;
           }
       }
       //AddFirst - using a Node
       public void AddFirst(DSNode newNode)
       {
   
           if(IsEmpty())//we're adding the first node
           {
               tail = newNode;
               head = newNode;
           }
           else{
               //point to new node the head
               newNode.next = head;
               head.previous = newNode;
               //make the head point to new node
               head = newNode;
           }
       }
       //AddLast - using a String
       public void AddLast(String newValue)
       {
           if(IsEmpty()) // if head is null
           {
               AddFirst(newValue);
           }
           else
           {
              //create a new node
               DSNode node = new DSNode(newValue);
       
               //link the last node to new Node
               tail.next = node;
            
               //link new node to current tail
               node.previous = tail;

               //update the tail
               tail = node;
           }
       }
       //AddLast - using a Node
       public void AddLast(DSNode newNode)
       {
           if(IsEmpty()) // if head is null
           {
               AddFirst(newNode);
           }
           else
           {
               //link the last node to new Node
               tail.next = newNode;
            
               //link new node to current tail
               newNode.previous = tail;

               //update the tail
               tail = newNode;
           }
       }

       //Print
       public void Print()
       {
           if(IsEmpty()) // if head is null
           {
               System.out.println("The list is empty!");
           }
           else
           {
               DSNode finger = head; // finger starts at the head
   
               while(finger!= null) // does finger point to a node?
               {
                   // read the value out loud
                   System.out.print(finger.value +" ");
                   // move the finger to the right
                   finger = finger.next;
               }
               System.out.println();
           }
       }
       //Clear
       public void Clear()
       {   // remove the head and tail nodes, deleting the whole list
           head = null;
           tail = null;
       }
   
       //DeleteFirst
       public void DeleteFirst() throws Exception
       {
           if(IsEmpty()) // if head is empty
           {
               throw new Exception("You cannot delete from an empty list");
           }
           else if(tail == head) // if we only have one node
           {
               head = tail = null;
           }
           else
           {
               head = head.next; // move head to the current heads next node
               head.previous = null; // remove heads previous node
           }
       }
       //DeleteLast
       public void DeleteLast() throws Exception
       {
           if(IsEmpty()) // if head is null
           {
               throw new Exception("You cannot delete from an empty list");
           }
           else if(head.next == null) // if head.next is null i.e. if there is only one element
           {
               Clear();
           }
           else
           {   
               tail = tail.previous; // tails previous node becomes the new tail
               tail.next = null; // tails next node is null
           }
       }
       //DeleteValue
       public void DeleteValue(String value) throws Exception
       {
           if(IsEmpty()) // if head is null
           {
               throw new Exception("You cannot delete from an empty list");
           }
           else if(head.next == null) // if head.next is null i.e. if there is only one element
           {
               Clear();
           }
           else if (tail.value == value) // if tail has the value to delete
           {
               DeleteLast();
           }
           else if (head.value == value) // if head has the value to delete
           {
               DeleteFirst();
           }
           else
           {
               DSNode finger = head; // initialize a finger node to search the list

               while (finger.next != null) // while finger doesn't point to the end of the list
               {
                   if (finger.value == value) // if finger has the value to delete
                   {  // link the finger's previous and next nodes together, deleting the finger
                      finger.previous.next = finger.next;
                      finger.next.previous = finger.previous;
                      break; // end the while loop
                   }
                   finger = finger.next; // else point finger to the next node
               }
           }
       }
       //DeleteNode
       public void DeleteNode(DSNode nodeToDelete) throws Exception
       {
            if(IsEmpty()) // if head is null
            {
               throw new Exception("You cannot delete from an empty list");
            }
            else if (head == tail && tail == nodeToDelete) // if there is only 1 node and that is the nodeToDelete
            {
                Clear();
            }
            else if (head == nodeToDelete) // if head is the nodeToDelete
            {
                DeleteFirst();
            }
            else if (tail == nodeToDelete) // if tail is the nodeToDelete
            {
                DeleteLast();
            }
            else
            {   // link the nodeToDelete's previous and next nodes together, deleting the nodeToDelete
                nodeToDelete.previous.next = nodeToDelete.next; 
                nodeToDelete.next.previous = nodeToDelete.previous;
            }
       }
       
       //Reverse the list
       public void Reverse() throws Exception
       {    
            if(IsEmpty()) // if head is null
            {
                throw new Exception("You cannot reverse an empty list");
            }
            else if (head.next == null) // if there is only 1 node
            {
                throw new Exception("There is only 1 item in this list");
            }
            else
            {
                DSNode finger = head; // initalize a pointer Node with the head node
                DSNode temp; // temporary reference for nodes

                // while finger still references a node
                while (finger != null) {
                    temp = finger.previous; // hold the previous node in temp
                    finger.previous = finger.next; // swap the current nodes previous and next nodes
                    finger.next = temp; // point the current nodes next to temp's node
                    finger = finger.previous; // move finger
                }

                // swap head and tail
                temp = head;
                head = tail;
                tail = temp;
            }
       }
}