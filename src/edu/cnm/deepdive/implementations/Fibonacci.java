/**
 * 
 */
package edu.cnm.deepdive.implementations;

import java.math.BigInteger;
import java.util.Iterator;

/**
 * @author Ejerson Balabas
 *
 */
public class Fibonacci implements Iterable<BigInteger> {
  
  private static final int DEFAULT_UPPER = -1;
  
  private final int upper;
  
  public Fibonacci() {
    this(DEFAULT_UPPER);
  }
  
  public Fibonacci(int upper) {
    this.upper = upper;
  }
  
//  @Override
//  public Iterator<BigInteger> iterator() {
//    return new FibIterator();
//  }
  
  @Override
  public Iterator<BigInteger> iterator() {
    // Anonymous class implementing the Iterator<BigInteger> Interface. 
    return new Iterator<BigInteger> () {
      
      private BigInteger previous = BigInteger.valueOf(-1);
      private BigInteger current = BigInteger.ONE; // current = 1
      private int index = 0;

      @Override
      public boolean hasNext() {
        return upper < 0 || index < upper; // if either one is true, then we can increment
      }

      @Override
      public BigInteger next() {
        BigInteger next = previous.add(current); // to add previous and current
        previous = current;
        current = next;
        index++; // increments the index value
        return current; 
      }
    };
  }
}

// inner class implementing iterator
//  private class FibIterator implements Iterator<BigInteger> {
//    
//    private BigInteger previous = BigInteger.valueOf(-1);
//    private BigInteger current = BigInteger.ONE; // current = 1
//    private int index = 0;
//
//    @Override
//    public boolean hasNext() {
//      return upper < 0 || index < upper; // if either one is true, then we can increment
//    }
//
//    @Override
//    public BigInteger next() {
//      BigInteger next = previous.add(current); // to add previous and current
//      previous = current;
//      current = next;
//      index++; // increments the index value
//      return current; 
//    }
//    
//  }
//  
//}
