package organismModeling;

/**
 * Creates an Organism. Super for all organism subtypes used in Poulation.java
 * 
 * @author Ally Rogers - rogersal@grinnell.edu
 * @author Elise Bargman - bargmane@grinnell.edu
 */
public class Organism {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * Organism's total energy
   */
  int energy;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create new organism
   */
  public Organism() {
    this.energy = 0;
  } // Organism()

  // +---------+----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Update organism by incrementing its energy
   */
  public void update() {
    this.incrementEnergy();
  } // update()

  /**
   * Get the organism's current energy
   */
  public int getEnergy() {
    return this.energy;
  } // getEnergy()

  /**
   * Increment the organism's energy
   */
  public void incrementEnergy() {
    this.energy += 1;
  } // incrementEnergy()

  /**
   * Decrement the organism's energy
   */
  public void decrementEnergy() {
    if (this.energy > 0) {
      this.energy -= 1;
    } // if
  } // decrementEnergy()

  /**
   * Get the type of organism
   */
  public String getType() { // To be overwritten
    return "Organism";
  } // getType()

  /**
   * Return an offspring (duplicate) of the organism
   */
  public Organism reproduce() { // To be overwritten
    Organism offspring = new Organism();
    offspring = this;
    return offspring;
  } // reproduce()

  /**
   * Get the organism's cooperation probability
   */
  public double getCooperationProbability() { // To be overwritten
    return 0;
  } // getCooperationProbability()

  /**
   * Return a boolean that indicates whether or not the organism cooperates
   */
  public boolean cooperates() { // To be overwritten
    return false;
  } // cooperates()

} // class Organism
