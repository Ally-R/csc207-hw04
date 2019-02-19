package organismModeling;

public class Defector extends Organism {
 // +--------------+------------------------------------------------
 // | Constructors |
 // +--------------+
 
 public Defector() {
   super();
 } // Defector()

 // +---------+-----------------------------------------------------------
 // | Methods |
 // +---------+
 
 @Override
 public String getType() {
   return "Defector";
 } // getType()

 @Override
 public Defector reproduce() {
   super.energy = 0;
   Defector offspring = new Defector();
   return offspring;
 } // reproduce()
 
 @Override
 public double getCooperationProbability() {
   return 0;
 } // getCooperationProbability()
 
 @Override
 public boolean cooperates() {
   return false;
 } // cooperates()
 
} // class Defector