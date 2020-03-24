class AssociationList<Key, Value>{
  private class Node{
    private Key key;
    private Value value;
    private Node next;
    private Node(Key key, Value value, Node next){
      this.key = key;
      this.next = next;
      this.value = value;
    }
  }
  private Node head;
  public AssociationList(){
    head = new Node(null, null, null);
  }
  public void delete(Key key){
    Node left = head;
    Node right = head.next;
    while(right != null){
      if(isEqual(right.key, key)){
        left.next = right.next;
        break;
      }
      left = right;
      right = right.next;
    }
  }
  public Value get(Key key){
    Node right = head.next;
    while(right != null){
      if(isEqual(right.key, key)){
        return right.value;
      }
      right = right.next;
    }
    throw new IllegalArgumentException("no Node has a key slot.");
  }
  public boolean isEqual(Key leftkey, Key rightkey){
    if(leftkey == null || rightkey == null){
      return leftkey == rightkey;
    }
    else{
      return leftkey.equals(rightkey);
    }
  }
  public boolean isIn(Key key){
    Node right = head.next;
    while(right != null){
      if(isEqual(right.key, key)){
        return true;
      }
      right = right.next;
    }
    return false;
  }
  public void put(Key key, Value value){
    Node right = head.next;
    while(right != null){
      if(isEqual(right.key, key)){
        right.value = value;
        return;
      }
      right = right.next;
    }
    head.next = new Node(key, value, head.next);
  }
}




class Hogwarts
{

//  MAIN. Make an instance of ASSOCIATION LIST and test it.

  public static void main(String[] args)
  {
    AssociationList<String,String> list = new AssociationList<String,String>();

    System.out.println(list.isIn(null));         //  false         2 points.

    try
    {
      System.out.println(list.get(null));
    }
    catch (IllegalArgumentException ignore)
    {
      System.out.println("No null");             //  No null       2 points.
    }

    list.put(null,        "Wormtail");
    list.put("Ron",       "Lavender");
    list.put("Voldemort", null);
    list.put("Dean",      "Ginny");

    System.out.println(list.isIn("Dean"));       //  true          2 points.
    System.out.println(list.isIn("Ginny"));      //  false         2 points.
    System.out.println(list.isIn("Ron"));        //  true          2 points.
    System.out.println(list.isIn("Voldemort"));  //  true          2 points.
    System.out.println(list.isIn(null));         //  true          2 points.
    System.out.println(list.isIn("Joanne"));     //  false         2 points.

    System.out.println(list.get("Ron"));         //  Lavender      2 points.
    System.out.println(list.get("Dean"));        //  Ginny         2 points.
    System.out.println(list.get("Voldemort"));   //  null          2 points.
    System.out.println(list.get(null));          //  Wormtail      2 points.

    try
    {
      System.out.println(list.get("Joanne"));
    }
    catch (IllegalArgumentException ignore)
    {
      System.out.println("No Joanne");           //  No Joanne     2 points.
    }

    list.delete(null);

    System.out.println(list.isIn(null));         //  false         2 points.

    list.put(null,    null);
    list.put("Harry", "Ginny");
    list.put("Ron",   "Hermione");

    System.out.println(list.isIn(null));         //  true          2 points.
    System.out.println(list.get(null));          //  null          2 points.
    System.out.println(list.get("Harry"));       //  Ginny         2 points.
    System.out.println(list.get("Dean"));        //  Ginny         2 points.
    System.out.println(list.get("Ron"));         //  Hermione      2 points.

    list.delete("Dean");

    try
    {
      System.out.println(list.get("Dean"));
    }
    catch (IllegalArgumentException ignore)
    {
      System.out.println("No Dean");             //  No Dean       2 points.
    }
  }
}
