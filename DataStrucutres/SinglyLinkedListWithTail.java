public class SinglyLinkedListWithTail {
    
   //data
    private DSNode head;
    private DSNode tail;

    //methods
    public DSNode getHead()
    {
        return head;
    }
    
    //IsEmpty
    public boolean IsEmpty() //running time O(1)
    {
/*         if(head==null)
            return true;
        else
            return false; */
        return head == null;
    }
    //AddFirst
    public void AddFirst(String newValue) //running time O(1)
    {
        //create a new node
        DSNode node = new DSNode(newValue);

        if(IsEmpty())//we're adding the first node
        {
            tail = node;
            head = node;
        }
        else{
            //point to new node the head
            node.next = head;
    
            //make the head point to new node
            head = node;
        }
    }
    //Print
    public void Print() //running time O(n)
    {
        if(IsEmpty())
        {
            System.out.println("The list is empty!");
        }
        else
        {
            DSNode finger = head; //finger starts at the head

            while(finger!= null)//does finger point to a node?
            {
                //read the value out loud
                System.out.print(finger.value +" ");
                //move the finger to the right
                finger = finger.next;
            }
            System.out.println();
        }
    }
    //AddLast
    public void AddLast(String newValue)//O(1)
    {
        if(IsEmpty())
        {
            AddFirst(newValue);
        }
        else{
           //create a new node
            DSNode node = new DSNode(newValue);
    
            //link the last node to new Node
            tail.next = node;

            //update the tail
            tail = node;
        }
    }
    //Clear
    public void Clear()
    {
        head = null;
        tail = null;
    }

    //DeleteFirst - O(1)
    public void DeleteFirst() throws Exception
    {
        if(IsEmpty())
        {
            throw new Exception("You cannot delete from an empty list");
        }
        else if(tail == head) //we only have one node
        {
            head = tail = null;
        }
        else{
            head = head.next;
        }
    }
    //DeleteLast - O(n)
    public void DeleteLast() throws Exception
    {
        if(IsEmpty())//if head is null
        {
            throw new Exception("You cannot delete from an empty list");
        }
        else if(head.next == null) //if head.next is null i.e. if there is only one element
        {
            DeleteFirst();
        }
        else
        {
            DSNode finger = head;
    
            //moves finger from head to the next to last node
            while(finger.next.next!=null)
            {
                finger = finger.next;//move finger to the right
            }
            //link out the last node
            finger.next = null;

            //move the tail
            tail = finger;
        }
    }


    //ctor(s)
}

