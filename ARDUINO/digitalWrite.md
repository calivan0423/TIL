const int RED_PIN =13;
//빨간색을 13번
const int YELLO_PIN=12;
//노란색을 12번
const int BLUE_PIN=11;
//파란색을 11번


void setup() {
   Serial.begin(9600);
   pinMode(RED_PIN,OUTPUT);
   pinMode(YELLO_PIN,OUTPUT);
   pinMode(BLUE_PIN,OUTPUT);

}

void loop() {
  if(Serial.available()){
    int swt= (int)Serial.read();
    if(swt==49){
      digitalWrite(13,1);
      delay(1000);
      digitalWrite(13,0);
    }
    else if(swt==50){
      digitalWrite(12,1);
      delay(1000);
      digitalWrite(12,0);
   }
    else if( swt==51){
      digitalWrite(11,1);
      delay(1000);
      digitalWrite(11,0);
   }
    else{
     
      
      }
  }

}


///////////////////////////////////////////////////////////////////////




int ledPins[]={13,12,11};

void setup() {
   int index;
   for(index=0;index<=2;index++){
    pinMode(ledPins[index],OUTPUT);
   }

}

void loop() {
  oneAfterAnotherNoLoop();
  //반복분을 사용하지 않고 led를 하나씩 키는 함수
  oneAfterAnotherLoop();
  //반복문을 사용하여 led를 하나씩

}

void  oneAfterAnotherNoLoop(){
  //1.하나씩 켜지고 1초씩 일시정지, 거꾸로 하나씩

  digitalWrite(ledPins[0],1);
  delay(1000);
  digitalWrite(ledPins[1],1);
  delay(1000);
  digitalWrite(ledPins[2],1);
  delay(1000);
  digitalWrite(ledPins[2],0);
  delay(1000);
  digitalWrite(ledPins[1],0);
  delay(1000);
  digitalWrite(ledPins[0],0);
  delay(1000);
}

void oneAfterAnotherLoop(){
  int index;
  for(index=2;index>=0;index--){
    digitalWrite(ledPins[index],1);
    delay(1000);
  }
  for(index=0;index<=2;index++){
    digitalWrite(ledPins[index],0);
    delay(1000);
  }
}

