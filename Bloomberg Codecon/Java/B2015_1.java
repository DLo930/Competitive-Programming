import java.util.*;
import java.io.*;

class B2015_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("B2015_1.txt")/*InputStreamReader(System.in)*/);
		PrintWriter out = new PrintWriter(System.out, true);
		StringTokenizer st;
		
		int n = pi(br.readLine()), pairs = 0;
		Set<String> set = new HashSet<>(n);
		while(n-->0) {
			String tmp = br.readLine(), rev = new StringBuilder(tmp).reverse().toString();
			if(tmp.equals(rev)) continue;
			if(!set.contains(rev)) {
				set.add(tmp);
			}
			else {
				set.remove(rev);
				pairs++;
			}
		}
		out.println(set.isEmpty() ? pairs : -1);
	}
	
	static int pi(String s) {
		return Integer.parseInt(s);
	}
}