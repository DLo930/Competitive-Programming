/*
 * Author: DLo930
 * Date: 10/14/18
*/

#include <cmath>
#include <bitset>
#include <iostream>
#include <utility>

#define ll long long

using namespace std;

int digSum(long long n) {
	int sum = 0;
	while(n) {
		sum += n%10;
		n /= 10;
	}
	return sum;
}

pair<int,int> recur(ll n, ll d) {
	if(n < 10) {
		pair<int,int> p(n,0);
		return p;
	}
	int minSum = 100, minOps = 100;
	for(int i=0;i<9;i++) {			//digSum repeats at +9d
		pair<int,int> tmp = recur(digSum(n), d);
		if(tmp.first < minSum) {
			minSum = tmp.first;
			minOps = tmp.second + i;
		} else if(tmp.first == minSum && tmp.second + i < minOps) {
			minOps = tmp.second + i;
		}
		n += d;
	}
	pair<int,int> p(minSum, minOps);
	return p;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	int t;
	cin >> t;
	while(t--) {
		ll n, d;
		cin >> n >> d;
		
		int minSum = 100, minOps = 100;
		for(int i=0;i<9;i++) {
			pair<int,int> tmp = recur(n, d);
			if(tmp.first < minSum) {
				minSum = tmp.first;
				minOps = tmp.second + i;
			} else if(tmp.first == minSum && tmp.second + i < minOps) {
				minOps = tmp.second + i;
			}
			n += d;
		}
		cout << minSum << ' ' << minOps << '\n';
	}
	return 0;
}