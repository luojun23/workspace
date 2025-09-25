#include <bits/stdc++.h>
using namespace std;

void go(){
	int a,k;
	cin>>a>>k;
	if(k>a){
		cout<<k-a<<endl;
	}else{
		if((a-k)%2==0){
			cout<<0<<endl;
		}else{
			cout<<1<<endl;
		}
	}
}


int main(){
	int x;
	cin>>x;
	while(x--){
		go();
	}
	return 0;
} 
