/*
ID: dennisl5
LANG: JAVA
TASK: ariprog
 */
package TrainingC1;

import java.util.*;
import java.io.*;

public class ariprog {
    static final String FILE = "ariprog";
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File(FILE+".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE+".out")), true);
        
        int n = s.nextInt(), m = s.nextInt();
        boolean[] bisquare = new boolean[m*m*2+1];
        for(int i=0;i<=m;i++) for(int j=0;j<=m;j++) bisquare[i*i+j*j] = true;
        
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<2*m*m;i++) {
            if(!bisquare[i]) continue;
            for(int j=1;j<=(m*m*2-i)/(n-1);j++) {
                boolean flag = true;
                for(int k=1;k<n;k++) if(!bisquare[i+k*j]) {
                    flag = false;
                    break;
                }
                if(flag) list.add(new int[]{i, j});
            }
        }
        Collections.sort(list, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if(arr1[1]-arr2[1] > 0) return 1;
                if(arr1[1]-arr2[1] < 0) return -1;
                return (arr1[0]-arr2[0] > 0) ? 1 : -1;
            }
        });
        if(list.size() == 0) out.println("NONE");
        else for(int[] arr : list) out.println(arr[0]+" "+arr[1]);
    }
}
