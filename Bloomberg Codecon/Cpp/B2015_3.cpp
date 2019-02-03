/*
 * Author: DLo930
 * Date: 11/22/18
*/

#include <iostream>

using namespace std;

/* 0 1 2 3 4 5 6 7 8 9
0: 0 0 0 0 1 0 1 0 0 0
1: 0 0 0 0 0 0 1 0 1 0
2: 0 0 0 0 0 0 0 1 0 1
3: 0 0 0 0 1 0 0 0 1 0
4: 1 0 0 1 0 0 0 0 0 1
5: 0 0 0 0 0 0 0 0 0 0
6: 1 1 0 0 0 0 0 1 0 0
7: 0 0 1 0 0 0 1 0 0 0
8: 0 1 0 1 0 0 0 0 0 0
9: 0 0 1 0 1 0 0 0 0 0

Soln: adjMtx^n
*/

void mtxMult(int A1[][10], int A2[][10]) {
	int res[10][10];
	for(int i=0;i<10;i++) {
		for(int j=0;j<10;j++) {
			int dotProd = 0;
			for(int k=0;k<10;k++) {
				dotProd += A1[i][k] * A2[k][j];
			}
			res[i][j] = dotProd;
		}
	}
	
	//A1 = res
	for(int i=0;i<10;i++)
		for(int j=0;j<10;j++)
			A1[i][j] = res[i][j];
}

int soln[11];	//{0,0,0,0,3,0,22,0,128,0,696}

void preCompute() {
	int A[][10] =  {{0,0,0,0,1,0,1,0,0,0},
					{0,0,0,0,0,0,1,0,1,0},
					{0,0,0,0,0,0,0,1,0,1},
					{0,0,0,0,1,0,0,0,1,0},
					{1,0,0,1,0,0,0,0,0,1},
					{0,0,0,0,0,0,0,0,0,0},
					{1,1,0,0,0,0,0,1,0,0},
					{0,0,1,0,0,0,1,0,0,0},
					{0,1,0,1,0,0,0,0,0,0},
					{0,0,1,0,1,0,0,0,0,0}};
	int res[10][10];
	for(int i=0;i<10;i++)
		for(int j=0;j<10;j++)
			res[i][j] = A[i][j];
	
	for(int i=2;i<=10;i++) {
		mtxMult(res, A);
		soln[i] = res[1][9];
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	preCompute();
	
	int n;
	cin >> n;
	cout << soln[n] << '\n';
	
	return 0;
}
