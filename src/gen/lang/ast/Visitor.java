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
 * Visitor interface for Calc language. Each concrete node type must
 * have a visit method.
 * @ast interface
 * @aspect Visitor
 * @declaredat /Users/adriansteene/dev/mini-c-compiler/src/jastadd/Visitor.jrag:6
 */
public interface Visitor {

         
        public Object visit(List node, Object data);

         
        public Object visit(Opt node, Object data);

         
        public Object visit(Program node, Object data);

         
        public Object visit(Block node, Object data);

         
        public Object visit(DeclareStmt node, Object data);

         
        public Object visit(AssignStmt node, Object data);

         
        public Object visit(WhileStmt node, Object data);

         
        public Object visit(IfStmt node, Object data);

         
        public Object visit(IfElseStmt node, Object data);

         
        public Object visit(ReturnStmt node, Object data);

         
        public Object visit(FunctionCallStmt node, Object data);

         
        public Object visit(Numeral node, Object data);

         
        public Object visit(IdUse node, Object data);

         
        public Object visit(FunctionCall node, Object data);

         
        public Object visit(FunctionDecl node, Object data);

         
        public Object visit(Equal node, Object data);

         
        public Object visit(NotEqual node, Object data);

         
        public Object visit(Less node, Object data);

         
        public Object visit(Greater node, Object data);

         
        public Object visit(LessOrEqual node, Object data);

         
        public Object visit(GreaterOrEqual node, Object data);

         
        public Object visit(Sub node, Object data);

         
        public Object visit(Add node, Object data);

         
        public Object visit(Mul node, Object data);

         
        public Object visit(Div node, Object data);

         
        public Object visit(Mod node, Object data);

         
        public Object visit(IdDecl node, Object data);
}
