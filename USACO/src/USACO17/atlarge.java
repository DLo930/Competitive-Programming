/**
 * Dennis Lo
 * 01/21/18
 */
package USACO17;
import java.util.*;
import java.io.*;

public class atlarge {
    FileInputStream fs;
    InputStream is;
    PrintWriter out;
    String INPUT = "", FILE = "atlarge";
    List<Integer>[] nodes;
    boolean[] visited;
    int start;
    
    int adjUnv(int v) {
        for(Integer i : nodes[v]) if(!visited[i]) return i;
        return -1;
    }
    
    int subtree(int root, int distFromStart) {
        out.println(root+" "+distFromStart);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(root);
        visited[root] = true;
        int res = 0, step = 0;
        while(!stack.isEmpty()) {
            int next = adjUnv(stack.peek());
            if(next == -1) {
                if(nodes[stack.peek()].size() == 1) {
                    if(step <= distFromStart && root != start) return 1;
                    res++;
                }
                stack.pop();
                step--;
            }
            else {
                if(nodes[next].size() > 2) res += subtree(next, distFromStart+step); //reached subtree
                else {
                    visited[next] = true;
                    stack.push(next);
                    step++;
                }
            }
            if(step < 0) out.println(step);
        }
        return res;
    }

    void solve() {
        int n = ni();
        start = ni();
        nodes = new List[n+1];
        visited = new boolean[n+1];
        for(int i=1;i<=n;i++) nodes[i] = new ArrayList<>();
        for(int i=0;i<n-1;i++) {
            int a = ni(), b = ni();
            nodes[a].add(b);
            nodes[b].add(a);
        }
        out.println(nodes[start].size() == 1 ? "1" : subtree(start, 0));
    }
    
    /*
     ** Credit to Uwi Tenpen for fast I/O **
    */
    void run() throws Exception {
        fs = new FileInputStream(FILE+".in");
        is = INPUT.isEmpty() ? fs : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out/*new BufferedWriter(new FileWriter(FILE+".out"))*/);

        long s = System.currentTimeMillis();
        solve();
        out.flush();
        if (!INPUT.isEmpty()) {
            tr(System.currentTimeMillis() - s + "ms");
        }
    }

    public static void main(String[] args) throws Exception {
        new atlarge().run();
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
