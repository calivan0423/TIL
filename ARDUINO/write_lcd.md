/*
 * 12C LCD에 문자 출력하기
 */


 //LCD 제어를 위한 라이브러리 추가
 #include <LiquidCrystal_I2C.h>
 #include <Wire.h>

 //0x03F 주소를 가진 16*2 LCD 객체 생성
 LiquidCrystal_I2C lcd(0x03F,16,2);

 void setup()
 {
  lcd.init();
  lcd.backlight();
  
 }


void loop()
{
  int value=random(0,3);
  // 0~2까지 수 중 랜덤하게
  if(value==0)
  {
    lcd.setCursor(0,0); //0번째 줄 0번째 셀부터 입력
    lcd.print(" calivan");
  }
  else if(value==1)
  {
    lcd.setCursor(0,1);
    lcd.print(" YounBlog");
  }
  else if(value==2)
  {
    lcd.setCursor(0,0);
    lcd.print("calivan");
    lcd.setCursor(0,1);
    lcd.print("YoungBlog");
  }
  delay(1000);
  lcd.clear();
  
}
