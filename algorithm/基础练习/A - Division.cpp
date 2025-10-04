#include<bits/stdc++.h>
#include<iostream>
using namespace std;

void go(int a){
	int flag = 0;
	for(int i = 1234;i<=98765;++i){//分母 
		int j = a*i;//分子
		int used[10] = {0};
		bool valid = true;
		if(i<10000){
			used[0] = 1;
		}
		int tempi = i,tempj = j;
		//验证分母
		while(tempi!=0){
			int x = 10;
			if(used[tempi%x]!=0){
				valid = false;
				break; 
			}else{
				used[tempi%x]=1;
			}
			x*=10;
			tempi/=10;
		}
		if(!valid) continue;
		while(tempj!=0){
			int x = 10;
			if(used[tempj%x]!=0){
				valid = false;
				break; 
			}else{
				used[tempj%x]=1;
			}
			x*=10;
			tempj/=10;
		}
		if(!valid) continue;
		
		bool use = true;
		for(int i = 0;i<10;i++){
			if(used[i]!=1){
				use = false;
				break;
			}
		}
		if(use){
			flag = 1;	
            cout << setw(5) << setfill('0') << j 
                 << " / " 
                 << setw(5) << setfill('0') <<  i
                 << " = " << a << endl;
		}	
	}
	if(!flag){
		cout << "There are no solutions for " << a << "." << endl;
		cout<<endl; 
	}
}


int main(){
	int a;
	while(cin>>a&&a!=0){
		go(a);
	}
	return 0;
}
