// Codey Webb

public class Main {

    public static void main(String[] args) throws Exception {
        // create some nodes to test with
        DSNode n1 = new DSNode("Alex");
        DSNode n2 = new DSNode("Ben");
        DSNode n3 = new DSNode("Jess");

        // create a DoublyLinkedList
        DoublyLinkedList dll = new DoublyLinkedList();

        // test AddFirst and AddLast with nodes and print
        dll.AddFirst(n1);
        dll.AddLast(n2);
        dll.AddLast(n3);
        dll.Print();
        
        // test AddFirst and AddLast with values and print
        dll.AddFirst("Codey");
        dll.AddLast("Kalynn");
        dll.AddLast("William");
        dll.Print();

        // reverse the list and print
        dll.Reverse();
        dll.Print();

        // test DeleteValue and DeleteNode and print
        dll.DeleteValue("Codey");
        dll.DeleteNode(n2);
        dll.Print();

        // test DeleteFirst and DeleteLast and print
        dll.DeleteFirst();
        dll.DeleteLast();
        dll.Print();

        // test IsEmpty
        System.out.println("Dll is empty: " + dll.IsEmpty());

        // test Clear and check if dll is empty
        dll.Clear();
        System.out.println("Dll is empty: " + dll.IsEmpty());
    }
}