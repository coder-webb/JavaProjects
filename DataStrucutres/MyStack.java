/**
 * MyStack
 */
public class MyStack {
    //data - fields
    private SinglyLinkedList data = new SinglyLinkedList();
    private int count = 0;

    //actions - methods
    //Push -O (1)
    public void Push(String newValue)
    {
        count++;//increase count
        data.AddFirst(newValue);
    }
    //Pop - O(1)
    public String Pop() throws Exception
    {
        count--; //what if the list is empty
        String ret = data.getHead().value;
        data.DeleteFirst();
        return ret;
    }
    //Peek - O(1)
    public String Peek()
    {
        return data.getHead().value;
    }

    //Clear - O(1)
    public void Clear()
    {
        count= 0;
        data.Clear();
    }

    //IsEmpty - O(1)
    public boolean IsEmpty()
    {
        return data.IsEmpty();
    }
    //getCount 
    public int GetCount()
    {
        return count;
    }

    //ctor
    
}