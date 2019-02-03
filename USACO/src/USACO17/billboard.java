/**
 * Dennis Lo
 * 12/17/17
 */
import java.util.*;
import java.io.*;

class billboard {
    FileInputStream fs;
    InputStream is;
    PrintWriter out;
    String INPUT = "", FILE = "billboard";

    void solve() {
        int[] r1 = swapYadd1000(na(4)), r2 = swapYadd1000(na(4)), t = swapYadd1000(na(4));
        out.println(a(r1)+a(r2)-overlap(r1, t)-overlap(r2, t));
    }
    int[] swapYadd1000(int[] r) {
        for(int i=0;i<4;i++) r[i] += 1000;
        r[1] += r[3];
        r[3] = r[1]-r[3];
        r[1] -= r[3];
        return r;
    }
    int a(int[] r) { return Math.abs((r[2]-r[0]) * (r[3]-r[1])); }
    
    int overlap(int[] r1, int[] r2) {
	if(r1[0] >= r2[2] || r1[2] <= r2[0] || r1[1] <= r2[3] || r1[3] >= r2[1]) return 0;
        
        int x1, y1, x2, y2;
        x1 = (r1[0] >= r2[0]) ? r1[0] : r2[0];
        x2 = (r1[2] <= r2[2]) ? r1[2] : r2[2];
        y1 = (r1[1] <= r2[1]) ? r1[1] : r2[1];
        y2 = (r1[3] >= r2[3]) ? r1[3] : r2[3];
        
        return a(new int[]{x1,y1,x2,y2});
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
        new billboard().run();
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
