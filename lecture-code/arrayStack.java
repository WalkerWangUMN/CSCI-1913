//
//  ARRAY STACK. A fixed length stack implemented as an array.
//
//    James Moen
//    05 Nov 19
//

//  ARRAY STACK. A fixed length stack of BASEs implemented using an array.

class ArrayStack<Base>
{
  private int     count;   //  How many BASEs are the stack.
  private Base [] values;  //  The BASEs themselves.
  public ArrayStack()
  {
    this(0);
  }
  public ArrayStack(int size)
  {
    if (size >= 0)
    {
      count = 0;
      values = (Base []) new Object [size];
    }
    else
    {
      throw new IllegalArgumentException("Stack size is negative.");
    }
  }
  public boolean isEmpty()
  {
    return count == 0;
  }
  public boolean isFull()
  {
    return count >= values.length;
  }
  public Base peek()
  {
    if (isEmpty())
    {
      throw new IllegalStateException("Stack is empty.");
    }
    else
    {
      return values[count - 1];
    }
  }
  public void pop()
  {
    if (isEmpty())
    {
      throw new IllegalStateException("Stack is empty.");
    }
    else
    {
      count -= 1;
      values[count] = null;
    }
  }
  public void push(Base value)
  {
    if (isFull())
    {
      throw new IllegalStateException("Stack is full.");
    }
    else
    {
      values[count] = value;
      count += 1;
    }
  }
}

//  ARRAY STACK DRIVER. Demonstrate how an ARRAY STACK works.

class ArrayStackDriver
{

//  MAIN. Run it.

  public static void main(String [] args)
  {

//  Make a new STACK and PUSH some strings into it.

    ArrayStack<String> stack = new ArrayStack<String>(3);

    stack.push("C");
    stack.push("B");
    stack.push("A");

//  Now POP the strings off the stack and print them.

    System.out.println(stack.isEmpty());            //  false
    System.out.println(stack.isFull());             //  true

    System.out.println(stack.peek()); stack.pop();  //  A
    System.out.println(stack.peek()); stack.pop();  //  B
    System.out.println(stack.peek()); stack.pop();  //  C

    System.out.println(stack.isEmpty());            //  true
    System.out.println(stack.isFull());             //  false
  }
}
