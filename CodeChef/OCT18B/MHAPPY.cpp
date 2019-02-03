/*
 * Author: DLo930
 * Date: 10/12/18
*/

#include <cmath>
#include <iostream>
#include <queue>
#include <utility>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	int n;
	long long m;
	cin >> n >> m;
	vector<long long> a(n);
	for(int i=0;i<n;i++) cin >> a[i];
	
	priority_queue<pair<long long, int>> pq;
	int b;
	for(int i=0;i<n;i++) {
		cin >> b;
		pair<long long, int> p(b*a[i], b);
		pq.push(p);
	}
	while(m > 0 && pq.size() > 0) {
		pair<long long, int> p = pq.top();
		pq.pop();
		long long tmp = min((long long)ceil((p.first - pq.top().first)/(double)p.second), m);
		if(tmp == 0) tmp = 1;
		m -= tmp;
		p.first -= p.second * tmp;
		if(p.first > 0) pq.push(p);
	}
	cout << pq.top().first << '\n';
	
	return 0;
}
