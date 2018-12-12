package halfman;

public class queueMin {
    public int front = -1;
    private int rear, maxTemp;
    int max=1,Max;
    public Node[] elements = new Node[127];

    public void enQueue(Node element) {
        int k=0;
        while (elements[k] != null)
            k++;

        elements[k] = element;
        k=0;
        while (k<127){
            if (elements[k++]!=null)
                front++;
        }
    }

    public Node dequeue()
    {
        int i=0;
        while (elements[i].count!=0){
            i++;
        }
        return elements[i];
    }
    public Node deQueue() {

        for (int i=0;i<127; i++) {
            if (elements[i]!=null) {
                if (elements[i].count > max) {
                    max = elements[i].count;
                }
            }
        }
        int coun = 0;
        maxTemp = max;
        for (int i = 0; i < 127; i++) {
            if (elements[i]!=null) {
                if (elements[i].count != 0) {
                    if (maxTemp >= elements[i].count && elements[i].count != 0) {
                        maxTemp = elements[i].count;
                        coun = i;

                    }
                }
            }
            }
            if (elements[coun] == null)
                return null;
            Node Return=elements[coun];
            elements[coun] = null;
            front--;
            return Return;
    }
//    public Node dequeueShow(int max){
//        int coun = 0;
//        maxTemp = max;
//        for (int i = 0; i < front; i++) {
//            if (elements[i].count != 0) {
//                if (maxTemp >= elements[i].count && elements[i].count != 0) {
//                    maxTemp = elements[i].count;
//                    coun = i;
//
//                }
//            }
//        }
//        Node Return=new Node(elements[coun].data,elements[coun].count,null,null,null,null);
//        return Return;
//    }

}