#include <bits/stdc++.h>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	int arr[5];
	for(int i=0;i<5;i++) {
		cin >> arr[i];
	}
	sort(arr, arr+5);
	for(int i=0;i<5;i++)
		cout << arr[i] << ' ';
	cout << "\n";
	return 0;
}