/*
 * Author: DLo930
 * Date: 11/22/18
*/

#include <iostream>
#include <stack>
#include <vector>

using namespace std;

struct Point {
	int i;
	int j;
	Point(int i, int j):
		i(i), j(j)
	{}
};

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	int r, c;
	cin >> r >> c;
	
	string maze[r];
	for(int i=0;i<r;i++)
		cin >> maze[i];
	
	bool visited[r][c];
	for(int i=0;i<r;i++)
		for(int j=0;j<c;j++)
			visited[i][j] = false;
	
	stack<Point> s;
	s.emplace(1, 0);
	bool done = false;
	vector<Point> res;
	while(!s.empty()) {
		Point curr = s.top();
		visited[curr.i][curr.j] = true;
		if(curr.i == r-2 && curr.j == c-1) done = true;
		if(!done) {
			if(curr.j < c-1 && !visited[curr.i][curr.j+1] && maze[curr.i][curr.j+1] == '_') s.emplace(curr.i, curr.j+1);
			else if(curr.i > 0 && !visited[curr.i-1][curr.j] && maze[curr.i-1][curr.j] == '_') s.emplace(curr.i-1, curr.j);
			else if(curr.j > 0 && !visited[curr.i][curr.j-1] && maze[curr.i][curr.j-1] == '_') s.emplace(curr.i, curr.j-1);
			else if(curr.i < r-1 && !visited[curr.i+1][curr.j] && maze[curr.i+1][curr.j] == '_') s.emplace(curr.i+1, curr.j);
			else s.pop();	
		}
		else {
			res.push_back(curr);
			s.pop();
		}
	}
	for(vector<Point>::reverse_iterator it = res.rbegin(); it != res.rend(); it++)
		cout << (*it).i << ',' << (*it).j << '\n';
	
	return 0;
}
