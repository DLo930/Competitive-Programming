import java.util.*;
import java.io.*;

class B2015_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("B2015_2.txt")/*InputStreamReader(System.in)*/);
		PrintWriter out = new PrintWriter(System.out, true);
		StringTokenizer st;
		
		int n = pi(br.readLine());
		boolean[][] arr = new boolean[n][33];
		String s = br.readLine();
		while(s != null) {
			String[] tmp = s.split("-");
			if(tmp.length == 3) {
				int rm = pi(tmp[0]), start = pi(tmp[1]), end = start + pi(tmp[2]), i;
				for(i=start;i<end;i++) {
					if(!arr[rm][i]) arr[rm][i] = true;
					else break;
				}
				if(i != end)
					for(int j=start;j<i;j++)
						arr[rm][j] = false;
				out.println(i == end ? 'Y' : 'N');
			}
			else {
				int start = pi(tmp[0]), end = start + pi(tmp[1]), cnt = 0;
				List<Integer> avail = new ArrayList<>();
				for(int i=0;i<n;i++) {
					boolean valid = true;
					for(int j=start;j<end && valid;j++) {
						if(arr[i][j]) valid = false;
					}
					if(valid) avail.add(i+1);
				}
				for(int i=0;i<avail.size()-1;i++) out.print(avail.get(i)+' ');
				out.println(avail.get(avail.size()-1));
			}
			s = br.readLine();
		}
	}
	
	static int pi(String s) {
		return Integer.parseInt(s);
	}
}