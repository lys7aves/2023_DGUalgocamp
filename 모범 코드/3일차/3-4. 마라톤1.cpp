#include <stdio.h>
#include <algorithm>

using namespace std;

int x[100000], y[100000];

int d(int p, int q)
{
    return abs(x[p]-x[q]) + abs(y[p]-y[q]);
}

int main()
{
    int n, i, D=0, maxi=0, l1, l2, l3;
    
    scanf("%d", &n);
    for(i=0; i<n; i++)
        scanf("%d %d", &x[i], &y[i]);
        
    for(i=1; i<n; i++){
        D += d(i,i-1);
    }
    
    for(i=1; i<n-1; i++){
        l1 = d(i-1, i);
        l2 = d(i, i+1);
        l3 = d(i-1, i+1);
        
        maxi = max(maxi, l1+l2-l3);
    }
    
    printf("%d", D-maxi);
    
    return 0;
}