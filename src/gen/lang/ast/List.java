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
 * @astdecl List : ASTNode;
 * @production List : {@link ASTNode};

 */
public class List<T extends ASTNode> extends ASTNode<T> implements Cloneable, Iterable<T> {
  /**
   * @aspect Visitor
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Visitor.jrag:39
   */
  public Object accept(Visitor visitor, Object data) {
        return visitor.visit(this, data);
    }
  /**
   * @declaredat ASTNode:1
   */
  public List() {
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
  public List(T... initialChildren) {
    children = new ASTNode[initialChildren.length];
    for (int i = 0; i < children.length; ++i) {
      addChild(initialChildren[i]);
    }
  }
  /**
   * @declaredat ASTNode:20
   */
  public List<T> add(T node) {
    addChild(node);
    return this;
  }
  /**
   * @declaredat ASTNode:25
   */
  public List<T> addAll(Iterable<? extends T> c) {
    for (T node : c) {
      addChild(node);
    }
    return this;
  }
  /**
   * @declaredat ASTNode:32
   */
  public List<T> insertChild(ASTNode node, int i) {
    super.insertChild(node, i);
    return this;
  }
  /**
   * @declaredat ASTNode:37
   */
  public List<T> addChild(T node) {
    super.addChild(node);
    return this;
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:43
   */
  public void removeChild(int i) {
    super.removeChild(i);
  }
  /**
   * @declaredat ASTNode:47
   */
  public int getNumChild() {
    return getNumChildNoTransform();
  }
  /** @return an iterator to iterate over elements in this list node. 
   * @declaredat ASTNode:52
   */
  @Override
  public java.util.Iterator<T> iterator() {
    return astChildIterator();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:57
   */
  public void flushAttrCache() {
    super.flushAttrCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:62
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:67
   */
  public List<T> clone() throws CloneNotSupportedException {
    List node = (List) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:72
   */
  public List<T> copy() {
    try {
      List node = (List) clone();
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
   * @declaredat ASTNode:91
   */
  @Deprecated
  public List<T> fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:101
   */
  public List<T> treeCopyNoTransform() {
    List tree = (List) copy();
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
   * @declaredat ASTNode:121
   */
  public List<T> treeCopy() {
    List tree = (List) copy();
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

}
