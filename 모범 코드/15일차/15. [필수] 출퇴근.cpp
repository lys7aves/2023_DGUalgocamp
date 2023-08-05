#include <bits/stdc++.h>

using namespace std;

set<string> s;

int main()
{
	int n;
	string name, status;
	
	cin >> n;
	while(n--){
		cin >> name >> status;
		
		if(status == "enter") s.insert(name);
		else s.erase(name);
	}
	
	cout << s.size() << '\n';
	for(auto name: s) cout << name << '\n';
	
	return 0;
}