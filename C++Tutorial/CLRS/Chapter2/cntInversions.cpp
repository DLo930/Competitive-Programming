/*
 * Author: DLo930
 * Date: 10/27/18
*/

#include <iostream>
#include <vector>

using namespace std;

int inv = 0;

void mergeArr(vector<int> &arr, int l, int m, int r) {
	int tmp[r-l+1];
	int i = l, j = m+1, k = 0;
	while(i <= m && j <= r) {
		if(arr[i] > arr[j]) {
			tmp[k++] = arr[j++];
			inv += m+1 - i;
		}
		else
			tmp[k++] = arr[i++];
	}
	while(i <= m) tmp[k++] = arr[i++];
	while(j <= r) tmp[k++] = arr[j++];
	
	for(int i=l;i<=r;i++)
		arr[i] = tmp[i-l];
}
void mergeSort(vector<int> &arr, int l, int r) {	//[l,r]
	if(l < r) {
		int m = (l+r)/2;
		mergeSort(arr, l, m);
		mergeSort(arr, m+1, r);
		mergeArr(arr, l, m, r);
	}
}

int bruteForceCntInv(vector<int> &arr) {
	int n = arr.size(), cnt = 0;
	for(int i=0;i<n;i++)
		for(int j=i+1;j<n;j++)
			if(arr[i] > arr[j])
				cnt++;
	return cnt;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	int n;
	cin >> n;
	vector<int> arr(n);
	for(int i=0;i<n;i++)
		cin >> arr[i];
	
	cout << "Brute Force: " << bruteForceCntInv(arr) << '\n';
	mergeSort(arr, 0, n-1);
	cout << "MergeSort: " << inv;
	
	return 0;
}
