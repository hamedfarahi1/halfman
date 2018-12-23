package huffman;

public class TreeCreator extends FileWR {
    private Node[] elements;
    private Node T;
    public static String[] strings = new String[127];
    private int front;
    private int Barg;
    private int max;
    private FileCreate n = new FileCreate();
    public TreeCreator() {
        elements = new Node[240];
        front = -1;
        Barg =0;
        max=1;
    }
    private void fillElements(){

        for (int i=0;i<127;i++){
            if (counter[i] !=0) {
                String s=Integer.toString(i);
                Node element = new Node(s ,counter[i],counter[i],null,null,null,null);
                enElement(element);
                Barg++;
            }
        }
    }
    public void treeCreator() {
        fillElements();
        while (elementsReport())
        {
            int fr = front + 1;
            elements[fr] = new Node();
            elements[fr].left=deElements();
            elements[fr].right=deElements();
            elements[fr].right.parent= elements[fr];
            elements[fr].left.parent= elements[fr];
            elements[fr].right.code="1";
            elements[fr].left.code="0";
            elements[fr].count1=elements[fr].left.count1 + elements[fr].right.count1;
            elements[fr].count=elements[fr].left.count1 + elements[fr].right.count1;
            elements[fr].data=elements[fr].left.data + elements[fr].right.data;
            front = fr;
        }
        for (int i = 0; i< Barg; i++) {
            T = elements[i];
            String str="";
            while (T.parent!=null)
            {
                str = T.code + str ;
                T = T.parent;
            }
            strings[Integer.parseInt(elements[i].data)]=str;
        }

    }
    private void enElement(Node element) {
        elements[++front]=element;
    }
    private boolean elementsReport() {
        int i=0,k=0;
        while (elements[i]!= null){
            if (elements[i].count!=0)
                k++;
            i++;
        }
        return k!=1;
    }
    private Node deElements() {
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
       // assert elements[coun] != null;
        elements[coun].count = 0;
        return elements[coun];
    }
    public void CreateFile(String path){
        n.setter(strings);
        n.Create(path);
    }
    public void Extract(){
        n.ExtractFile();
    }
}