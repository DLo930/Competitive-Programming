/*
 * Author: DLo930
 * Date: 12/14/18
*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

const int lim = (int)1e6;
vector<int> primes;

void sieve() {
	bool prime[lim+1];
	fill(prime, prime+lim, 1);
	
	for(int i=2;i<=lim;i++)
		if(prime[i])
			for(int j=2*i;j<=lim;j+=i)
				prime[j] = 0;
	
	for(int i=2;i<=lim;i++)
		if(prime[i])
			primes.push_back(i);
}

void pFactorize(int n) {
	int idx = 0, p;
	vector<int> b, e;
	while(n > 1) {
		p = primes[idx++];
		int cnt = 0;
		while(n%p == 0) {
			n /= p;
			cnt++;
		}
		if(cnt > 0) {
			b.push_back(p);
			e.push_back(cnt);
		}
	}
	cout << b[0] << '^' << e[0];
	for(size_t i=1;i<b.size();i++)
		cout << " + " << b[i] << '^' << e[i];
	cout << '\n';
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	sieve();
	
	int t, tmp;
	cin >> t;
	while(t--) {
		cin >> tmp;
		pFactorize(tmp);
	}
	
	return 0;
}
