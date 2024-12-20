package lang.ast;

import java.util.*;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;
import java.util.TreeSet;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.lang.reflect.InvocationTargetException;
/** Wrapper class for storing nullable attribute values. 
 * @ast class
 * @declaredat ASTState:2
 */
public class AttributeValue<T> extends java.lang.Object {
  /**
   * This singleton object is an illegal, unused, attribute value.
   * It represents that an attribute has not been memoized, or that
   * a circular attribute approximation has not been initialized.
   * @declaredat ASTState:8
   */
  
  /**
   * This singleton object is an illegal, unused, attribute value.
   * It represents that an attribute has not been memoized, or that
   * a circular attribute approximation has not been initialized.
   */
  public static final Object NONE = new Object();
  /**
   * @declaredat ASTState:10
   */
  

  public final T value;
  /**
   * @declaredat ASTState:12
   */
  

  public AttributeValue(T value) {
    this.value = value;
  }
  /**
   * @declaredat ASTState:16
   */
  

  public static <V> boolean equals(AttributeValue<V> v1, AttributeValue<V> v2) {
    if (v1 == null || v2 == null) {
      return v1 == v2;
    } else {
      return equals(v1.value, v2.value);
    }
  }
  /**
   * @declaredat ASTState:24
   */
  

  public static <V> boolean equals(V v1, V v2) {
    if (v1 == null || v2 == null) {
      return v1 == v2;
    } else {
      return v1 == v2 || v1.equals(v2);
    }
  }

}
