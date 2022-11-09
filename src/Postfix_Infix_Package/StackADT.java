package Postfix_Infix_Package;
/**
 * This class creates a Stack data structure
 * The class includes an Inner Class which acts as the
 * individual nodes of the Stack
 * @author Michael Vibert
 * @version ver 1.0.0
 */
public class StackADT<Character>
{
    private StackNode<Character> head = null;
    private StackNode<Character> tail = null;
    private int stackSize = 0;

//------------------------------------------- Start of StackNode class -------------------------------------------\\

    private static class StackNode<Character>
    {
        private Character data;
        private StackNode<Character> next;
        /**
         * This is a constructor for the class StackNode
         * @param data Object Character is the element which the node will contain
         * @param next Object StackNode is the reference to the next StackNode in the Stack
         */
        public StackNode(Character data, StackNode<Character> next)
        {
            this.data = data;
            this.next = next;
        }
        /**
         * This is a method that checks the precedence of the character passed
         * @return a Character which is contained in the Node
         */
        public Character getData()
        {
            return data;
        }
        /**
         * A method that looks for the next Node in the Stack
         * @return a Node of object StackNode
         */
        public StackNode<Character> getNext()
        {
            return next;
        }
    }

//------------------------------------------- End of StackNode class -------------------------------------------\\
    /**
     * A default constructor for the class StackADT
     */
    public StackADT()
    {
    }
    /**
     * This is a method that returns the Node at the head of the Stack
     * @return a Node of object StackNode
     */
    public StackNode<Character> getHead()
    {
        return head;
    }
    /**
     * This is a method checks if there is any Nodes in the Stack
     * @return a Boolean answer
     */
    public boolean isEmpty()
    {
        return stackSize == 0;
    }
    /**
     * A method that removes the topmost Node from the Stack
     * @return the Character which is contained in the Node
     * to be removed
     */
    public Character pop()
    {
        if (isEmpty())
        {
            return null;
        }

        Character data = this.head.getData();
        this.head = this.head.getNext();
        stackSize--;

        if(stackSize == 0)
        {
            tail = null;
        }
        return data;
    }
    /**
     * This method will print the whole Stack.
     * It accesses the element (Character) within each
     * Node of the Stack and prints them to the terminal
     */
    public void print()
    {
        StackNode<Character> temp = getHead();
        while (temp != null)
        {
            System.out.print(temp.getData() + ",\t");
            temp = temp.getNext();
        }
    }
    /**
     * This is a method for adding a new node to the Stack
     * @param data Object Character is the element which the
     * new Node will contain
     */
    public void push(Character data)
    {
        head = new StackNode<Character>(data, head);
        if (isEmpty())
        {
            tail = head;
        }
        stackSize++;
    }
    /**
     * This is a method for accessing the topmost Node element
     * without removing the Node
     * @return a Character held by the Node
     */
    public Character stackTop()
    {
        return head.getData();
    }
}