/*
 제목 :  서보 모터 제어하기
 내용 :  ""
 */

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
