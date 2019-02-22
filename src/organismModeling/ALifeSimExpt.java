package organismModeling;

import java.io.PrintWriter;

public class ALifeSimExpt {
  public static void main(String[] args) throws Exception {
    
    PrintWriter pen = new PrintWriter(System.out, true);
    if (args.length != 3) {
      throw new Exception(
          "Usage java ALifeSimExpt: <#/cooperators> <#/defectors> <#/partial cooperators>");
    } // if wrong number of arguments, throw exception
    pen.println("+--------------------------------------------------------+");
    pen.println("+ Tests for ALifeSim: 10 trials with 100 iterations each +");
    pen.println("+--------------------------------------------------------+");
    pen.println();
    pen.println();
    
    pen.println("TESTING WITH ARGS: 100 " + args[0] + " " + args[1] + " " + args[2]);
    pen.println("-------------------------------");
    pen.println();
    for (int i = 0; i < 10; i++) {
      pen.println("Test #" + (i+1));
      pen.println();
      String[] arguments = new String[] {"100", args[0], args[1], args[2]};
      ALifeSim.main(arguments);
      pen.println();
      pen.println("------");
      pen.println();
    } // for
    
  } // main
} // class ALifeSimExpt