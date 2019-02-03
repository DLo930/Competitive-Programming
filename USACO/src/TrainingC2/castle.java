/*
ID: dennisl5
LANG: JAVA
TASK: castle
 */
package TrainingC2;

import java.util.*;
import java.io.*;

class Triple implements Comparator<Triple> {
    int i, j;
    char dir;
    public Triple() {}
    public Triple(int i, int j, char dir) {
        this.i = i;
        this.j = j;
        this.dir = dir;
    }
    @Override
    public int compare(Triple a, Triple b) {
        if(a.j-b.j != 0) return a.j-b.j;
        if(b.i-a.i != 0) return b.i-a.i; //y vals in 2D array are reversed
        return (a.dir == 'N') ? -1 : 1;
    }
    @Override
    public String toString() { return i+1+" "+(j+1)+" "+dir; }
}

public class castle {
    static final String FILE = "castle";
    static boolean[][][] nodes;
    static boolean[] visited;
    static int[] marked;
    static int m, n, max = 1, mark = 0, maxSize = 0;
    static List<List> components;
    static List<Triple> positions;
    
    static void dfs(int i) {
        if(visited[i]) return;
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> component = new ArrayList<>();
        stack.add(i);
        while(!stack.isEmpty()) {
            visited[stack.peek()] = true;
            int next = getAdjUnv(stack.peek());
            if(next == -1) {
                component.add(stack.peek());
                marked[stack.poll()] = mark;
            }
            else stack.push(next);
        }
        components.add(component);
        max = Math.max(max, component.size());
        mark++;
    }
    
    static int getAdjUnv(int i) { //for DFS
        if(nodes[i/m][i%m][0] && !visited[i-1]) return i-1;
        if(nodes[i/m][i%m][1] && !visited[i-m]) return i-m;
        if(nodes[i/m][i%m][2] && !visited[i+1]) return i+1;
        if(nodes[i/m][i%m][3] && !visited[i+m]) return i+m;
        return -1;
    }
    
    static void eval(int i, int j) {
        int total = components.get(marked[i]).size()+components.get(marked[j]).size();
        if(total < maxSize) return;
        if(total > maxSize) {
            maxSize = total;
            positions.clear();
        }
        if(j == i-m) positions.add(new Triple(i/m, i%m, 'N'));
        else if(j == i+m) positions.add(new Triple(j/m, j%m, 'N'));
        else if(j == i-1) positions.add(new Triple(j/m, j%m, 'E'));
        else positions.add(new Triple(i/m, i%m, 'E'));
    }
    
    static boolean hasWall(int a, int k) { return (a & (1 << k-1)) > 0; }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FILE+".in"));
        PrintWriter out = new PrintWriter(/*System.out*/new BufferedWriter(new FileWriter(FILE+".out")), true);
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int tmp;
        nodes = new boolean[n][m][4];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++) {
                tmp = Integer.parseInt(st.nextToken());
                for(int k=1;k<=4;k++) if(!hasWall(tmp, k)) nodes[i][j][k-1] = true;
            }
        }
        components = new ArrayList<>();
        visited = new boolean[n*m];
        marked = new int[n*m];
        for(int i=0;i<m*n;i++) dfs(i);
        out.println(components.size()+"\n"+max);
        
        positions = new ArrayList<>();
        for(int i=0;i<m*n;i++) {
            if(i%m != 0 && marked[i-1] != marked[i]) eval(i, i-1);
            if(i%m != m-1 && marked[i+1] != marked[i]) eval(i, i+1);
            if(i/m != 0 && marked[i-m] != marked[i]) eval(i, i-m);
            if(i/m != n-1 && marked[i+m] != marked[i]) eval(i, i+m);
        }
        Collections.sort(positions, new Triple());
        out.println(maxSize);
        out.println(positions.get(0));
    }
}
