#include <bits/stdc++.h>
using namespace std;

void go(){
	int i,target,sum;
	cin>>i;
	int arr[i];
	for(int j = 1;j<=i;j++){
		cin>>arr[j];
		sum+=arr[j];
	}
	target = sum*2/i;
	for(int j = 1;j<=i;j++){
		for(int k = j+1;k<=i;k++){
			if(arr[j]+arr[k]==target){
				cout<<j<<" "<<k<<endl;
				arr[j] = arr[k] = 0;
			}
		}
	}
}


int main(){
	go();
	return 0;
} 
