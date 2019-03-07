

void setup() {
  // put your setup code here, to run once:
  // 초기 1회 실행
  Serial.begin(9600);  // 시리얼 통신 
  pinMode(13,OUTPUT);  // 13번 핀으로 출력
}

void loop() {
  // put your main code here, to run repeatedly:
  // 무한 루프
  if(Serial.available()){  // 시리얼에 값이 있으면
    int swt = (int)Serial.read();  // 시리얼에서 읽은 값을 swt로 저장
    if(swt==49){   // swt가 '정수 1'이면 ( 아스키코드로 1은 49)
      digitalWrite(13,1);  // 13번 핀 on ..?( 5v를 연결한다는 의미..?)
      delay(1000);    //  1초가 기다림
    }
    else                
