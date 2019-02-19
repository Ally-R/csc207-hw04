package organismModeling;

import java.util.Random;

public class PartialCooperator extends Organism {
  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+
  
  public PartialCooperator() {
    super();
  } // Defector()

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  
  @Override
  public String getType() {
    return "PartialCooperator";
  } // getType()

  @Override
  public PartialCooperator reproduce() {
    super.energy = 0;
    PartialCooperator offspring = new PartialCooperator();
    return offspring;
  } // reproduce()
  
  @Override
  public double getCooperationProbability() {
    return 0.5;
  } // getCooperationProbability()
  
  @Override
  public boolean cooperates() {
    boolean bool;
    Random rand = new Random(System.currentTimeMillis());
    bool = rand.nextBoolean();
    return bool;
  } // cooperates()
  
} // class PartialCooperator