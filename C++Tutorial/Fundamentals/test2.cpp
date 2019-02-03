/*
 * Author: DLo930
 * Date: MM/DD/YY
*/

#include <bits/stdc++.h>

using namespace std;

typedef long long ll;
typedef vector<int> vi;
typedef vector<long> vl;
typedef vector<long long> vll;
typedef vector<string> vs;


int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	int x = 7;
	int *ip = &x;
	int &y = x;
	
	printf("%d %d %d\n", x, *ip, y);
	
	return 0;
}
