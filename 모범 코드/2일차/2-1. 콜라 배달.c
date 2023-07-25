#include <stdio.h>

int main()
{
    int n;
    
    scanf("%d", &n);
    
    if(n%5 == 0) printf("%d", n/5);
    else if(n%5 == 1){
        if(n == 1) printf("-1");
        else printf("%d", n/5+1);
    }
    else if(n%5 == 2){
        if(n < 12) printf("-1");
        else printf("%d", n/5+2);
    }
    else if(n%5 == 3) printf("%d", n/5+1);
    else if(n%5 == 4){
        if(n == 4) printf("-1");
        else printf("%d", n/5+2);
    }
    return 0;
}