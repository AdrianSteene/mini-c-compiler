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
 * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/lang.ast:19
 * @astdecl IdUse : Expr ::= <ID:String>;
 * @production IdUse : {@link Expr} ::= <span class="component">&lt;ID:{@link String}&gt;</span>;

 */
public class IdUse extends Expr implements Cloneable {
  /**
   * @aspect Visitor
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Visitor.jrag:75
   */
  public Object accept(Visitor visitor, Object data) {
        return visitor.visit(this, data);
    }
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/PrettyPrint.jrag:159
   */
  public void prettyPrint(PrintStream out, String ind) {
        out.print(getID());
    }
  /**
   * @aspect CodeGen
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:243
   */
  public void genConditionalJump(PrintStream out, String name){}
  /**
   * @aspect CodeGen
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:288
   */
  public void genEval(PrintStream out) {
    out.println("        movq " + decl().address() + ", %rax");
    }
  /**
   * @aspect Interpreter
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Interpreter.jrag:141
   */
  int value(ActivationRecord actrec) {
        return actrec.getValue(getID());
    }
  /**
   * @declaredat ASTNode:1
   */
  public IdUse() {
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
    name = {"ID"},
    type = {"String"},
    kind = {"Token"}
  )
  public IdUse(String p0) {
    setID(p0);
  }
  /**
   * @declaredat ASTNode:20
   */
  public IdUse(beaver.Symbol p0) {
    setID(p0);
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
    isCircular_reset();
    actualType_reset();
    isVariable_reset();
    isFunction_reset();
    decl_reset();
    inExprOf_IdDecl_reset();
    lookup_String_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:39
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:44
   */
  public IdUse clone() throws CloneNotSupportedException {
    IdUse node = (IdUse) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:49
   */
  public IdUse copy() {
    try {
      IdUse node = (IdUse) clone();
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
   * @declaredat ASTNode:68
   */
  @Deprecated
  public IdUse fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:78
   */
  public IdUse treeCopyNoTransform() {
    IdUse tree = (IdUse) copy();
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
   * @declaredat ASTNode:98
   */
  public IdUse treeCopy() {
    IdUse tree = (IdUse) copy();
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
   * Replaces the lexeme ID.
   * @param value The new value for the lexeme ID.
   * @apilevel high-level
   */
  public IdUse setID(String value) {
    tokenString_ID = value;
    return this;
  }
  /** @apilevel internal 
   */
  protected String tokenString_ID;
  /**
   */
  public int IDstart;
  /**
   */
  public int IDend;
  /**
   * JastAdd-internal setter for lexeme ID using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme ID
   * @apilevel internal
   */
  public IdUse setID(beaver.Symbol symbol) {
    if (symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setID is only valid for String lexemes");
    tokenString_ID = (String)symbol.value;
    IDstart = symbol.getStart();
    IDend = symbol.getEnd();
    return this;
  }
  /**
   * Retrieves the value for the lexeme ID.
   * @return The value for the lexeme ID.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="ID")
  public String getID() {
    return tokenString_ID != null ? tokenString_ID : "";
  }
/** @apilevel internal */
protected boolean isCircular_visited = false;
  /** @apilevel internal */
  private void isCircular_reset() {
    isCircular_computed = false;
    isCircular_visited = false;
  }
  /** @apilevel internal */
  protected boolean isCircular_computed = false;

  /** @apilevel internal */
  protected boolean isCircular_value;

  /**
   * @attribute syn
   * @aspect CircularDefinitions
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/CircularDefinitions.jrag:3
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="CircularDefinitions", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/CircularDefinitions.jrag:3")
  public boolean isCircular() {
    ASTState state = state();
    if (isCircular_computed) {
      return isCircular_value;
    }
    if (isCircular_visited) {
      throw new RuntimeException("Circular definition of attribute IdUse.isCircular().");
    }
    isCircular_visited = true;
    state().enterLazyAttribute();
    isCircular_value = inExprOf(decl());
    isCircular_computed = true;
    state().leaveLazyAttribute();
    isCircular_visited = false;
    return isCircular_value;
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
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:8
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
/** @apilevel internal */
protected boolean isVariable_visited = false;
  /** @apilevel internal */
  private void isVariable_reset() {
    isVariable_computed = false;
    isVariable_visited = false;
  }
  /** @apilevel internal */
  protected boolean isVariable_computed = false;

  /** @apilevel internal */
  protected boolean isVariable_value;

  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:37
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:36")
  public boolean isVariable() {
    ASTState state = state();
    if (isVariable_computed) {
      return isVariable_value;
    }
    if (isVariable_visited) {
      throw new RuntimeException("Circular definition of attribute IdUse.isVariable().");
    }
    isVariable_visited = true;
    state().enterLazyAttribute();
    isVariable_value = decl().isVariable();
    isVariable_computed = true;
    state().leaveLazyAttribute();
    isVariable_visited = false;
    return isVariable_value;
  }
/** @apilevel internal */
protected boolean isFunction_visited = false;
  /** @apilevel internal */
  private void isFunction_reset() {
    isFunction_computed = false;
    isFunction_visited = false;
  }
  /** @apilevel internal */
  protected boolean isFunction_computed = false;

  /** @apilevel internal */
  protected boolean isFunction_value;

  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:45
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:44")
  public boolean isFunction() {
    ASTState state = state();
    if (isFunction_computed) {
      return isFunction_value;
    }
    if (isFunction_visited) {
      throw new RuntimeException("Circular definition of attribute IdUse.isFunction().");
    }
    isFunction_visited = true;
    state().enterLazyAttribute();
    isFunction_value = decl().isFunction();
    isFunction_computed = true;
    state().leaveLazyAttribute();
    isFunction_visited = false;
    return isFunction_value;
  }
/** @apilevel internal */
protected boolean decl_visited = false;
  /** @apilevel internal */
  private void decl_reset() {
    decl_computed = false;
    
    decl_value = null;
    decl_visited = false;
  }
  /** @apilevel internal */
  protected boolean decl_computed = false;

  /** @apilevel internal */
  protected IdDecl decl_value;

  /**
   * @attribute syn
   * @aspect NameAnalysis
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/NameAnalysis.jrag:24
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/NameAnalysis.jrag:24")
  public IdDecl decl() {
    ASTState state = state();
    if (decl_computed) {
      return decl_value;
    }
    if (decl_visited) {
      throw new RuntimeException("Circular definition of attribute IdUse.decl().");
    }
    decl_visited = true;
    state().enterLazyAttribute();
    decl_value = decl_compute();
    decl_computed = true;
    state().leaveLazyAttribute();
    decl_visited = false;
    return decl_value;
  }
  /** @apilevel internal */
  private IdDecl decl_compute() {
              IdDecl idDecl1 = lookup(getID());
              if(!idDecl1.isUnknown())
                  return idDecl1;
              return unknownDecl();
           }
  /**
   * @attribute inh
   * @aspect CircularDefinitions
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/CircularDefinitions.jrag:4
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="CircularDefinitions", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/CircularDefinitions.jrag:4")
  public boolean inExprOf(IdDecl decl) {
    Object _parameters = decl;
    if (inExprOf_IdDecl_visited == null) inExprOf_IdDecl_visited = new java.util.HashSet(4);
    if (inExprOf_IdDecl_values == null) inExprOf_IdDecl_values = new java.util.HashMap(4);
    ASTState state = state();
    if (inExprOf_IdDecl_values.containsKey(_parameters)) {
      return (Boolean) inExprOf_IdDecl_values.get(_parameters);
    }
    if (inExprOf_IdDecl_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute IdUse.inExprOf(IdDecl).");
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
   * @attribute inh
   * @aspect NameAnalysis
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/NameAnalysis.jrag:31
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/NameAnalysis.jrag:31")
  public IdDecl lookup(String name) {
    Object _parameters = name;
    if (lookup_String_visited == null) lookup_String_visited = new java.util.HashSet(4);
    if (lookup_String_values == null) lookup_String_values = new java.util.HashMap(4);
    ASTState state = state();
    if (lookup_String_values.containsKey(_parameters)) {
      return (IdDecl) lookup_String_values.get(_parameters);
    }
    if (lookup_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute IdUse.lookup(String).");
    }
    lookup_String_visited.add(_parameters);
    state().enterLazyAttribute();
    IdDecl lookup_String_value = getParent().Define_lookup(this, null, name);
    lookup_String_values.put(_parameters, lookup_String_value);
    state().leaveLazyAttribute();
    lookup_String_visited.remove(_parameters);
    return lookup_String_value;
  }
/** @apilevel internal */
protected java.util.Set lookup_String_visited;
  /** @apilevel internal */
  private void lookup_String_reset() {
    lookup_String_values = null;
    lookup_String_visited = null;
  }
  /** @apilevel internal */
  protected java.util.Map lookup_String_values;

  /** @apilevel internal */
  protected void collect_contributors_Program_errors(Program _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Error.jrag:33
    if (decl().isUnknown()) {
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
    // @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Error.jrag:57
    if (isCircular()) {
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
    if (decl().isUnknown()) {
      collection.add(error("symbol '" + getID() + "' is not declared"));
    }
    if (isCircular()) {
      collection.add(error("the definition of symbol '" + getID() + "' is circular"));
    }
  }

}
