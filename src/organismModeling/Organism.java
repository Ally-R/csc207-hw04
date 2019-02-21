package organismModeling;

public class Organism {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+
  
  int energy;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+
  
  public Organism() {
    this.energy = 0;
  } // Organism()

  // +---------+----------------------------------------------------
  // | Methods |
  // +---------+
  
  public void update() {
    this.incrementEnergy();
  } // update()

  public int getEnergy() {
    return this.energy;
  } // getEnergy()

  public void incrementEnergy() {
    this.energy += 1;
  } // incrementEnergy()

  public void decrementEnergy() {
    if (this.energy > 0) {
      this.energy -= 1;
    } // if
  } // decrementEnergy()

  public String getType() { // To be overwritten
    return "Organism";
  } // getType()

  public Organism reproduce() { // To be overwritten
    Organism offspring = new Organism();
    offspring = this;
    return offspring;
  } // reproduce()
  
  public double getCooperationProbability() { // To be overwritten
    return 0;
  } // getCooperationProbability()
  
  public boolean cooperates() { // To be overwritten
    return false;
  } // cooperates()

} // class Organism
