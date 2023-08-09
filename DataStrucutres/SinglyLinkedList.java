public class SinglyLinkedList {
    //data
    private DSNode head;

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

        //point to new node the head
        node.next = head;

        //make the head point to new node
        head = node;
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
    public void AddLast(String newValue)//O(n)
    {
        if(IsEmpty())
        {
            AddFirst(newValue);
        }
        else{
            //traverse to find the last node
            DSNode finger = head;
            while(finger.next!=null)
            {
                finger = finger.next;//move finger to the right
            }
    
            //create a new node
            DSNode node = new DSNode(newValue);
    
            //link the last node to new Node
            finger.next = node;
        }
    }
    //Clear
    public void Clear()
    {
        head = null;
    }

    //DeleteFirst - O(1)
    public void DeleteFirst() throws Exception
    {
        if(IsEmpty())
        {
            throw new Exception("You cannot delete from an empty list");
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
        }
    }


    //ctor(s)
}
