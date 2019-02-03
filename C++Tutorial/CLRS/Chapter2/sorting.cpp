/*
 * Author: DLo930
 * Date: 10/26/18
*/

#include <iostream>
#include <vector>

using namespace std;
/*
 * Note: Binary search cannot be used to optimize insertion
 *		 sort since elements greater than curr must still
 *		 be shifted to the right; O(n) for each curr
*/
void insertionSort(vector<int> &arr) {
	int n = arr.size(), curr, j;
	for(int i=1;i<n;i++) {
		curr = arr[i];
		j = i-1;
		while(j >= 0 && arr[j] > curr) {
			arr[j+1] = arr[j];
			j--;
		}
		arr[j+1] = curr;
	}
}

void recInsertionSort(vector<int> &arr, unsigned int i) {
	if(i != arr.size()) {
		int curr = arr[i], j = i-1;
		while(j >= 0 && arr[j] > curr) {
			arr[j+1] = arr[j];
			j--;
		}
		arr[j+1] = curr;
		recInsertionSort(arr, i+1);
	}
}

//Merging two sorted subarrays in O(n)
void mergeArr(vector<int> &arr, int l, int m, int r) {
	int tmp[r-l+1];
	int i = l, j = m+1, k = 0;
	while(i <= m && j <= r)
		tmp[k++] = (arr[i] < arr[j]) ? arr[i++] : arr[j++];
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

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	int n;
	cin >> n;
	vector<int> arr(n);
	for(int i=0;i<n;i++) cin >> arr[i];
	
	recInsertionSort(arr, 1U);
	
	for(int i=0;i<n;i++) cout << arr[i] << ((i < n-1) ? ' ' : '\n');
	
	return 0;
}
