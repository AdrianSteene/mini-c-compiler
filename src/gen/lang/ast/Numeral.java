/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.6 */
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
 * @ast node
 * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/lang.ast:17
 * @astdecl Numeral : Expr ::= <NUMERAL:String>;
 * @production Numeral : {@link Expr} ::= <span class="component">&lt;NUMERAL:{@link String}&gt;</span>;

 */
public class Numeral extends Expr implements Cloneable {
  /**
   * @aspect Visitor
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Visitor.jrag:72
   */
  public Object accept(Visitor visitor, Object data) {
        return visitor.visit(this, data);
    }
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/PrettyPrint.jrag:155
   */
  public void prettyPrint(PrintStream out, String ind) {
        out.print(getNUMERAL());
    }
  /**
   * @aspect CodeGen
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:242
   */
  public void genConditionalJump(PrintStream out, String name){}
  /**
   * @aspect CodeGen
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:279
   */
  public void genEval(PrintStream out) {
        out.println("        movq $" + getNUMERAL() + ", %rax");
    }
  /**
   * @aspect Interpreter
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Interpreter.jrag:137
   */
  public int value(ActivationRecord actrec){
        return Integer.valueOf(getNUMERAL());
    }
  /**
   * @declaredat ASTNode:1
   */
  public Numeral() {
    super();
  }
  /**
   * Initializes the child array to the correct size.
   * Initializes List and Opt nta children.
   * @apilevel internal
   * @ast method
   * @declaredat ASTNode:10
   */
  public void init$Children() {
  }
  /**
   * @declaredat ASTNode:12
   */
  @ASTNodeAnnotation.Constructor(
    name = {"NUMERAL"},
    type = {"String"},
    kind = {"Token"}
  )
  public Numeral(String p0) {
    setNUMERAL(p0);
  }
  /**
   * @declaredat ASTNode:20
   */
  public Numeral(beaver.Symbol p0) {
    setNUMERAL(p0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:24
   */
  protected int numChildren() {
    return 0;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:28
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    actualType_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:33
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:38
   */
  public Numeral clone() throws CloneNotSupportedException {
    Numeral node = (Numeral) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:43
   */
  public Numeral copy() {
    try {
      Numeral node = (Numeral) clone();
      node.parent = null;
      if (children != null) {
        node.children = (ASTNode[]) children.clone();
      }
      return node;
    } catch (CloneNotSupportedException e) {
      throw new Error("Error: clone not supported for " + getClass().getName());
    }
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @deprecated Please use treeCopy or treeCopyNoTransform instead
   * @declaredat ASTNode:62
   */
  @Deprecated
  public Numeral fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:72
   */
  public Numeral treeCopyNoTransform() {
    Numeral tree = (Numeral) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        ASTNode child = (ASTNode) children[i];
        if (child != null) {
          child = child.treeCopyNoTransform();
          tree.setChild(child, i);
        }
      }
    }
    return tree;
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:92
   */
  public Numeral treeCopy() {
    Numeral tree = (Numeral) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        ASTNode child = (ASTNode) getChild(i);
        if (child != null) {
          child = child.treeCopy();
          tree.setChild(child, i);
        }
      }
    }
    return tree;
  }
  /**
   * Replaces the lexeme NUMERAL.
   * @param value The new value for the lexeme NUMERAL.
   * @apilevel high-level
   */
  public Numeral setNUMERAL(String value) {
    tokenString_NUMERAL = value;
    return this;
  }
  /** @apilevel internal 
   */
  protected String tokenString_NUMERAL;
  /**
   */
  public int NUMERALstart;
  /**
   */
  public int NUMERALend;
  /**
   * JastAdd-internal setter for lexeme NUMERAL using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme NUMERAL
   * @apilevel internal
   */
  public Numeral setNUMERAL(beaver.Symbol symbol) {
    if (symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setNUMERAL is only valid for String lexemes");
    tokenString_NUMERAL = (String)symbol.value;
    NUMERALstart = symbol.getStart();
    NUMERALend = symbol.getEnd();
    return this;
  }
  /**
   * Retrieves the value for the lexeme NUMERAL.
   * @return The value for the lexeme NUMERAL.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="NUMERAL")
  public String getNUMERAL() {
    return tokenString_NUMERAL != null ? tokenString_NUMERAL : "";
  }
/** @apilevel internal */
protected boolean actualType_visited = false;
  /** @apilevel internal */
  private void actualType_reset() {
    actualType_computed = false;
    
    actualType_value = null;
    actualType_visited = false;
  }
  /** @apilevel internal */
  protected boolean actualType_computed = false;

  /** @apilevel internal */
  protected Type actualType_value;

  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:6
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:5")
  public Type actualType() {
    ASTState state = state();
    if (actualType_computed) {
      return actualType_value;
    }
    if (actualType_visited) {
      throw new RuntimeException("Circular definition of attribute Expr.actualType().");
    }
    actualType_visited = true;
    state().enterLazyAttribute();
    actualType_value = intType();
    actualType_computed = true;
    state().leaveLazyAttribute();
    actualType_visited = false;
    return actualType_value;
  }

}
