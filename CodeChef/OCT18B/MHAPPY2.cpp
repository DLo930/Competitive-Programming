/*
 * Author: DLo930
 * Date: 10/12/18
*/

#include <cmath>
#include <iostream>
#include <queue>
#include <utility>

#define ll long long

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	int n;
	ll sum = 0, m;
	cin >> n >> m;
	vector<ll> a(n), b(n);
	for(int i=0;i<n;i++) {
		cin >> a[i];
		sum += a[i];
	}
	for(int i=0;i<n;i++) cin >> b[i];
	
	priority_queue<pair<ll, int>, vector<pair<ll,int>>, greater<pair<ll,int>>> pq;
	pair<ll,int> tmp;
	for(int i=0;i<n;i++) {
		tmp(0,b[i]);
		pq.push(tmp);
	}
	
	ll missing = sum - m;
	pair<ll,int> p, q;
	while(missing > 0) {
		p = pq.top();
		pq.pop();
		q = pq.top();
		
		ll mult = min((ll)floor(q.second/p.second), m);
		p.first +=
		m--;
	}
	cout << pq.top().first << '\n';
		
	return 0;
}
