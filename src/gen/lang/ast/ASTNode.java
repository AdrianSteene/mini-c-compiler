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
 * @astdecl ASTNode;
 * @production ASTNode;

 */
public class ASTNode<T extends ASTNode> extends beaver.Symbol implements Cloneable {
  /**
   * @aspect Visitor
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Visitor.jrag:36
   */
  public Object accept(Visitor visitor, Object data) {
        throw new Error("Visitor: accept method not available for " + getClass().getName());
    }
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/PrettyPrint.jrag:5
   */
  public void prettyPrint(PrintStream out) {
        prettyPrint(out, "");
        out.println();
    }
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/PrettyPrint.jrag:10
   */
  public void prettyPrint(PrintStream out, String ind) {
      for (ASTNode child : astChildren()) {
          child.prettyPrint(out, ind);
        }
    }
  /**
   * @aspect Errors
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Error.jrag:22
   */
  protected ErrorMessage error(String message) {
        return new ErrorMessage(message, getLine(getStart()));
    }
  /**
   * @aspect DumpTree
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/DumpTree.jrag:9
   */
  public String TREE_VERSION() { return "24a"; }
  /**
   * @aspect DumpTree
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/DumpTree.jrag:10
   */
  private static final String DUMP_TREE_INDENT = "  ";
  /**
   * @aspect DumpTree
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/DumpTree.jrag:12
   */
  public String dumpTree() {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        dumpTree(new PrintStream(bytes));
        return bytes.toString();
    }
  /**
   * @aspect DumpTree
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/DumpTree.jrag:18
   */
  public void dumpTree(PrintStream out) {
        dumpTree(out, "");
        out.flush();
    }
  /**
   * @aspect DumpTree
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/DumpTree.jrag:23
   */
  public void dumpTree(PrintStream out, String indent) {
        out.print(indent + getClass().getSimpleName());
        out.println(getTokens());
        String childIndent = indent + DUMP_TREE_INDENT;
        for (ASTNode child : astChildren()) {
            if (child == null) {
                out.println(childIndent + "null");
            } else {
                child.dumpTree(out, childIndent);
            }
        }
    }
  /**
   * @aspect DumpTree
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/DumpTree.jrag:36
   */
  public String getTokens() {
        java.util.TreeSet<java.lang.reflect.Method> methods = new java.util.TreeSet<>(
                new java.util.Comparator<java.lang.reflect.Method>() {
                    public int compare(java.lang.reflect.Method m1, java.lang.reflect.Method m2) {
                        return m1.getName().compareTo(m2.getName());
                    }
                });

        methods.addAll(java.util.Arrays.asList(getClass().getMethods()));

        String result = "";
        for (java.lang.reflect.Method method : methods) {
            ASTNodeAnnotation.Token token = method.getAnnotation(ASTNodeAnnotation.Token.class);
            if (token != null) {
                try {
                    result += String.format(" %s=\"%s\"", token.name(), method.invoke(this));
                } catch (IllegalAccessException ignored) {
                } catch (InvocationTargetException ignored) {
                }
            }
        }
        return result;
    }
  /**
   * @declaredat ASTNode:1
   */
  public ASTNode() {
    super();
    init$Children();
  }
  /**
   * Initializes the child array to the correct size.
   * Initializes List and Opt nta children.
   * @apilevel internal
   * @ast method
   * @declaredat ASTNode:11
   */
  public void init$Children() {
  }
  /**
   * Cached child index. Child indices are assumed to never change (AST should
   * not change after construction).
   * @apilevel internal
   * @declaredat ASTNode:18
   */
  private int childIndex = -1;
  /** @apilevel low-level 
   * @declaredat ASTNode:21
   */
  public int getIndexOfChild(ASTNode node) {
    if (node == null) {
      return -1;
    }
    if (node.childIndex >= 0) {
      return node.childIndex;
    }
    for (int i = 0; children != null && i < children.length; i++) {
      if (children[i] == node) {
        node.childIndex = i;
        return i;
      }
    }
    return -1;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:38
   */
  public static final boolean generatedWithCacheCycle = true;
  /** @apilevel low-level 
   * @declaredat ASTNode:41
   */
  protected ASTNode parent;
  /** @apilevel low-level 
   * @declaredat ASTNode:44
   */
  protected ASTNode[] children;
  /** @apilevel internal 
   * @declaredat ASTNode:48
   */
  private static ASTState state = new ASTState();
  /** @apilevel internal 
   * @declaredat ASTNode:51
   */
  public final ASTState state() {
    return state;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:56
   */
  public final static ASTState resetState() {
    return state = new ASTState();
  }
  /**
   * @return an iterator that can be used to iterate over the children of this node.
   * The iterator does not allow removing children.
   * @declaredat ASTNode:65
   */
  public java.util.Iterator<T> astChildIterator() {
    return new java.util.Iterator<T>() {
      private int index = 0;

      @Override
      public boolean hasNext() {
        return index < getNumChild();
      }

      @Override
      public T next() {
        return hasNext() ? (T) getChild(index++) : null;
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }
  /** @return an object that can be used to iterate over the children of this node 
   * @declaredat ASTNode:87
   */
  public Iterable<T> astChildren() {
    return new Iterable<T>() {
      @Override
      public java.util.Iterator<T> iterator() {
        return astChildIterator();
      }
    };
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:97
   */
  public T getChild(int i) {
    ASTNode child = getChildNoTransform(i);
    return (T) child;
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:102
   */
  public ASTNode addChild(T node) {
    setChild(node, getNumChildNoTransform());
    return this;
  }
  /**
   * Gets a child without triggering rewrites.
   * @apilevel low-level
   * @declaredat ASTNode:110
   */
  public T getChildNoTransform(int i) {
    if (children == null) {
      return null;
    }
    T child = (T) children[i];
    return child;
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:118
   */
  protected int numChildren;
  /** @apilevel low-level 
   * @declaredat ASTNode:121
   */
  protected int numChildren() {
    return numChildren;
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:126
   */
  public int getNumChild() {
    return numChildren();
  }
  /**
   * Behaves like getNumChild, but does not invoke AST transformations (rewrites).
   * @apilevel low-level
   * @declaredat ASTNode:134
   */
  public final int getNumChildNoTransform() {
    return numChildren();
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:138
   */
  public ASTNode setChild(ASTNode node, int i) {
    if (children == null) {
      children = new ASTNode[(i + 1 > 4 || !(this instanceof List)) ? i + 1 : 4];
    } else if (i >= children.length) {
      ASTNode c[] = new ASTNode[i << 1];
      System.arraycopy(children, 0, c, 0, children.length);
      children = c;
    }
    children[i] = node;
    if (i >= numChildren) {
      numChildren = i+1;
    }
    if (node != null) {
      node.setParent(this);
      node.childIndex = i;
    }
    return this;
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:157
   */
  public ASTNode insertChild(ASTNode node, int i) {
    if (children == null) {
      children = new ASTNode[(i + 1 > 4 || !(this instanceof List)) ? i + 1 : 4];
      children[i] = node;
    } else {
      ASTNode c[] = new ASTNode[children.length + 1];
      System.arraycopy(children, 0, c, 0, i);
      c[i] = node;
      if (i < children.length) {
        System.arraycopy(children, i, c, i+1, children.length-i);
        for(int j = i+1; j < c.length; ++j) {
          if (c[j] != null) {
            c[j].childIndex = j;
          }
        }
      }
      children = c;
    }
    numChildren++;
    if (node != null) {
      node.setParent(this);
      node.childIndex = i;
    }
    return this;
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:183
   */
  public void removeChild(int i) {
    if (children != null) {
      ASTNode child = (ASTNode) children[i];
      if (child != null) {
        child.parent = null;
        child.childIndex = -1;
      }
      // Adding a check of this instance to make sure its a List, a move of children doesn't make
      // any sense for a node unless its a list. Also, there is a problem if a child of a non-List node is removed
      // and siblings are moved one step to the right, with null at the end.
      if (this instanceof List || this instanceof Opt) {
        System.arraycopy(children, i+1, children, i, children.length-i-1);
        children[children.length-1] = null;
        numChildren--;
        // fix child indices
        for(int j = i; j < numChildren; ++j) {
          if (children[j] != null) {
            child = (ASTNode) children[j];
            child.childIndex = j;
          }
        }
      } else {
        children[i] = null;
      }
    }
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:210
   */
  public ASTNode getParent() {
    return (ASTNode) parent;
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:214
   */
  public void setParent(ASTNode node) {
    parent = node;
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:279
   */
  public void flushTreeCache() {
    flushCache();
    if (children != null) {
      for (int i = 0; i < children.length; i++) {
        if (children[i] != null) {
          ((ASTNode) children[i]).flushTreeCache();
        }
      }
    }
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:290
   */
  public void flushCache() {
    flushAttrAndCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:294
   */
  public void flushAttrAndCollectionCache() {
    flushAttrCache();
    flushCollectionCache();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:299
   */
  public void flushAttrCache() {
    numLocals_reset();
    localIndex_reset();
    ParamIndex_reset();
    stmtIndex_reset();
    lastNode_reset();
    prevNode_int_reset();
    prevNode_reset();
    unknownDecl_reset();
    program_reset();
    intType_reset();
    boolType_reset();
    unknownType_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:314
   */
  public void flushCollectionCache() {
  }
  /** @apilevel internal 
   * @declaredat ASTNode:317
   */
  public ASTNode<T> clone() throws CloneNotSupportedException {
    ASTNode node = (ASTNode) super.clone();
    node.flushAttrAndCollectionCache();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:323
   */
  public ASTNode<T> copy() {
    try {
      ASTNode node = (ASTNode) clone();
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
   * @declaredat ASTNode:342
   */
  @Deprecated
  public ASTNode<T> fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:352
   */
  public ASTNode<T> treeCopyNoTransform() {
    ASTNode tree = (ASTNode) copy();
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
   * @declaredat ASTNode:372
   */
  public ASTNode<T> treeCopy() {
    ASTNode tree = (ASTNode) copy();
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
   * Performs a full traversal of the tree using getChild to trigger rewrites
   * @apilevel low-level
   * @declaredat ASTNode:389
   */
  public void doFullTraversal() {
    for (int i = 0; i < getNumChild(); i++) {
      getChild(i).doFullTraversal();
    }
  }
  /**
   * @aspect <NoAspect>
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Error.jrag:26
   */
    /** @apilevel internal */
  protected void collect_contributors_Program_errors(Program _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    for (int i = 0; i < getNumChild(); i++) {
      getChild(i).collect_contributors_Program_errors(_root, _map);
    }
  }
  /** @apilevel internal */
  protected void contributeTo_Program_errors(Set<ErrorMessage> collection) {
  }

  /**
   * @aspect <NoAspect>
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/functionCall.jrag:5
   */
    /** @apilevel internal */
  protected void collect_contributors_FunctionDecl_functionCalls(Program _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    for (int i = 0; i < getNumChild(); i++) {
      getChild(i).collect_contributors_FunctionDecl_functionCalls(_root, _map);
    }
  }
  /** @apilevel internal */
  protected void contributeTo_FunctionDecl_functionCalls(Set<FunctionDecl> collection) {
  }

/** @apilevel internal */
protected boolean numLocals_visited = false;
  /** @apilevel internal */
  private void numLocals_reset() {
    numLocals_computed = false;
    numLocals_visited = false;
  }
  /** @apilevel internal */
  protected boolean numLocals_computed = false;

  /** @apilevel internal */
  protected int numLocals_value;

  /**
   * Local variable counting.
   * @attribute syn
   * @aspect CodeGen
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:393
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:393")
  public int numLocals() {
    ASTState state = state();
    if (numLocals_computed) {
      return numLocals_value;
    }
    if (numLocals_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.numLocals().");
    }
    numLocals_visited = true;
    state().enterLazyAttribute();
    numLocals_value = lastNode().localIndex() - localIndex();
    numLocals_computed = true;
    state().leaveLazyAttribute();
    numLocals_visited = false;
    return numLocals_value;
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
   * Local variable numbering.
   * @attribute syn
   * @aspect CodeGen
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:398
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
    localIndex_value = prevNode().localIndex();
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
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:399
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
    ParamIndex_value = prevNode().ParamIndex();
    ParamIndex_computed = true;
    state().leaveLazyAttribute();
    ParamIndex_visited = false;
    return ParamIndex_value;
  }
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
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:400
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:400")
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
    stmtIndex_value = prevNode().stmtIndex();
    stmtIndex_computed = true;
    state().leaveLazyAttribute();
    stmtIndex_visited = false;
    return stmtIndex_value;
  }
/** @apilevel internal */
protected boolean lastNode_visited = false;
  /** @apilevel internal */
  private void lastNode_reset() {
    lastNode_computed = false;
    
    lastNode_value = null;
    lastNode_visited = false;
  }
  /** @apilevel internal */
  protected boolean lastNode_computed = false;

  /** @apilevel internal */
  protected ASTNode lastNode_value;

  /**
   * @attribute syn
   * @aspect CodeGen
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:414
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:414")
  public ASTNode lastNode() {
    ASTState state = state();
    if (lastNode_computed) {
      return lastNode_value;
    }
    if (lastNode_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.lastNode().");
    }
    lastNode_visited = true;
    state().enterLazyAttribute();
    lastNode_value = prevNode(getNumChild());
    lastNode_computed = true;
    state().leaveLazyAttribute();
    lastNode_visited = false;
    return lastNode_value;
  }
/** @apilevel internal */
protected java.util.Set prevNode_int_visited;
  /** @apilevel internal */
  private void prevNode_int_reset() {
    prevNode_int_values = null;
    prevNode_int_visited = null;
  }
  /** @apilevel internal */
  protected java.util.Map prevNode_int_values;

  /**
   * @attribute syn
   * @aspect CodeGen
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:415
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:415")
  public ASTNode prevNode(int i) {
    Object _parameters = i;
    if (prevNode_int_visited == null) prevNode_int_visited = new java.util.HashSet(4);
    if (prevNode_int_values == null) prevNode_int_values = new java.util.HashMap(4);
    ASTState state = state();
    if (prevNode_int_values.containsKey(_parameters)) {
      return (ASTNode) prevNode_int_values.get(_parameters);
    }
    if (prevNode_int_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute ASTNode.prevNode(int).");
    }
    prevNode_int_visited.add(_parameters);
    state().enterLazyAttribute();
    ASTNode prevNode_int_value = i>0 ? getChild(i-1).lastNode() : this;
    prevNode_int_values.put(_parameters, prevNode_int_value);
    state().leaveLazyAttribute();
    prevNode_int_visited.remove(_parameters);
    return prevNode_int_value;
  }
  /**
   * @attribute inh
   * @aspect CodeGen
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:412
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:412")
  public ASTNode prevNode() {
    ASTState state = state();
    if (prevNode_computed) {
      return prevNode_value;
    }
    if (prevNode_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.prevNode().");
    }
    prevNode_visited = true;
    state().enterLazyAttribute();
    prevNode_value = getParent().Define_prevNode(this, null);
    prevNode_computed = true;
    state().leaveLazyAttribute();
    prevNode_visited = false;
    return prevNode_value;
  }
/** @apilevel internal */
protected boolean prevNode_visited = false;
  /** @apilevel internal */
  private void prevNode_reset() {
    prevNode_computed = false;
    
    prevNode_value = null;
    prevNode_visited = false;
  }
  /** @apilevel internal */
  protected boolean prevNode_computed = false;

  /** @apilevel internal */
  protected ASTNode prevNode_value;

  /**
   * @attribute inh
   * @aspect UnknownDecl
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/UnknownDecl.jrag:4
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="UnknownDecl", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/UnknownDecl.jrag:4")
  public UnknownDecl unknownDecl() {
    ASTState state = state();
    if (unknownDecl_computed) {
      return unknownDecl_value;
    }
    if (unknownDecl_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.unknownDecl().");
    }
    unknownDecl_visited = true;
    state().enterLazyAttribute();
    unknownDecl_value = getParent().Define_unknownDecl(this, null);
    unknownDecl_computed = true;
    state().leaveLazyAttribute();
    unknownDecl_visited = false;
    return unknownDecl_value;
  }
/** @apilevel internal */
protected boolean unknownDecl_visited = false;
  /** @apilevel internal */
  private void unknownDecl_reset() {
    unknownDecl_computed = false;
    
    unknownDecl_value = null;
    unknownDecl_visited = false;
  }
  /** @apilevel internal */
  protected boolean unknownDecl_computed = false;

  /** @apilevel internal */
  protected UnknownDecl unknownDecl_value;

  /**
   * @attribute inh
   * @aspect Errors
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Error.jrag:28
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="Errors", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/Error.jrag:28")
  public Program program() {
    ASTState state = state();
    if (program_computed) {
      return program_value;
    }
    if (program_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.program().");
    }
    program_visited = true;
    state().enterLazyAttribute();
    program_value = getParent().Define_program(this, null);
    program_computed = true;
    state().leaveLazyAttribute();
    program_visited = false;
    return program_value;
  }
/** @apilevel internal */
protected boolean program_visited = false;
  /** @apilevel internal */
  private void program_reset() {
    program_computed = false;
    
    program_value = null;
    program_visited = false;
  }
  /** @apilevel internal */
  protected boolean program_computed = false;

  /** @apilevel internal */
  protected Program program_value;

  /**
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:57
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:57")
  public IntType intType() {
    ASTState state = state();
    if (intType_computed) {
      return intType_value;
    }
    if (intType_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.intType().");
    }
    intType_visited = true;
    state().enterLazyAttribute();
    intType_value = getParent().Define_intType(this, null);
    intType_computed = true;
    state().leaveLazyAttribute();
    intType_visited = false;
    return intType_value;
  }
/** @apilevel internal */
protected boolean intType_visited = false;
  /** @apilevel internal */
  private void intType_reset() {
    intType_computed = false;
    
    intType_value = null;
    intType_visited = false;
  }
  /** @apilevel internal */
  protected boolean intType_computed = false;

  /** @apilevel internal */
  protected IntType intType_value;

  /**
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:61
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:61")
  public BoolType boolType() {
    ASTState state = state();
    if (boolType_computed) {
      return boolType_value;
    }
    if (boolType_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.boolType().");
    }
    boolType_visited = true;
    state().enterLazyAttribute();
    boolType_value = getParent().Define_boolType(this, null);
    boolType_computed = true;
    state().leaveLazyAttribute();
    boolType_visited = false;
    return boolType_value;
  }
/** @apilevel internal */
protected boolean boolType_visited = false;
  /** @apilevel internal */
  private void boolType_reset() {
    boolType_computed = false;
    
    boolType_value = null;
    boolType_visited = false;
  }
  /** @apilevel internal */
  protected boolean boolType_computed = false;

  /** @apilevel internal */
  protected BoolType boolType_value;

  /**
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:65
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:65")
  public UnknownType unknownType() {
    ASTState state = state();
    if (unknownType_computed) {
      return unknownType_value;
    }
    if (unknownType_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.unknownType().");
    }
    unknownType_visited = true;
    state().enterLazyAttribute();
    unknownType_value = getParent().Define_unknownType(this, null);
    unknownType_computed = true;
    state().leaveLazyAttribute();
    unknownType_visited = false;
    return unknownType_value;
  }
/** @apilevel internal */
protected boolean unknownType_visited = false;
  /** @apilevel internal */
  private void unknownType_reset() {
    unknownType_computed = false;
    
    unknownType_value = null;
    unknownType_visited = false;
  }
  /** @apilevel internal */
  protected boolean unknownType_computed = false;

  /** @apilevel internal */
  protected UnknownType unknownType_value;

  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:412
   * @apilevel internal
   */
  public ASTNode Define_prevNode(ASTNode _callerNode, ASTNode _childNode) {
    int i = this.getIndexOfChild(_callerNode);
    return prevNode(i);
  }
  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:412
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute prevNode
   */
  protected boolean canDefine_prevNode(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /** @apilevel internal */
  public UnknownDecl Define_unknownDecl(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_unknownDecl(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_unknownDecl(self, _callerNode);
  }

  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/UnknownDecl.jrag:5
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute unknownDecl
   */
  protected boolean canDefine_unknownDecl(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public Program Define_program(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_program(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_program(self, _callerNode);
  }

  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Error.jrag:29
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute program
   */
  protected boolean canDefine_program(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public boolean Define_inExprOf(ASTNode _callerNode, ASTNode _childNode, IdDecl decl) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_inExprOf(self, _callerNode, decl)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_inExprOf(self, _callerNode, decl);
  }

  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/CircularDefinitions.jrag:6
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute inExprOf
   */
  protected boolean canDefine_inExprOf(ASTNode _callerNode, ASTNode _childNode, IdDecl decl) {
    return false;
  }
  /** @apilevel internal */
  public IntType Define_intType(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_intType(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_intType(self, _callerNode);
  }

  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:58
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute intType
   */
  protected boolean canDefine_intType(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public BoolType Define_boolType(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_boolType(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_boolType(self, _callerNode);
  }

  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:62
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute boolType
   */
  protected boolean canDefine_boolType(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public UnknownType Define_unknownType(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_unknownType(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_unknownType(self, _callerNode);
  }

  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:66
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute unknownType
   */
  protected boolean canDefine_unknownType(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public boolean Define_functionLookup(ASTNode _callerNode, ASTNode _childNode, String name, List list) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_functionLookup(self, _callerNode, name, list)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_functionLookup(self, _callerNode, name, list);
  }

  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/NameAnalysis.jrag:6
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute functionLookup
   */
  protected boolean canDefine_functionLookup(ASTNode _callerNode, ASTNode _childNode, String name, List list) {
    return false;
  }
  /** @apilevel internal */
  public IdDecl Define_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_lookup(self, _callerNode, name)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_lookup(self, _callerNode, name);
  }

  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/NameAnalysis.jrag:69
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute lookup
   */
  protected boolean canDefine_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    return false;
  }
  /** @apilevel internal */
  public Type Define_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_expectedType(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_expectedType(self, _callerNode);
  }

  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:21
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute expectedType
   */
  protected boolean canDefine_expectedType(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public boolean Define_isParam(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_isParam(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_isParam(self, _callerNode);
  }

  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:383
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute isParam
   */
  protected boolean canDefine_isParam(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public FunctionDecl Define_enclosingFunction(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_enclosingFunction(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_enclosingFunction(self, _callerNode);
  }

  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/functionCall.jrag:8
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute enclosingFunction
   */
  protected boolean canDefine_enclosingFunction(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public FunctionDecl Define_funcDecl(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_funcDecl(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_funcDecl(self, _callerNode);
  }

  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/functionCall.jrag:15
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute funcDecl
   */
  protected boolean canDefine_funcDecl(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public boolean Define_isVariable(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_isVariable(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_isVariable(self, _callerNode);
  }

  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:34
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute isVariable
   */
  protected boolean canDefine_isVariable(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
  /** @apilevel internal */
  public boolean Define_isFunction(ASTNode _callerNode, ASTNode _childNode) {
    ASTNode self = this;
    ASTNode parent = getParent();
    while (parent != null && !parent.canDefine_isFunction(self, _callerNode)) {
      _callerNode = self;
      self = parent;
      parent = self.getParent();
    }
    return parent.Define_isFunction(self, _callerNode);
  }

  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:42
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute isFunction
   */
  protected boolean canDefine_isFunction(ASTNode _callerNode, ASTNode _childNode) {
    return false;
  }
public ASTNode rewrittenNode() { throw new Error("rewrittenNode is undefined for ASTNode"); }

}
