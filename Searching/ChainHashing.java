//620710124 พงศกร มีนุช

import java.util.ArrayList;
import java.util.Random;
class Hashing{
    ArrayList<Integer> num;
    Hashing(){
        num = new ArrayList<>();
    }

    void showValue(){
        for(int i=0;i<num.size();++i){
            System.out.print(num.get(i));
            if(i!=num.size()-1)
                System.out.print(",");
        }
    }
}

public class ChainHashing {
    public static void main(String[] args) {
        Random rand = new Random();
        int n = rand.nextInt(11)+10;
        Hashing[] HashTable = new Hashing[n*2];
        System.out.println("--- Random Numbers ["+n+"] ---");
        int count =0,usedKey =0;
        while(count<n){
            int x = rand.nextInt(101);
            int Hash = x%(2*n);
            boolean isRepeat = false;
            if(HashTable[Hash] == null){
                HashTable[Hash] = new Hashing();
                usedKey++;
            }
            for(int h:HashTable[Hash].num){
                if(h==x){
                    isRepeat = true;
                    System.out.print("!"+x+" ");
                }
            }
            if(isRepeat)
                continue;
            System.out.print(x+" ");
            HashTable[Hash].num.add(x);
            count++;
        }
        System.out.println("\n--- Hash Table ["+usedKey+"/"+n+"] ---");
        for(int i=0;i<2*n;++i){
            if(HashTable[i] != null){
                System.out.print(i+"->");
                HashTable[i].showValue();
                System.out.print(" ");
            }
        }
        count = 0;
        int total=0;
        System.out.println("\n--- Finding Match ---");
        while(count<3){
            total++;
            int m = rand.nextInt(101);
            int index = (100-m)%(2*n);
            boolean found = false;
            if(HashTable[index] != null){
                for(int i=0;i<HashTable[index].num.size();++i){
                    if(HashTable[index].num.get(i)+m == 100){
                        found =true;
                        count++;
                        HashTable[index].num.remove(i);
                        System.out.print(m+" ");
                        if(HashTable[index].num.isEmpty())
                            usedKey--;
                        break;
                    }
                }
            }
            if(!found)
                System.out.print("!"+m+" ");
        }
        System.out.println("\nTotal Finding: "+total);
        System.out.println("--- Hash Table ["+usedKey+"/"+n+"] ---");
        for(int i=0;i<2*n;++i){
            if(HashTable[i] != null && !HashTable[i].num.isEmpty()){
                System.out.print(i+"->");
                HashTable[i].showValue();
                System.out.print(" ");
            }
        }
    }
}
