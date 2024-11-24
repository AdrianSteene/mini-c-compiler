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
 * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/lang.ast:6
 * @astdecl FunctionDecl : ASTNode ::= Left:IdDecl Right:IdDecl* Block;
 * @production FunctionDecl : {@link ASTNode} ::= <span class="component">Left:{@link IdDecl}</span> <span class="component">Right:{@link IdDecl}*</span> <span class="component">{@link Block}</span>;

 */
public class FunctionDecl extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect Visitor
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Visitor.jrag:81
   */
  public Object accept(Visitor visitor, Object data) {
        return visitor.visit(this, data);
    }
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/PrettyPrint.jrag:16
   */
  public void prettyPrint(PrintStream out, String ind) {
        getLeft().prettyPrint(out, ind);
        out.print("(");
        for(IdDecl id: getRights()){
            id.prettyPrint(out, ind);
        }
        
        out.print("){");
        out.println();
        getBlock().prettyPrint(out, ind);
        out.print("}");
        out.println();
    }
  /**
   * @aspect CodeGen
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:147
   */
  public void genCode(PrintStream out) {
        out.println(getLeft().getID() + ":");
        //if(!getLeft().getID().equals("main")){
            out.println("        pushq %rbp");
            out.println("        movq %rsp, %rbp");
        //}            
        out.println("        subq $" + ((numLocals()*8) + ", %rsp"));
        getBlock().genCode(out);
    }
  /**
   * @aspect Interpreter
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Interpreter.jrag:22
   */
  public int eval(ActivationRecord actrec){
        return getBlock().execute(actrec);
    }
  /**
   * @declaredat ASTNode:1
   */
  public FunctionDecl() {
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
    children = new ASTNode[3];
    setChild(new List(), 1);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Left", "Right", "Block"},
    type = {"IdDecl", "List<IdDecl>", "Block"},
    kind = {"Child", "List", "Child"}
  )
  public FunctionDecl(IdDecl p0, List<IdDecl> p1, Block p2) {
    setChild(p0, 0);
    setChild(p1, 1);
    setChild(p2, 2);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:25
   */
  protected int numChildren() {
    return 3;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:29
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    localIndex_reset();
    ParamIndex_reset();
    reachable_reset();
    localLookup_String_reset();
    functionLookup_String_List_reset();
    lookup_String_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:39
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
    FunctionDecl_functionCalls_visited = false;
    FunctionDecl_functionCalls_computed = false;
    
    FunctionDecl_functionCalls_value = null;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:47
   */
  public FunctionDecl clone() throws CloneNotSupportedException {
    FunctionDecl node = (FunctionDecl) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:52
   */
  public FunctionDecl copy() {
    try {
      FunctionDecl node = (FunctionDecl) clone();
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
   * @declaredat ASTNode:71
   */
  @Deprecated
  public FunctionDecl fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:81
   */
  public FunctionDecl treeCopyNoTransform() {
    FunctionDecl tree = (FunctionDecl) copy();
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
   * @declaredat ASTNode:101
   */
  public FunctionDecl treeCopy() {
    FunctionDecl tree = (FunctionDecl) copy();
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
  public FunctionDecl setLeft(IdDecl node) {
    setChild(node, 0);
    return this;
  }
  /**
   * Retrieves the Left child.
   * @return The current node used as the Left child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Left")
  public IdDecl getLeft() {
    return (IdDecl) getChild(0);
  }
  /**
   * Retrieves the Left child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Left child.
   * @apilevel low-level
   */
  public IdDecl getLeftNoTransform() {
    return (IdDecl) getChildNoTransform(0);
  }
  /**
   * Replaces the Right list.
   * @param list The new list node to be used as the Right list.
   * @apilevel high-level
   */
  public FunctionDecl setRightList(List<IdDecl> list) {
    setChild(list, 1);
    return this;
  }
  /**
   * Retrieves the number of children in the Right list.
   * @return Number of children in the Right list.
   * @apilevel high-level
   */
  public int getNumRight() {
    return getRightList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Right list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Right list.
   * @apilevel low-level
   */
  public int getNumRightNoTransform() {
    return getRightListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Right list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Right list.
   * @apilevel high-level
   */
  public IdDecl getRight(int i) {
    return (IdDecl) getRightList().getChild(i);
  }
  /**
   * Check whether the Right list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasRight() {
    return getRightList().getNumChild() != 0;
  }
  /**
   * Append an element to the Right list.
   * @param node The element to append to the Right list.
   * @apilevel high-level
   */
  public FunctionDecl addRight(IdDecl node) {
    List<IdDecl> list = (parent == null) ? getRightListNoTransform() : getRightList();
    list.addChild(node);
    return this;
  }
  /** @apilevel low-level 
   */
  public FunctionDecl addRightNoTransform(IdDecl node) {
    List<IdDecl> list = getRightListNoTransform();
    list.addChild(node);
    return this;
  }
  /**
   * Replaces the Right list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public FunctionDecl setRight(IdDecl node, int i) {
    List<IdDecl> list = getRightList();
    list.setChild(node, i);
    return this;
  }
  /**
   * Retrieves the Right list.
   * @return The node representing the Right list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Right")
  public List<IdDecl> getRightList() {
    List<IdDecl> list = (List<IdDecl>) getChild(1);
    return list;
  }
  /**
   * Retrieves the Right list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Right list.
   * @apilevel low-level
   */
  public List<IdDecl> getRightListNoTransform() {
    return (List<IdDecl>) getChildNoTransform(1);
  }
  /**
   * @return the element at index {@code i} in the Right list without
   * triggering rewrites.
   */
  public IdDecl getRightNoTransform(int i) {
    return (IdDecl) getRightListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the Right list.
   * @return The node representing the Right list.
   * @apilevel high-level
   */
  public List<IdDecl> getRights() {
    return getRightList();
  }
  /**
   * Retrieves the Right list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Right list.
   * @apilevel low-level
   */
  public List<IdDecl> getRightsNoTransform() {
    return getRightListNoTransform();
  }
  /**
   * Replaces the Block child.
   * @param node The new node to replace the Block child.
   * @apilevel high-level
   */
  public FunctionDecl setBlock(Block node) {
    setChild(node, 2);
    return this;
  }
  /**
   * Retrieves the Block child.
   * @return The current node used as the Block child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Block")
  public Block getBlock() {
    return (Block) getChild(2);
  }
  /**
   * Retrieves the Block child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Block child.
   * @apilevel low-level
   */
  public Block getBlockNoTransform() {
    return (Block) getChildNoTransform(2);
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
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:403
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:398")
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
    localIndex_value = 0;
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
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:404
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:399")
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
    ParamIndex_value = 1;
    ParamIndex_computed = true;
    state().leaveLazyAttribute();
    ParamIndex_visited = false;
    return ParamIndex_value;
  }
/** @apilevel internal */
protected ASTState.Cycle reachable_cycle = null;
  /** @apilevel internal */
  private void reachable_reset() {
    reachable_computed = false;
    reachable_initialized = false;
    reachable_value = null;
    reachable_cycle = null;
  }
  /** @apilevel internal */
  protected boolean reachable_computed = false;

  /** @apilevel internal */
  protected Set<FunctionDecl> reachable_value;
  /** @apilevel internal */
  protected boolean reachable_initialized = false;
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isCircular=true)
  @ASTNodeAnnotation.Source(aspect="reachableFunctions", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/functionCall.jrag:22")
  public Set<FunctionDecl> reachable() {
    if (reachable_computed) {
      return reachable_value;
    }
    ASTState state = state();
    if (!reachable_initialized) {
      reachable_initialized = true;
      reachable_value = new HashSet<FunctionDecl>();
    }
    if (!state.inCircle() || state.calledByLazyAttribute()) {
      state.enterCircle();
      do {
        reachable_cycle = state.nextCycle();
        Set<FunctionDecl> new_reachable_value = reachable_compute();
        if (!AttributeValue.equals(reachable_value, new_reachable_value)) {
          state.setChangeInCycle();
        }
        reachable_value = new_reachable_value;
      } while (state.testAndClearChangeInCycle());
      reachable_computed = true;
      state.startLastCycle();
      Set<FunctionDecl> $tmp = reachable_compute();

      state.leaveCircle();
    } else if (reachable_cycle != state.cycle()) {
      reachable_cycle = state.cycle();
      if (state.lastCycle()) {
        reachable_computed = true;
        Set<FunctionDecl> new_reachable_value = reachable_compute();
        return new_reachable_value;
      }
      Set<FunctionDecl> new_reachable_value = reachable_compute();
      if (!AttributeValue.equals(reachable_value, new_reachable_value)) {
        state.setChangeInCycle();
      }
      reachable_value = new_reachable_value;
    } else {
    }
    return reachable_value;
  }
  /** @apilevel internal */
  private Set<FunctionDecl> reachable_compute() {
      Set<FunctionDecl> reachableFunctions = new HashSet(functionCalls());
      for(FunctionDecl funcDecl: functionCalls()) {
        reachableFunctions.addAll(funcDecl.reachable());
      }
      return reachableFunctions;
    }
/** @apilevel internal */
protected java.util.Set localLookup_String_visited;
  /** @apilevel internal */
  private void localLookup_String_reset() {
    localLookup_String_values = null;
    localLookup_String_visited = null;
  }
  /** @apilevel internal */
  protected java.util.Map localLookup_String_values;

  /**
   * @attribute syn
   * @aspect NameAnalysis
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/NameAnalysis.jrag:88
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/NameAnalysis.jrag:88")
  public IdDecl localLookup(String s) {
    Object _parameters = s;
    if (localLookup_String_visited == null) localLookup_String_visited = new java.util.HashSet(4);
    if (localLookup_String_values == null) localLookup_String_values = new java.util.HashMap(4);
    ASTState state = state();
    if (localLookup_String_values.containsKey(_parameters)) {
      return (IdDecl) localLookup_String_values.get(_parameters);
    }
    if (localLookup_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute FunctionDecl.localLookup(String).");
    }
    localLookup_String_visited.add(_parameters);
    state().enterLazyAttribute();
    IdDecl localLookup_String_value = localLookup_compute(s);
    localLookup_String_values.put(_parameters, localLookup_String_value);
    state().leaveLazyAttribute();
    localLookup_String_visited.remove(_parameters);
    return localLookup_String_value;
  }
  /** @apilevel internal */
  private IdDecl localLookup_compute(String s) {
          if(getLeft().getID().equals(s)) return getLeft();
          for (IdDecl d: getRightList()) {
              if (d.getID().equals(s))
                  return d;
          }
          return unknownDecl();
      }
  /**
   * @attribute inh
   * @aspect NameAnalysis
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/NameAnalysis.jrag:21
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/NameAnalysis.jrag:21")
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
      throw new RuntimeException("Circular definition of attribute FunctionDecl.functionLookup(String,List).");
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

  /**
   * @attribute inh
   * @aspect NameAnalysis
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/NameAnalysis.jrag:35
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/NameAnalysis.jrag:35")
  public IdDecl lookup(String name) {
    Object _parameters = name;
    if (lookup_String_visited == null) lookup_String_visited = new java.util.HashSet(4);
    if (lookup_String_values == null) lookup_String_values = new java.util.HashMap(4);
    ASTState state = state();
    if (lookup_String_values.containsKey(_parameters)) {
      return (IdDecl) lookup_String_values.get(_parameters);
    }
    if (lookup_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute FunctionDecl.lookup(String).");
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

  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:380
   * @apilevel internal
   */
  public boolean Define_isParam(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getRightListNoTransform()) {
      // @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:382
      int childIndex = _callerNode.getIndexOfChild(_childNode);
      return true;
    }
    else if (_callerNode == getLeftNoTransform()) {
      // @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:381
      return false;
    }
    else {
      return getParent().Define_isParam(this, _callerNode);
    }
  }
  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:380
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute isParam
   */
  protected boolean canDefine_isParam(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/functionCall.jrag:9
   * @apilevel internal
   */
  public FunctionDecl Define_enclosingFunction(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getBlockNoTransform()) {
      // @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/functionCall.jrag:8
      return this;
    }
    else {
      return getParent().Define_enclosingFunction(this, _callerNode);
    }
  }
  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/functionCall.jrag:9
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute enclosingFunction
   */
  protected boolean canDefine_enclosingFunction(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/functionCall.jrag:16
   * @apilevel internal
   */
  public FunctionDecl Define_funcDecl(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getLeftNoTransform()) {
      // @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/functionCall.jrag:15
      return this;
    }
    else {
      return getParent().Define_funcDecl(this, _callerNode);
    }
  }
  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/functionCall.jrag:16
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute funcDecl
   */
  protected boolean canDefine_funcDecl(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:31
   * @apilevel internal
   */
  public boolean Define_isVariable(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getRightListNoTransform()) {
      // @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:33
      int childIndex = _callerNode.getIndexOfChild(_childNode);
      return true;
    }
    else if (_callerNode == getLeftNoTransform()) {
      // @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:32
      return false;
    }
    else {
      return getParent().Define_isVariable(this, _callerNode);
    }
  }
  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:31
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute isVariable
   */
  protected boolean canDefine_isVariable(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:39
   * @apilevel internal
   */
  public boolean Define_isFunction(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getRightListNoTransform()) {
      // @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:41
      int childIndex = _callerNode.getIndexOfChild(_childNode);
      return false;
    }
    else if (_callerNode == getLeftNoTransform()) {
      // @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:40
      return true;
    }
    else {
      return getParent().Define_isFunction(this, _callerNode);
    }
  }
  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:39
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute isFunction
   */
  protected boolean canDefine_isFunction(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/NameAnalysis.jrag:85
   * @apilevel internal
   */
  public IdDecl Define_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    if (_callerNode == getRightListNoTransform()) {
      // @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/NameAnalysis.jrag:69
      int childIndex = _callerNode.getIndexOfChild(_childNode);
      {
              for (IdDecl d: getRightList()) {
                  if (d.getID().equals(name))
                      return d;
              }
              return lookup(name);
          }
    }
    else if (_callerNode == getBlockNoTransform()) {
      // @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/NameAnalysis.jrag:62
      {
              IdDecl decl = localLookup(name);
              if(!decl.isUnknown())
                  return decl;
              return lookup(name);
          }
    }
    else {
      return getParent().Define_lookup(this, _callerNode, name);
    }
  }
  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/NameAnalysis.jrag:85
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute lookup
   */
  protected boolean canDefine_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    return true;
  }
/** @apilevel internal */
protected boolean FunctionDecl_functionCalls_visited = false;
  /**
   * @attribute coll
   * @aspect functionCalls
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/functionCall.jrag:5
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
  @ASTNodeAnnotation.Source(aspect="functionCalls", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/functionCall.jrag:5")
  public Set<FunctionDecl> functionCalls() {
    ASTState state = state();
    if (FunctionDecl_functionCalls_computed) {
      return FunctionDecl_functionCalls_value;
    }
    if (FunctionDecl_functionCalls_visited) {
      throw new RuntimeException("Circular definition of attribute FunctionDecl.functionCalls().");
    }
    FunctionDecl_functionCalls_visited = true;
    state().enterLazyAttribute();
    FunctionDecl_functionCalls_value = functionCalls_compute();
    FunctionDecl_functionCalls_computed = true;
    state().leaveLazyAttribute();
    FunctionDecl_functionCalls_visited = false;
    return FunctionDecl_functionCalls_value;
  }
  /** @apilevel internal */
  private Set<FunctionDecl> functionCalls_compute() {
    ASTNode node = this;
    while (node.getParent() != null) {
      node = node.getParent();
    }
    Program root = (Program) node;
    root.survey_FunctionDecl_functionCalls();
    Set<FunctionDecl> _computedValue = new HashSet<FunctionDecl>();
    if (root.contributorMap_FunctionDecl_functionCalls.containsKey(this)) {
      for (ASTNode contributor : (java.util.Set<ASTNode>) root.contributorMap_FunctionDecl_functionCalls.get(this)) {
        contributor.contributeTo_FunctionDecl_functionCalls(_computedValue);
      }
    }
    return _computedValue;
  }
  /** @apilevel internal */
  protected boolean FunctionDecl_functionCalls_computed = false;

  /** @apilevel internal */
  protected Set<FunctionDecl> FunctionDecl_functionCalls_value;


}
