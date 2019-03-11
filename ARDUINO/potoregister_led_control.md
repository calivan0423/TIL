/*
 제목 :  포토 레지스터로 LED 밝기 조절
 내용 :  ""
 */

const int sensorPin=A0;
//버튼을 아날로그 0번 핀에 연결
const int ledPin=11;
//led를 디지털 11번 핀에 연결
int lightLevel;

void setup() {
    pinMode(ledPin,OUTPUT);  
    //13번 핀을 출력 핀으로 설정
}

void loop() {
  //setup()함수 호출 이후 loop()함수 호출되며,
  //블록안 코드 무한 반복

  lightLevel=analogRead(sensorPin);
  manualTune();
  //led 밝기 조절 함수
  analogWrite(ledPin,lightLevel);
}

void manualTune(){
  //밝기 정하기
  lightLevel=map(lightLevel,0,150,0,300);
  //0~150범위에 있는 lightLevel를 0~255로 제한
  lightLevel=constrain(lightLevel,0,300);
}
