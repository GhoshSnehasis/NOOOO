#include <bits/stdc++.h>
#define rep(x,y,z) for(int x = (y); x <= (z);x++)

using namespace std;
const int N = 1e3 + 5;
int T,n,k,a[N][N];
int main(){
    for(scanf("%d",&T);T;T--){
        scanf("%d%d",&n,&k);
        rep(i,1,n) rep(j,1,n) scanf("%d",&a[i][j]);
        int diff = 0;
        rep(i,1,n) rep(j,1,n) if(a[i][j] != a[n+1-i][n+1-j]) ++diff;

        diff /= 2;
        if(diff > k) puts("NO");
        else{
            k -= diff;
            if(n & 1) puts("YES");
            else if(k & 1) puts("NO");
            else puts("YES");
        }
    }
    return 0;
}