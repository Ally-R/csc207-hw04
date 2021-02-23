package organismModeling;

import java.util.Random;

/**
 * Creates a PartialCooperator organism.
 * 
 * @author Ally
 * @author Elise Bargman - bargmane@grinnell.edu
 */
public class PartialCooperator extends Organism {
  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create new PartialCooperator
   */
  public PartialCooperator() {
    super();
  } // Defector()

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get the type of organism (PartialCooperator)
   */
  @Override
  public String getType() {
    return "PartialCooperator";
  } // getType()

  /**
   * Return an offspring (duplicate) of the organism
   */
  @Override
  public PartialCooperator reproduce() {
    super.energy = 0;
    PartialCooperator offspring = new PartialCooperator();
    return offspring;
  } // reproduce()

  /**
   * Get the organism's cooperation probability (always 0.5)
   */
  @Override
  public double getCooperationProbability() {
    return 0.5;
  } // getCooperationProbability()

  /**
   * Return a boolean that indicates whether or not the organism cooperates (randomly chosen)
   */
  @Override
  public boolean cooperates() {
    boolean bool;
    Random rand = new Random(System.currentTimeMillis());
    bool = rand.nextBoolean();
    return bool;
  } // cooperates()

} // class PartialCooperator
