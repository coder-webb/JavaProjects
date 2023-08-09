public class MyQueue extends SinglyLinkedListWithTail {
    //data ... this

    //methods
    //Enqueue
    public void Enqueue(String newValue)//O(1)
    {
        AddLast(newValue);
    }

    //Dequeue
    public String Dequeue() throws Exception // O(1)
    {
        try
        {
            String ret = getHead().value;
            DeleteFirst();
            return ret;
        }
        catch(Exception e)
        {
            throw new Exception("empty queue ... cannot delete");
        }
    }
    //Peek
    public String Peek()
    {
        return getHead().value;
    }
    //IsEmpty - not needed ... we have inheritance
    //Clear - not needed ... we have inheritance
}
