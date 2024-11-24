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
 * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/lang.ast:39
 * @astdecl IdDecl : ASTNode ::= <ID:String>;
 * @production IdDecl : {@link ASTNode} ::= <span class="component">&lt;ID:{@link String}&gt;</span>;

 */
public class IdDecl extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect Visitor
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/Visitor.jrag:117
   */
  public Object accept(Visitor visitor, Object data) {
        return visitor.visit(this, data);
    }
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/PrettyPrint.jrag:163
   */
  public void prettyPrint(PrintStream out, String ind) {
        out.print("int ");
        out.print(getID());
    }
  /**
   * @declaredat ASTNode:1
   */
  public IdDecl() {
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
  public IdDecl(String p0) {
    setID(p0);
  }
  /**
   * @declaredat ASTNode:20
   */
  public IdDecl(beaver.Symbol p0) {
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
    address_reset();
    localIndex_reset();
    ParamIndex_reset();
    isUnknown_reset();
    actualType_reset();
    isMultiDeclared_reset();
    isParam_reset();
    funcDecl_reset();
    isVariable_reset();
    isFunction_reset();
    lookup_String_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:43
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:48
   */
  public IdDecl clone() throws CloneNotSupportedException {
    IdDecl node = (IdDecl) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:53
   */
  public IdDecl copy() {
    try {
      IdDecl node = (IdDecl) clone();
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
   * @declaredat ASTNode:72
   */
  @Deprecated
  public IdDecl fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:82
   */
  public IdDecl treeCopyNoTransform() {
    IdDecl tree = (IdDecl) copy();
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
   * @declaredat ASTNode:102
   */
  public IdDecl treeCopy() {
    IdDecl tree = (IdDecl) copy();
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
  public IdDecl setID(String value) {
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
  public IdDecl setID(beaver.Symbol symbol) {
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
protected boolean address_visited = false;
  /** @apilevel internal */
  private void address_reset() {
    address_computed = false;
    
    address_value = null;
    address_visited = false;
  }
  /** @apilevel internal */
  protected boolean address_computed = false;

  /** @apilevel internal */
  protected String address_value;

  /**
   * Address of local variable variable in the current stack frame.
   * @attribute syn
   * @aspect CodeGen
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/CodeGen.jrag:388
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/CodeGen.jrag:388")
  public String address() {
    ASTState state = state();
    if (address_computed) {
      return address_value;
    }
    if (address_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.address().");
    }
    address_visited = true;
    state().enterLazyAttribute();
    address_value = this.isParam() ? (ParamIndex()*8)+"(%rbp)" : "-"+(localIndex()*8)+"(%rbp)";
    address_computed = true;
    state().leaveLazyAttribute();
    address_visited = false;
    return address_value;
  }
/** @apilevel internal */
protected boolean localIndex_visited = false;
  /** @apilevel internal */
  private void localIndex_reset() {
    localIndex_computed = false;
    localIndex_visited = false;
  }
  /** @apilevel internal */
  protected boolean localIndex_computed = false;

  /** @apilevel internal */
  protected int localIndex_value;

  /**
   * @attribute syn
   * @aspect CodeGen
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/CodeGen.jrag:407
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/CodeGen.jrag:398")
  public int localIndex() {
    ASTState state = state();
    if (localIndex_computed) {
      return localIndex_value;
    }
    if (localIndex_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.localIndex().");
    }
    localIndex_visited = true;
    state().enterLazyAttribute();
    localIndex_value = this.isVariable() ? prevNode().localIndex() + 1 : prevNode().localIndex();
    localIndex_computed = true;
    state().leaveLazyAttribute();
    localIndex_visited = false;
    return localIndex_value;
  }
/** @apilevel internal */
protected boolean ParamIndex_visited = false;
  /** @apilevel internal */
  private void ParamIndex_reset() {
    ParamIndex_computed = false;
    ParamIndex_visited = false;
  }
  /** @apilevel internal */
  protected boolean ParamIndex_computed = false;

  /** @apilevel internal */
  protected int ParamIndex_value;

  /**
   * @attribute syn
   * @aspect CodeGen
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/CodeGen.jrag:408
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/CodeGen.jrag:399")
  public int ParamIndex() {
    ASTState state = state();
    if (ParamIndex_computed) {
      return ParamIndex_value;
    }
    if (ParamIndex_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.ParamIndex().");
    }
    ParamIndex_visited = true;
    state().enterLazyAttribute();
    ParamIndex_value = this.isParam() ? prevNode().ParamIndex() + 1: prevNode().ParamIndex();
    ParamIndex_computed = true;
    state().leaveLazyAttribute();
    ParamIndex_visited = false;
    return ParamIndex_value;
  }
/** @apilevel internal */
protected boolean isUnknown_visited = false;
  /** @apilevel internal */
  private void isUnknown_reset() {
    isUnknown_computed = false;
    isUnknown_visited = false;
  }
  /** @apilevel internal */
  protected boolean isUnknown_computed = false;

  /** @apilevel internal */
  protected boolean isUnknown_value;

  /**
   * @attribute syn
   * @aspect UnknownDecl
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/UnknownDecl.jrag:7
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="UnknownDecl", declaredAt="/Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/UnknownDecl.jrag:7")
  public boolean isUnknown() {
    ASTState state = state();
    if (isUnknown_computed) {
      return isUnknown_value;
    }
    if (isUnknown_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.isUnknown().");
    }
    isUnknown_visited = true;
    state().enterLazyAttribute();
    isUnknown_value = false;
    isUnknown_computed = true;
    state().leaveLazyAttribute();
    isUnknown_visited = false;
    return isUnknown_value;
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
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:3
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:3")
  public Type actualType() {
    ASTState state = state();
    if (actualType_computed) {
      return actualType_value;
    }
    if (actualType_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.actualType().");
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
protected boolean isMultiDeclared_visited = false;
  /** @apilevel internal */
  private void isMultiDeclared_reset() {
    isMultiDeclared_computed = false;
    isMultiDeclared_visited = false;
  }
  /** @apilevel internal */
  protected boolean isMultiDeclared_computed = false;

  /** @apilevel internal */
  protected boolean isMultiDeclared_value;

  /**
   * @attribute syn
   * @aspect NameAnalysis
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/NameAnalysis.jrag:84
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/NameAnalysis.jrag:84")
  public boolean isMultiDeclared() {
    ASTState state = state();
    if (isMultiDeclared_computed) {
      return isMultiDeclared_value;
    }
    if (isMultiDeclared_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.isMultiDeclared().");
    }
    isMultiDeclared_visited = true;
    state().enterLazyAttribute();
    isMultiDeclared_value = lookup(getID()) != this;
    isMultiDeclared_computed = true;
    state().leaveLazyAttribute();
    isMultiDeclared_visited = false;
    return isMultiDeclared_value;
  }
  /**
   * @attribute inh
   * @aspect CodeGen
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/CodeGen.jrag:380
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/CodeGen.jrag:380")
  public boolean isParam() {
    ASTState state = state();
    if (isParam_computed) {
      return isParam_value;
    }
    if (isParam_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.isParam().");
    }
    isParam_visited = true;
    state().enterLazyAttribute();
    isParam_value = getParent().Define_isParam(this, null);
    isParam_computed = true;
    state().leaveLazyAttribute();
    isParam_visited = false;
    return isParam_value;
  }
/** @apilevel internal */
protected boolean isParam_visited = false;
  /** @apilevel internal */
  private void isParam_reset() {
    isParam_computed = false;
    isParam_visited = false;
  }
  /** @apilevel internal */
  protected boolean isParam_computed = false;

  /** @apilevel internal */
  protected boolean isParam_value;

  /**
   * @attribute inh
   * @aspect functionCalls
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/functionCall.jrag:16
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="functionCalls", declaredAt="/Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/functionCall.jrag:16")
  public FunctionDecl funcDecl() {
    ASTState state = state();
    if (funcDecl_computed) {
      return funcDecl_value;
    }
    if (funcDecl_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.funcDecl().");
    }
    funcDecl_visited = true;
    state().enterLazyAttribute();
    funcDecl_value = getParent().Define_funcDecl(this, null);
    funcDecl_computed = true;
    state().leaveLazyAttribute();
    funcDecl_visited = false;
    return funcDecl_value;
  }
/** @apilevel internal */
protected boolean funcDecl_visited = false;
  /** @apilevel internal */
  private void funcDecl_reset() {
    funcDecl_computed = false;
    
    funcDecl_value = null;
    funcDecl_visited = false;
  }
  /** @apilevel internal */
  protected boolean funcDecl_computed = false;

  /** @apilevel internal */
  protected FunctionDecl funcDecl_value;

  /**
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:31
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:31")
  public boolean isVariable() {
    ASTState state = state();
    if (isVariable_computed) {
      return isVariable_value;
    }
    if (isVariable_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.isVariable().");
    }
    isVariable_visited = true;
    state().enterLazyAttribute();
    isVariable_value = getParent().Define_isVariable(this, null);
    isVariable_computed = true;
    state().leaveLazyAttribute();
    isVariable_visited = false;
    return isVariable_value;
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
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:39
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/TypeAnalysis.jrag:39")
  public boolean isFunction() {
    ASTState state = state();
    if (isFunction_computed) {
      return isFunction_value;
    }
    if (isFunction_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.isFunction().");
    }
    isFunction_visited = true;
    state().enterLazyAttribute();
    isFunction_value = getParent().Define_isFunction(this, null);
    isFunction_computed = true;
    state().leaveLazyAttribute();
    isFunction_visited = false;
    return isFunction_value;
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
   * @attribute inh
   * @aspect NameAnalysis
   * @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/NameAnalysis.jrag:85
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/NameAnalysis.jrag:85")
  public IdDecl lookup(String name) {
    Object _parameters = name;
    if (lookup_String_visited == null) lookup_String_visited = new java.util.HashSet(4);
    if (lookup_String_values == null) lookup_String_values = new java.util.HashMap(4);
    ASTState state = state();
    if (lookup_String_values.containsKey(_parameters)) {
      return (IdDecl) lookup_String_values.get(_parameters);
    }
    if (lookup_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute IdDecl.lookup(String).");
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
    // @declaredat /Users/adriansteene/dev/EDAN65/p017-adrian-christoffer/A6/A6 - SimpliC/src/jastadd/Error.jrag:37
    if (isMultiDeclared()) {
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
    if (isMultiDeclared()) {
      collection.add(error("symbol '" + getID() + "' is already declared!"));
    }
  }

}
