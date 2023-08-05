#include <bits/stdc++.h>

using namespace std;

map<string, int> books;
int main()
{
	int n, maxi=0;
	string book;
	
	cin >> n;
	while(n--){
		cin >> book;
		
		if(books.find(book) == books.end()) books[book] = 0;
		books[book]++;
	}
	
	for(auto it: books){
		if(maxi < it.second){
			maxi = it.second;
			book = it.first;
		}
	}
	
	cout << book;
	
	return 0;
}