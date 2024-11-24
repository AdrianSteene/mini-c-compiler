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
 * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/lang.ast:8
 * @astdecl Stmt : ASTNode;
 * @production Stmt : {@link ASTNode};

 */
public abstract class Stmt extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/CodeGen.jrag:164
   */
  abstract public void genCode(PrintStream out);
  /**
   * @aspect Interpreter
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/Interpreter.jrag:64
   */
  public int execute(ActivationRecord actrec){
        return 0;
    }
  /**
   * @declaredat ASTNode:1
   */
  public Stmt() {
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
    stmtIndex_reset();
    validDecl_reset();
    localLookup_reset();
    expectedType_reset();
    level_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:26
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:31
   */
  public Stmt clone() throws CloneNotSupportedException {
    Stmt node = (Stmt) super.clone();
    return node;
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @deprecated Please use treeCopy or treeCopyNoTransform instead
   * @declaredat ASTNode:42
   */
  @Deprecated
  public abstract Stmt fullCopy();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:50
   */
  public abstract Stmt treeCopyNoTransform();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:58
   */
  public abstract Stmt treeCopy();
/** @apilevel internal */
protected boolean stmtIndex_visited = false;
  /** @apilevel internal */
  private void stmtIndex_reset() {
    stmtIndex_computed = false;
    stmtIndex_visited = false;
  }
  /** @apilevel internal */
  protected boolean stmtIndex_computed = false;

  /** @apilevel internal */
  protected int stmtIndex_value;

  /**
   * @attribute syn
   * @aspect CodeGen
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/CodeGen.jrag:409
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/CodeGen.jrag:400")
  public int stmtIndex() {
    ASTState state = state();
    if (stmtIndex_computed) {
      return stmtIndex_value;
    }
    if (stmtIndex_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.stmtIndex().");
    }
    stmtIndex_visited = true;
    state().enterLazyAttribute();
    stmtIndex_value = prevNode().stmtIndex() + 1;
    stmtIndex_computed = true;
    state().leaveLazyAttribute();
    stmtIndex_visited = false;
    return stmtIndex_value;
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
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:48
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:48")
  public boolean validDecl() {
    ASTState state = state();
    if (validDecl_computed) {
      return validDecl_value;
    }
    if (validDecl_visited) {
      throw new RuntimeException("Circular definition of attribute Stmt.validDecl().");
    }
    validDecl_visited = true;
    state().enterLazyAttribute();
    validDecl_value = false;
    validDecl_computed = true;
    state().leaveLazyAttribute();
    validDecl_visited = false;
    return validDecl_value;
  }
/** @apilevel internal */
protected boolean localLookup_visited = false;
  /** @apilevel internal */
  private void localLookup_reset() {
    localLookup_computed = false;
    
    localLookup_value = null;
    localLookup_visited = false;
  }
  /** @apilevel internal */
  protected boolean localLookup_computed = false;

  /** @apilevel internal */
  protected IdDecl localLookup_value;

  /**
   * @attribute syn
   * @aspect NameAnalysis
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/NameAnalysis.jrag:106
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/NameAnalysis.jrag:106")
  public IdDecl localLookup() {
    ASTState state = state();
    if (localLookup_computed) {
      return localLookup_value;
    }
    if (localLookup_visited) {
      throw new RuntimeException("Circular definition of attribute Stmt.localLookup().");
    }
    localLookup_visited = true;
    state().enterLazyAttribute();
    localLookup_value = unknownDecl();
    localLookup_computed = true;
    state().leaveLazyAttribute();
    localLookup_visited = false;
    return localLookup_value;
  }
  /**
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:23
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:23")
  public Type expectedType() {
    ASTState state = state();
    if (expectedType_computed) {
      return expectedType_value;
    }
    if (expectedType_visited) {
      throw new RuntimeException("Circular definition of attribute Stmt.expectedType().");
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

  /**
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:102
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:102")
  public int level() {
    ASTState state = state();
    if (level_computed) {
      return level_value;
    }
    if (level_visited) {
      throw new RuntimeException("Circular definition of attribute Stmt.level().");
    }
    level_visited = true;
    state().enterLazyAttribute();
    level_value = getParent().Define_level(this, null);
    level_computed = true;
    state().leaveLazyAttribute();
    level_visited = false;
    return level_value;
  }
/** @apilevel internal */
protected boolean level_visited = false;
  /** @apilevel internal */
  private void level_reset() {
    level_computed = false;
    level_visited = false;
  }
  /** @apilevel internal */
  protected boolean level_computed = false;

  /** @apilevel internal */
  protected int level_value;

  /**
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:102
   * @apilevel internal
   */
  public int Define_level(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return level() + 1;
  }
  /**
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:102
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute level
   */
  protected boolean canDefine_level(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /** @apilevel internal */
  protected void collect_contributors_Program_errors(Program _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/Error.jrag:49
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
    if (validDecl()) {
      collection.add(error("Declare Error " + this.toString()));
    }
  }

}
