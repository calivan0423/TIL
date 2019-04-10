/* 
 *  초음파 센서로 10cm 이내 물체 감지시 led 켜지기
 */


 // 초음파 센서 송신부를 8번 핀으로 선언 수신부는 9번 핀으로

 int trig=8;
 int echo=9;

 int led=3;

 void setup(){
  Serial.begin(9600);
  //시리얼 통신을 이용하기 위한 설정
  pinMode(trig,OUTPUT);
  pinMode(echo,INPUT);
  pinMode(led,OUTPUT);
 }

 void loop(){
  digitalWrite(trig,LOW);
  digitalWrite(echo,LOW);
  delayMicroseconds(2);
  digitalWrite(trig,HIGH);
  delayMicroseconds(10);
  digitalWrite(trig,LOW);

  unsigned long duration =pulseIn(echo,HIGH);
  float distance =duration /29.0/2.0 ;
  // 초음파의 속도는 초당 340미터 이동, 또는 29마이크로초당 1센치 이동
  // 따라서 초음파의 이동거리는 duration(왕복걸린시간)/29/2

  Serial.print(distance);
  Serial.println("cm");

  if(distance<30){
    digitalWrite(led,HIGH);
  }
  else{
    digitalWrite(led,LOW);
  }
  delay(200);
  
 }
