//620710124 พงศกร มีนุช 
import java.util.Random;

public class SArr {
    int[] num;

    SArr(int n) {
        num = new int[n];
    }

    void randVal(int m) {
        Random rand = new Random();
        for (int i = 0; i < num.length; ++i) {
            num[i] = rand.nextInt(m + m) - m;
        }
    }

    void insertSort() {
        int tmp;
        for (int i = 1; i < num.length; ++i) {
            tmp = num[i];
            for (int j = i; j > 0 && num[j - 1] > tmp; --j) {
                num[j] = num[j - 1];
                num[j - 1] = tmp;
            }
        }
    }

    void selectionSort() {
        int minIndex, tmp;
        for (int i = 0; i < num.length - 1; ++i) {
            minIndex = i;
            for (int j = i + 1; j < num.length; ++j) {
                if (num[j] < num[minIndex])
                    minIndex = j;
                if (minIndex != i) {
                    tmp = num[i];
                    num[i] = num[minIndex];
                    num[minIndex] = tmp;
                }
            }
        }
    }

    void bubbleSort() {
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < num.length - j; ++i) {
                if (num[i] > num[i + 1]) {
                    tmp = num[i];
                    num[i] = num[i + 1];
                    num[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }

    void shellSort() {
        int j;
        for (int gap = num.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < num.length; ++i) {
                int tmp = num[i];
                for (j = i; j >= gap && tmp < num[j - gap]; j -= gap) {
                    num[j] = num[j - gap];
                    num[j-gap] = tmp;
                    
                }
            }
        }
    }

    void printVal() {
        for (int i = 0; i < num.length; ++i) {
            System.out.print(num[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 0; i < 4; ++i) {
            int n = rand.nextInt(20 - 10) + 10;
            int m = rand.nextInt(50 - 10) + 10;
            System.out.println("Random " + n + " numbers [-" + m + ".." + m + "] :");
            SArr s = new SArr(n);
            s.randVal(m);
            s.printVal();
            switch (i) {
                case 0:
                    System.out.println("Insertion Sort :");
                    s.insertSort();
                    break;
                case 1:
                    System.out.println("Selection Sort :");
                    s.selectionSort();
                    break;
                case 2:
                    System.out.println("Bubble Sort :");
                    s.bubbleSort();
                    break;
                case 3:
                    System.out.println("Shell Sort :");
                    s.shellSort();
                    break;
            }
            s.printVal();
            System.out.println("-----------------");
        }
    }
}
