package ast;
import java.util.*;

public class ClassNode extends ASTNode {
    public String name;
    public List<StatementNode> statements = new ArrayList<>();

    public ClassNode(String name) {
        this.name = name;
    }

    public void addStatement(StatementNode s) {
        statements.add(s);
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "Class: " + name);
        for (StatementNode s : statements) {
            s.print(indent + "  ");
        }
    }
}
