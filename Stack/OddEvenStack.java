//620710124 พงศกร มีนุช

import java.util.Random;

class Node{
    private Object info = null;
    private Node link = null;

    public Node(Object info,Node link){
        this.info = info;
        this.link = link;
    }

    public Node(Object info){
        this(info,null);
    }

    public Node(){
        this(null,null);
    }

    public void setInfo(Object info){
        this.info = info;
    }

    public void setLink(Node link){
        this.link = link;
    }

    public Object getInfo(){
        return info;
    }

    public Node getLink(){
        return link;
    }
}

class Stack{
    private int stackSize =0;
    private Node stackTop = null;

    public Stack(){
        stackTop = null;
    }

    public void initilizeStack(){
        stackTop = null;
    }

    public boolean isEmptyStack(){
        return (stackTop==null);
    }

    public void push(Object newItem){
        Node newNode = new Node(newItem);
        newNode.setLink(stackTop);
        stackTop = newNode;
        stackSize++;
    }

    public Object pop() throws Exception{
        Object itemInfo;
        if(isEmptyStack())
            throw new Exception("StackUnderflow");
        itemInfo = stackTop.getLink();
        stackTop = stackTop.getLink();
        stackSize--;
        return itemInfo;
    }

    public Object peek() throws Exception{
        if(isEmptyStack())
            throw new Exception("StackUnderflow");
        return stackTop.getInfo();
    }

    public int getSize(){
        return stackSize;
    }

    public void print(){
        Node trav = stackTop;
        while(trav!=null){
            System.out.print(trav.getInfo()+" ");
            trav = trav.getLink();
        }
        if(trav == null)
            System.out.println();
    }
}

public class OddEvenStack {
    public static void main(String[] args) {
        Random rand = new Random();
        int n = rand.nextInt(20-10)+10;
        Stack eStack = new Stack();
        Stack oStack = new Stack();
        System.out.println("--- Random Numbers ["+n+"] ---");
        for(int i=0;i<n;++i){
            int x = rand.nextInt(100)+1;
            System.out.print(x+" ");
            if(x%2==0){
                eStack.push(x);
            }else{
                oStack.push(x);
            }
        }
        try{
            System.out.println("\n--- Even Stack ["+eStack.getSize()+"] ---");
            eStack.print();
            System.out.println("--- Odd Stack ["+oStack.getSize()+"] ---");
            oStack.print();
        }catch (Exception e){
            System.err.println(e);
        }

        Stack newEStack = new Stack();
        Stack newOStack = new Stack();
        while(eStack.getSize()!=0){
            try{
               newEStack.push(eStack.peek());
               eStack.pop();
            }catch (Exception e){
                System.err.println(e);
            }
        }
        while(oStack.getSize()!=0){
            try{
               newOStack.push(oStack.peek());
               oStack.pop();
            }catch (Exception e){
                System.err.println(e);
            }
        }

        while(!newEStack.isEmptyStack() && !newOStack.isEmptyStack()){
           
            try{
                int eS = (Integer)newEStack.peek();
                int oS = (Integer)newOStack.peek();
                if(eS > oS)
                    newEStack.pop();
                else
                    newOStack.pop();

           }catch (Exception e){
                System.err.println(e);
            }
        }
        if(newEStack.isEmptyStack())
            System.out.println("===> Even is the winner!");
        else
            System.out.println("===> Odd is the winner!");
    }
}
