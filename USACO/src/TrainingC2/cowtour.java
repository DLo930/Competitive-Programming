/*
ID: dennisl5
LANG: JAVA
TASK: cowtour
 */
package TrainingC2;

import java.util.*;
import java.io.*;
import java.text.*;

public class cowtour {
    static final String FILE = "cowtour";
    static final double INF = Integer.MAX_VALUE;
    static int n;
    
    static class UFDS {

        int[] p, rank, size;
        int sets; // # of disjoint sets

        int findSet(int i) {
            return (p[i] == i) ? i : findSet(p[i]);
        }

        boolean sameSet(int i, int j) {
            return findSet(i) == findSet(j);
        }

        void union(int i, int j) {
            if (!sameSet(i, j)) {
                int x = findSet(i), y = findSet(j);
                if (rank[x] > rank[y]) {
                    p[y] = x;
                    size[x] += size[y];
                } else {
                    p[x] = y;
                    size[y] += size[x];
                }
                if (rank[x] == rank[y]) {
                    rank[y]++;
                }
                sets--;
            }
        }

        int getSize(int i) {
            return size[i];
        }

        public UFDS(int n) {
            p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
            }
            rank = new int[n];
            size = new int[n];
            Arrays.fill(size, 1);
            sets = n;
        }
    }
   
    static double dist(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }
    
    static double[][] fw(double[][] graph) {  //Floyd-Warshall's Algo for APSP
        double[][] res = new double[graph.length][];
        for(int i=0;i<n;i++) res[i] = graph[i].clone();
        
        for(int j=0;j<n;j++)
            for(int i=0;i<n;i++)
                for(int k=0;k<n;k++) {
                    double tmp = Math.min(res[i][k], res[i][j] + res[j][k]);
                    res[i][k] = tmp;
                    res[k][i] = tmp;
                }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FILE+".in"));
        PrintWriter out = new PrintWriter(System.out/*new BufferedWriter(new FileWriter(FILE+".out"))*/, true);
        DecimalFormat df = new DecimalFormat("0.000000");
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        int[] x = new int[n], y = new int[n];
        UFDS ds = new UFDS(n);
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        
        double[][] adjMat = new double[n][n];
        for(int i=0;i<n;i++) Arrays.fill(adjMat[i], INF);
        
        for(int i=0;i<n;i++) {
            char[] tmp = br.readLine().toCharArray();
            for(int j=0;j<i;j++)    //adjMat is symmetric along diagonal
                if(tmp[j] == '1') {
                    double d = dist(x[i], y[i], x[j], y[j]);
                    adjMat[i][j] = d;
                    adjMat[j][i] = d;
                    ds.union(i, j);
                }
            adjMat[i][i] = 0;
        }
        
        double[][] shortest = fw(adjMat);
        double[] farthest = new double[n];
        for(int i=0;i<n;i++) {
            double max = 0;
            for(int j=0;j<n;j++) if(shortest[i][j] != INF) max = Math.max(max, shortest[i][j]);
            farthest[i] = max;
        }
        
        double[] diam = new double[n];  // Calculating diameters necessary only for handling edge cases
        for(int i=0;i<n;i++) {
            int p = ds.findSet(i);
            if(diam[p] == 0) diam[p] = INF;
            for(int j=0;j<n;j++)
                if(ds.findSet(j) == p){
                    if(diam[p] == INF) diam[p] = shortest[i][j];
                    else diam[p] = Math.max(diam[p], shortest[i][j]);
                }
        }
        
        double minDiam = Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
            for(int j=i+1;j<n;j++)
                if(shortest[i][j] == INF) {
                    minDiam = Math.min(minDiam, Math.max(farthest[i] + dist(x[i],y[i],x[j],y[j]) + farthest[j], Math.max(diam[ds.findSet(i)],diam[ds.findSet(j)])));
                }
        out.println(df.format(minDiam));
    }
}