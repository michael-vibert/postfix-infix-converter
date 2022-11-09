package Postfix_Infix_Package;
/**
 * This class creates a Queue Data Structure
 * It utilises two Objects of type StackADT to
 * achieve a functional Queue
 * @author Michael Vibert
 * @version ver 1.0.0
 */
public class QueueADT
{
    private StackADT<Character> stack = new StackADT<>();
    private StackADT<Character> queue = new StackADT<>();
    /**
     * A default constructor for the class QueueADT
     */
    public QueueADT()
    {
    }
    /**
     * This is a method that removes the Node at the front of
     * the Queue.
     * @return a Character which is contained in the removed Node
     */
    public Character dequeue()
    {
        while (!stack.isEmpty())
        {
            queue.push(stack.pop());
        }

        return queue.pop();
    }
    /**
     * A method that adds a new Node at the back of the Queue.
     */
    public void enQueue(Character data)
    {
        stack.push(data);
    }
    /**
     * This is a method checks if there is any Nodes in the Queue
     * @return a Boolean answer
     */
    public boolean isEmpty()
    {
        return stack.isEmpty() && queue.isEmpty();
    }
    /**
     * This method will print the whole Queue.
     * It accesses the element (Character) within each
     * Node of the Stack and prints them to the terminal
     */
    public void print()
    {
        StackADT<Character> temp = new StackADT<>();
        while (!queue.isEmpty())
        {
            temp.push(queue.pop());
        }

        while (!stack.isEmpty())
        {
            queue.push(stack.pop());
        }

        while(!temp.isEmpty())
        {
            queue.push(temp.pop());
        }

        queue.print();
        System.out.println(" ");
    }
    /**
     * This method will print the whole Stack.
     * It accesses the element (Character) within each
     * Node of the Stack and prints them to the terminal
     */
    public char queueFront()
    {
        StackADT<Character> temp = new StackADT<>();
        while (!queue.isEmpty())
        {
            temp.push(queue.pop());
        }

        while (!stack.isEmpty())
        {
            queue.push(stack.pop());
        }

        while(!temp.isEmpty())
        {
            queue.push(temp.pop());
        }

        return queue.stackTop();
    }
}