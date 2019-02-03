/*
 * Author: DLo930
 * Date: 10/11/18
*/

#include <iostream>
#include <utility>

using namespace std;

int digSum(long long n) {
	int sum = 0;
	while(n) {
		sum += n%10;
		n /= 10;
	}
	return sum;
}

pair<int, int> minDigSum(long long n) {
	int ops = 0;
	while(n >= 10) {
		n = digSum(n);
		ops++;
	}
	pair<int, int> p(n,ops);
	return p;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	int t;
	cin >> t;
	while(t--) {
		long long n, d;
		cin >> n >> d;
		
		int minSum = 91, minOps = 0;	//digSum(10^10-1) = 9*10
		for(int i=0;i<10;i++) {			//digSum repeats after 10 iterations
			pair<int,int> tmp = minDigSum(n);
			if(tmp.first < minSum) {
				minSum = tmp.first;
				minOps = i + tmp.second;
			} else if(tmp.first == minSum && i + tmp.second < minOps) {
				minOps = i + tmp.second;
			}
			n += d;
		}
		cout << minSum << ' ' << minOps << '\n';
	}
	
	return 0;
}