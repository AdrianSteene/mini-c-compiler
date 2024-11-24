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
 * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/lang.ast:24
 * @astdecl MathExpr : BinExpr ::= Left:Expr Right:Expr;
 * @production MathExpr : {@link BinExpr};

 */
public class MathExpr extends BinExpr implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/CodeGen.jrag:217
   */
  public void getJump(PrintStream out, String name){}
  /**
   * @aspect CodeGen
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/CodeGen.jrag:241
   */
  public void genConditionalJump(PrintStream out, String name){}
  /**
   * @aspect CodeGen
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/CodeGen.jrag:292
   */
  public void genEval(PrintStream out) {

    }
  /**
   * @aspect Interpreter
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/Interpreter.jrag:145
   */
  int value(ActivationRecord actrec) {
        return 0;
    }
  /**
   * @declaredat ASTNode:1
   */
  public MathExpr() {
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
    children = new ASTNode[2];
  }
  /**
   * @declaredat ASTNode:13
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Left", "Right"},
    type = {"Expr", "Expr"},
    kind = {"Child", "Child"}
  )
  public MathExpr(Expr p0, Expr p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:23
   */
  protected int numChildren() {
    return 2;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:27
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    actualType_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:32
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:37
   */
  public MathExpr clone() throws CloneNotSupportedException {
    MathExpr node = (MathExpr) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:42
   */
  public MathExpr copy() {
    try {
      MathExpr node = (MathExpr) clone();
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
   * @declaredat ASTNode:61
   */
  @Deprecated
  public MathExpr fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:71
   */
  public MathExpr treeCopyNoTransform() {
    MathExpr tree = (MathExpr) copy();
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
   * @declaredat ASTNode:91
   */
  public MathExpr treeCopy() {
    MathExpr tree = (MathExpr) copy();
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
   * Replaces the Left child.
   * @param node The new node to replace the Left child.
   * @apilevel high-level
   */
  public MathExpr setLeft(Expr node) {
    setChild(node, 0);
    return this;
  }
  /**
   * Retrieves the Left child.
   * @return The current node used as the Left child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Left")
  public Expr getLeft() {
    return (Expr) getChild(0);
  }
  /**
   * Retrieves the Left child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Left child.
   * @apilevel low-level
   */
  public Expr getLeftNoTransform() {
    return (Expr) getChildNoTransform(0);
  }
  /**
   * Replaces the Right child.
   * @param node The new node to replace the Right child.
   * @apilevel high-level
   */
  public MathExpr setRight(Expr node) {
    setChild(node, 1);
    return this;
  }
  /**
   * Retrieves the Right child.
   * @return The current node used as the Right child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Right")
  public Expr getRight() {
    return (Expr) getChild(1);
  }
  /**
   * Retrieves the Right child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Right child.
   * @apilevel low-level
   */
  public Expr getRightNoTransform() {
    return (Expr) getChildNoTransform(1);
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
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:11
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:5")
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
  /**
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:17
   * @apilevel internal
   */
  public Type Define_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getRightNoTransform()) {
      // @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:21
      return intType();
    }
    else if (_callerNode == getLeftNoTransform()) {
      // @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:20
      return intType();
    }
    else {
      return getParent().Define_expectedType(this, _callerNode);
    }
  }
  /**
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:17
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute expectedType
   */
  protected boolean canDefine_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }

}
