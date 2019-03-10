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
