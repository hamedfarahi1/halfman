package halfman;

public class Node {
    public int  data;
    public int count;
    public  Node left;
    public  Node right;
    public Node parent;
    public String code;
    public Node(int data,int count, Node left,Node right,Node parent,String code)
    {
        this.data=data;
        this.count=count;
        this.left=left;
        this.right=right;
        this.parent=parent;
        this.code=code;
    }
    public Node()
    {
        this.count=0;
        this.code=null;
        this.parent=null;
        this.data=0;
        this.right=null;
        this.left=null;
    }
}
