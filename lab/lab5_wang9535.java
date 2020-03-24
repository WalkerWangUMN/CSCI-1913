class Sieve{
  private boolean [] numbers;
  public Sieve(int max){
    if (max < 2){
      throw new IllegalArgumentException ("Max is less than 2.");
    }
    else{
      numbers = new boolean [max];
      for (int i = 0; i < max; i++){
        if (i < 2){
          numbers[i] = false;
        }
        else{
            numbers[i] = true;
        }
      }
    }
  }

  public void findPrimes(){
    for (int i = 0; i < numbers.length; i++){
      if (numbers[i]){
        for (int a = i+1; a < numbers.length; a++){
          if (a % i == 0){
            numbers[a] = false;
          }
        }
      }
    }
  }

  public String toString(){
    String str = " ";
    for (int i = 0; i < numbers.length; i++){
      if (numbers[i]){
        str = str + i +" ";
      }
    }
    return str;
  }
}

class TossTheKnees
{

//  MAIN. Find some primes.

  public static void main(String [] args)
  {
    Sieve sieve = null;  //  We must initialize SIEVE or Java will cry.

//  5 points. This must print "Sieve size must be at least 2." but without the
//  quotes.

    try
    {
      sieve = new Sieve(0);
    }
    catch (IllegalArgumentException oops)
    {
      System.out.println("Sieve size must be at least 2.");
    }

//  5 points. This must print nothing.

    try
    {
      sieve = new Sieve(100);
    }
    catch (IllegalArgumentException oops)
    {
      System.out.println("Sieve size must be at least 2.");
    }

//  10 points. This must print integers from 2 to 99, separated by blanks.

    System.out.println(sieve);

//  10 points. This must print the prime numbers between 2 and 99, separated by
//  blanks. They are:
//
//  2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97

    sieve.findPrimes();
    System.out.println(sieve);
  }
}

/*
Sieve size must be at least 2.
2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99
2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97
*/