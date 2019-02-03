/*
 * Author: DLo930
 * Date: 11/21/18
*/

#include <iostream>
#include <algorithm>
#include <unordered_set>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	int n, pairs = 0;
	cin >> n;
	unordered_set<string> strSet;
	while(n--) {
		string tmp;
		cin >> tmp;
		string rev = tmp;
		reverse(rev.begin(), rev.end());
		
		if(tmp != rev) {
			if(strSet.find(rev) == strSet.end()) {	//reverse not in strSet
				strSet.insert(tmp);
			}
			else {
				strSet.erase(rev);
				pairs++;
			}
		}
	}
	cout << (strSet.empty() ? pairs : -1) << '\n';
	
	return 0;
}
