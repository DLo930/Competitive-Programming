/*
ID: dennisl5
LANG: JAVA
TASK: transform
 */
package TrainingC1;

import java.util.*;
import java.io.*;

public class transform {
    static int check(int n, char[][] arr, char[][] arr2, boolean type) {
        char[][] tmp = new char[n][n];
        for(int i=0;i<n;i++) for(int j=0;j<n;j++) tmp[i][j] = arr[n-1-j][i];
        if(Arrays.deepEquals(arr2, tmp)) return 1;
        
        for(int i=0;i<n;i++) for(int j=0;j<n;j++) tmp[i][j] = arr[n-1-i][n-1-j];
        if(Arrays.deepEquals(arr2, tmp)) return 2;
        
        for(int i=0;i<n;i++) for(int j=0;j<n;j++) tmp[i][j] = arr[j][n-1-i];
        if(Arrays.deepEquals(arr2, tmp)) return 3;
        
        if(type) return 7;
        
        for(int i=0;i<n;i++) for(int j=0;j<n;j++) tmp[i][j] = arr[i][n-1-j];
        if(Arrays.deepEquals(arr2, tmp)) return 4;
        
        int rotation = check(n, tmp, arr2, true);
        if(rotation != 7) return 5;
        
        if(Arrays.deepEquals(arr2, tmp)) return 6;
        
        return 7;
    }
    
    static final String FILE = "transform";
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File(FILE+".in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE+".out")), true);
        
        int n = s.nextInt();
        char[][] arr = new char[n][], arr2 = new char[n][];
        for(int i=0;i<n;i++) arr[i] = s.next().toCharArray();
        for(int i=0;i<n;i++) arr2[i] = s.next().toCharArray();
        
        out.println(check(n, arr, arr2, false));
    }
}
