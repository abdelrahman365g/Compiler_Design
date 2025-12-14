package ast;
public class AssignmentNode extends StatementNode {
    public String name;
    public int value;

    public AssignmentNode(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "Assign: " + name + " = " + value);
    }
}
