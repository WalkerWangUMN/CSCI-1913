class Deque<Base>{
  private class Node{
    Base object;
    Node left;
    Node right;
    private Node(Base object, Node left, Node right){
      this.object = object;
      this.left = left;
      this.right = right;
    }
  }
  private Node head;
  public Deque(){
    head = new Node(null, null, null);
    head.left = head;
    head.right = head;
  }
  public void enqueueFront(Base object){
    Node p = new Node(object, head, head.right);
    head.right.left = p;
    head.right = p;
  }
  public void enqueueRear(Base object){
    Node q = new Node(object, head.left, head);
    head.left.right = q;
    head.left = q;
  }
  public Base dequeueFront(){
    if(isEmpty()){
      throw new IllegalStateException("Deque is empty");
    }
    else{
      Node n = head.right;
      Base temp1 = n.object;
      head.right = n.right;
      n.right.left = head;
      return temp1;
    }
  }
    public Base dequeueRear(){
      if(isEmpty()){
        throw new IllegalStateException("Dequeu is empty");
      }
      else{
        Node k = head.left;
        Base temp2 = k.object;
        k.left.right = head;
        head.left = k.left;
        return temp2;
      }
    }
    public boolean isEmpty(){
      if (head.left == head && head.right == head) {
        return true;
      }
      else{
        return false;
      }
    }
}
  class ObservationDeque
  {

  //  MAIN. Test the DEQUE on various example arguments.

    public static void main(String [] args)
    {
      Deque<String> deque = new Deque<String>();

      System.out.println(deque.isEmpty());       // true                2 points.

      try
      {
        System.out.println(deque.dequeueFront());
      }
      catch (IllegalStateException ignore)
      {
        System.out.println("No dequeueFront.");  //  No dequeueFront.   2 points.
      }

      try
      {
        System.out.println(deque.dequeueRear());
      }
      catch (IllegalStateException ignore)
      {
        System.out.println("No dequeueRear.");   //  No dequeueRear.    2 points.
      }

  //  Enqueueing to the rear and dequeueing from the rear makes the DEQUE act
  //  like a stack.

      deque.enqueueRear("A");
      deque.enqueueRear("B");
      deque.enqueueRear("C");

      System.out.println(deque.isEmpty());       //  false              2 points.

      System.out.println(deque.dequeueRear());   //  C                  2 points.
      System.out.println(deque.dequeueRear());   //  B                  2 points.
      System.out.println(deque.dequeueRear());   //  A                  2 points.

      System.out.println(deque.isEmpty());       //  true               2 points.

  //  Enqueueing to the rear and dequeueing from the front makes the DEQUE act
  //  like a queue.

      deque.enqueueRear("A");
      deque.enqueueRear("B");
      deque.enqueueRear("C");

      System.out.println(deque.dequeueFront());  //  A                  2 points.
      System.out.println(deque.dequeueFront());  //  B                  2 points.
      System.out.println(deque.dequeueFront());  //  C                  2 points.

      System.out.println(deque.isEmpty());       //  true               2 points.

  //  Enqueueing to the front and dequeueing from the front makes the DEQUE act
  //  like a stack.

      deque.enqueueFront("A");
      deque.enqueueFront("B");
      deque.enqueueFront("C");

      System.out.println(deque.dequeueFront());  //  C                  2 points.
      System.out.println(deque.dequeueFront());  //  B                  2 points.
      System.out.println(deque.dequeueFront());  //  A                  2 points.

      System.out.println(deque.isEmpty());       //  true               2 points.

  //  Enqueueing to the front and dequeueing from the rear makes the DEQUE act
  //  like a queue.

      deque.enqueueFront("A");
      deque.enqueueFront("B");
      deque.enqueueFront("C");

      System.out.println(deque.dequeueRear());   //  A                  2 points.
      System.out.println(deque.dequeueRear());   //  B                  2 points.
      System.out.println(deque.dequeueRear());   //  C                  2 points.

      System.out.println(deque.isEmpty());       //  true               2 points.
    }
  }
