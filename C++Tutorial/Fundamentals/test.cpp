#include <bits/stdc++.h>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	bitset<8> set(0b0000'0101);
	set.set(7);
	set.reset(2);
	cout << set.test(7) << " " << set.test(2) << " " << set.test(0) << "\n";
	return 0;
}