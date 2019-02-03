/*
 * Author: DLo930
 * Date: 11/04/18
*/

#include <iostream>
#include <vector>

using namespace std;

const int lim = 41;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	vector<int> arr;
	for(int i=1;i<=lim;i++) {
		if(i*i % 41 == 2) arr.push_back(i);
	}
	for(unsigned int i=0u;i<arr.size();i++) cout << arr[i] << ((i == arr.size()-1) ? '\n' : ' ');
	
	return 0;
}
