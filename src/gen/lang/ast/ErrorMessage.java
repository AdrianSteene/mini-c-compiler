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
/**
 * @ast class
 * @aspect Errors
 * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Error.jrag:5
 */
public class ErrorMessage extends java.lang.Object implements Comparable<ErrorMessage> {
  /**
   * @aspect Errors
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Error.jrag:6
   */
  
        protected final String message;
  /**
   * @aspect Errors
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Error.jrag:7
   */
  
        protected final int lineNumber;
  /**
   * @aspect Errors
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Error.jrag:8
   */
  
        public ErrorMessage(String message, int lineNumber) {
            this.message = message;
            this.lineNumber = lineNumber;
        }
  /**
   * @aspect Errors
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Error.jrag:12
   */
  
        public int compareTo(ErrorMessage other) {
            if (lineNumber == other.lineNumber) {
                return message.compareTo(other.message);
            }
            return Integer.compare(lineNumber, other.lineNumber); 
        }
  /**
   * @aspect Errors
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Error.jrag:18
   */
  
        public String toString() {
            return "Error at line " + lineNumber + ": " + message;
        }

}
