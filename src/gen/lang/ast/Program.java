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
 * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/lang.ast:1
 * @astdecl Program : ASTNode ::= FunctionDecl*;
 * @production Program : {@link ASTNode} ::= <span class="component">{@link FunctionDecl}*</span>;

 */
public class Program extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect Visitor
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Visitor.jrag:48
   */
  public Object accept(Visitor visitor, Object data) {
        return visitor.visit(this, data);
    }
  /**
   * @aspect CodeGen
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:2
   */
  public void genCode(PrintStream out) {
        out.println(".global _start");
        out.println(".data");
        // etc.
        out.println("buf: .skip 1024");
        out.println();
        out.println(".text");
        out.println("_start:");

         // Allocate space for local variables (bindings):
        // out.println("        pushq %rbp");
        // out.println("        movq %rsp, %rbp");
        //out.println("        subq $" + (getFunctionDeclList().numLocals()*8) + ", %rsp");

        // Print result:

        //out.println("        call main");
        
        // De-allocate local variables:
        // out.println("        movq %rbp, %rsp");
        // out.println("        popq %rbp");

        // Call sys_exit:
        out.println("        call main");
        out.println("        movq $0, %rdi");
        out.println("        movq $60, %rax");
        out.println("        syscall"); // Done!

        for (FunctionDecl decl: getFunctionDeclList()) {
            decl.genCode(out);
        }
                
        // call main function
        // call sys_exit
        // helper procedures (print/read)
        out.println("# Procedure to print number to stdout.");
        out.println("# C signature: void print(long int)");
        out.println("print:");
        out.println("        pushq %rbp");
        out.println("        movq %rsp, %rbp");
        out.println("        ### Convert integer to string (itoa).");
        out.println("        movq 16(%rbp), %rax");
        out.println("        leaq buf(%rip), %rsi    # RSI = write pointer (starts at end of buffer)");
        out.println("        addq $1023, %rsi");
        out.println("        movb $0x0A, (%rsi)      # insert newline");
        out.println("        movq $1, %rcx           # RCX = string length");
        out.println("        cmpq $0, %rax");
        out.println("        jge itoa_loop");
        out.println("        negq %rax               # negate to make RAX positive");
        out.println("itoa_loop:                      # do.. while (at least one iteration)");
        out.println("        movq $10, %rdi");
        out.println("        cqo                     # sign extend RAX to RDX to prepare for idiv");
        out.println("        idivq %rdi              # divide RDX:RAX by 10");
        out.println("        addb $0x30, %dl         # remainder + '0'");
        out.println("        decq %rsi               # move string pointer");
        out.println("        movb %dl, (%rsi)");
        out.println("        incq %rcx               # increment string length");
        out.println("        cmpq $0, %rax");
        out.println("        jg itoa_loop            # produce more digits");
        out.println("itoa_done:");
        out.println("        movq 16(%rbp), %rax");
        out.println("        cmpq $0, %rax");
        out.println("        jge print_end");
        out.println("        decq %rsi");
        out.println("        incq %rcx");
        out.println("        movb $0x2D, (%rsi)");
        out.println("print_end:");
        out.println("        movq $1, %rdi");
        out.println("        movq %rcx, %rdx");
        out.println("        movq $1, %rax");
        out.println("        syscall");
        out.println("        popq %rbp");
        out.println("        ret");
        out.println("");

        out.println("# Procedure to read number from stdin.");
        out.println("# C signature: long long int read(void)");
        out.println("read:");
        out.println("        pushq %rbp");
        out.println("        movq %rsp, %rbp");
        out.println("        ### R9  = sign");
        out.println("        movq $1, %r9            # sign <- 1");
        out.println("        ### R10 = sum");
        out.println("        movq $0, %r10           # sum <- 0");
        out.println("skip_ws: # skip any leading whitespace");
        out.println("        movq $0, %rdi");
        out.println("        leaq buf(%rip), %rsi");
        out.println("        movq $1, %rdx");
        out.println("        movq $0, %rax");
        out.println("        syscall                 # get one char: sys_read(0, buf, 1)");
        out.println("        cmpq $0, %rax");
        out.println("        jle atoi_done           # nchar <= 0");
        out.println("        movb (%rsi), %cl        # c <- current char");
        out.println("        cmp $32, %cl");
        out.println("        je skip_ws              # c == space");
        out.println("        cmp $13, %cl");
        out.println("        je skip_ws              # c == CR");
        out.println("        cmp $10, %cl");
        out.println("        je skip_ws              # c == NL");
        out.println("        cmp $9, %cl");
        out.println("        je skip_ws              # c == tab");
        out.println("        cmp $45, %cl            # check if negative");
        out.println("        jne atoi_loop");
        out.println("        movq $-1, %r9           # sign <- -1");
        out.println("        movq $0, %rdi");
        out.println("        leaq buf(%rip), %rsi");
        out.println("        movq $1, %rdx");
        out.println("        movq $0, %rax");
        out.println("        syscall                 # get one char: sys_read(0, buf, 1)");
        out.println("atoi_loop:");
        out.println("        cmpq $0, %rax           # while (nchar > 0)");
        out.println("        jle atoi_done           # leave loop if nchar <= 0");
        out.println("        movzbq (%rsi), %rcx     # move byte, zero extend to quad-word");
        out.println("        cmpq $0x30, %rcx        # test if < '0'");
        out.println("        jl atoi_done            # character is not numeric");
        out.println("        cmpq $0x39, %rcx        # test if > '9'");
        out.println("        jg atoi_done            # character is not numeric");
        out.println("        imulq $10, %r10         # multiply sum by 10");
        out.println("        subq $0x30, %rcx        # value of character");
        out.println("        addq %rcx, %r10         # add to sum");
        out.println("        movq $0, %rdi");
        out.println("        leaq buf(%rip), %rsi");
        out.println("        movq $1, %rdx");
        out.println("        movq $0, %rax");
        out.println("        syscall                 # get one char: sys_read(0, buf, 1)");
        out.println("        jmp atoi_loop           # loop back");
        out.println("atoi_done:");
        out.println("        imulq %r9, %r10         # sum *= sign");
        out.println("        movq %r10, %rax         # put result value in RAX");
        out.println("        popq %rbp");
        out.println("        ret");
        out.println();
        out.println("print_string:");
        out.println("        pushq %rbp");
        out.println("        movq %rsp, %rbp");
        out.println("        movq $1, %rdi");
        out.println("        movq 16(%rbp), %rsi");
        out.println("        movq 24(%rbp), %rdx");
        out.println("        movq $1, %rax");
        out.println("        syscall");
        out.println("        popq %rbp");
        out.println("        ret");
    
    }
  /**
   * @aspect Interpreter
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Interpreter.jrag:7
   */
  public void eval(){
        boolean hasMainFunc = false;

        ActivationRecord actrec = new ActivationRecord();
        for(int i = 0; i < getNumFunctionDecl(); i++){
            if(getFunctionDecl(i).getLeft().getID().equals("main")) {
                hasMainFunc = true;
                actrec.setValue(getFunctionDecl(i).getLeft().getID(), getFunctionDecl(i).eval(actrec));
            }
        }
        if(!hasMainFunc){
            throw new RuntimeException("");
        }
    }
  /**
   * @declaredat ASTNode:1
   */
  public Program() {
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
    setChild(new List(), 0);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"FunctionDecl"},
    type = {"List<FunctionDecl>"},
    kind = {"List"}
  )
  public Program(List<FunctionDecl> p0) {
    setChild(p0, 0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:23
   */
  protected int numChildren() {
    return 1;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:27
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    stmtIndex_reset();
    unknownDecl_reset();
    intType_reset();
    boolType_reset();
    unknownType_reset();
    pred_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:37
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
    Program_errors_visited = false;
    Program_errors_computed = false;
    
    Program_errors_value = null;
    contributorMap_Program_errors = null;
    contributorMap_FunctionDecl_functionCalls = null;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:47
   */
  public Program clone() throws CloneNotSupportedException {
    Program node = (Program) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:52
   */
  public Program copy() {
    try {
      Program node = (Program) clone();
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
  public Program fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:81
   */
  public Program treeCopyNoTransform() {
    Program tree = (Program) copy();
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
  public Program treeCopy() {
    Program tree = (Program) copy();
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
   * Replaces the FunctionDecl list.
   * @param list The new list node to be used as the FunctionDecl list.
   * @apilevel high-level
   */
  public Program setFunctionDeclList(List<FunctionDecl> list) {
    setChild(list, 0);
    return this;
  }
  /**
   * Retrieves the number of children in the FunctionDecl list.
   * @return Number of children in the FunctionDecl list.
   * @apilevel high-level
   */
  public int getNumFunctionDecl() {
    return getFunctionDeclList().getNumChild();
  }
  /**
   * Retrieves the number of children in the FunctionDecl list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the FunctionDecl list.
   * @apilevel low-level
   */
  public int getNumFunctionDeclNoTransform() {
    return getFunctionDeclListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the FunctionDecl list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the FunctionDecl list.
   * @apilevel high-level
   */
  public FunctionDecl getFunctionDecl(int i) {
    return (FunctionDecl) getFunctionDeclList().getChild(i);
  }
  /**
   * Check whether the FunctionDecl list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasFunctionDecl() {
    return getFunctionDeclList().getNumChild() != 0;
  }
  /**
   * Append an element to the FunctionDecl list.
   * @param node The element to append to the FunctionDecl list.
   * @apilevel high-level
   */
  public Program addFunctionDecl(FunctionDecl node) {
    List<FunctionDecl> list = (parent == null) ? getFunctionDeclListNoTransform() : getFunctionDeclList();
    list.addChild(node);
    return this;
  }
  /** @apilevel low-level 
   */
  public Program addFunctionDeclNoTransform(FunctionDecl node) {
    List<FunctionDecl> list = getFunctionDeclListNoTransform();
    list.addChild(node);
    return this;
  }
  /**
   * Replaces the FunctionDecl list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public Program setFunctionDecl(FunctionDecl node, int i) {
    List<FunctionDecl> list = getFunctionDeclList();
    list.setChild(node, i);
    return this;
  }
  /**
   * Retrieves the FunctionDecl list.
   * @return The node representing the FunctionDecl list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="FunctionDecl")
  public List<FunctionDecl> getFunctionDeclList() {
    List<FunctionDecl> list = (List<FunctionDecl>) getChild(0);
    return list;
  }
  /**
   * Retrieves the FunctionDecl list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the FunctionDecl list.
   * @apilevel low-level
   */
  public List<FunctionDecl> getFunctionDeclListNoTransform() {
    return (List<FunctionDecl>) getChildNoTransform(0);
  }
  /**
   * @return the element at index {@code i} in the FunctionDecl list without
   * triggering rewrites.
   */
  public FunctionDecl getFunctionDeclNoTransform(int i) {
    return (FunctionDecl) getFunctionDeclListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the FunctionDecl list.
   * @return The node representing the FunctionDecl list.
   * @apilevel high-level
   */
  public List<FunctionDecl> getFunctionDecls() {
    return getFunctionDeclList();
  }
  /**
   * Retrieves the FunctionDecl list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the FunctionDecl list.
   * @apilevel low-level
   */
  public List<FunctionDecl> getFunctionDeclsNoTransform() {
    return getFunctionDeclListNoTransform();
  }
  /**
   * @aspect <NoAspect>
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Error.jrag:26
   */
  /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_Program_errors = null;

  /** @apilevel internal */
  protected void survey_Program_errors() {
    if (contributorMap_Program_errors == null) {
      contributorMap_Program_errors = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
      collect_contributors_Program_errors(this, contributorMap_Program_errors);
    }
  }

  /**
   * @aspect <NoAspect>
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/functionCall.jrag:5
   */
  /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FunctionDecl_functionCalls = null;

  /** @apilevel internal */
  protected void survey_FunctionDecl_functionCalls() {
    if (contributorMap_FunctionDecl_functionCalls == null) {
      contributorMap_FunctionDecl_functionCalls = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
      collect_contributors_FunctionDecl_functionCalls(this, contributorMap_FunctionDecl_functionCalls);
    }
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
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/CodeGen.jrag:405
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
    stmtIndex_value = 1;
    stmtIndex_computed = true;
    state().leaveLazyAttribute();
    stmtIndex_visited = false;
    return stmtIndex_value;
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
   * @attribute syn
   * @aspect UnknownDecl
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/UnknownDecl.jrag:2
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="UnknownDecl", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/UnknownDecl.jrag:2")
  public UnknownDecl unknownDecl() {
    ASTState state = state();
    if (unknownDecl_computed) {
      return unknownDecl_value;
    }
    if (unknownDecl_visited) {
      throw new RuntimeException("Circular definition of attribute Program.unknownDecl().");
    }
    unknownDecl_visited = true;
    state().enterLazyAttribute();
    unknownDecl_value = new UnknownDecl("<unknown>");
    unknownDecl_value.setParent(this);
    unknownDecl_computed = true;
    state().leaveLazyAttribute();
    unknownDecl_visited = false;
    return unknownDecl_value;
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
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:56
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:56")
  public IntType intType() {
    ASTState state = state();
    if (intType_computed) {
      return intType_value;
    }
    if (intType_visited) {
      throw new RuntimeException("Circular definition of attribute Program.intType().");
    }
    intType_visited = true;
    state().enterLazyAttribute();
    intType_value = new IntType();
    intType_value.setParent(this);
    intType_computed = true;
    state().leaveLazyAttribute();
    intType_visited = false;
    return intType_value;
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
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:60
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:60")
  public BoolType boolType() {
    ASTState state = state();
    if (boolType_computed) {
      return boolType_value;
    }
    if (boolType_visited) {
      throw new RuntimeException("Circular definition of attribute Program.boolType().");
    }
    boolType_visited = true;
    state().enterLazyAttribute();
    boolType_value = new BoolType();
    boolType_value.setParent(this);
    boolType_computed = true;
    state().leaveLazyAttribute();
    boolType_visited = false;
    return boolType_value;
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
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:64
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:64")
  public UnknownType unknownType() {
    ASTState state = state();
    if (unknownType_computed) {
      return unknownType_value;
    }
    if (unknownType_visited) {
      throw new RuntimeException("Circular definition of attribute Program.unknownType().");
    }
    unknownType_visited = true;
    state().enterLazyAttribute();
    unknownType_value = new UnknownType();
    unknownType_value.setParent(this);
    unknownType_computed = true;
    state().leaveLazyAttribute();
    unknownType_visited = false;
    return unknownType_value;
  }
/** @apilevel internal */
protected boolean pred_visited = false;
  /** @apilevel internal */
  private void pred_reset() {
    pred_computed = false;
    
    pred_value = null;
    pred_visited = false;
  }
  /** @apilevel internal */
  protected boolean pred_computed = false;

  /** @apilevel internal */
  protected List<FunctionDecl> pred_value;

  /**
   * @attribute syn
   * @aspect NameAnalysis
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/NameAnalysis.jrag:37
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/NameAnalysis.jrag:37")
  public List<FunctionDecl> pred() {
    ASTState state = state();
    if (pred_computed) {
      return pred_value;
    }
    if (pred_visited) {
      throw new RuntimeException("Circular definition of attribute Program.pred().");
    }
    pred_visited = true;
    state().enterLazyAttribute();
    pred_value = pred_compute();
    pred_value.setParent(this);
    pred_computed = true;
    state().leaveLazyAttribute();
    pred_visited = false;
    return pred_value;
  }
  /** @apilevel internal */
  private List<FunctionDecl> pred_compute() {
          List<FunctionDecl> list = new List<FunctionDecl>();
          list.add(new FunctionDecl(new IdDecl("print"), new List().add(new IdDecl("var")), new Block(new List())));
          list.add(new FunctionDecl(new IdDecl("read"), new List(), new Block(new List())));
          return list;
      }
  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/UnknownDecl.jrag:4
   * @apilevel internal
   */
  public UnknownDecl Define_unknownDecl(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return unknownDecl();
  }
  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/UnknownDecl.jrag:4
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute unknownDecl
   */
  protected boolean canDefine_unknownDecl(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Error.jrag:28
   * @apilevel internal
   */
  public Program Define_program(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return this;
  }
  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Error.jrag:28
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute program
   */
  protected boolean canDefine_program(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/CircularDefinitions.jrag:4
   * @apilevel internal
   */
  public boolean Define_inExprOf(ASTNode _callerNode, ASTNode _childNode, IdDecl decl) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return false;
  }
  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/CircularDefinitions.jrag:4
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute inExprOf
   */
  protected boolean canDefine_inExprOf(ASTNode _callerNode, ASTNode _childNode, IdDecl decl) {
    return true;
  }
  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:57
   * @apilevel internal
   */
  public IntType Define_intType(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return intType();
  }
  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:57
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute intType
   */
  protected boolean canDefine_intType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:61
   * @apilevel internal
   */
  public BoolType Define_boolType(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return boolType();
  }
  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:61
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute boolType
   */
  protected boolean canDefine_boolType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:65
   * @apilevel internal
   */
  public UnknownType Define_unknownType(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return unknownType();
  }
  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/TypeAnalysis.jrag:65
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute unknownType
   */
  protected boolean canDefine_unknownType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/NameAnalysis.jrag:22
   * @apilevel internal
   */
  public boolean Define_functionLookup(ASTNode _callerNode, ASTNode _childNode, String name, List list) {
    if (_callerNode == getFunctionDeclListNoTransform()) {
      // @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/NameAnalysis.jrag:6
      int index = _callerNode.getIndexOfChild(_childNode);
      {
              for(int i = 0; i < getNumFunctionDecl(); i++){
                  if(getFunctionDecl(i).getLeft().getID().equals(name)){
                      return getFunctionDecl(i).getRightList().getNumChild() == list.getNumChild();
                  }
              }
      
              for(FunctionDecl func: pred()){
                  if(func.getLeft().getID().equals(name)){
                      return func.getRightList().getNumChild() == list.getNumChild();
                  }
              }
              return false;
          }
    }
    else {
      return getParent().Define_functionLookup(this, _callerNode, name, list);
    }
  }
  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/NameAnalysis.jrag:22
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute functionLookup
   */
  protected boolean canDefine_functionLookup(ASTNode _callerNode, ASTNode _childNode, String name, List list) {
    return true;
  }
  /**
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/NameAnalysis.jrag:85
   * @apilevel internal
   */
  public IdDecl Define_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    if (_callerNode == getFunctionDeclListNoTransform()) {
      // @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/NameAnalysis.jrag:44
      int index = _callerNode.getIndexOfChild(_childNode);
      {
              for(FunctionDecl fd : getFunctionDecls()) {
                  if(fd.getLeft().getID().equals(name)){
                      return fd.getLeft();
                  }
              }
             
              for(FunctionDecl func: pred()){
                  if(func.getLeft().getID().equals(name)){
                      return func.getLeft();
                  }
                  
              }
              return unknownDecl();
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
protected boolean Program_errors_visited = false;
  /**
   * @attribute coll
   * @aspect Errors
   * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Error.jrag:26
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
  @ASTNodeAnnotation.Source(aspect="Errors", declaredAt="/Users/adriansteene/dev/mini-c-compiler/src/jastadd/Error.jrag:26")
  public Set<ErrorMessage> errors() {
    ASTState state = state();
    if (Program_errors_computed) {
      return Program_errors_value;
    }
    if (Program_errors_visited) {
      throw new RuntimeException("Circular definition of attribute Program.errors().");
    }
    Program_errors_visited = true;
    state().enterLazyAttribute();
    Program_errors_value = errors_compute();
    Program_errors_computed = true;
    state().leaveLazyAttribute();
    Program_errors_visited = false;
    return Program_errors_value;
  }
  /** @apilevel internal */
  private Set<ErrorMessage> errors_compute() {
    ASTNode node = this;
    while (node != null && !(node instanceof Program)) {
      node = node.getParent();
    }
    Program root = (Program) node;
    root.survey_Program_errors();
    Set<ErrorMessage> _computedValue = new TreeSet<ErrorMessage>();
    if (root.contributorMap_Program_errors.containsKey(this)) {
      for (ASTNode contributor : (java.util.Set<ASTNode>) root.contributorMap_Program_errors.get(this)) {
        contributor.contributeTo_Program_errors(_computedValue);
      }
    }
    return _computedValue;
  }
  /** @apilevel internal */
  protected boolean Program_errors_computed = false;

  /** @apilevel internal */
  protected Set<ErrorMessage> Program_errors_value;


}
