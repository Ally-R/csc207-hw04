package organismModeling;

public class Pair<T, U> {
  // Fields
  T left;
  U right;

  // Constructor
  public Pair(T left, U right) {
    this.left = left;
    this.right = right;
  } // Pair

  // Methods
  public T getLeft() {
    return this.left;
  } // getLeft()

  public U getRight() {
    return this.right;
  } // getRight()

} // class Pair
