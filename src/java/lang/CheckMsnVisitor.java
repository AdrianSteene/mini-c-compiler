package lang;

import lang.ast.*;

public class CheckMsnVisitor extends TraversingVisitor {

    public static int result(ASTNode n) {
        CheckMsnVisitor v = new CheckMsnVisitor();
        n.accept(v, null);
        return v.maxMsn;
    }

    private static int maxMsn = 0;
    private static int currentMsn = 0;

    @Override
    public Object visit(Block node, Object data) {
        currentMsn++;
        maxMsn = currentMsn > maxMsn ? currentMsn : maxMsn;
        visitChildren(node, data);
        currentMsn -= 1;
        return data;
    }

}
