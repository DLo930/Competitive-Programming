/*
 * Author: DLo930
 * Date: 10/10/18
*/

#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	int t;
	long p1, p2, k;
	cin >> t;
	while(t--) {
		cin >> p1 >> p2 >> k;
		cout << ((p1+p2)/k%2 ? "COOK" : "CHEF") << '\n';
	}
	
	return 0;
}
