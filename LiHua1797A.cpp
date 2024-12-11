#include <bits/stdc++.h>
int T,n,m,x1,x2,y1,y2;
using namespace std;
int f(int x,int y){
    if((x == 1 || x == n) && (y == 1 || y == m)) return 2; //in the corner
    if(x == 1 || x == n || y == 1 || y == m) return 3;
    return 4;
}
int main() {
    
	for(scanf("%d", &T);T;T--) {
		scanf("%d%d%d%d%d%d", &n, &m, &x1, &y1, &x2, &y2);
		printf("%d\n", min(f(x1, y1), f(x2, y2)));
	}
	return 0;
}