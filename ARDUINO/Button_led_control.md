/*
 제목 :  push 버튼으로 led 켜기
 내용 :  push 버튼으로 led 제어
 */

const int button1Pin=2;
//버튼을 디지털 2번 핀에 연결
const int ledPin=11;
//led를 디지털 13번 핀에 연결

void setup() {
    pinMode(button1Pin,INPUT);
    //2번 핀을 입력 핀으로 설정
    pinMode(ledPin,OUTPUT);  
    //13번 핀을 출력 핀으로 설정
}

void loop() {
  //setup()함수 호출 이후 loop()함수 호출되며,
  //블록안 코드 무한 반복

  int button1Sate= digitalRead(button1Pin);
  //버튼의 눌림 여부 상태를 읽어와 앞 변수에 저장
  
   if(button1Sate==LOW)
   {
    //버튼이 눌렸으면
    digitalWrite(ledPin,HIGH);
    }
   else{
    //버튼이 안눌렸으면
    digitalWrite(ledPin,LOW);
    }
}
