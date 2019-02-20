package organismModeling;

import java.util.Random;

public class Population {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+
  
  Organism[] population;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+
  
  public Population(Pair<String, Integer>[] counts) throws IllegalArgumentException {
    int popsize = 0;
    for (int i = 0; i < counts.length; i++) {
      popsize += counts[i].getRight();
    } // for
    this.population = new Organism[popsize];
    int place = 0; // Current position in population
    for (int i = 0; i < counts.length; i++) { // Iterates through counts
      String currentType = counts[i].getLeft();
      for (int k = place; k < (place + counts[i].getRight()); k++) { // Iterates through population,
                                                                     // adding organisms
        if (currentType.equals("Cooperator")) {
          population[k] = new Cooperator();
        } else if (currentType.equals("Defector")) {
          population[k] = new Defector();
        } else if (currentType.equals("PartialCooperator")) {
          population[k] = new PartialCooperator();
        } else {
          throw new IllegalArgumentException(
              "Input " + currentType + " invalid. Must be either Cooperator, Defector, or PartialCooperator.");
        } // else
      } // for
    } // for
  } // Population(Pair<String, Integer>[] counts)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  
  void update() {
    Random rand = new Random(System.currentTimeMillis());
    for (int i = 0; i < this.population.length; i++) {
      this.population[i].update();
      if (this.population[i].cooperates()) {
        this.population[i].decrementEnergy();
        for (int k = 0; k < 8; k++) {
          int index = rand.nextInt(this.population.length);
          if (index == i) {
            k--;
          } else {
            this.population[index].incrementEnergy();
          } // else
        } // for
      } // if organism cooperates
      if (this.population[i].getEnergy() >= 10) {
        int index = rand.nextInt(this.population.length);
        this.population[index] = this.population[i].reproduce();
      } // if energy >= 10
    } // for
  } // update()
  
  public double calculateCooperationMean() {
    int popSize = this.population.length;
    double totalProb = 0;
    for (int i = 0; i < popSize; i++) {
      totalProb += this.population[i].getCooperationProbability();
    } // for
    return totalProb/popSize;
  } // calculateCooperationMean()
  
  public Pair<String, Integer>[] getPopulationCounts() {
    int popSize = this.population.length;
    Pair<String,Integer>[] popCount = (Pair<String,Integer>[]) (new Pair[3]);
    popCount[0] = new Pair<String,Integer>("Collaborator", 0);
    popCount[1] = new Pair<String,Integer>("Defector", 0);
    popCount[2] = new Pair<String,Integer>("PartialCooperator", 0);
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
        throw new IllegalArgumentException(
            "The " + currentType + "organism is invalid. Must be either Cooperator, Defector, or PartialCooperator.");
      } // else
    } // for
    return popCount;
  } // getPopulationCounts()

} // class Population
