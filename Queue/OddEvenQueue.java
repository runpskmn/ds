//620710124 พงศกร มีนุช

import java.util.Random;
import java.util.Scanner;
class Node {
    private Object info = null;
    private Node link = null;

    public Node(Object info, Node link) {
        this.info = info;
        this.link = link;
    }

    public Node(Object info) {
        this(info, null);
    }

    public Node() {
        this(null, null);
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public void setLink(Node link) {
        this.link = link;
    }

    public Object getInfo() {
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

    public Object front() throws Exception {
        if (isEmptyQueue())
            throw new Exception("QueueUnderflow");
        return queueFront.getInfo();
    }

    public Object back() throws Exception {
        if (isEmptyQueue())
            throw new Exception("QueueUnderflow");
        return queueRear.getInfo();
    }

    public void enQueue(Object newItem) {
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

    public Object deQueue() throws Exception {
        Object itemInfo;
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

public class OddEvenQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        Queue eQ = new Queue();
        Queue oQ = new Queue();
        int round = 0,eWin = 0,oWin = 0;
        int n = sc.nextInt();
        System.out.println("=== Random numbers ["+n+"] ===");
        for(int i=0;i<n;++i){
            int x = rand.nextInt(100);
            System.out.print(x+" ");
            if(x%2==0)
                eQ.enQueue(x);
            else
                oQ.enQueue(x);
        }
        System.out.println("\n=== Even Queue ["+eQ.getSize()+"] ===");
        eQ.print();
        System.out.println("=== Odd Queue ["+oQ.getSize()+"] ===");
        oQ.print();
        int eSize = eQ.getSize();
        int oSize = oQ.getSize();
        while(!eQ.isEmptyQueue() && !oQ.isEmptyQueue() && eWin != eSize && oWin != oSize){
            try{
                round++;
                int intEQ = (Integer)eQ.front();
                int intOQ = (Integer)oQ.front();
                int info;
                if(intEQ > intOQ){
                    eQ.deQueue();
                    info = (Integer)oQ.deQueue();
                    oQ.enQueue(info);
                    eWin++;
                }else{
                    oQ.deQueue();
                    info = (Integer)eQ.deQueue();
                    eQ.enQueue(info);
                    oWin++;
                }
            }catch(Exception e){
                System.err.println(e);
            }
        }
        if(eQ.isEmptyQueue())
            System.out.println("===> Winner is Even");
        else
            System.out.println("===> Winner is Odd");
        System.out.print("Round=" + round +", Win=(E:"+ eWin +",O:"+ oWin+"), ");
        if(eQ.isEmptyQueue())
            System.out.println("Odd Left="+ oQ.getSize());
        else
            System.out.println("Even Left="+ eQ.getSize());
    }
}
