/*
ID: dennisl5
LANG: JAVA
TASK: sort3
 */
package TrainingC2;

import java.util.*;
import java.io.*;

public class sort3 {
    static final String FILE = "sort3";
    static int other(int a, int b) {
        int i=1;
        while(i == a || i == b) i++;
        return i;
    }
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File(FILE+".in"));
        PrintWriter out = new PrintWriter(/*System.out*/new BufferedWriter(new FileWriter(FILE+".out")), true);
        
        int n = s.nextInt();
        int[] arr = new int[n], cnt = new int[4];
        int[][] order = new int[4][4]; //Freq. of each # in each section
        for(int i=0;i<n;i++) {
            arr[i] = s.nextInt();
            cnt[arr[i]]++;
        }
        int i;
        for(i=0;i<cnt[1];i++) order[1][arr[i]]++;
        for(;i<cnt[1]+cnt[2];i++) order[2][arr[i]]++;
        for(;i<n;i++) order[3][arr[i]]++;

        /*  2 2 1 3 3 3 2 3 1
            0 2 0
            1 0 2
            1 1 2
        */
        int exchanges = 0;
        for(i=1;i<=3;i++) if(order[i][i] != cnt[i])
            for(int j=1;j<=3;j++) {
                if(j == i) continue;
                if(order[j][i] > 0) {
                    order[i][i] += order[j][i];
                    if(order[i][j] >= order[j][i]) {
                        order[j][j] += order[j][i];
                        order[i][j] -= order[j][i];
                    }
                    else {
                        int other = other(i, j), tmp = order[j][i]-order[i][j];
                        order[j][j] += order[i][j];
                        order[i][j] = 0;
                        order[j][other] += tmp;
                        order[i][other] -= tmp;
                    }
                    exchanges += order[j][i];
                    order[j][i] = 0;
                }
            }
        /*for(int a=0;a<4;a++) {
            for(int b=0;b<4;b++) out.print(order[a][b]+" ");
            out.println();
        }*/
        out.println(exchanges);
    }
}
