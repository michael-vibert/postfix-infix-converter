package Postfix_Infix_Package;

/**
 * This class coverts an expression given as a String
 * from infix notion to postfix notation
 * @author Michael Vibert
 * @version ver 1.0.0
 */
public class InfixConverter
{
    private String expression;
    private QueueADT infix = new QueueADT();
    private QueueADT postfix = new QueueADT();
    private StackADT<Character> stack1 = new StackADT<Character>();

    /**
     * This is a constructor for the class InfixConverter
     * @param expression Object String is passed as a parameter
     */
    public InfixConverter(String expression)
    {
        this.expression = expression;
    }
    /**
     * This is a method that checks the precedence of the character passed
     * @param chToCheck Object Character is passed as a parameter
     * @return an Integer representing the ranking of the character
     * compared to other characters
     */
    public int checkPrecedence(char chToCheck)
    {
        switch (chToCheck)
        {
            case '+', '-':
            {
                return 1;
            }

            case '*', '/', '%':
            {
                return 2;
            }

            case '^':
            {
                return 3;
            }

            default:
            {
                return -1;
            }
        }
    }
    /**
     * This is a method checks if the input contains either 2 digits in a row
     * or two operators in a row which would make the input invalid
     * @return a Boolean answer
     */
    public boolean checkRepeats()
    {
        convertToChar();
        char ch = infix.dequeue();
        while (!infix.isEmpty())
        {
            if (isOperator(ch) && isOperator(infix.queueFront()) || (isDigit(ch) && isDigit(infix.queueFront())))
            {
                return false;
            }
            else
                ch = infix.dequeue();
        }
        return true;
    }
    /**
     * This is a method checks if the input is valid for processing
     * @return a Boolean answer
     */
    public boolean checkValid()
    {
        int rParenthesis = 0;
        int lParenthesis = 0;
        int length = expression.length();

        for (int i = 0; i < expression.length(); i++)
        {
            if (expression.charAt(i) == '(')
            {
                lParenthesis++;
            } else if (expression.charAt(i) == ')')
            {
                rParenthesis++;
            }
            else if (!isOperator(expression.charAt(i)))
            {
                if  (!isDigit(expression.charAt(i)))
                {
                    return false;
                }
            }
        }

        if(rParenthesis != lParenthesis)
        {
            return false;
        }

        if (isOperator(expression.charAt(0)) || isOperator(expression.charAt(length - 1)))
        {
            return false;
        }
        return checkRepeats();
    }
    /**
     * This is a method converts the postfix queue
     * back into a string and prints it to the screen
     */
    public String convertBackToString()
    {
        Character ch = ' ';
        String postFixString = "";
        while (!postfix.isEmpty())
        {
            if (!postfix.isEmpty())
            {
                ch = postfix.dequeue();
            }
            postFixString += ch;
        }
        System.out.println("=====>>");
        System.out.println("Postfix expression after processing: ");
        System.out.println(postFixString);
        return postFixString;
    }
    /**
     * This is a method that turns a string into queue of characters
     * It utilises the fields of this class to perform this task
     */
    public void convertToChar()
    {
        for (int i = 0; i < expression.length(); i++)
        {
            char ch = expression.charAt(i);
            infix.enQueue(ch);
        }
    }
    /**
     * This is a method that manipulates the flow of characters
     * in your infix expression and converts it into
     * a postfix expression
     * It utilises the fields of this class to perform this task
     */
    public String convertToPostfix()
    {
        System.out.println("Your infix expression is: " + expression);
        stack1.push('(');
        if(!checkValid())
        {
            System.out.println("Your expression is not valid... System is shutting down.");
            System.exit(-1);
        }
        convertToChar();
        infix.enQueue(')');

        while (!infix.isEmpty())
        {
            char ch = infix.dequeue();
            if (isDigit(ch))
            {
                postfix.enQueue(ch);
            }

            else if (ch == '(')
            {
                stack1.push(ch);
            }

            else if (ch == ')')
            {
                while (!stack1.isEmpty() && stack1.stackTop() != '(')
                {
                    postfix.enQueue(stack1.pop());
                }
                stack1.pop();
            }

            else if (isOperator(ch))
            {
                while (!stack1.isEmpty() && checkPrecedence(ch)
                        <= checkPrecedence(stack1.stackTop()))
                {
                    postfix.enQueue(stack1.pop());
                }
                stack1.push(ch);
            }
//
//            else
//            {
//                System.out.println("You have entered a non-valid expression, system is shutting down");
//                System.exit(-1);
//            }
        }
        return convertBackToString();
    }
    /**
     * This is a method checks if a character is a digit from 0-9
     * @param chToCheck Object Character is passed as a parameter
     * @return a Boolean answer
     */
    public boolean isDigit(char chToCheck)
    {
        return chToCheck >= '0' && chToCheck <= '9';
    }
    /**
     * This is a method checks if a character is an operator
     * @param chToCheck Object Character is passed as a parameter
     * @return a Boolean answer
     */
    public boolean isOperator(char chToCheck)
    {
        return chToCheck == '+' || chToCheck == '-' ||
                chToCheck == '*' || chToCheck == '/'
                || chToCheck == '%' || chToCheck == '^';
    }
}
