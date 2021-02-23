package organismModeling;

/**
 * Creates a Defector organism.
 * 
 * @author Ally
 * @author Elise Bargman - bargmane@grinnell.edu
 */
public class Defector extends Organism {
  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create new Defector
   */
  public Defector() {
    super();
  } // Defector()

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get the type of organism (Defector)
   */
  @Override
  public String getType() {
    return "Defector";
  } // getType()

  /**
   * Return an offspring (duplicate) of the organism
   */
  @Override
  public Defector reproduce() {
    super.energy = 0;
    Defector offspring = new Defector();
    return offspring;
  } // reproduce()

  /**
   * Get the organism's cooperation probability (always 0)
   */
  @Override
  public double getCooperationProbability() {
    return 0;
  } // getCooperationProbability()

  /**
   * Return a boolean that indicates whether or not the organism cooperates (always false)
   */
  @Override
  public boolean cooperates() {
    return false;
  } // cooperates()

} // class Defector
