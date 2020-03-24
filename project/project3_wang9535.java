import java.io.FileReader;   //  Read Unicode chars from a file.
import java.io.IOException;  //  In case there's IO trouble.

//  WORDS. Iterator. Read words, represented as STRINGs, from a text file. Each
//  word is the longest possible contiguous series of alphabetic ASCII CHARs.

class Words
{
  private int           ch;      //  Last CHAR from READER, as an INT.
  private FileReader    reader;  //  Read CHARs from here.
  private StringBuilder word;    //  Last word read from READER.
//  Constructor. Initialize an instance of WORDS, so it reads words from a file
//  whose pathname is PATH. Throw an exception if we can't open PATH.
  public Words(String path)
  {
    try
    {
      reader = new FileReader(path);
      ch = reader.read();
    }
    catch (IOException ignore)
    {
      throw new IllegalArgumentException("Cannot open '" + path + "'.");
    }
  }
//  HAS NEXT. Try to read a WORD from READER, converting it to lower case as we
//  go. Test if we were successful.
  public boolean hasNext()
  {
    word = new StringBuilder();
    while (ch > 0 && ! isAlphabetic((char) ch))
    {
      read();
    }
    while (ch > 0 && isAlphabetic((char) ch))
    {
      word.append(toLower((char) ch));
      read();
    }
    return word.length() > 0;
  }
//  IS ALPHABETIC. Test if CH is an ASCII letter.
  private boolean isAlphabetic(char ch)
  {
    return 'a' <= ch && ch <= 'z' || 'A' <= ch && ch <= 'Z';
  }
//  NEXT. If HAS NEXT is true, then return a WORD read from READER as a STRING.
//  Otherwise, return an undefined STRING.
  public String next()
  {
    return word.toString();
  }
//  READ. Read the next CHAR from READER. Set CH to the CHAR, represented as an
//  INT. If there are no more CHARs to be read from READER, then set CH to -1.
  private void read()
  {
    try
    {
      ch = reader.read();
    }
    catch (IOException ignore)
    {
      ch = -1;
    }
  }
//  TO LOWER. Return the lower case ASCII letter which corresponds to the ASCII
//  letter CH.
  private char toLower(char ch)
  {
    if ('a' <= ch && ch <= 'z')
    {
      return ch;
    }
    else
    {
      return (char) (ch - 'A' + 'a');
    }
  }
//  MAIN. For testing. Open a text file whose pathname is the 0th argument from
//  the command line. Read words from the file, and print them one per line.
  public static void main(String [] args)
  {
    Words words = new Words(args[0]);
    while (words.hasNext())
    {
      System.out.println("'" + words.next() + "'");
    }
  }
}
class AnagramTree{
  private class TreeNode{
    private byte summary[];
    private WordNode words;
    private TreeNode left;
    private TreeNode right;
    private TreeNode(byte summary[], WordNode words, TreeNode left, TreeNode right){
        this.summary = summary;
        this.words = words;
        this.left = left;
        this.right = right;
    }
  }
  private class WordNode{
    private String word;
    private WordNode next;
    private WordNode(String word, WordNode next){
        this.word = word;
        this.next = next;
    }
  }
  private TreeNode head;
  private TreeNode root;
  public AnagramTree(){
      byte arr []  = new byte[26];
      head = new TreeNode(arr,null,null,null);
      root = null;
  }
  public void add(String word){
    byte checkArr[] = stringToSummary(word);
    WordNode wordNode = new WordNode(word, null);
    TreeNode subtree = root;
    if(subtree == null){
      root = new TreeNode(checkArr, wordNode, null, null);
    }
    else{
      TreeNode above = head;
      while(true){
        int checkNum = compareSummaries(checkArr, subtree.summary);
        if(checkNum < 0){
          above = subtree;
          subtree = subtree.left;
          if(subtree == null){
            above.left = new TreeNode(checkArr, wordNode, null, null);
            return;
          }
        }
        else if(checkNum > 0){
          above = subtree;
          subtree = subtree.right;
          if(subtree == null){
            above.right = new TreeNode(checkArr, wordNode, null, null);
            return;
          }
        }
        else{
          WordNode check = subtree.words;
          while(check != null){
            if(check.word.equals(word)){
              return;
            }
            check = check.next;
          }
          subtree.words = new WordNode(word, subtree.words);
          return;
        }
      }
    }
  }
  public void anagrams(){
    help(root);
  }
  public void help(TreeNode root){
      TreeNode subtree = root;
      if(subtree != null){
        if(subtree.words.next != null){
          WordNode temp = subtree.words;
          while(temp != null){
              System.out.print(temp.word);
              System.out.print(" ");
              temp = temp.next;
          }     
          System.out.println();
        }
        help(subtree.left);
        help(subtree.right);
      }
  }
  private int compareSummaries(byte[] left, byte[] right){
      int index = 0;
      while(index<left.length && index<right.length){
          if(left[index] == right[index]){
              index += 1;
          }
          else{
              return left[index] - right[index];
          }
      }
      return left.length - right.length;
  }
  private byte[] stringToSummary(String word){
    byte arr[] = new byte [26];
    return helper(arr, word);
  }
  private byte[] helper(byte arr[], String word){
      if(word.length() == 0){
        return arr; 
      }
      else{
        int index = word.charAt(0) - 'a';
        arr[index] += 1;   
        return helper(arr, word.substring(1,word.length()));
      }
  }
}

class Anagrammer{
    public static void main(String [] args){
      Words words = new Words("warAndPeace.txt");
      byte arr[] = new byte[26];
      AnagramTree tree = new AnagramTree();
      while(words.hasNext()){
        tree.add(words.next());  
      }
      tree.anagrams();
    }
}
