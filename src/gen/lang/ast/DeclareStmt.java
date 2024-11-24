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
 * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/lang.ast:9
 * @astdecl DeclareStmt : Stmt ::= IdDecl [Expr];
 * @production DeclareStmt : {@link Stmt} ::= <span class="component">{@link IdDecl}</span> <span class="component">[{@link Expr}]</span>;

 */
public class DeclareStmt extends Stmt implements Cloneable {
  /**
   * @aspect Visitor
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/Visitor.jrag:51
   */
  public Object accept(Visitor visitor, Object data) {
        return visitor.visit(this, data);
    }
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/PrettyPrint.jrag:37
   */
  public void prettyPrint(PrintStream out, String ind) {
        out.print(ind);
        getIdDecl().prettyPrint(out, ind);
        if (hasExpr()) {
            out.print(" = ");
            getExpr().prettyPrint(out, ind);
        }
        out.print(";");
    }
  /**
   * @aspect CodeGen
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/CodeGen.jrag:166
   */
  public void genCode(PrintStream out){
        if(hasExpr()){
            getExpr().genEval(out);
        }
        out.println("        movq %rax, " + getIdDecl().address());
    }
  /**
   * @aspect Interpreter
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/Interpreter.jrag:53
   */
  public int execute(ActivationRecord actrec){
        if(hasExpr()){
            int value = getExpr().value(actrec);
            actrec.setValue(getIdDecl().getID(), value);
        }
        else{
            actrec.setValue(getIdDecl().getID(), 0);
        }
        return 0;
    }
  /**
   * @declaredat ASTNode:1
   */
  public DeclareStmt() {
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
    setChild(new Opt(), 1);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"IdDecl", "Expr"},
    type = {"IdDecl", "Opt<Expr>"},
    kind = {"Child", "Opt"}
  )
  public DeclareStmt(IdDecl p0, Opt<Expr> p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:24
   */
  protected int numChildren() {
    return 2;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:28
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    localLookup_reset();
    inExprOf_IdDecl_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:34
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:39
   */
  public DeclareStmt clone() throws CloneNotSupportedException {
    DeclareStmt node = (DeclareStmt) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:44
   */
  public DeclareStmt copy() {
    try {
      DeclareStmt node = (DeclareStmt) clone();
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
   * @declaredat ASTNode:63
   */
  @Deprecated
  public DeclareStmt fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:73
   */
  public DeclareStmt treeCopyNoTransform() {
    DeclareStmt tree = (DeclareStmt) copy();
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
   * @declaredat ASTNode:93
   */
  public DeclareStmt treeCopy() {
    DeclareStmt tree = (DeclareStmt) copy();
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
   * Replaces the IdDecl child.
   * @param node The new node to replace the IdDecl child.
   * @apilevel high-level
   */
  public DeclareStmt setIdDecl(IdDecl node) {
    setChild(node, 0);
    return this;
  }
  /**
   * Retrieves the IdDecl child.
   * @return The current node used as the IdDecl child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="IdDecl")
  public IdDecl getIdDecl() {
    return (IdDecl) getChild(0);
  }
  /**
   * Retrieves the IdDecl child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the IdDecl child.
   * @apilevel low-level
   */
  public IdDecl getIdDeclNoTransform() {
    return (IdDecl) getChildNoTransform(0);
  }
  /**
   * Replaces the optional node for the Expr child. This is the <code>Opt</code>
   * node containing the child Expr, not the actual child!
   * @param opt The new node to be used as the optional node for the Expr child.
   * @apilevel low-level
   */
  public DeclareStmt setExprOpt(Opt<Expr> opt) {
    setChild(opt, 1);
    return this;
  }
  /**
   * Replaces the (optional) Expr child.
   * @param node The new node to be used as the Expr child.
   * @apilevel high-level
   */
  public DeclareStmt setExpr(Expr node) {
    getExprOpt().setChild(node, 0);
    return this;
  }
  /**
   * Check whether the optional Expr child exists.
   * @return {@code true} if the optional Expr child exists, {@code false} if it does not.
   * @apilevel high-level
   */
  public boolean hasExpr() {
    return getExprOpt().getNumChild() != 0;
  }
  /**
   * Retrieves the (optional) Expr child.
   * @return The Expr child, if it exists. Returns {@code null} otherwise.
   * @apilevel low-level
   */
  public Expr getExpr() {
    return (Expr) getExprOpt().getChild(0);
  }
  /**
   * Retrieves the optional node for the Expr child. This is the <code>Opt</code> node containing the child Expr, not the actual child!
   * @return The optional node for child the Expr child.
   * @apilevel low-level
   */
  @ASTNodeAnnotation.OptChild(name="Expr")
  public Opt<Expr> getExprOpt() {
    return (Opt<Expr>) getChild(1);
  }
  /**
   * Retrieves the optional node for child Expr. This is the <code>Opt</code> node containing the child Expr, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child Expr.
   * @apilevel low-level
   */
  public Opt<Expr> getExprOptNoTransform() {
    return (Opt<Expr>) getChildNoTransform(1);
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
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/NameAnalysis.jrag:107
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
    localLookup_value = getIdDecl();
    localLookup_computed = true;
    state().leaveLazyAttribute();
    localLookup_visited = false;
    return localLookup_value;
  }
  /**
   * @attribute inh
   * @aspect CircularDefinitions
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/CircularDefinitions.jrag:5
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="CircularDefinitions", declaredAt="/Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/CircularDefinitions.jrag:5")
  public boolean inExprOf(IdDecl decl) {
    Object _parameters = decl;
    if (inExprOf_IdDecl_visited == null) inExprOf_IdDecl_visited = new java.util.HashSet(4);
    if (inExprOf_IdDecl_values == null) inExprOf_IdDecl_values = new java.util.HashMap(4);
    ASTState state = state();
    if (inExprOf_IdDecl_values.containsKey(_parameters)) {
      return (Boolean) inExprOf_IdDecl_values.get(_parameters);
    }
    if (inExprOf_IdDecl_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute DeclareStmt.inExprOf(IdDecl).");
    }
    inExprOf_IdDecl_visited.add(_parameters);
    state().enterLazyAttribute();
    boolean inExprOf_IdDecl_value = getParent().Define_inExprOf(this, null, decl);
    inExprOf_IdDecl_values.put(_parameters, inExprOf_IdDecl_value);
    state().leaveLazyAttribute();
    inExprOf_IdDecl_visited.remove(_parameters);
    return inExprOf_IdDecl_value;
  }
/** @apilevel internal */
protected java.util.Set inExprOf_IdDecl_visited;
  /** @apilevel internal */
  private void inExprOf_IdDecl_reset() {
    inExprOf_IdDecl_values = null;
    inExprOf_IdDecl_visited = null;
  }
  /** @apilevel internal */
  protected java.util.Map inExprOf_IdDecl_values;

  /**
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/CodeGen.jrag:380
   * @apilevel internal
   */
  public boolean Define_isParam(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getIdDeclNoTransform()) {
      // @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/CodeGen.jrag:383
      return false;
    }
    else {
      return getParent().Define_isParam(this, _callerNode);
    }
  }
  /**
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/CodeGen.jrag:380
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute isParam
   */
  protected boolean canDefine_isParam(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/CircularDefinitions.jrag:4
   * @apilevel internal
   */
  public boolean Define_inExprOf(ASTNode _callerNode, ASTNode _childNode, IdDecl decl) {
    if (_callerNode == getExprOptNoTransform()) {
      // @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/CircularDefinitions.jrag:6
      return getIdDecl() == decl || inExprOf(decl);
    }
    else {
      return getParent().Define_inExprOf(this, _callerNode, decl);
    }
  }
  /**
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/CircularDefinitions.jrag:4
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute inExprOf
   */
  protected boolean canDefine_inExprOf(ASTNode _callerNode, ASTNode _childNode, IdDecl decl) {
    return true;
  }
  /**
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:17
   * @apilevel internal
   */
  public Type Define_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getExprOptNoTransform()) {
      // @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:25
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
  /**
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:31
   * @apilevel internal
   */
  public boolean Define_isVariable(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getIdDeclNoTransform()) {
      // @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:34
      return true;
    }
    else {
      return getParent().Define_isVariable(this, _callerNode);
    }
  }
  /**
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:31
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute isVariable
   */
  protected boolean canDefine_isVariable(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:39
   * @apilevel internal
   */
  public boolean Define_isFunction(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getIdDeclNoTransform()) {
      // @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:42
      return false;
    }
    else {
      return getParent().Define_isFunction(this, _callerNode);
    }
  }
  /**
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:39
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute isFunction
   */
  protected boolean canDefine_isFunction(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }

}
