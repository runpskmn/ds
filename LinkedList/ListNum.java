//620710124 พงศกร มีนุช
import java.util.Scanner;


class Node {
    private int info;
    private Node link;
    public Node(int info,Node link)
   {
       this.info=info;
       this.link=link;
    }
    public Node(int info)
    {
        this(info,null);
    }
    public Node()
    {
        this(0,null);
    }
    public int getInfo() {
	return this.info;
    }
    public Node getLink() {
        return link;
    }
    public void setInfo(int info) 
    {
	this.info=info;
    }
    public void setLink(Node link) {
        this.link = link;
    }
    public String toString() {
	return ""+this.info;
    }
}

public class ListNum {

    private Node head = null;
    private int size =0;
    public ListNum(){
        
    } 
    
    public void delHeadNode(){
        Node delNode = head;
        if(head!=null)
            head=head.getLink();
        size--;
    }
    
    public void delTailNode(){
        Node trav1 , trav2;
        trav1 = trav2 = head;
        while(trav1!=null && trav1.getLink()!=null){
            trav2 = trav1;
            trav1 = trav1.getLink();
        }
         Node delNode = trav1;
         if(trav2 != null){
            trav2.setLink(null);
             if(delNode == head.getLink())
                 head = null;
         }
         size--;
    }
    
    public void delInfoNode(int Info){
        Node trav1,trav2;
        trav1 = trav2 = head;
        while(trav1 != null ){
            if(trav1.getInfo() == Info){
                Node delNode = trav1;
                if(trav1 != head)
                    trav2.setLink(trav1.getLink());
                else
                    head = trav1.getLink();
            }else
                    trav2 = trav1;
                trav1 = trav1.getLink();
        }
       size--;
    }
    
    public void addStoreNode(int newInfo){
        Node trav1 , trav2;
        trav1 = trav2 = head;
        Node newNode = new Node(newInfo);
        while(trav1 != null && (trav1.getInfo() < newNode.getInfo())){
            trav2 = trav1;
            trav1 = trav1.getLink();
        }
        newNode.setLink(trav1);
        if(trav1!=trav2){
            trav2.setLink(newNode);
        }else
            head = newNode;
        size++;
    }
    public void addTailNode(int newInfo){
        Node trav1 , trav2;
        trav1 = trav2 = head;
        Node newNode = new Node(newInfo);
        while(trav1 != null){
            trav2 = trav1;
            trav1 = trav1.getLink();
        }
        if(trav1 != trav2)
            trav2.setLink(newNode);
        else
            head = newNode;
        size++;
    }
    public void addNode(int newInfo) {
    	Node newNode = new Node(newInfo);
            newNode.setLink(head);
            head = newNode;
            size++;
    }
    
    public void searchInfo(int info){
        Node trav = head;
        int id =1;
        for(id=1;trav != null && trav.getInfo() != info;id++){
            trav = trav.getLink();
        }
        if(trav != null)
            System.out.println(id);
        else    
            System.out.println("not found!");
    }
    
    public int getSize(){
        return size;
    }
    
    public String toString() {
        Node trav=head;
	String str="";
	while (trav!=null) {			
		str=str.concat(trav.toString());
		//str=str.concat(""+trav.getInfo());
                trav=trav.getLink();
		if(trav!=null)
                    str=str.concat(" | ");		
	}
	return str;
    }
    
    public static void main(String[] args) {
        ListNum listNum1=new ListNum();
        Scanner sc = new Scanner(System.in);
        listNum1.addNode(8);
        listNum1.addNode(5);
        listNum1.addNode(21);
        listNum1.addNode(2);
        String[] command = {"1 = Get size of Linked List","2 = Add node at the tail node","3 = Add node with stored info"
                 ,"4 = Delete node at the head","5 = Delete node at the tail","6 = Search info in Linked List","7 = Delete node by input info"
                ,"8 = Show info in linked list","0 = End of loop"};
        System.out.println("Command list :");
        for(int i=0;i<command.length;++i)
            System.out.println(command[i]);
        System.out.println("This is current info in linked list\n"+listNum1.toString());
        while(true){
            System.out.print("Enter your command : ");
            int com = sc.nextInt();
            if(com==0)
                break;
            switch (com) {
                case 1:
                    System.out.println("Size of linked list : "+ listNum1.getSize());
                    break;
                case 2:
                    System.out.print("Enter info to add : ");
                    listNum1.addTailNode(sc.nextInt());
                    System.out.println("This is current info in linked list\n"+listNum1.toString());
                    break;
                case 3:
                    System.out.print("Enter info to add : ");
                    listNum1.addStoreNode(sc.nextInt());
                    System.out.println("This is current info in linked list\n"+listNum1.toString());
                    break;
                case 4:
                    System.out.println("Delete success!");
                    listNum1.delHeadNode();
                    System.out.println("This is current info in linked list\n"+listNum1.toString());
                    break;
                case 5:
                    System.out.println("Delete success!");
                    listNum1.delTailNode();
                    System.out.println("This is current info in linked list\n"+listNum1.toString());
                    break;
                case 6:
                    System.out.print("Enter info to search : ");
                    listNum1.searchInfo(sc.nextInt());
                    break;
                case 7:
                    System.out.print("Enter info to delete : ");
                    listNum1.delInfoNode(sc.nextInt());
                    System.out.println("This is current info in linked list\n"+listNum1.toString());
                    
                    break;
                case 8:
                    System.out.println(listNum1.toString());
                    break;
                default:
                    System.out.println("Please enter with correct command!");
                    break;
            }
        }

    }    
}
