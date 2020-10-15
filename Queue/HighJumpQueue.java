import java.util.Random;
public class HighJumpQueue {
    public static void main(String[] args) {
        Random  rand = new Random();
        Queue q = new Queue();
        for(int i=0;i<20;++i){
            double p = Math.random();
            int ip = (int)Math.round(p);
            if(ip==1){
                int use_time = rand.nextInt(3);
                q.enQueue(use_time);
            }
            
        }
    }
}
