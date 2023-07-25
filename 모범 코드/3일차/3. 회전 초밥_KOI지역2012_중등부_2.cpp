#include <bits/stdc++.h>
using namespace std;
int cb[30005];
int ch[30005];
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); 
    cout.tie(NULL);
    int n,d,k,c;
    cin>>n>>d>>k>>c;

    int ccheck=1;
    for(int i=0;i<n;i++)
    {
        cin>>cb[i];
    }
    int ans=0;
    for(int i=0;i<n;i++)
    {
    //    cout << i << ": " << flush;

        int val=0;
        for(int j=i;j<i+k;j++)
        {
            //cout << j << " " << flush;

            
            if(ch[cb[j%n]]!=1)
            {
                ch[cb[j%n]]=1;
                val++;
                
            }
            if(cb[j%n]==c)
            {
                ccheck=0;
            }
        }
        //cout<<"\n";
        ans=max(ans,val+ccheck);
        ccheck=1;
        memset(ch,0,sizeof(ch));
    }
    cout<<ans;
}