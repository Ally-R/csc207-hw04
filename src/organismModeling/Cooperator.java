package organismModeling;

/**
 * Creates a Cooperator organism.
 * 
 * @author Ally Rogers - rogersal@grinnell.edu
 * @author Elise Bargman - bargmane@grinnell.edu
 */
public class Cooperator extends Organism {
  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create new Cooperator
   */
  public Cooperator() {
    super();
  } // Cooperator()

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get the type of organism (Cooperator)
   */
  @Override
  public String getType() {
    return "Cooperator";
  } // getType()

  /**
   * Return an offspring (duplicate) of the organism
   */
  @Override
  public Cooperator reproduce() {
    super.energy = 0;
    Cooperator offspring = new Cooperator();
    return offspring;
  } // reproduce()

  /**
   * Get the organism's cooperation probability (always 1)
   */
  @Override
  public double getCooperationProbability() {
    return 1;
  } // getCooperationProbability()

  /**
   * Return a boolean that indicates whether or not the organism cooperates (always true)
   */
  @Override
  public boolean cooperates() {
    return true;
  } // cooperates()

} // class Cooperator
