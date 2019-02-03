/*
ID: dennisl5
LANG: JAVA
TASK: ttwo
 */
package TrainingC2;

import java.util.*;
import java.io.*;

public class ttwo {
    static final String FILE = "ttwo";
    static final int MAX = 160000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FILE+".in"));
        PrintWriter out = new PrintWriter(/*System.out*/new BufferedWriter(new FileWriter(FILE+".out")), true);
        
        boolean[][] mtx = new boolean[11][11];
        int[] xdirs = {0, 1, 0, -1}, ydirs = {-1, 0, 1, 0};
        int cx = 0, cy = 0, fx = 0, fy = 0, fdir = 0, cdir = 0;
        for(int i=1;i<=10;i++) {
            String tmp = br.readLine();
            for(int j=1;j<=10;j++) {
                char c = tmp.charAt(j-1);
                if(c == '*') mtx[i][j] = true;
                if(c == 'F') {
                    fx = j;
                    fy = i;
                }
                if(c == 'C') {
                    cx = j;
                    cy = i;
                }
            }
        }
        int cnt = 0;
        while(cx != fx || cy != fy) {
            int tryfx = fx + xdirs[fdir%4], tryfy = fy + ydirs[fdir];
            int trycx = cx + xdirs[cdir%4], trycy = cy + ydirs[cdir];
            if(tryfx == 0 || tryfy == 0 || tryfx == 11 || tryfy == 11 || mtx[tryfy][tryfx])
                fdir = (fdir+1)%4;
            else {
                fx = tryfx;
                fy = tryfy;
            }
            if(trycx == 0 || trycy == 0 || trycx == 11 || trycy == 11 || mtx[trycy][trycx])
                cdir = (cdir+1)%4;
            else {
                cx = trycx;
                cy = trycy;
            }
            if(cnt > MAX) {
                cnt = 0;
                break;
            }
            cnt++;
        }
        out.println(cnt);
    }
}
