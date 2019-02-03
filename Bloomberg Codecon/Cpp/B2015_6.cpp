/*
 * Author: DLo930
 * Date: 11/24/18
*/

#include <bits/stdc++.h>

using namespace std;

struct Planet {
	int x, y, z;
	double rng;
	string name;
	Planet(int x, int y, int z, double rng, string name):
		x(x), y(y), z(z), rng(rng), name(name)
	{}
};

vector<string> split(string s, string delim) {
	vector<string> arr;
	size_t prev = 0, curr;
	while((curr = s.find(delim, prev)) != string::npos) {
		arr.push_back(s.substr(prev, curr-prev));
		prev = curr + 1;
	}
	arr.push_back(s.substr(prev));
	return arr;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	int n;
	cin >> n;
	vector<Planet> arr;
	for(int i=0;i<n;i++) {
		string line;
		cin >> line;
		vector<string> tmp = split(line, ",");
		arr.emplace_back(stoi(tmp[0]), stoi(tmp[1]), stoi(tmp[2]), stod(tmp[3]), tmp[4]);
	}
	
	vector<vector<int>> adjList(n, vector<int>());
	for(int i=0;i<n;i++) {
		for(int j=i+1;j<n;j++) {
			double d = pow(arr[j].x-arr[i].x, 2) + pow(arr[j].y-arr[i].y, 2) + pow(arr[j].z-arr[i].z, 2);
			if(pow(arr[i].rng, 2) >= d) adjList[i].push_back(j);
			if(pow(arr[j].rng, 2) >= d) adjList[j].push_back(i);
		}
	}
	for(vector<int> arr : adjList) {
		for(int i : arr) cout << i << ' ';
		cout << '\n';
	}
	
	return 0;
}
