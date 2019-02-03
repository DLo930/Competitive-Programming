/*
 ID: dennisl5
 LANG: JAVA
 TASK: comehome
 */
package TrainingC2;

import java.util.*;
import java.io.*;

public class comehome {

    static final int INF = Integer.MAX_VALUE;
    static int nodes = 58;  //disregard 27-32
    static boolean[] visited;
    static int[][] adjMat;
    static int[] dist;

    static int minAdj() {
        int min = INF, minIndex = -1;
        for (int i = 1; i <= nodes; i++) {
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    static void dijkstra(int source) {
        for (int i = 1; i <= nodes; i++) dist[i] = INF;
        dist[source] = 0;

        for (int i = 0; i < nodes - 1; i++) {   //iterate through graph
            int next = minAdj();
            if(next == -1) break;
            
            visited[next] = true;
            
            for (int j = 1; j <= nodes; j++)
                if (!visited[j] && adjMat[next][j] > 0)
                    dist[j] = Math.min(dist[j], dist[next] + adjMat[next][j]);
            
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("comehome.in"));
        PrintWriter out = new PrintWriter(/*System.out*/new BufferedWriter(new FileWriter("comehome.out")), true);
        StringTokenizer st;

        int edges = Integer.parseInt(br.readLine());

        visited = new boolean[nodes + 1];
        adjMat = new int[nodes + 1][nodes + 1];
        dist = new int[nodes + 1];

        while (edges-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = (int) st.nextToken().charAt(0) - 'A' + 1, b = (int) st.nextToken().charAt(0) - 'A' + 1, weight = Integer.parseInt(st.nextToken());
            if((adjMat[a][b] != 0 && weight < adjMat[a][b]) || adjMat[a][b] == 0) {
                adjMat[a][b] = weight;
                adjMat[b][a] = weight;
            }
        }

        dijkstra(26);
        
        int min = INF, minIndex = 0;
        for (int i = 1; i < 26; i++) {
            if (dist[i] < min) {
                min = dist[i];
                minIndex = i;
            }
        }
        out.println((char) (minIndex + 'A' - 1) + " " + min);
    }
}
