#include <bits/stdc++.h>

using namespace std;

set<int> s;

int main()
{
	int n, x;
	
	cin >> n;
	while(n--){
		cin >> x;
		s.insert(x);
	}
	
	cout << s.size();
	
	return 0;
}