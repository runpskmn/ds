//620710124 พงศกร มีนุช

import java.util.Arrays;
import java.util.Random;
public class LinearProbling {
    public static void main(String[] args) {
        Random rand = new Random();
        int n = rand.nextInt(10)+10;
        int[] HashTable = new int[2*n];
        boolean[] Status = new boolean[2*n];
        Arrays.fill(HashTable, -1);
        System.out.println(n);
        int count =0,find =0;
        System.out.println("--- Random Numbers ["+n+"] ---");
        while(count<n){
            int x = rand.nextInt(101);
            boolean isRepeat = false;
            for(int h : HashTable){
                if(h != -1 && x == h){
                    System.out.print("!"+x+" ");
                    isRepeat = true;
                    break;
                }
            }
            if(isRepeat)
                continue;
            count++;
            System.out.print(x+" ");
            int Hash = x%(2*n);
            boolean notEmpty = false;
            while(HashTable[Hash] != -1){
                Hash = (Hash+1)%(n*2);
                notEmpty = true;
            }
            HashTable[Hash] = x;
            Status[Hash] = notEmpty;
        }
        System.out.println("\n--- Hash Table ["+n+"] ---");
        for(int i=0;i<HashTable.length;++i){
            if(HashTable[i]!=-1){
                if(Status[i])
                    System.out.print(i+":"+HashTable[i]+"* ");
                else
                    System.out.print(i+":"+HashTable[i]+" ");
            }
        }
        count =0;
        System.out.println("\n--- Findind Match ---");
        while(count<3){
            find++;
            int m = rand.nextInt(101);
            boolean found = false;
            for(int i=0;i<2*n;++i){
                if(HashTable[i]+m ==100 && HashTable[i] != -1){
                    count++;
                    HashTable[i] = -1;
                    found = true;
                    System.out.print(m+" ");
                    break;
                }
            }
            if(!found)
                System.out.print("!"+m+" ");
        }
        System.out.println("\nTotal Finding: "+find);
        System.out.println("--- Hash Table["+(n-3)+"] ---");
        for(int i=0;i<HashTable.length;++i){
            if(HashTable[i]!=-1){
                if(Status[i])
                    System.out.print(i+":"+HashTable[i]+"* ");
                else
                    System.out.print(i+":"+HashTable[i]+" ");
            }
        }
    }
}
