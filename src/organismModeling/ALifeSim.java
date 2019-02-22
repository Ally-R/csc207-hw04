package organismModeling;

import java.lang.Integer;
import java.io.PrintWriter;

/**
 * Simulates a population of organisms based on command-line input and prints results
 * 
 * @author Ally Rogers - rogersal@grinnell.edu
 * @author Elise Bargman - bargmane@grinnell.edu
 */
public class ALifeSim {
  /**
   * Simulate organism population
   * 
   * @pre Four command-line arguments given
   * @pre All command-line arguments are non-negative ints
   * @throws Exception if first precondition not met
   */
  public static void main(String[] args) throws Exception {
    if (args.length != 4) {
      throw new Exception(
          "Usage java ALifeSim <#/iterations> <#/cooperators> <#/defectors> <#/partial cooperators>");
    } // if wrong number of arguments, throw exception
    int iterations = Integer.parseInt(args[0]);
    int numCoop = Integer.parseInt(args[1]);
    int numDefect = Integer.parseInt(args[2]);
    int numPC = Integer.parseInt(args[3]);
    PrintWriter pen = new PrintWriter(System.out, true);

    Pair<String, Integer>[] inputCount = (Pair<String, Integer>[]) (new Pair[3]);
    inputCount[0] = new Pair<String, Integer>("Cooperator", numCoop);
    inputCount[1] = new Pair<String, Integer>("Defector", numDefect);
    inputCount[2] = new Pair<String, Integer>("PartialCooperator", numPC);

    Population pop = new Population(inputCount);
    for (int i = 0; i < iterations; i++) {
      pop.update();
    } // for

    Pair<String, Integer>[] finalCounts = pop.getPopulationCounts();
    pen.println("After " + iterations + " updates:");
    pen.println(finalCounts[0].getLeft() + "        = " + finalCounts[0].getRight());
    pen.println(finalCounts[1].getLeft() + "          = " + finalCounts[1].getRight());
    pen.println(finalCounts[2].getLeft() + " = " + finalCounts[2].getRight());
    pen.println();
    pen.println("Mean Cooperation Probability = " + pop.calculateCooperationMean());
  } // main

} // class ALifeSim
