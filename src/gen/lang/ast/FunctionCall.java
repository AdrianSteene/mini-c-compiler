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
 * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/lang.ast:20
 * @astdecl FunctionCall : Expr ::= IdUse Expr*;
 * @production FunctionCall : {@link Expr} ::= <span class="component">{@link IdUse}</span> <span class="component">{@link Expr}*</span>;

 */
public class FunctionCall extends Expr implements Cloneable {
  /**
   * @aspect Visitor
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Visitor.jrag:78
   */
  public Object accept(Visitor visitor, Object data) {
        return visitor.visit(this, data);
    }
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/PrettyPrint.jrag:88
   */
  public void prettyPrint(PrintStream out, String ind) {
        getIdUse().prettyPrint(out, ind);
        out.print("(");
        getExprs().prettyPrint(out, ind);
        out.print(")");
        out.print(";");
    }
  /**
   * @aspect CodeGen
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:245
   */
  public void genConditionalJump(PrintStream out, String name){}
  /**
   * @aspect CodeGen
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:350
   */
  public void genEval(PrintStream out) {
        if(getIdUse().getID().equals("print")) {
            getExpr(0).genEval(out);
            out.println("        pushq %rax");
            out.println("        call print");
            out.println("        addq $8, %rsp");
        }  else if(getIdUse().getID().equals("read")){
            out.println("        call read");
        }
        else {
            for(int index = getExprList().getNumChild()-1; index >= 0; index--){
                getExprList().getChild(index).genEval(out);
                out.println("        pushq %rax");

            }

            // Return
            out.println("        call " + getIdUse().getID());
            out.println("        addq $" + 8*(getExprList().getNumChild()) + ", %rsp");
          
            //out.println("        movq %rax, " + getIdUse().decl().address());
        }

        //getIdUse().decl().address();




    }
  /**
   * @aspect Interpreter
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Interpreter.jrag:151
   */
  int value(ActivationRecord actrec) {
        if(getIdUse().getID().equals("print")){
            for(Expr expr: getExprs()){
                int value = expr.value(actrec);
                System.out.println(value);
                return 0;
            }
        }
        if(getIdUse().getID().equals("read")){
            return actrec.getScanner().nextInt();
        }

        ActivationRecord actrecNew = actrec.push();
    
        for(FunctionDecl decl: getIdUse().decl().program().getFunctionDeclList()){
            if(decl.getLeft().getID().equals(getIdUse().getID())){
                FunctionDecl mainDecl = decl;
                for(int i = 0; i < mainDecl.getRightList().getNumChild(); i++){
                    actrecNew.setValue(mainDecl.getRight(i).getID(), getExpr(i).value(actrec));
                }

                return mainDecl.eval(actrecNew);
            }
        }
        return 0;

    }
  /**
   * @declaredat ASTNode:1
   */
  public FunctionCall() {
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
    setChild(new List(), 1);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"IdUse", "Expr"},
    type = {"IdUse", "List<Expr>"},
    kind = {"Child", "List"}
  )
  public FunctionCall(IdUse p0, List<Expr> p1) {
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
    addFunctionCall_reset();
    actualType_reset();
    validDecl_reset();
    validCall_reset();
    enclosingFunction_reset();
    functionLookup_String_List_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:38
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:43
   */
  public FunctionCall clone() throws CloneNotSupportedException {
    FunctionCall node = (FunctionCall) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:48
   */
  public FunctionCall copy() {
    try {
      FunctionCall node = (FunctionCall) clone();
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
   * @declaredat ASTNode:67
   */
  @Deprecated
  public FunctionCall fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:77
   */
  public FunctionCall treeCopyNoTransform() {
    FunctionCall tree = (FunctionCall) copy();
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
   * @declaredat ASTNode:97
   */
  public FunctionCall treeCopy() {
    FunctionCall tree = (FunctionCall) copy();
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
   * Replaces the IdUse child.
   * @param node The new node to replace the IdUse child.
   * @apilevel high-level
   */
  public FunctionCall setIdUse(IdUse node) {
    setChild(node, 0);
    return this;
  }
  /**
   * Retrieves the IdUse child.
   * @return The current node used as the IdUse child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="IdUse")
  public IdUse getIdUse() {
    return (IdUse) getChild(0);
  }
  /**
   * Retrieves the IdUse child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the IdUse child.
   * @apilevel low-level
   */
  public IdUse getIdUseNoTransform() {
    return (IdUse) getChildNoTransform(0);
  }
  /**
   * Replaces the Expr list.
   * @param list The new list node to be used as the Expr list.
   * @apilevel high-level
   */
  public FunctionCall setExprList(List<Expr> list) {
    setChild(list, 1);
    return this;
  }
  /**
   * Retrieves the number of children in the Expr list.
   * @return Number of children in the Expr list.
   * @apilevel high-level
   */
  public int getNumExpr() {
    return getExprList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Expr list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Expr list.
   * @apilevel low-level
   */
  public int getNumExprNoTransform() {
    return getExprListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Expr list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Expr list.
   * @apilevel high-level
   */
  public Expr getExpr(int i) {
    return (Expr) getExprList().getChild(i);
  }
  /**
   * Check whether the Expr list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasExpr() {
    return getExprList().getNumChild() != 0;
  }
  /**
   * Append an element to the Expr list.
   * @param node The element to append to the Expr list.
   * @apilevel high-level
   */
  public FunctionCall addExpr(Expr node) {
    List<Expr> list = (parent == null) ? getExprListNoTransform() : getExprList();
    list.addChild(node);
    return this;
  }
  /** @apilevel low-level 
   */
  public FunctionCall addExprNoTransform(Expr node) {
    List<Expr> list = getExprListNoTransform();
    list.addChild(node);
    return this;
  }
  /**
   * Replaces the Expr list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public FunctionCall setExpr(Expr node, int i) {
    List<Expr> list = getExprList();
    list.setChild(node, i);
    return this;
  }
  /**
   * Retrieves the Expr list.
   * @return The node representing the Expr list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Expr")
  public List<Expr> getExprList() {
    List<Expr> list = (List<Expr>) getChild(1);
    return list;
  }
  /**
   * Retrieves the Expr list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Expr list.
   * @apilevel low-level
   */
  public List<Expr> getExprListNoTransform() {
    return (List<Expr>) getChildNoTransform(1);
  }
  /**
   * @return the element at index {@code i} in the Expr list without
   * triggering rewrites.
   */
  public Expr getExprNoTransform(int i) {
    return (Expr) getExprListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Expr list.
   * @return The node representing the Expr list.
   * @apilevel high-level
   */
  public List<Expr> getExprs() {
    return getExprList();
  }
  /**
   * Retrieves the Expr list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Expr list.
   * @apilevel low-level
   */
  public List<Expr> getExprsNoTransform() {
    return getExprListNoTransform();
  }
/** @apilevel internal */
protected boolean addFunctionCall_visited = false;
  /** @apilevel internal */
  private void addFunctionCall_reset() {
    addFunctionCall_computed = false;
    
    addFunctionCall_value = null;
    addFunctionCall_visited = false;
  }
  /** @apilevel internal */
  protected boolean addFunctionCall_computed = false;

  /** @apilevel internal */
  protected FunctionDecl addFunctionCall_value;

  /**
   * @attribute syn
   * @aspect functionCalls
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/functionCall.jrag:12
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="functionCalls", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/functionCall.jrag:12")
  public FunctionDecl addFunctionCall() {
    ASTState state = state();
    if (addFunctionCall_computed) {
      return addFunctionCall_value;
    }
    if (addFunctionCall_visited) {
      throw new RuntimeException("Circular definition of attribute FunctionCall.addFunctionCall().");
    }
    addFunctionCall_visited = true;
    state().enterLazyAttribute();
    addFunctionCall_value = getIdUse().decl().funcDecl();
    addFunctionCall_computed = true;
    state().leaveLazyAttribute();
    addFunctionCall_visited = false;
    return addFunctionCall_value;
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
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:9
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
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:52
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:51")
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
    validDecl_value = getIdUse().isVariable();
    validDecl_computed = true;
    state().leaveLazyAttribute();
    validDecl_visited = false;
    return validDecl_value;
  }
/** @apilevel internal */
protected boolean validCall_visited = false;
  /** @apilevel internal */
  private void validCall_reset() {
    validCall_computed = false;
    validCall_visited = false;
  }
  /** @apilevel internal */
  protected boolean validCall_computed = false;

  /** @apilevel internal */
  protected boolean validCall_value;

  /**
   * @attribute syn
   * @aspect NameAnalysis
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/NameAnalysis.jrag:2
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/NameAnalysis.jrag:2")
  public boolean validCall() {
    ASTState state = state();
    if (validCall_computed) {
      return validCall_value;
    }
    if (validCall_visited) {
      throw new RuntimeException("Circular definition of attribute FunctionCall.validCall().");
    }
    validCall_visited = true;
    state().enterLazyAttribute();
    validCall_value = !functionLookup(getIdUse().getID(), getExprs());
    validCall_computed = true;
    state().leaveLazyAttribute();
    validCall_visited = false;
    return validCall_value;
  }
  /**
   * @attribute inh
   * @aspect functionCalls
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/functionCall.jrag:9
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="functionCalls", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/functionCall.jrag:9")
  public FunctionDecl enclosingFunction() {
    ASTState state = state();
    if (enclosingFunction_computed) {
      return enclosingFunction_value;
    }
    if (enclosingFunction_visited) {
      throw new RuntimeException("Circular definition of attribute FunctionCall.enclosingFunction().");
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
   * @attribute inh
   * @aspect NameAnalysis
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/NameAnalysis.jrag:22
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/NameAnalysis.jrag:22")
  public boolean functionLookup(String name, List list) {
    java.util.List _parameters = new java.util.ArrayList(2);
    _parameters.add(name);
    _parameters.add(list);
    if (functionLookup_String_List_visited == null) functionLookup_String_List_visited = new java.util.HashSet(4);
    if (functionLookup_String_List_values == null) functionLookup_String_List_values = new java.util.HashMap(4);
    ASTState state = state();
    if (functionLookup_String_List_values.containsKey(_parameters)) {
      return (Boolean) functionLookup_String_List_values.get(_parameters);
    }
    if (functionLookup_String_List_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute FunctionCall.functionLookup(String,List).");
    }
    functionLookup_String_List_visited.add(_parameters);
    state().enterLazyAttribute();
    boolean functionLookup_String_List_value = getParent().Define_functionLookup(this, null, name, list);
    functionLookup_String_List_values.put(_parameters, functionLookup_String_List_value);
    state().leaveLazyAttribute();
    functionLookup_String_List_visited.remove(_parameters);
    return functionLookup_String_List_value;
  }
/** @apilevel internal */
protected java.util.Set functionLookup_String_List_visited;
  /** @apilevel internal */
  private void functionLookup_String_List_reset() {
    functionLookup_String_List_values = null;
    functionLookup_String_List_visited = null;
  }
  /** @apilevel internal */
  protected java.util.Map functionLookup_String_List_values;

  /** @apilevel internal */
  protected void collect_contributors_FunctionDecl_functionCalls(Program _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/functionCall.jrag:6
    {
      FunctionDecl target = (FunctionDecl) (enclosingFunction());
      java.util.Set<ASTNode> contributors = _map.get(target);
      if (contributors == null) {
        contributors = new java.util.LinkedHashSet<ASTNode>();
        _map.put((ASTNode) target, contributors);
      }
      contributors.add(this);
    }
    super.collect_contributors_FunctionDecl_functionCalls(_root, _map);
  }
  /** @apilevel internal */
  protected void collect_contributors_Program_errors(Program _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Error.jrag:41
    if (validCall()) {
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
  protected void contributeTo_FunctionDecl_functionCalls(Set<FunctionDecl> collection) {
    super.contributeTo_FunctionDecl_functionCalls(collection);
    collection.add(addFunctionCall());
  }
  /** @apilevel internal */
  protected void contributeTo_Program_errors(Set<ErrorMessage> collection) {
    super.contributeTo_Program_errors(collection);
    if (validCall()) {
      collection.add(error("Type Error " + this.toString()));
    }
  }

}
