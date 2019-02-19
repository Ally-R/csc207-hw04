package organismModeling;

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

} // class Population

/*
   public void checkType(String type) throws IllegalArgumentException {
    if (!(type.equals("Cooperator") || type.equals("Defector")
        || type.equals("PartialCooperator"))) {
      throw new IllegalArgumentException(
          "Input " + type + " invalid. Must be either Cooperator, Defector, or PartialCooperator.");
    } // if
  } // checkType(String type)
*/
