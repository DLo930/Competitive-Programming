/*
 * Author: DLo930
 * Date: 10/10/18
*/

#include <bits/stdc++.h>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	int t;
	cin >> t;
	while(t--) {
		int n;
		cin >> n;
		
		if(n == 0) {
			cout << "0 0 0\n";
			continue;
		} else {
			long long x = (n-1)/26, a = 0, b = 0, c = 0;
			int tmp = (n-1)%26;
			
			if(tmp < 2) a = 1ll << x;
			else if(tmp < 10) b = 1ll << x;
			else c = 1ll << x;
			
			cout << a << ' ' << b << ' ' << c << '\n';
		}
		
	}
	
	return 0;
}
