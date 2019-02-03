/*
 * Author: DLo930
 * Date: 11/22/18
*/
/*
#include <fstream>
#include <iostream>
#include <vector>
*/
#include <bits/stdc++.h>

using namespace std;

vector<int> split(string s, string delim) {
	vector<int> arr;
	size_t prev = 0, curr;
	while((curr = s.find(delim, prev)) != string::npos) {
		arr.push_back(stoi(s.substr(prev, curr-prev)));
		prev = curr + 1;
	}
	arr.push_back(stoi(s.substr(prev)));
	return arr;
}

int main() {
	ifstream file("B2015_2.txt");
	
	size_t n;
	file >> n;
	bool sch[n+1][33];
	for(size_t i=1;i<=n;i++)
		for(size_t j=1;j<=32;j++)
			sch[i][j] = false;
	
	file.ignore(100, '\n');
	string line;
	while(getline(file, line)) {
		vector<int> arr = split(line, "-");
		if(arr.size() == 3) {
			bool valid = true;
			for(int i=arr[1];i<arr[1]+arr[2];i++) {
				if(sch[arr[0]][i]) {
					valid = false;
					break;
				}
			}
			if(valid) {
				for(int i=arr[1];i<arr[1]+arr[2];i++) {
					sch[arr[0]][i] = true;
				}
			}
			cout << (valid ? 'Y' : 'N') << '\n';
		}
		else {
			vector<int> avail;
			for(size_t i=1;i<=n;i++) {
				bool valid = true;
				for(int j=arr[0];j<arr[0]+arr[1];j++) {
					if(sch[i][j]) {
						valid = false;
						break;
					}
				}
				if(valid) {
					avail.push_back(i);
				}
			}
			for(size_t i=0;i<avail.size()-1;i++) {
				cout << avail[i] << ' ';
			}
			cout << avail[avail.size()-1] << '\n';
		}
	}
	return 0;
}
