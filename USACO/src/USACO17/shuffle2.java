/**
 * Dennis Lo
 * 12/18/17
 */
import java.util.*;
import java.io.*;

class Graph {

    List<Integer>[] graph; //1-based indexing
    Stack<Integer> stack;
    int[] lowestLink;
    boolean[] visited;
    int t;
    List<List<Integer>> sccs;

    public Graph(int n) {
        graph = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        stack = new Stack<>();
        lowestLink = new int[n + 1];
        visited = new boolean[n + 1];
        t = 0;
        sccs = new ArrayList<>();
    }

    List<List<Integer>> getSCCs() {
        for (int i = 1; i < graph.length; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
        return sccs;
    }

    void dfs(int v) {
        lowestLink[v] = t++;
        visited[v] = true;
        stack.push(v);
        boolean isSCCRoot = true;

        for (Integer i : graph[v]) {
            if (!visited[i]) {
                dfs(i);
            }
            if (lowestLink[i] < lowestLink[v]) {
                lowestLink[v] = lowestLink[i];
                isSCCRoot = false;
            }
        }
        if (isSCCRoot) {
            List<Integer> components = new ArrayList<>();
            while (true) {
                int x = stack.pop();
                components.add(x);
                lowestLink[x] = Integer.MAX_VALUE;
                if (x == v) {
                    break;
                }
            }
            if(components.size() > 1) sccs.add(components);
        }
    }
}

public class shuffle2 {
    FileInputStream fs;
    InputStream is;
    PrintWriter out;
    String INPUT = "", FILE = "shuffle";

    void solve() { /*count # of distinct elements in arr whose index is also in arr
        int n = ni(), res = 0;
        int[] arr = new int[n+1], pos = new int[n+1];
        //Set<Integer> set = new HashSet<>();
        for(int i=1;i<=n;i++) arr[i] = ni();
        for(int i=1;i<=n;i++) 
        out.println(res);*/
        
        //* of positions part of SCCs
        int n = ni(), res = 0;
        Graph g = new Graph(n);
        for(int i=1;i<=n;i++) {
            int tmp = ni();
            if(tmp != i) g.graph[i].add(tmp);
            else res++;
        }
        List<List<Integer>> scc = g.getSCCs();
        
        for(List<Integer> list : scc) {
            //out.println(list);
            res += list.size();
        }
        out.println(res);
    }
    
    /*
     ** Credit to Uwi Tenpen for fast I/O **
    */
    void run() throws Exception {
        fs = new FileInputStream(FILE+".in");
        is = INPUT.isEmpty() ? fs : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(new BufferedWriter(new FileWriter(FILE+".out")));

        long s = System.currentTimeMillis();
        solve();
        out.flush();
        if (!INPUT.isEmpty()) {
            tr(System.currentTimeMillis() - s + "ms");
        }
    }

    public static void main(String[] args) throws Exception {
        new shuffle2().run();
    }

    private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;

    private int readByte() {
        if (lenbuf == -1) {
            throw new InputMismatchException();
        }
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0) {
                return -1;
            }
        }
        return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b));
        return b;
    }

    private double nd() {
        return Double.parseDouble(ns());
    }

    private char nc() {
        return (char) skip();
    }

    private String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !(isSpaceChar(b))) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    private char[][] nm(int n, int m) {
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) {
            map[i] = ns(m);
        }
        return map;
    }

    private int[] na(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = ni();
        }
        return a;
    }

    private int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private void tr(Object... o) {
        if (INPUT.length() > 0) {
            System.out.println(Arrays.deepToString(o));
        }
    }
}
