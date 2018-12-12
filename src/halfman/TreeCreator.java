package halfman;


import javax.management.StringValueExp;

public class TreeCreator extends FileWR {
    private int[] gereh = new int[2];
    public Node root;
    public Node[] adress = new Node[1000];
    public String[] output = new String[127];
    private queueMin queueMin = new queueMin();
    public void fillQueue(){

        for (int i=0;i<127;i++){
            if (counter[i] !=0)
            {
                Node element = new Node(i,counter[i],null,null,null,null);
                queueMin.enQueue(element);
            }
        }
    }
    public void Creator() {
        fillQueue();
        Node nodep;
        while (true ){
            Node nodeL=queueMin.deQueue();
            Node nodeR=queueMin.deQueue();
            if (nodeR == null) {
                queueMin.enQueue(nodeL);
                break;
            }
            nodep=new Node(nodeL.data+nodeR.data,nodeL.count+nodeR.count,nodeL,nodeR,null,null);
            nodeL.parent=nodep;
            nodeR.parent=nodep;
            nodeL.code="0";
            nodeR.code="1";

            System.out.println(nodep.left.count+"    "+nodep.right.count);
            System.out.println(nodep.count);
            if (nodep.count != 0) {
                root = nodep;
               queueMin.enQueue(root);
            }
        }
        for (int i=0;i<127;i++)
        {
            if (queueMin.elements[i] != null)
                if (queueMin.elements[i].count !=0)
                    show(queueMin.elements[i]);
        }



        //System.out.println(root.count);
        //show(root);
/*
        public void waze () {
            String st = "";
            for (int i = 0; i <= 127; i++) {
                if (adress[i] == null) break;
                Node t = adress[i];
                //System.out.println(adress[i]);
                try {
                    while (t != null) {
                        st = st + t.code;
                        t = t.parent;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                int f = Integer.parseInt(adress[i].data);
                output[f] = st;
                st = "";
            }
        }*/
    }
            public void show (Node T) {
                if (T.left == null && T.right != null)
                    return;
                else {
                    System.out.println(T.count);
                    show(T.left);
                    show(T.right);
                }
        }
    }
