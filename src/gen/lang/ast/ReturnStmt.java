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
 * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/lang.ast:14
 * @astdecl ReturnStmt : Stmt ::= Expr;
 * @production ReturnStmt : {@link Stmt} ::= <span class="component">{@link Expr}</span>;

 */
public class ReturnStmt extends Stmt implements Cloneable {
  /**
   * @aspect Visitor
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/Visitor.jrag:66
   */
  public Object accept(Visitor visitor, Object data) {
        return visitor.visit(this, data);
    }
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/PrettyPrint.jrag:78
   */
  public void prettyPrint(PrintStream out, String ind) {
        out.print(ind + "return ");
        getExpr().prettyPrint(out, ind);
        out.print(";");
    }
  /**
   * @aspect CodeGen
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/CodeGen.jrag:263
   */
  public void genCode(PrintStream out){
        getExpr().genEval(out);
        //if(!this.enclosingFunction().getLeft().getID().equals("main")){
            out.println("        movq %rbp, %rsp");
            out.println("        popq %rbp");
        //}
        out.println("        ret");
    }
  /**
   * @aspect Interpreter
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/Interpreter.jrag:47
   */
  public int execute(ActivationRecord actrec){
        int value = getExpr().value(actrec);
        actrec.setValue("return" + value, value);
        return value;
    }
  /**
   * @declaredat ASTNode:1
   */
  public ReturnStmt() {
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
    children = new ASTNode[1];
  }
  /**
   * @declaredat ASTNode:13
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Expr"},
    type = {"Expr"},
    kind = {"Child"}
  )
  public ReturnStmt(Expr p0) {
    setChild(p0, 0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:22
   */
  protected int numChildren() {
    return 1;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:26
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    enclosingFunction_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:31
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:36
   */
  public ReturnStmt clone() throws CloneNotSupportedException {
    ReturnStmt node = (ReturnStmt) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:41
   */
  public ReturnStmt copy() {
    try {
      ReturnStmt node = (ReturnStmt) clone();
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
   * @declaredat ASTNode:60
   */
  @Deprecated
  public ReturnStmt fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:70
   */
  public ReturnStmt treeCopyNoTransform() {
    ReturnStmt tree = (ReturnStmt) copy();
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
   * @declaredat ASTNode:90
   */
  public ReturnStmt treeCopy() {
    ReturnStmt tree = (ReturnStmt) copy();
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
   * Replaces the Expr child.
   * @param node The new node to replace the Expr child.
   * @apilevel high-level
   */
  public ReturnStmt setExpr(Expr node) {
    setChild(node, 0);
    return this;
  }
  /**
   * Retrieves the Expr child.
   * @return The current node used as the Expr child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Expr")
  public Expr getExpr() {
    return (Expr) getChild(0);
  }
  /**
   * Retrieves the Expr child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Expr child.
   * @apilevel low-level
   */
  public Expr getExprNoTransform() {
    return (Expr) getChildNoTransform(0);
  }
  /**
   * @attribute inh
   * @aspect functionCalls
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/functionCall.jrag:10
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="functionCalls", declaredAt="/Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/functionCall.jrag:10")
  public FunctionDecl enclosingFunction() {
    ASTState state = state();
    if (enclosingFunction_computed) {
      return enclosingFunction_value;
    }
    if (enclosingFunction_visited) {
      throw new RuntimeException("Circular definition of attribute ReturnStmt.enclosingFunction().");
    }
    enclosingFunction_visited = true;
    state().enterLazyAttribute();
    enclosingFunction_value = getParent().Define_enclosingFunction(this, null);
    enclosingFunction_computed = true;
    state().leaveLazyAttribute();
    enclosingFunction_visited = false;
    return enclosingFunction_value;
  }
/** @apilevel internal */
protected boolean enclosingFunction_visited = false;
  /** @apilevel internal */
  private void enclosingFunction_reset() {
    enclosingFunction_computed = false;
    
    enclosingFunction_value = null;
    enclosingFunction_visited = false;
  }
  /** @apilevel internal */
  protected boolean enclosingFunction_computed = false;

  /** @apilevel internal */
  protected FunctionDecl enclosingFunction_value;

  /**
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:17
   * @apilevel internal
   */
  public Type Define_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getExprNoTransform()) {
      // @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:28
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
