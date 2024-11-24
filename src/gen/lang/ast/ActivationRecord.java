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
 * @aspect Interpreter
 * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/Interpreter.jrag:183
 */
 class ActivationRecord extends java.lang.Object {
  /**
   * @aspect Interpreter
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/Interpreter.jrag:184
   */
  
        Scanner scanner;
  /**
   * @aspect Interpreter
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/Interpreter.jrag:185
   */
  
        Map<String, Integer> values;
  /**
   * @aspect Interpreter
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/Interpreter.jrag:186
   */
  
        private final ActivationRecord tail;
  /**
   * @aspect Interpreter
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/Interpreter.jrag:188
   */
  
       
        private static final ActivationRecord BOTTOM = new ActivationRecord() {};
  /**
   * @aspect Interpreter
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/Interpreter.jrag:190
   */
  
       
        public ActivationRecord(){
            tail = BOTTOM;
            values = new HashMap<String, Integer>();
            scanner = new Scanner(System.in);
        }
  /**
   * @aspect Interpreter
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/Interpreter.jrag:196
   */
  

        public ActivationRecord(ActivationRecord actrec){
            this.tail = actrec;
            this.values = new HashMap<String, Integer>();
            this.scanner = new Scanner(System.in);
        }
  /**
   * @aspect Interpreter
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/Interpreter.jrag:202
   */
  

        public int getValue(String name){
            if(values.containsKey(name)){
                return values.get(name);
            }
            else if (tail != null){
                return tail.getValue(name);
            }
            else{
                return 0;
            }
        }
  /**
   * @aspect Interpreter
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/Interpreter.jrag:214
   */
  

        public boolean returns(String name){
            return values.containsKey(name);
        }
  /**
   * @aspect Interpreter
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/Interpreter.jrag:218
   */
  

        public void setValue(String name, int value){
            values.put(name, Integer.valueOf(value));
        }
  /**
   * @aspect Interpreter
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/Interpreter.jrag:222
   */
  
        
        public void updateValue(String name, int value){
            if(values.containsKey(name)){
                values.put(name, Integer.valueOf(value));
            }
            else {
                tail.updateValue(name, value);
            }
        }
  /**
   * @aspect Interpreter
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/Interpreter.jrag:230
   */
  
        public Set<String> getKeys(){
            return values.keySet();
        }
  /**
   * @aspect Interpreter
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/Interpreter.jrag:234
   */
  

        public Scanner getScanner(){
            if(tail!=null){ 
                return tail.getScanner();
            }
            return scanner;
        }
  /**
   * @aspect Interpreter
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/Interpreter.jrag:240
   */
  
        public ActivationRecord push(){
            return new ActivationRecord(this);
        }
  /**
   * @aspect Interpreter
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/Interpreter.jrag:243
   */
  
        public ActivationRecord pop(){
            return tail;
        }

}
