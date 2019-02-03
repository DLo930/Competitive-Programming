/*
 * Author: DLo930
 * Date: 10/27/18
*/

#include <iostream>
#include <vector>

using namespace std;

int binSearch(vector<int> &arr, int q) {
	int l = 0, r = arr.size()-1, m;
	while(l <= r) {
		m = (l+r)/2;
		if(arr[m] == q) return m;
		if(arr[m] < q) l = m+1;
		else r = m-1;
	}
	return -1;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	int N;
	cin >> N;
	vector<int> arr(N);
	for(int i=0;i<N;i++) cin >> arr[i];
	
	int Q, q;
	cin >> Q;
	while(Q--) {
		cin >> q;
		cout << binSearch(arr, q) << '\n';
	}
	return 0;
}
