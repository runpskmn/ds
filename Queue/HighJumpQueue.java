
import java.util.Random;

class Node {
    private int info = 0;
    private Node link = null;

    public Node(int info, Node link) {
        this.info = info;
        this.link = link;
    }

    public Node(int info) {
        this(info, null);
    }

    public Node() {
        this(0, null);
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public void setLink(Node link) {
        this.link = link;
    }

    public int getInfo() {
        return info;
    }

    public Node getLink() {
        return link;
    }
}

class Queue {
    private Node queueFront = null;
    private Node queueRear = null;
    private int count = 0;

    public void initializeQueue() {
        queueFront = null;
        queueRear = null;
        count = 0;
    }

    public boolean isEmptyQueue() {
        return (queueFront == null);
    }

    public boolean isFullQueue() {
        return false;
    }

    public int front() throws Exception {
        if (isEmptyQueue())
            throw new Exception("QueueUnderflow");
        return queueFront.getInfo();
    }

    public int back() throws Exception {
        if (isEmptyQueue())
            throw new Exception("QueueUnderflow");
        return queueRear.getInfo();
    }

    public void enQueue(int newItem) {
        Node newNode = new Node(newItem);
        if (queueFront == null) {
            queueFront = newNode;
            queueRear = newNode;
        } else {
            queueRear.setLink(newNode);
            queueRear = queueRear.getLink();
        }
        count++;
    }

    public int deQueue() throws Exception {
        int itemInfo;
        if (isEmptyQueue())
            throw new Exception("QueueUnderflow");
        itemInfo = queueFront.getInfo();
        queueFront = queueFront.getLink();
        if (queueFront == null)
            queueRear = null;
        count--;
        return itemInfo;
    }

    public int getSize() {
        return count;
    }
    
    public int getValue(){
        Node trav = queueFront;
        int value = 0;
        while(trav!=null){
            value+=trav.getInfo();
            trav = trav.getLink();
        }
        return value;
    }
    
    public void decreteFront(){
        queueFront.setInfo(queueFront.getInfo()-1);
    }

    public void print(){
        Node trav = queueFront;
        System.out.print("[ ");
        while(trav!=null){
            System.out.print(trav.getInfo()+" ");
            trav = trav.getLink();
        }
        System.out.println(" ]");
    }
}

public class HighJumpQueue {
    public static void main(String[] args) {
        Random  rand = new Random();
        Queue q = new Queue();
        for(int i=0;i<20;++i){
            double p = Math.random();
            int ip = (int)Math.round(p);
            if(ip==1){
                int use_time = rand.nextInt(3)+1;
                q.enQueue(use_time);
                System.out.println("He should jump in " + q.getValue()+" minute(s)");
            }
            if(q.isEmptyQueue())
                System.out.println("Queue is empty");
            else{
                if(q.getValue()==0)
                    q.deQueue();
                
            }
            q.print();
        }
    }
}
