HAL 드라이버의 HAL_Delay() 로 1ms 딜레이를 줄려고 할 때

실제 측정 결과 2ms 나오는 오류 확인

기본 함수를 확인해본 결과 최소 주기를 보장하기 위한 코드가 있는 것으로 확인함.

__weak void HAL_Delay(__IO uint32_t Delay)
{
  uint32_t tickstart = HAL_GetTick();
  uint32_t wait = Delay;
  
  /* Add a period to guarantee minimum wait */
  if (wait < HAL_MAX_DELAY)
  {
     wait++;
  }
  
  while((HAL_GetTick() - tickstart) < wait)
  {
  }
}


위 코드에서 wait++ 해주는 부분으로 보아 최소 주기를 보장하기 위한 것으로 확인

__weak void HAL_IncTick(void)
{
  uwTick++;
}
 
__weak uint32_t HAL_GetTick(void)
{
  return uwTick;
}
또한 위 함수에서  uwTick을 Systick 타이머 인터럽트에서 증가시키는 것을 확인.




그러하여 위 코드들을 아래와 같이 수정 하며
us 시간을 측정하기 위한 delay_us() 함수 역시 추가.

extern __IO uint32_t uwTick;
 
uint32_t micros() {
  return (uwTick&0x3FFFFF)*1000 + (SYSTICK_LOAD-SysTick->VAL)/SYS_CLOCK;
}
 
void HAL_Delay(__IO uint32_t Delay) {
  uint32_t tickstart = HAL_GetTick();
 
  while((HAL_GetTick() - tickstart) < Delay);
}
 
void delay_us(uint32_t us) {
  uint32_t temp = micros();
  uint32_t comp = temp + us;
  uint8_t  flag = 0;
  while(comp > temp){
    if(((uwTick&0x3FFFFF)==0)&&(flag==0)){
      flag = 1;
    }
    if(flag) temp = micros() + 0x400000UL * 1000;
    else     temp = micros();
  }
}



실제 원하는 것처럼 작동하는 지 확인 할 예정.

