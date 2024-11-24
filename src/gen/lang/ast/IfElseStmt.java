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
 * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/lang.ast:13
 * @astdecl IfElseStmt : Stmt ::= IfStmt Block;
 * @production IfElseStmt : {@link Stmt} ::= <span class="component">{@link IfStmt}</span> <span class="component">{@link Block}</span>;

 */
public class IfElseStmt extends Stmt implements Cloneable {
  /**
   * @aspect Visitor
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Visitor.jrag:63
   */
  public Object accept(Visitor visitor, Object data) {
        return visitor.visit(this, data);
    }
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/PrettyPrint.jrag:70
   */
  public void prettyPrint(PrintStream out, String ind) {
        getIfStmt().prettyPrint(out, ind);
        out.println();
        out.print(ind + "else{");
        out.println();
        getBlock().prettyPrint(out, ind);
        out.print(ind + "}");
    }
  /**
   * @aspect CodeGen
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:247
   */
  public void genCode(PrintStream out){
        out.println("if" + stmtIndex() + ":");        
        getIfStmt().getExpr().genConditionalJump(out, "else" + stmtIndex());
        getIfStmt().getBlock().genCode(out);
        out.println("        jmp " + "endif" +stmtIndex() );


        out.println("else" + stmtIndex() + ":");        

        getBlock().genCode(out);
        out.println("        jmp " + "endif" +stmtIndex() );
    //While end:
    out.println("endif" +stmtIndex() + ":");

    }
  /**
   * @aspect Interpreter
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Interpreter.jrag:86
   */
  public int execute(ActivationRecord actrec){
        int value = getIfStmt().execute(actrec);

        if(actrec.getValue("false") == 1){
            return getBlock().execute(actrec);
        }
        return 0;
    }
  /**
   * @declaredat ASTNode:1
   */
  public IfElseStmt() {
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
    name = {"IfStmt", "Block"},
    type = {"IfStmt", "Block"},
    kind = {"Child", "Child"}
  )
  public IfElseStmt(IfStmt p0, Block p1) {
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
  public IfElseStmt clone() throws CloneNotSupportedException {
    IfElseStmt node = (IfElseStmt) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:42
   */
  public IfElseStmt copy() {
    try {
      IfElseStmt node = (IfElseStmt) clone();
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
  public IfElseStmt fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:71
   */
  public IfElseStmt treeCopyNoTransform() {
    IfElseStmt tree = (IfElseStmt) copy();
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
  public IfElseStmt treeCopy() {
    IfElseStmt tree = (IfElseStmt) copy();
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
   * Replaces the IfStmt child.
   * @param node The new node to replace the IfStmt child.
   * @apilevel high-level
   */
  public IfElseStmt setIfStmt(IfStmt node) {
    setChild(node, 0);
    return this;
  }
  /**
   * Retrieves the IfStmt child.
   * @return The current node used as the IfStmt child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="IfStmt")
  public IfStmt getIfStmt() {
    return (IfStmt) getChild(0);
  }
  /**
   * Retrieves the IfStmt child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the IfStmt child.
   * @apilevel low-level
   */
  public IfStmt getIfStmtNoTransform() {
    return (IfStmt) getChildNoTransform(0);
  }
  /**
   * Replaces the Block child.
   * @param node The new node to replace the Block child.
   * @apilevel high-level
   */
  public IfElseStmt setBlock(Block node) {
    setChild(node, 1);
    return this;
  }
  /**
   * Retrieves the Block child.
   * @return The current node used as the Block child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Block")
  public Block getBlock() {
    return (Block) getChild(1);
  }
  /**
   * Retrieves the Block child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Block child.
   * @apilevel low-level
   */
  public Block getBlockNoTransform() {
    return (Block) getChildNoTransform(1);
  }

}
