package USACO17;
/**
 * Dennis Lo
 * 12/17/17
 */
import java.util.*;
import java.io.*;



public class measurement {
    FileInputStream fs;
    InputStream is;
    PrintWriter out;
    String INPUT = "", FILE = "measurement";
    
    private class Pair {
        String name;
        int n;
        public Pair(String name, String n) {
            this.name = name;
            this.n = Integer.parseInt(n);
        }
    }

    void solve() {
        int[] cows = {7,7,7};
        int res = 0;
        Map<Integer, Pair> log = new TreeMap<>();
        for(int T=ni();T>0;T--) log.put(ni(), new Pair(ns(),ns()));
        
        Iterator iter = log.values().iterator();
        while(iter.hasNext()) {
            Pair tmp = (Pair) iter.next();
            int[] prev = max(cows);
            cows[cowNum(tmp.name)] += tmp.n;
            int[] curr = max(cows);
            //for(int i=1;i<3;i++) out.print(curr[i]+" ");
            //out.println();
            if(/*!Arrays.equals(prev,curr) &&*/ curr[1] != prev[1] || curr[2] != prev[2]) res++;
        }
        out.println(res);
    }
    
    int cowNum(String name) {
        switch(name) {
            case "Bessie": return 0;
            case "Elsie" : return 1;
            case "Mildred": return 2;
            default: return -1;
        }
    }
    
    int[] max(int[] cows) {
        int max = 0, freq = 0, who = -1; //"who" keeps track of single biggest producer
        for(int i=0;i<3;i++) {
            if(cows[i] > max) {
                max = cows[i];
                freq = 1;
                who = i;
            }
            else if(cows[i] == max) {
                freq++;
                who = -1;
            }
        }
        return new int[]{max, freq, who};
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
        new measurement().run();
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
