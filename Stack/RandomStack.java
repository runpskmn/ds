//620710124 พงศกร มีนุช
import java.util.Random;

class Stack{
    private int stackTop =0;
    private int maxStackSize = 10;
    private Object[] list;
    public Stack(){
        list = new Object[maxStackSize];
    }

    boolean isEmptyStack(){
        return (stackTop==0);
    }

    boolean isFullStack(){
        return (stackTop==maxStackSize);
    }

    public void push(Object newItem) throws Exception{
        if(isFullStack())
            throw new Exception("StackOverflow");
        list[stackTop] = newItem;
        stackTop++;
    }

    public Object peek() throws Exception {
        if (isEmptyStack())
        throw new Exception("StackUnderflow");
        return list[stackTop - 1];
    }

    public Object pop() throws Exception {
        Object itemInfo;
        if (isEmptyStack())
        throw new Exception("StackUnderflow");
        stackTop--; //decrement stackTop
        itemInfo = list[stackTop];
        list[stackTop] = null;
        return itemInfo;
    }

    public int getSize() {
        return stackTop; // no. of current items
    }

    public int getMaxSize() {
        return maxStackSize; // max stack size
    }

    public void print(){
        for(int i=0;i<getSize();++i){
            System.out.print(list[i]+" ");
        }
        System.out.println();
    }
}
public class RandomStack {
    public static void main(String[] args) {
        Random rand = new Random();
        Stack s = new Stack();
        while(true){
            try{
                int x = rand.nextInt(99);
                String str1 = x+"";
                int num1 = Integer.parseInt(str1.substring(str1.length()-1));
                int num12 = -1;
                if(str1.length()==2){
                    num12 = Integer.parseInt(str1.substring(str1.length()-2));
                }
                
                if(s.isFullStack()){
                    System.out.print("Random:"+x+" Push:"+x+" Stack:*Full*");
                    break;
                }
                if(s.isEmptyStack()){
                    s.push(x);
                    System.out.print("Random:"+x+" Push:"+x+" Stack["+s.getSize()+"]:");
                    s.print();
                }else{
                    String str2 = s.peek().toString();
                    int num2 = Integer.parseInt(str2.substring(str2.length()-1));
                    int num22 = -2;
                    if(str2.length()==2){
                        num22 = Integer.parseInt(str2.substring(str2.length()-2));
                    }
                    if(str1.equals(str2)){
                        System.out.print("Random:"+x+" *Quit*");
                        break;
                    }
                    if(num2+num1>=10 || num1==num2 || num12 == num22|| num1 == num22 || num2 == num12){
                        System.out.print("Random:"+x+" Pop:"+s.pop()+" Stack["+s.getSize()+"]:");
                        if(s.isEmptyStack()){
                            System.out.println("*Empty*");
                            break;
                        }else
                            s.print();
                    }else{
                        s.push(x);
                        System.out.print("Random:"+x+" Push:"+x+" Stack["+s.getSize()+"]:");
                        s.print();
                    }       
                }
            }catch (Exception e){
                System.err.println(e);
            }
        }
    }
}
