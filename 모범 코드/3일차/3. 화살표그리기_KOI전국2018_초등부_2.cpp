#include <stdio.h>
#include <algorithm>

#define MAX 100000

using namespace std;

pair<int,int> p[5000];
int l[5000], last[5001];

int main()
{
    int n, i, sum=0;
    
    scanf("%d", &n);
    for(i=0; i<n; i++)
        scanf("%d %d", &p[i].first, &p[i].second);
    
    sort(p, p+n);
    
    for(i=1; i<=n; i++) last[i] = -MAX;
    for(i=0; i<n; i++){
        l[i] = p[i].first - last[p[i].second];
        last[p[i].second] = p[i].first;
    }
    
    for(i=1; i<=n; i++) last[i] = 2*MAX;
    for(i=n-1; i>=0; i--){
        l[i] = min(l[i], last[p[i].second]-p[i].first);
        last[p[i].second] = p[i].first;
    }
    
    for(i=0; i<n; i++){
        sum += l[i];
    }
    printf("%d", sum);
    
    return 0;
}