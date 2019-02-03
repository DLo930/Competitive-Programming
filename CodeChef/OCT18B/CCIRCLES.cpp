/*
 * Author: DLo930
 * Date: 10/14/18
*/

#include <algorithm>
#include <iostream>
#include <cmath>
#include <vector>

using namespace std;

pair<double, double> dist(int x1, int y1, int r1, int x2, int y2, int r2) {
	double d = sqrt(pow(x2-x1, 2) + pow(y2-y1, 2)), min, max;
	min = (abs(r1-r2) <= d && d <= r1+r2) ? 0 :		//circles intersect
		  (r1+r2 < d) ? d-r1-r2 : 					//circles are apart
		  (d+r1 < r2) ? r2-d-r1 : r1-d-r2;			//one circle in the other
	max = d+r1+r2;
	pair<double, double> p(min, max);
	return p;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	int n, q;
	cin >> n >> q;
	int circles[n][3];
	for(int i=0;i<n;i++)
		for(int j=0;j<3;j++)
			cin >> circles[i][j];
	
	int p = n*(n-1)/2;
	vector<double> mins, maxes;
	for(int i=0;i<n;i++) {
		for(int j=i+1;j<n;j++) {
			pair<double, double> tmp = dist(circles[i][0],circles[i][1],circles[i][2],circles[j][0],circles[j][1],circles[j][2]);
			mins.push_back(tmp.first);
			maxes.push_back(tmp.second);
		}
	}
	sort(mins.begin(), mins.end());
	sort(maxes.begin(), maxes.end());
	
	vector<int> arr((int)1e6+1);
	int i = 0, j = 0, cnt = 0;
	for(int k=0;k<(int)1e6+1;k++) {
		while(i < p && mins[i] <= k) {
			cnt++;
			i++;
		}
		while(j < p && maxes[j] < k) {
			cnt--;
			j++;
		}
		arr[k] = cnt;
	}
	
	int query;
	while(q--) {
		cin >> query;
		cout << arr[query] << '\n';
	}
	return 0;
}
