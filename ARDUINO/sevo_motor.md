/*
 제목 :  서보 모터 제어하기
 내용 :  ""
 */
 
 //////////// 180도 갔다 다시 -180도

#include<Servo.h> //서보 라이브러 불러오기

Servo myservo; // 서보를 제어할 서브 오브젝트 생성

int pos=0; // 서보 위치를 저장할 변수

void setup()
{
  myservo.attach(9,1000,2000);//핀 9번의 서보를 서보 오브젝트에 연결
}

void loop()
{
  for(pos=0;pos<180;pos+=1) // 0도에서 180도로 이동
  { // 이동할때 각도는 1도씩 이동
    myservo.write(pos); //pos변수의 위치로 서보를 이동
    delay(15); 
  }
  for(pos=180;pos>=1;pos-=1);//180도에서 0도로 이동
  {
    myservo.write(pos);
    delay(15);
  }
}





//////////////////////////////////////////  360 도 계속 돌리기

#include <Servo.h> //서보 라이브러리를 불러옵니다.
 
Servo myservo;  // 서보를 제어할 서보 오브젝트를 만듭니다.
               
int pos = 0;     // 서보 위치를 저장할 변수를 선언합니다.

void setup() 
{ 
  myservo.attach(9);  // 핀 9의 서보를 서보 오브젝트에 연결합니다.
} 
 
 
void loop() 
{ 
 
  myservo.write(0);
  delay(1000);
  
  
} 
