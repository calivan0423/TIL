자연수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.


#include <string>
#include <vector>
using namespace std;
int solution(int n) {
    int answer = 0;
    
    for(int i=1;i<=n;i++){
        if(n%i==0){
         answer+=i;
        }
    }    
    return answer;
}


for문으로 i 값을 1씩 증가시키며
n을 i로 나눈다. 나눈 나머지의 값이 0이면 i는 n의 약수 이므로
answer에 i를 차례대로 더한다.
