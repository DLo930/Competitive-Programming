/*
 * Author: DLo930
 * Date: 11/23/18
*/

#include <iostream>
#include <cstdio>

using namespace std;

// Extended Euclidean Algorithm
// Reference: https://cp-algorithms.com/algebra/extended-euclid-algorithm.html
int extEucAlgo(int a, int b, int *x, int *y) {
	if(a == 0) {
		*x = 0;
		*y = 1;
		return b;
	}
	int x1, y1;
	int gcd = extEucAlgo(b%a, a, &x1, &y1);
	
	*x = y1 - (b/a)*x1;
	*y = x1;
	return gcd;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	int a, b, x, y;
	cin >> a >> b;
	int gcd = extEucAlgo(a, b, &x, &y);
	printf("%d(%d) + %d(%d) = %d", a, x, b, y, gcd);
	
	return 0;
}
