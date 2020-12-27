import java.util.Scanner;

class adjMatrix{
    int[][] Path;

    adjMatrix(int m){
        Path = new int[m][m];
    }

    void setPath(int A,int B){
        Path[A][B] = 1;
    }

    int calPath(int start , int stop){
        int count = 0;
        for(int i=0;i<Path.length;++i){
            if(Path[start][i] == 1 && Path[i][stop] == 1)
                count++;
        }
        return count;
    }
}

public class Village{
    public static void main(String[] args) {
        System.out.println("==Village Info==");
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        String[] sVil = sc.next().split(";");
        adjMatrix adj = new adjMatrix(m);
        int n = sc.nextInt();
        String[] sPath = sc.next().split(";");
        for(String s:sPath){
            String str[] = s.split(">");
            int A,B;
            A = B = -1;
            for(int i=0;i<m;++i){
                if(str[0].equals(sVil[i])){
                    A = i;
                    break;
                }
            }
            for(int i=0;i<m;++i){
                if(str[1].equals(sVil[i])){
                    B = i;
                    break;
                }
            }
        }
        System.out.println("== Village Calculation===");
        while(true){
            String order = sc.next();
            if(order.equals("-")){
                System.out.println("BYE");
                break;
            }
            String[] str = order.split(">>");
            if(str.length <= 1){
                System.out.println("ERROR!");
                continue;
            }
            int start,stop;
            start = stop = -1;
            for(int i=0;i<m;++i){
                if(str[0].equals(sVil[i])){
                    start = i;
                    break;
                }
            }
            for(int i=0;i<m;++i){
                if(str[1].equals(sVil[i])){
                    stop = i;
                    break;
                }
            }
            int c = adj.calPath(start, stop);
            System.out.println(c);
        }
    }
}
