package coding;
import java.util.*;
import java.io.*;

public class Main {

  /* How to run the code
   * javac Main.java
   * java -Xms896m -Xmx896m -Xss64m -XX:+UseSerialGC coding.Main < coding/sample.in > coding/sample.out
   */
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int m = in.nextInt();
      System.out.println("Case #" + i + ": " + (n + m) + " " + (n * m));
    }
  }
}
