package organismModeling;

import java.util.Random;

/**
 * Creates an population of Organisms.
 * 
 * @author Elise Bargman - bargmane@grinnell.edu
 * @author Ally
 */
public class Population {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * Array of organisms to represent population
   */
  Organism[] population;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Generate a new population of organisms based on given input
   * 
   * @pre each string in Pair is a valid organism subtype, case sensitive
   * @pre each integer in Pair is >= 0
   * @throws IllegalArgumentException when first precondition not met
   * @throws Exception when second precondition not met
   */
  public Population(Pair<String, Integer>[] counts) throws IllegalArgumentException, Exception {
    int popsize = 0;
    for (int i = 0; i < counts.length; i++) {
      if (counts[i].getRight() < 0) {
        throw new Exception("Number of " + counts[i].getLeft() + " must be >= 0");
      }
      popsize += counts[i].getRight();
    } // for
    this.population = new Organism[popsize];
    int place = 0; // Current position in population
    for (int i = 0; i < counts.length; i++) { // Iterates through counts
      String currentType = counts[i].getLeft();
      for (int k = place; k < (place + counts[i].getRight()); k++) { // Iterates through population,
                                                                     // adding organisms
        if (currentType.equals("Cooperator")) {
          this.population[k] = new Cooperator();
        } else if (currentType.equals("Defector")) {
          this.population[k] = new Defector();
        } else if (currentType.equals("PartialCooperator")) {
          this.population[k] = new PartialCooperator();
        } else {
          throw new IllegalArgumentException("Input " + currentType
              + " invalid. Must be either Cooperator, Defector, or PartialCooperator.");
        } // else
      } // for
      place += counts[i].getRight();
    } // for
  } // Population(Pair<String, Integer>[] counts)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Update all organisms: Increment energy, simulate cooperation, simulate reproduction
   */
  public void update() {
    int leng = this.population.length;
    long seed = System.currentTimeMillis();
    Random rand = new Random(seed);
    for (int i = 0; i < leng; i++) {
      this.population[i].update();
      if (this.population[i].cooperates()) {
        this.population[i].decrementEnergy();
        int[] indeces = new int[] {-1, -1, -1, -1, -1, -1, -1, i};
        for (int k = 0; k < 8; k++) { // Donate energy to 8 unique randomly selected organisms
          int index = rand.nextInt(leng - 1);
          if (index == indeces[0] || index == indeces[1] || index == indeces[2]
              || index == indeces[3] || index == indeces[4] || index == indeces[5]
              || index == indeces[6] || index == indeces[7]) {
            k--;
          } else {
            indeces[k] = index;
            this.population[index].incrementEnergy();
          } // else
        } // for
      } // if organism cooperates
      if (this.population[i].getEnergy() >= 10) {
        int index = rand.nextInt(leng - 1);
        while (index == i) {
          index = rand.nextInt(leng - 1);
        } // while (Make sure child organism not replacing its parent)
        this.population[index] = this.population[i].reproduce();
      } // if energy >= 10
    } // for
  } // update()

  /**
   * Get the mean cooperation probability of the population
   */
  public double calculateCooperationMean() {
    int popSize = this.population.length;
    double totalProb = 0;
    for (int i = 0; i < popSize; i++) {
      totalProb += this.population[i].getCooperationProbability();
    } // for
    return totalProb / popSize;
  } // calculateCooperationMean()

  /**
   * Get the total number of each organism subtype
   */
  public Pair<String, Integer>[] getPopulationCounts() {
    int popSize = this.population.length;
    Pair<String, Integer>[] popCount = (Pair<String, Integer>[]) (new Pair[3]);
    popCount[0] = new Pair<String, Integer>("Cooperator", 0);
    popCount[1] = new Pair<String, Integer>("Defector", 0);
    popCount[2] = new Pair<String, Integer>("PartialCooperator", 0);
    String currentType;
    for (int i = 0; i < popSize; i++) {
      currentType = this.population[i].getType();
      if (currentType.equals("Cooperator")) {
        popCount[0].right += 1;
      } else if (currentType.equals("Defector")) {
        popCount[1].right += 1;
      } else if (currentType.equals("PartialCooperator")) {
        popCount[2].right += 1;
      } else {
        throw new IllegalArgumentException("The " + currentType
            + "organism is invalid. Must be either Cooperator, Defector, or PartialCooperator.");
      } // else
    } // for
    return popCount;
  } // getPopulationCounts()

} // class Population
