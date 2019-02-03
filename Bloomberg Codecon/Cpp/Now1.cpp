//Problem        : Passport Control
//Language       : C++14
//Compiled Using : g++
//Version        : GCC 4.9.1
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

#include <bits/stdc++.h>

using namespace std;

int avail(vector<int> load, vector<int> cd) {
    for(size_t i=0;i<load.size();i++)
        if(load[i] == 0 && cd[i] == 0)
            return i;
    return -1;
}

int main() {
    int n, m;
    cin >> n >> m;
    
    vector<int> arr;
    for(int i=0;i<m;i++) {
        int tmp;
        cin >> tmp;
        arr.push_back(tmp);
    }
    
    vector<int> load;
    for(int i=0;i<n;i++) load.push_back(0);
    
    vector<int> cd;
    for(int i=0;i<n;i++) cd.push_back(0);
    
    int groups[n];
    for(int i=0;i<n;i++) groups[i] = 0;
    
    while(arr.size() > 0) {
        int next;
        while((next = avail(load, cd)) != -1 && arr.size() > 0) {
            int curr = arr[0];
            arr.erase(arr.begin());
            load[next] = curr;
        }
        for(int i=0;i<n;i++) {
            if(load[i] > 0) {
                load[i]--;
                if(load[i] == 0) {
                	groups[i]++;
                	if(groups[i]%10 == 0) cd[i] = 6;
                }
            }
            cd[i] = max(cd[i]-1, 0);
        }
        cout << "L: ";
        for(int i=0;i<n;i++) cout << load[i] << ' ';
        cout << '\n';
        cout << "G: ";
        for(int i=0;i<n;i++) cout << groups[i] << ' ';
        cout << '\n';
    }
	for(int i=0;i<n;i++) {
		if(load[i] > 0) groups[i]++;
	}
	for(int i=0;i<n-1;i++) cout << groups[i] << ' ';
    cout << groups[n-1] << '\n';
    return 0;
}