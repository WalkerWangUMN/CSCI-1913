class Zillion {
	private int[ ] digits;
	private int size;

	public Zillion(int size){
		this.size = size;
		digits = new int [size];
	}

	public void increment(){
    for(int i = 1; i <= size; i++){
      if(digits[size - i] == 9){
        digits[size - i] = 0;
      }
      else{
        digits[size - i] += 1;
        break;
      }
    }
	}

	public String toString(){
	  String str = "";
	  for (int i = 0; i < size; i++){
	    str += digits[i];
	  }
	  return str;
	}
}

class Driver
{
  public static void main(String[] args)
  {
    Zillion z = new Zillion(2);
    System.out.println(z);  //  00  2 points

    z.increment();
    System.out.println(z);  //  01  2 points

    z.increment();
    System.out.println(z);  //  02  2 points

    z.increment();
    z.increment();
    z.increment();
    z.increment();
    z.increment();
    z.increment();
    z.increment();
    z.increment();

    System.out.println(z);  //  10  2 points
    z.increment();
    System.out.println(z);  //  11  2 points

    z = new Zillion(4);
    System.out.println(z);  //  0000  2 points

    for (int j = 1; j <= 999; j += 1)
    {
      z.increment();
    }
    System.out.println(z);  //  0999  2 points

    z.increment();
    System.out.println(z);  //  1000  2 points

    for (int j = 1; j <= 999; j += 1)
    {
      z.increment();
    }
    System.out.println(z);  //  1999  2 points

    z.increment();
    System.out.println(z);  //  2000  2 points

    for (int j = 1; j <= 7999; j += 1)
    {
      z.increment();
    }
    System.out.println(z);  //  9999  2 points

    z.increment();
    System.out.println(z);  //  0000  2 points

    z.increment();
    System.out.println(z);  //  0001  1 point
  }
}

/*
00
01
02
10
11
0000
0999
1000
1999
2000
9999
0000
0001
*/
