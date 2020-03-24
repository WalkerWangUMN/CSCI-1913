class RunnyStack<Base>{
  private class Run{
    private Base base;
    private Run next;
    private int length;
    private Run(Base base, Run next){
      this.base = base;
      this.next = next;
      this.length = 1;
    }
  }
  private int depth;
  private int runs;
  private Run top;
  public RunnyStack(){
    top = null;
  }
  public int depth(){
    return depth;
  }
  public boolean isEmpty(){
    return top == null;
  }
  public Base peek(){
    if(isEmpty()){
      throw new IllegalStateException("stack is is empty");
    }
    else{
      return top.base;
    }
  }
  public void pop(){
    if(isEmpty()){
      throw new IllegalStateException("stack is empty");
    }
    else{
      top.length -= 1;
      if(top.length == 0){
        top = top.next;
        runs -= 1;
      }
      depth -= 1;
    }
  }
  public void push(Base base){
    if(isEmpty()){
      top = new Run(base, top);
      depth += 1;
      runs += 1;
    }
    else{
      if(isEqual(top.base, base)){
        top.length += 1;
      }
      else{
        top = new Run(base, top);
        runs += 1;
      }
      depth += 1;
    }
  }
  public boolean isEqual (Base base1, Base base2){
    if(base1 == null || base2 == null){
      return base1 == base2;
    }
    else{
      return base1.equals(base2);
    }
  }
  public int runs(){
    return runs;
  }
}


class Camembert
{
  public static void main(String [] args)
  {
    RunnyStack<String> s = new RunnyStack<String>();

    System.out.println(s.isEmpty());         //  true       1 point
    System.out.println(s.depth());           //  0          1 point
    System.out.println(s.runs());            //  0          1 point

    try
    {
      s.pop();
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("No pop");          //  No pop     1 point
    }

    try
    {
      System.out.println(s.peek());
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("No peek");         //  No peek    1 point
    }

    s.push("A");
    System.out.println(s.peek());            //  A          1 point
    System.out.println(s.depth());           //  1          1 point
    System.out.println(s.runs());            //  1          1 point

    System.out.println(s.isEmpty());         //  false      1 point

    s.push("B");
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  2          1 point
    System.out.println(s.runs());            //  2          1 point

    s.push("B");
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  3          1 point
    System.out.println(s.runs());            //  2          1 point

    s.push("B");
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  4          1 point
    System.out.println(s.runs());            //  2          1 point

    s.push("C");
    System.out.println(s.peek());            //  C          1 point
    System.out.println(s.depth());           //  5          1 point
    System.out.println(s.runs());            //  3          1 point

    s.push("C");
    System.out.println(s.peek());            //  C          1 point
    System.out.println(s.depth());           //  6          1 point
    System.out.println(s.runs());            //  3          1 point

    s.pop();
    System.out.println(s.peek());            //  C          1 point
    System.out.println(s.depth());           //  5          1 point
    System.out.println(s.runs());            //  3          1 point

    s.pop();
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  4          1 point
    System.out.println(s.runs());            //  2          1 point

    s.pop();
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  3          1 point
    System.out.println(s.runs());            //  2          1 point

    s.pop();
    s.pop();
    System.out.println(s.peek());            //  A          1 point
    System.out.println(s.depth());           //  1          1 point
    System.out.println(s.runs());            //  1          1 point

    s.pop();
    System.out.println(s.isEmpty());         //  true       1 point
    System.out.println(s.depth());           //  0          1 point
    System.out.println(s.runs());            //  0          1 point

    try
    {
      System.out.println(s.peek());
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("No peek");         //  No peek    1 point
    }
  }
}
