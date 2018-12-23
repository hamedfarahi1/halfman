package huffman;

class Node {
    String  data;
    int count;
    int count1;
    Node left;
    Node right;
    Node parent;
    String code;
    Node(String data, int count, int count1, Node left, Node right, Node parent, String code)
    {
        this.data=data;
        this.count=count;
        this.count1=count1;
        this.count1=count;
        this.left=left;
        this.right=right;
        this.parent=parent;
        this.code=code;
    }
    Node()
    {
        this.count=0;
        this.count1=0;
        this.code=null;
        this.parent=null;
        this.data=null;
        this.right=null;
        this.left=null;
    }
}
