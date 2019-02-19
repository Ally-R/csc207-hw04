package organismModeling;

public class Cooperator extends Organism {
  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+
  
  public Cooperator() {
    super();
  } // Cooperator()

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  
  @Override
  public String getType() {
    return "Cooperator";
  } // getType()

  @Override
  public Cooperator reproduce() {
    super.energy = 0;
    Cooperator offspring = new Cooperator();
    return offspring;
  } // reproduce()
  
  @Override
  public double getCooperationProbability() {
    return 1;
  } // getCooperationProbability()
  
  @Override
  public boolean cooperates() {
    return true;
  } // cooperates()
  
} // class Cooperator