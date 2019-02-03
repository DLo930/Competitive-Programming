/*
 * Author: DLo930
 * Date: 10/21/2018
*/

#include <iostream>
#include <iomanip>
#include <vector>

using namespace std;

int m1, n1, m2, n2;

void mtxMult(vector<vector<int>> mtx1, vector<vector<int>> mtx2) {
	for(int i=0;i<m1;i++) {
		for(int j=0;j<n2;j++) {
			int sum = 0;
			for(int k=0;k<n1;k++) {
				sum += mtx1[i][k] * mtx2[k][j];
			}
			cout << left << setw(5) << sum;
		}
		cout << '\n';
	}
}

int main() {	
	cin >> m1 >> n1;
	vector<vector<int>> mtx1(m1);
	
	for(int i=0;i<m1;i++) {
		for(int j=0;j<n1;j++) {
			int tmp;
			cin >> tmp;
			mtx1[i].push_back(tmp);
		}
	}
	
	cin >> m2 >> n2;
	if(n1 != m2) {
		cout << "n1 and m2 must be equal!\n";
		return 0;
	}
	vector<vector<int>> mtx2(m2);
	for(int i=0;i<m2;i++) {
		for(int j=0;j<n2;j++) {
			int tmp;
			cin >> tmp;
			mtx2[i].push_back(tmp);
		}
	}
	mtxMult(mtx1, mtx2);
	
	return 0;
}
