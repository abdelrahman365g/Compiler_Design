package ast;

public class VarDeclNode extends StatementNode {
    public String name;
    public Integer value;

    public VarDeclNode(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public void print(String indent) {
        if (value == null)
            System.out.println(indent + "VarDecl: int " + name);
        else
            System.out.println(indent + "VarDecl: int " + name + " = " + value);
    }
}
