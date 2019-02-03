/*
 * Author: DLo930
 * Date: 11/10/18
*/

#include <iostream>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	int n, m;
	cin >> n >> m;
	int tmp = n;
	while(tmp%m != 1) {
		tmp += n;
	}
	cout << "MMI: " << tmp/n << '\n';
	
	return 0;
}
