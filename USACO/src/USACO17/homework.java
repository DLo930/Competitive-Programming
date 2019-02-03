/**
 * Dennis Lo
 * 12/18/17
 */
import java.util.*;
import java.io.*;

class homework {
    FileInputStream fs;
    InputStream is;
    PrintWriter out;
    String INPUT = "", FILE = "homework";

    void solve() {
        int n = ni();
        int[] arr = na(n), sums = new int[n];
        sums[n-1] = arr[n-1];
        for(int i=n-2;i>0;i--) sums[i] = sums[i+1]+arr[i];
        double max = 0;
        List<Integer> list = new ArrayList<>();
        
        for(int i=1;i<=n-2;i++) {
            double tmp = sums[i]/(double)(n-i);
            if(tmp > max) {
                max = tmp;
                list.clear();
                list.add(i);
            }
            else if(tmp == max) list.add(i);
        }
        for(Integer i : list) out.println(i);
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
        new homework().run();
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
