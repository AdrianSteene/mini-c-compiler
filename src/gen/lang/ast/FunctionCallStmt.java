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
 * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/lang.ast:15
 * @astdecl FunctionCallStmt : Stmt ::= FunctionCall;
 * @production FunctionCallStmt : {@link Stmt} ::= <span class="component">{@link FunctionCall}</span>;

 */
public class FunctionCallStmt extends Stmt implements Cloneable {
  /**
   * @aspect Visitor
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Visitor.jrag:69
   */
  public Object accept(Visitor visitor, Object data) {
        return visitor.visit(this, data);
    }
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/PrettyPrint.jrag:83
   */
  public void prettyPrint(PrintStream out, String ind) {
        out.print(ind);
        getFunctionCall().prettyPrint(out, ind);
    }
  /**
   * @aspect CodeGen
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:273
   */
  public void genCode(PrintStream out){
        getFunctionCall().genEval(out);
    }
  /**
   * @aspect Interpreter
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Interpreter.jrag:95
   */
  public int execute(ActivationRecord actrec){
        return getFunctionCall().value(actrec);
    }
  /**
   * @declaredat ASTNode:1
   */
  public FunctionCallStmt() {
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
    name = {"FunctionCall"},
    type = {"FunctionCall"},
    kind = {"Child"}
  )
  public FunctionCallStmt(FunctionCall p0) {
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
  public FunctionCallStmt clone() throws CloneNotSupportedException {
    FunctionCallStmt node = (FunctionCallStmt) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:41
   */
  public FunctionCallStmt copy() {
    try {
      FunctionCallStmt node = (FunctionCallStmt) clone();
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
  public FunctionCallStmt fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:70
   */
  public FunctionCallStmt treeCopyNoTransform() {
    FunctionCallStmt tree = (FunctionCallStmt) copy();
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
  public FunctionCallStmt treeCopy() {
    FunctionCallStmt tree = (FunctionCallStmt) copy();
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
   * Replaces the FunctionCall child.
   * @param node The new node to replace the FunctionCall child.
   * @apilevel high-level
   */
  public FunctionCallStmt setFunctionCall(FunctionCall node) {
    setChild(node, 0);
    return this;
  }
  /**
   * Retrieves the FunctionCall child.
   * @return The current node used as the FunctionCall child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="FunctionCall")
  public FunctionCall getFunctionCall() {
    return (FunctionCall) getChild(0);
  }
  /**
   * Retrieves the FunctionCall child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the FunctionCall child.
   * @apilevel low-level
   */
  public FunctionCall getFunctionCallNoTransform() {
    return (FunctionCall) getChildNoTransform(0);
  }

}
