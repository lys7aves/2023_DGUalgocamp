#include <bits/stdc++.h>
using namespace std;

int n,k,arr[55],sum,ans;
char c[55];
pair<int,int> p[10005];

void f(int a){
    if(a==n+1){
        sum=0;
        for(int i=0;i<k;i++){
            if(c[i]=='S'){
                if(arr[p[i].first]!=arr[p[i].second]){
					return;
                }
            }
            else{
                if(arr[p[i].first]==arr[p[i].second]){
                    return;
                }
            }
        }
        ans++;
        
        
        return;
    }
    for(int i=1;i<=3;i++){
        arr[a]=i;
        f(a+1);
    }
}

int main()
{
    cin>>n>>k;
    for(int i=0;i<k;i++){
        cin>>c[i]>>p[i].first>>p[i].second;
    }
    f(1);
    cout<<ans;
}