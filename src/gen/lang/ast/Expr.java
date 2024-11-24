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
 * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/lang.ast:16
 * @astdecl Expr : ASTNode;
 * @production Expr : {@link ASTNode};

 */
public abstract class Expr extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/CodeGen.jrag:203
   */
  abstract public void genConditionalJump(PrintStream out, String name);
  /**
   * @aspect CodeGen
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/CodeGen.jrag:277
   */
  abstract public void genEval(PrintStream out);
  /**
   * @aspect Interpreter
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/Interpreter.jrag:99
   */
  abstract int value(ActivationRecord actrec);
  /**
   * @declaredat ASTNode:1
   */
  public Expr() {
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
  /** @apilevel low-level 
   * @declaredat ASTNode:13
   */
  protected int numChildren() {
    return 0;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:17
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    actualType_reset();
    typeError_reset();
    validDecl_reset();
    expectedType_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:25
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:30
   */
  public Expr clone() throws CloneNotSupportedException {
    Expr node = (Expr) super.clone();
    return node;
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @deprecated Please use treeCopy or treeCopyNoTransform instead
   * @declaredat ASTNode:41
   */
  @Deprecated
  public abstract Expr fullCopy();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:49
   */
  public abstract Expr treeCopyNoTransform();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:57
   */
  public abstract Expr treeCopy();
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
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:5
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
    actualType_value = unknownType();
    actualType_computed = true;
    state().leaveLazyAttribute();
    actualType_visited = false;
    return actualType_value;
  }
/** @apilevel internal */
protected boolean typeError_visited = false;
  /** @apilevel internal */
  private void typeError_reset() {
    typeError_computed = false;
    typeError_visited = false;
  }
  /** @apilevel internal */
  protected boolean typeError_computed = false;

  /** @apilevel internal */
  protected boolean typeError_value;

  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:13
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:13")
  public boolean typeError() {
    ASTState state = state();
    if (typeError_computed) {
      return typeError_value;
    }
    if (typeError_visited) {
      throw new RuntimeException("Circular definition of attribute Expr.typeError().");
    }
    typeError_visited = true;
    state().enterLazyAttribute();
    typeError_value = typeError_compute();
    typeError_computed = true;
    state().leaveLazyAttribute();
    typeError_visited = false;
    return typeError_value;
  }
  /** @apilevel internal */
  private boolean typeError_compute() {
        return !actualType().equals(expectedType());
      }
/** @apilevel internal */
protected boolean validDecl_visited = false;
  /** @apilevel internal */
  private void validDecl_reset() {
    validDecl_computed = false;
    validDecl_visited = false;
  }
  /** @apilevel internal */
  protected boolean validDecl_computed = false;

  /** @apilevel internal */
  protected boolean validDecl_value;

  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:51
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:51")
  public boolean validDecl() {
    ASTState state = state();
    if (validDecl_computed) {
      return validDecl_value;
    }
    if (validDecl_visited) {
      throw new RuntimeException("Circular definition of attribute Expr.validDecl().");
    }
    validDecl_visited = true;
    state().enterLazyAttribute();
    validDecl_value = false;
    validDecl_computed = true;
    state().leaveLazyAttribute();
    validDecl_visited = false;
    return validDecl_value;
  }
  /**
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:17
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:17")
  public Type expectedType() {
    ASTState state = state();
    if (expectedType_computed) {
      return expectedType_value;
    }
    if (expectedType_visited) {
      throw new RuntimeException("Circular definition of attribute Expr.expectedType().");
    }
    expectedType_visited = true;
    state().enterLazyAttribute();
    expectedType_value = getParent().Define_expectedType(this, null);
    expectedType_computed = true;
    state().leaveLazyAttribute();
    expectedType_visited = false;
    return expectedType_value;
  }
/** @apilevel internal */
protected boolean expectedType_visited = false;
  /** @apilevel internal */
  private void expectedType_reset() {
    expectedType_computed = false;
    
    expectedType_value = null;
    expectedType_visited = false;
  }
  /** @apilevel internal */
  protected boolean expectedType_computed = false;

  /** @apilevel internal */
  protected Type expectedType_value;

  /** @apilevel internal */
  protected void collect_contributors_Program_errors(Program _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/Error.jrag:45
    if (typeError()) {
      {
        Program target = (Program) (program());
        java.util.Set<ASTNode> contributors = _map.get(target);
        if (contributors == null) {
          contributors = new java.util.LinkedHashSet<ASTNode>();
          _map.put((ASTNode) target, contributors);
        }
        contributors.add(this);
      }
    }
    // @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/Error.jrag:53
    if (validDecl()) {
      {
        Program target = (Program) (program());
        java.util.Set<ASTNode> contributors = _map.get(target);
        if (contributors == null) {
          contributors = new java.util.LinkedHashSet<ASTNode>();
          _map.put((ASTNode) target, contributors);
        }
        contributors.add(this);
      }
    }
    super.collect_contributors_Program_errors(_root, _map);
  }
  /** @apilevel internal */
  protected void contributeTo_Program_errors(Set<ErrorMessage> collection) {
    super.contributeTo_Program_errors(collection);
    if (typeError()) {
      collection.add(error("Type Error " + this.toString()));
    }
    if (validDecl()) {
      collection.add(error("Function call Error " + this.toString()));
    }
  }

}
