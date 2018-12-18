package halfman;

public class TreeCreator extends FileWR {
    private Node[] elements;
    public String[] strings = new String[127];
    private int front;
    private int barg;
    private int max;
    public TreeCreator()
    {
        elements = new Node[240];
        front = -1;
        barg=0;
        max=1;
    }
    public void fillElements(){

        for (int i=0;i<127;i++){
            if (counter[i] !=0) {
                String s=Integer.toString(i);
                Node element = new Node(s ,counter[i],counter[i],null,null,null,null);
                enElement(element);
                barg++;
            }
        }
    }
    public void treeCreator() {
        fillElements();
        while (elementsReport())
        {
            int fr = front + 1;
            elements[fr] = new Node();
            elements[fr].left=deQueue();
            elements[fr].right=deQueue();
            elements[fr].right.parent= elements[fr];
            elements[fr].left.parent= elements[fr];
            elements[fr].right.code="1";
            elements[fr].left.code="0";
            elements[fr].count1=elements[fr].left.count1 + elements[fr].right.count1;
            elements[fr].count=elements[fr].left.count1 + elements[fr].right.count1;
            elements[fr].data=elements[fr].left.data + elements[fr].right.data;
            front = fr;
        }
        for (int i=0;i<barg;i++) {
            Node T = elements[i];
            String str="";
            while (T.parent!=null)
            {
                str = str + T.code;
                T = T.parent;
            }
            strings[Integer.parseInt(elements[i].data)]=str;
        }
   }

    public void enElement(Node element) {
        elements[++front]=element;
    }

    public boolean elementsReport()
    {
        int i=0,k=0;
        while (elements[i]!= null){
            if (elements[i].count!=0)
                k++;
            i++;
        }
        return k!=1;
    }
    public Node deQueue() {
        int i=0,coun=0;
        while (elements[i]!=null){
                if (elements[i].count > max) {
                    max = elements[i].count;
                }
                i++;
        }
        i=0;
        while (elements[i] != null){
            if (elements[i].count > 0) {
                    if (max >= elements[i].count && elements[i].count != 0) {
                        max = elements[i].count;
                        coun = i;
                    }
                }
                i++;
        }
        elements[coun].count = 0;
        return elements[coun];
    }
}