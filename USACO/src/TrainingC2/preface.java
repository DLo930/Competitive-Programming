/*
ID: dennisl5
LANG: JAVA
TASK: preface
 */
package TrainingC2;

import java.util.*;
import java.io.*;

public class preface {
    static final String FILE = "preface";
    static int[] nums = {1,5,10,50,100,500,1000}, cnt = {0,0,0,0,0,0,0};
    static char[] letters = {'I','V','X','L','C','D','M'};
    
    static void process(int n) {
        for(int i=6;i>=0;i--) {
            if(n >= nums[i]) {
                cnt[i] += n/nums[i];
                n %= nums[i];
            }
            if(i >= 2 && i%2 == 0 && n >= nums[i]-nums[i-2]) {
                cnt[i]++;
                cnt[i-2]++;
                n -= nums[i]-nums[i-2];
            }
            else if(i >= 1 && i%2 == 1 && n >= nums[i]-nums[i-1]) {
                cnt[i]++;
                cnt[i-1]++;
                n -= nums[i]-nums[i-1];
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(/*System.in*/new File(FILE+".in"));
        PrintWriter out = new PrintWriter(/*System.out*/new BufferedWriter(new FileWriter(FILE+".out")), true);
        
        int n = s.nextInt();
        for(int i=1;i<=n;i++) process(i);
        
        for(int i=0;i<7;i++) if(cnt[i] > 0) out.println(letters[i]+" "+cnt[i]);
    }
}
