/*
 * Author: DLo930
 * Date: 10/28/18
*/

#include <iostream>
#include <vector>

using namespace std;

void mergeArr(vector<int> &arr, int l, int m, int r) {
	int tmp[r-l+1];
	int i=l, j=m+1, k=0;
	while(i <= m && j <= r)
		tmp[k++] = (arr[i] < arr[j]) ? arr[i++] : arr[j++];
	while(i <= m) tmp[k++] = arr[i++];
	while(j <= r) tmp[k++] = arr[j++];
	for(int x=0;x<r-l+1;x++) arr[x+l] = tmp[x];
}
void mergeSort(vector<int> &arr, int l, int r) {
	if(l < r) {
		int m = (l+r)/2;
		mergeSort(arr, l, m);
		mergeSort(arr, m+1, r);
		mergeArr(arr, l, m, r);
	}
}

int binSearch(vector<int> &arr, int l, int r, int q) {
	while(l <= r) {
		int m = (l+r)/2;
		if(arr[m] == q) return m;
		if(arr[m] < q) l = m+1;
		else r = m-1;
	}
	return -1;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	int n;
	cin >> n;
	vector<int> arr(n);
	for(int i=0;i<n;i++) cin >> arr[i];
	
	mergeSort(arr, 0, n-1);
	
	int Q, q;
	cin >> Q;
	while(Q--) {
		cin >> q;
		bool done = false;
		for(int i=0;i<n;i++) {
			int j = binSearch(arr, i+1, n-1, q-arr[i]);
			if(j != -1) {
				done = true;
				break;
			}
		}
		cout << ((done) ? "Exists.\n" : "Doesn't exist.\n");
	}
	
	return 0;
}