//620710124 พงศกร มีนุช
/*import java.util.Scanner;


class Node {

    private int info;
    private Node link;
    
    Node(int info,Node link){
        setInfo(info);
        setLink(link);
    }
    
    Node(int info){
        this(info,null);
    }
    
    Node(){
        
    }
    
    public void setLink(Node link){
        this.link = link;
    }
    
    public int getInfo(){
        return info;
    }
    
    public Node getLink(){
        return link;
    }

    public void setInfo(int info) {
        this.info = info;
    }
}

public class BasicLinkedList {
    public static void main(String[] args) {
        Node head = new Node();
        Node current = head;
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<5;++i){
            int info = sc.nextInt();
            Node obj = new Node(info);
            current.setLink(obj);
            current = obj;
        }
        current = head;
        for(int i=0;i<5;++i){
            current = current.getLink();
            System.out.print(current.getInfo()+" ");
        }
    }
}
