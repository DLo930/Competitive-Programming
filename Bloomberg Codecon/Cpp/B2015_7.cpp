/*
 * Author: DLo930
 * Date: MM/DD/YY
*/

#include <iostream>


using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	int r, c, n;
	cin >> r >> c >> n;
	int arr[r][c];
	for(int i=0;i<r;i++)
		for(int j=0;j<c;j++)
			arr[i][j] = 0;
	
	int row, col;
	while(n--) {
		cin >> row >> col;
		arr[row][col] = 1;
	}
	for(int i=0;i<r;i++) {
		for(int j=0;j<c;j++) {
			cout << arr[i][j] << ' ';
		}
		cout << '\n';
	}
	
	return 0;
}
