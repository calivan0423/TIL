
먼저 lcd를 알맞게 보드에 연결



// LCD 주소확인

#include <Wire.h>

void setup()
{
  Wire.begin();

  Serial.begin(9600);
  while(!Serial);
  Serial.println("\n12C Scanner");
  
}


void loop()
{
  byte error,address;
  int nDevices;
  Serial.println("Scanning....");
  nDevices=0;
  for(address=1;address<127;address++)
  {
    Wire.beginTransmission(address);
    error=Wire.endTransmission();

    if(error==0)
    {
      Serial.print("12c device found at address0x");
      if(address<16);
      Serial.print("0");
      Serial.print(address,HEX);
      Serial.println("!");
      nDevices++;
    }
    else if(error==4)
    {
      Serial.print("Unknow error at address 0x");
      if(address<16)
        Serial.print("0");
      Serial.println(address,HEX);
    }
  }

  if(nDevices==0)
    Serial.println("no 12c devices found\n");
  else
    Serial.println("done\n");
  delay(5000);
}



![image](https://user-images.githubusercontent.com/43804441/54527733-1ff0cf00-49be-11e9-9f8c-56b42ef1f0e1.png)
