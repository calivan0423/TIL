
참고 논문 https://www.mdpi.com/1996-1073/10/3/315/htm

An Autonomous Coil Alignment System for the Dynamic Wireless Charging of Electric Vehicles to Minimize Lateral Misalignment


Karam Hwang 1, Jaeyong Cho 1, Dongwook Kim 1, Jaehyoung Park 1, Jong Hwa Kwon 2,

Sang Il Kwak 2, Hyun Ho Park 3 and Seungyoung Ahn 1,*


횡방향 정렬 불량으로 인한 문제를 최소화 하기 위하여 횡방향 정렬 오차를 최대화하는 방안

코일의 기하학적 변경, 직교 구성, 중복 구성, 다른 형상의 여러 코일을 하나의 단위로 결합

강자성 재료의 활용 , E or U 자형 페라이트 코어

측면 공차를 최대화->능동 코일 공진 주파수 튜닝 회로 포함


-> 그러나 차량의 설치 공간, 중량 제약 및 동적 주행 환경으로 인한 구현에 많은 제한 사항


코일 사이의 오정렬은 센서를 사용하여 감지, 차량의 위치는 DWC(dynamic wireless charging)에서 저하된 동력 전달이 최적의 수준으로 복원될 때ᄁᆞ지 적절한 자율 조향에 의해 조정


차량 자기 추적 방법

GPS

RFID, 자기마커 -> 거리에 따라 자기장 강도의 급격한 감소

자율 코일 정렬 시스템(ACAS)


ACAS

차량 부하 코일의 전압만 측정하여 차량의 정렬 불량 위치를 추적하는 방법

외부 마그네틱이나 RFID 마커가 없어 자기 추적 기능에 대한 구현 비용 감소

load 코일이 소스 코일의 중심에 비례하여 왼/오 방향으로 잘못 정렬 되었는지 여부를 결정하는 방법이 주요 과제 -> 2개의 센서 코일의 전압 판독값의 차이를 계산하여 좌/우측 위치를 검출


단일 센서 코일 유닛으로 전압 위상의 변화를 감지하여 두 센서 코일 사이의 전압 차이가 아닌 좌우측 위치를 식별가능.


DWC(Dynamic Wireless Charge) 시스템에서의 횡방향 오정렬에 따른 전력손실 분석


General circuit model for wireless power transfer (WPT).

PS=I1VS=⎛⎝((RL+1jωCL+jωLL) / jωM) I2⎞⎠VS

(2)

PL=I2VL=I22RL=⎛⎝jωM / (RL+1jωCL+jωLL) I1⎞⎠2RL


RS, CS, LS는 각각 소스 코일의 저항기, 커패시터 또는 인덕터 구성요소를 나타내고, RL, CL, LL은 각각 로드 코일의 저항기, 커패시터 또는 인덕터 구성요소를 나타낸다. ω은 주파수를 나타내고, I1, I2는 각각 소스 코일과 로드 코일의 흐름을 나타낸다. M은 소스 코일과 로드 코일의 상호 인덕턴스

M=k√LSLL . where k is a coupling coefficient.



Concept of the Autonomous Coil Alignment System (ACAS)


Block diagram of the ACAS.


횡방향 정렬 불량 위치는 센서 코일 유닛에 의해 추정되며, 횡방향 정렬 불량 감지 유닛에 의해 추가로 처리된다. 감지된 횡방향 정렬 불량에 기초하여 퍼지 조향 컨트롤러는 전자식 파워 스티어링 시스템(EPS)에 조향 명령을 전송하고, 그 후 차량이 자동으로 조향되어 오정렬을 수정한다.

최대 충전 경로를 방해하는 장애물이 존재하는 경우 사용자는 ACAS 작동을 방해할 수 있어야 한다.





변환된 센서 코일 논리 신호인 Vse'와 변환된 부하 코일 논리 신호인 VL'을 XOR 게이트로 보내는데, 여기서 두 신호를 서로 비교하여 왼쪽 또는 오른쪽 측면 위치를 결정

y={−f(VL) if LP=HI

f(VL) if LP=LO

﻿
