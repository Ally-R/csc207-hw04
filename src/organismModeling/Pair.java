package organismModeling;

/**
 * Creates a pair of elements.
 * 
 * Code taken from Grinnell CSC 207.02 2019S Assignment 4
 */
public class Pair<T, U> {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+
  
  /**
   * Left element of Pair
   */
  T left;
  
  /**
   * Right element of Pair
   */
  U right;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+
  
  /**
   * Create new Pair
   */
  public Pair(T left, U right) {
    this.left = left;
    this.right = right;
  } // Pair

  // +---------+----------------------------------------------------
  // | Methods |
  // +---------+
  
  /**
   * Get left element of Pair
   */
  public T getLeft() {
    return this.left;
  } // getLeft()

  /**
   * Get right element of Pair
   */
  public U getRight() {
    return this.right;
  } // getRight()

} // class Pair
