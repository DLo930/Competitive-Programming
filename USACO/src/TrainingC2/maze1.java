/*
ID: dennisl5
LANG: JAVA
TASK: maze1
 */
package TrainingC2;

import java.util.*;
import java.io.*;

public class maze1 {
    static final String FILE = "maze1";
    static final int[][] dirs = {{0, -1},{1, 0},{0, 1},{-1, 0}}; // N E S W
    static int[][] dist;
    static int H, W;
    static boolean[][] visited;
    static boolean[][][] mtx;
    
    static class Pair {
        int a, b;
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    
    static void bfs(List<Pair> arr, int lvl) {  //recursive BFS to update dist
        if(arr.size() == 0) return;
        List<Pair> next = new ArrayList<>();
        for(Pair p : arr) {
            dist[p.a][p.b] = Math.min(dist[p.a][p.b], lvl);
            visited[p.a][p.b] = true;
            for(int dir=0;dir<4;dir++) {
                int x = p.b+dirs[dir][0], y = p.a+dirs[dir][1];
                if(mtx[p.a][p.b][dir] && !visited[y][x]) {
                    next.add(new Pair(y, x));
                    visited[y][x] = true;
                }
            }
        }
        bfs(next, lvl+1);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FILE+".in"));
        PrintWriter out = new PrintWriter(/*System.out*/new BufferedWriter(new FileWriter(FILE+".out")), true);
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        char[][] maze = new char[2*H+1][];
        for(int i=0;i<maze.length;i++) maze[i] = br.readLine().toCharArray();
        
        mtx = new boolean[H][W][4]; // "graph"
        dist = new int[H][W];   //dist of coord from nearest exit
        for(int i=0;i<H;i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        
        List<List<Pair>> exits = new ArrayList<>();
        for(int i=0;i<H;i++) {
            int h = 2*i+1;
            for(int j=0;j<W;j++) {
                int w = 2*j+1;
                for(int dir=0;dir<4;dir++) if(maze[h+dirs[dir][1]][w+dirs[dir][0]] == ' ') {
                    if((i == 0 && dir == 0) || (i == H-1 && dir == 2) || (j == 0 && dir == 3) || (j == W-1 && dir == 1)) {  //is exit
                        List<Pair> tmp = new ArrayList<>();
                        tmp.add(new Pair(i, j));
                        exits.add(tmp);
                    }
                    else mtx[i][j][dir] = true;
                }
            }
        }
        //FIRST EXIT
        visited = new boolean[H][W];
        visited[exits.get(0).get(0).a][exits.get(0).get(0).b] = true;
        bfs(exits.get(0), 1);
        
        //SECOND EXIT
        visited = new boolean[H][W];
        visited[exits.get(1).get(0).a][exits.get(1).get(0).b] = true;
        bfs(exits.get(1), 1);
        
        int max = 1;
        for(int i=0;i<H;i++)
            for(int j=0;j<W;j++) 
                if(dist[i][j] != Integer.MAX_VALUE)
                    max = Math.max(max, dist[i][j]);
        out.println(max);
    }
}