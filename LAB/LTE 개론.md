

이동통신 네트워크는 무선망과 코어망으로 구성.
lte네트워크의 무선망은 진화된 기지국(e-nodeB, eNB)로 구성, E-UTRAN이라 한다.
LTE에서는 코어망은 패키 네트워크만 구성되며 EPC(EVOLVED PACKET CORE)라고 한다.

EPC와 E-UTRAN을 포함한 것을 EPS.
.

LTE에서는 기지국 제어국이 없어 ENB간 핸드오버기능을 해결해야함으로, X2인터페이스가 추가ㄴ

핸드오버가 필요할경우 연결된 기지국은 핸드오버가 될 기지국으로 x2AP handover request 전송
타켓 기지국과 servingSGW간 GTP연결이 성립 / 타켓노드는 리소스를 할당하고 RACH 프리앰블 구성 과
CRNTI를 UE에게 할당........
https://www.slideshare.net/schwannden/lte-x2-interface 참고...

eNB간 X2인터페이스
    -LTE 구조에서 무선 자원 관리 용이
    -기지국 간 무선 자원 정보의 교환을 위한 시그널링
    - 핸드오버 데이터 및 명령 전달
S1_u 인터페이스
    사용자 데이터가 이를 통해 S-G/W에 연결
S1_MME 인터페이스
    코어망에 관련된 제어 시그널링이 이 인터페이스를 통해 MME로 연결


LTE는 EPS에서 동작하는 무선 기술이라는 의미.

네트워크의 구간별 시스템 간 신호 흐름 : 베어러 (bearer)
베어러는 제어신호 전달과 통화자 신호 전달의 용도로 구분.

통화자 신호흐름의 종류를 유저플레인이라하고, 제어신호흐름의 종류를 컨트롤 플레인이라고 한다.
LTE에서 컨트롤 플레인은 MME가, 유저플레인은 SGW가 관장한다.

LTE의 기본 베어러는 
휴대 전화와 기지국 간 제어 신호를 전송하는 SRB(SIGNALING RADIO bearer)
통화자 신호를 전송하는 DRB(DATA RADIO bearer)
휴대 전화와 통화 절차를 관장하는 코어 네트워크와의 제어 신호를 전송하는 RAB(RADIO ACCESS bearer)


전송의 신뢰성을 얻기 위하여 다음과 같은 절차 이용.

    1. 기지국에서 채널코딩된 데이터가 오면 휴대폰에서 에러를 복원하려는 FEC(forward error coreecting)절차
    2. FEC로 안되면 기지국에서 빠른 재전송 H-ARQ
    3. 여러번의 H-ARQ로 안되면 느린 재전송 ARQ로
    4. 여러번의 ARQ로 안되면 종단 서버에 재전(TCP/IP) 요구 


RRC 프로토콜
    LTE에서 가장 기본적인 프로토콜
        RRC_CONNECTED : 무선 자원 제어 연결 상태
            무선단말은 네트워크와 데이터를 송수신
            단말은 제어 채널을 모니터링
            네트워크 측이 주도적으로 핸드오버 수정
        RRC_IDLE : 무선 자원 제어 연결 안된 상태
            무선 단말은 오는 신호를 감지하기 위해 페이징 채널을 모니터링
            셀 정보를 얻고 이웃 셀 측정 및 셀 선택 수행
            무선 단말이 자율적으로 셀 재선택 가능

        위 두가지 모드를 반복.

LTE에서는 셀간 간섭을 줄이기 위하여ICIC기술이 제시
참고:https://www.netmanias.com/ko/post/blog/6362/lte-lte-a/interference-coordination-in-lte-lte-a-1-icic

각 셀은 자신에게 붙은 단말에 대해서만 알고 인접한 셀에 있는 단말들이 어떤 무선자원을
사용하지는 모르는 상태에서 독립적으로 무선 자원을 스케쥴링 하게 되어
셀 겹칩부분의 단말에 같은 주파수자원이 할당될 수 있기에
Inter-cell interference 발생

ICIC(Inter-cell interference coordination)은 lte시스템의 간섭제어 기술

인접한 셀들간 셀 경계에 있는 단말들이 서로 다른 주파수 자원을 사용함으써
셀간 간섭을 줄이는 기술.
기지국은 주파수 자원별로 간섭정보를 구성하고 이를 x2메세지를 통해 이웃 기지국과 교환
x2메세지를 수신한 기지국은 이웃 셀들의 간섭 상황을 파악하고 셀 간 간섭을 피하도록 
자신의 셀의 단말에 주파수를 할당.


lte의 다운링크 방식인 OFMD은 간섭을 피하기 위해 주파수 대역에 분산하여 송신신호를
전송하거나 호핑함으로써 간섭 신호에 대한 평균화 효과를 기대한다.
업링크는 SC-FDMA방식으로 전송되는데 신호가 한 몸체로 전송되어야 함으로 분산모드가 불가능하다.
그러므로 호핑모드를 사용한다.

이러한 호핑은 보안 목적이 아니라 간섭 신호를 평군화 하기위한 목적

위이 CICE를 사용하여 한 셀은 자신이 사용하는 부반송파의 목록을 인접셀에
보내어 사용 자제를 요청하지만
모든 부반송파를 한 셀에서 사용할 경우 효율성이 문제가 된다.
그러한 문제점을 해결하기 위하여 ECICE 사용.

ECICI는 주파수 축상이 아닌 시간 축상에서 양쪽 기지국의 신호가 겹치지 않게 한다. -> LTE-A에서


CoMP(COOPERATED MULTI POINT) : CICI가 기지국 단위의 셀 간 간섭 제어라면
COMP는 통화자의 개별적인 전파상황에 따라 매우 빠르게 제어하는 간섭 제어 기술 -> LTE-A에서 사용

JT-CoMP(JOINT TRANSMISSION)
    기지국의 전파 신호가 겹치는 곳의 휴대전화는 간섭을 유발하는 상대 기지국의 전파 상태를 보고
    이 보고를 받은 기지국은 상대 기지국과 마치 한 기지국에서 2개의 송신호의 의한 2*2MIMO 처럼 동작하려고 한다.
    양쪽의 기지국은 서로 다른 유저 데이터를 전송하고 휴대전화는 동시에 수신함으로서 다운링크 속도 증가
    (한쪽이 1,3,5,7 / 다른 쪽이 2,4,6,8...?)

    (소프트 핸드오버와 유사하지만 소프트 핸드오버는 동일한 데이터를 전송)

JS-CoMP
    JTCOMP는 양쪽 기지국에서 각기 다른 유저 데이터를 전송하지만
    JSCOMP는 양쪽 기지국의 안테나 빔포밍 방향을 서로 겹치지 않도록 제어해 간섭 최소화


옴니 안테나: 전파 방사 패턴이 균일한 원 모양의 등방성
    점 안테나 :  전파의 방사 패턴이 수직,수평의 지구본 모양으로 균등하게 방사
    다이폴 안테나 : 전파 방사 패턴이 위아래가 오목하게 들어간 사과모양

지형성 안테나 : 전파 방사 패턴이 특정 방향을 향하는 수평 방사 패턴
    안테나 이득 : 특정 방향으로 몇 배의 전파를 모아서 송신하는지를 나타내는 단위
            dBi : 점 안테나 대비 몇 배, dBd : 다이폴 안테나 대비 몇 배



휴대폰의 경우 지향성은 전파 품질의 편차가 크기 때문에 등방성 방사 패턴 이용
    -> 최대 출력 = 유효 방사 출력




lte-A  :  lte에 새로운 기술이 추가된 개념. Release 10부터 표준화

lte-A에 추가된 기술
    ca: 주파수 묶음에 의해 데이터 속도를 증가

    8*8 MIMO : 다중 안테나 기술

    Relay :  셀 내의 음영 지역 해소를 목적으로 사용
            셀 경계 지역에 릴레이를 설치하여 효과 적인 셀 커버리지 확장과 처리량을 향상.
            e-NodeB와 ue 간 통신 과정에 릴레이를 거쳐 통신
            릴레이는 백홀 링크에 있어 유선이 아닌 무선으로 새로은 eNodeB 필요 없음. 
            참고 : http://www.itfind.or.kr/WZIN/jugidong/1391/file27234-139103.pdf

            기지국의 여유 통화 용량을 무선 전용선처럼 활용하여 광케이블 전용선 설치를 줄일 수 있음.
        
        백홀 링크 :  데이터를 한 곳에 모아서 백본망에 전달 해주는 링크를 의미
    
    SON(SELF Organizing Network) : 자가 조직 네트워크
            네트워크가 스스로 셋업, 최적화, 고장 수리를 할 수 있는 기능을 정리
            이종 네트워크에서 펨토셀 기지국이 주변 기지국의 환경에 따라 이웃 셀 리스트를 독자적으로 결정하는 기술을 의미하기도,

    HetNet(Heterogeneous) :  두 개 이상의 기지국을 혼용하는 이종 네트워크
        
    스몰셀 = 펨토 셀 기지국 : 트래픽 밀집 지역의 트래픽 분산을 통한 데이터 속도 향상 혹은 음영지역 해결을 목적으로 설치.
            EICIC혹은 SoMP기술로 이종 네트워크 간 간섭 회피
        
    MASSIVE MIMO : 다중 안테나 기술

    eIMTA : LTE-TDD 기지국 간 업/다운 링크의 비대칭 비율이 다르게 설정되어 있을때 기지국 간 전파 간섭을 제어/회피하는 기술

    D2D 통신 : 기지국 도움 없이 장비간 직접 통신
                주로 재난망에 요구 되며
                업링크 대역만을 점유해 통신.
                LTE-FDD업링크 주파수에서 TDD처럼 동작하여 간섭 회피-> D2D통신과 기지국 통신이 동시에 가능

            
    MTC(MACHINE TYPE COMMUNICATION) : IoT 지원을 위한 기능
                전력소모가 적은 많은 사물들을 서비스 반경에 접속 시키기 위한
    
    eCA(evolved CA)  : 주파수 채널을 32개 까지 묶기 위한 기술

    LTE - U  :  ISM 비면허 대역을 사용하는 LTE
                다운로드 고속 데이터가 발생하는 순간에만 5GHz ISM 대역의 넓은 주파수 대역을 통해 고속 데이터 전송

5G는 아직 기술이 합의 되지 않아
다음과 같은 공통적인 시도가 이루어지고 있다.

1. 수십 GHz의 매우 높은 주파수 대역에서 넓은 주파수 대역폭을 확보
2. 다양한 안테나 기술을 적용해 데이터 속도 획기적 향상
3. 스몰셀을 설치해 전파의 회절성 문제 해결 및 통화 용량을 분산
4. 실질적 IoT을 위해 수 많은 장비가 서로 직접 통신이 가능1. 수십 GHz의 매우 높은 주파수 대역에서 넓은 주파수 대역폭을 확보
2. 다양한 안테나 기술을 적용해 데이터 속도 획기적 향상
3. 스몰셀을 설치해 전파의 회절성 문제 해결 및 통화 용량을 분산
4. 실질적 IoT을 위해 수 많은 장비가 서로 직접 통신이 가능



별도의 네트워크를 구성하는 모바일 tv에는 t-dmb등
이와 다른 이동통신 네트워크를 통한 모바일 tv에는 3g에서는 mbms , 4g에서는 e-mbms가 있다.

전송 방식에 따라 유니캐스트/멀티캐스트/브로트캐스트가 있다.
OFDM에서 유니캐스트는 일정 개수의 부반송파를 특정 사용자에게 독점하는 구조이며
        브로드캐스트는 10msec중 10개 서브프레임의 일부를 할당하는 구조. -> 누구든 수신이 가능

e-mbms 구조는
    콘텐츠-> mbms-gw -> mbsc
        mbms-gw는 패킷을 멀티캐스트로 전달하는 역활
        mbsc는 인증, 과금과 코어네트워크에서의 mbms패킷 흐름을 관장/  콘텐츠서버의 프록시 처럼 동작

embms는 멀티 or 브로드 개념이므로 특성 사용자에 맞추는 무선접속 기술 적용 불가(...?빔포밍..?)

lte에서는 10개의 서브프라임 중 6개를 e-mbms로 사용할 수 있도록 정의


브로드 캐스트 방식은 동일한 콘텐츠를 여얼 기지국에서 동시에 전송함으로 에너지컴바이닝에 의해 수신 성능이 향상.
이러한 네트워크 개념을 MBSFN이라한다.


ISM 대역 : 최소한의 규제만으로 허가 없이 사용할 수 있는 주파수 밴드
    1. 출력이 100mwatt 이하 일 것
    2. 상호 간섭 최소화를 위하여 대역확산 방식 사용 할 것
    3. 상호 간섭 최소화를 위하여 안테나 이득이 6dBi일때 유효 출력을 1watt 이하로 할 것


와이파이는 ISM 비면허 대역에서 동작하는 무선 기술.
    기본 프로토콜은 CSMA-CA
        LBT( Listen before talk)를 이용해 누가 사용하는지 확인 후 송신을 기본으로
    OFDM-TDMA 기술로  고속데이터를 저속데이터로 변환하여 20MHz ㄷ역폭 내에서 56개 부 반송파를 병렬로 전송
    하며 부반송파를 시분할해 공유

LTE는 허가받은 주파수 대역에서 효율성 높게 동작하는 무선 기술
    OFDM-FDMA 방식으로 부반송파를 통화자간 나눠 사용한다.
    LBT와 달리 기지국이 무선 구간 상태를 파악해 개별 통화자에 대한 패킷 전송 제어


LTE-U : ISM 대역을 이용한 LTE = LAA
    BUT 높은 신뢰성 확보는 힘듬. -> 제어 신호 흐름은 기존 LTE 대역에서 하고 고속 다운로드 데이터가 발생하는 순간에만
    5GHZ ISM 대역의 넓은 주파수를 이용
    => 이기종 시스템 간 주파ㅜ 채널 묶음인 inter-RAT CA라 할수 있음.

ISM 5GHZ 대역에서 LTE와 와이파이 패킷 간 충돌이 발생하면 와이파이는 신속하고 신뢰성있는 재전송 어려움.
반면 LTE는 강한 잡음 내성과 신속한 재전송으로 충돌에러만회가 가능해 
    와이파이의 성능 저하는 어쩔 수 없음.

이러한 혼란을 고려해    LTE-U는 다음 요소가 논의 중
        1. LBT같은 기능을 ISM대역관련 규정에서 의무화
        2. 주파수를 조각내는 OFDMA 기술을 ISM대역에서 허용할 것인가.
        3. 무상 대역인 ISM에서 과금 정책을 실행할 것인가.

PS-LTE는 LTE기술에 재난 안정망의 용도로 요구되는 기술을 적용한 기술
    
    D2D 또는 Proximity Services
            휴대전화간 직접통신을 의미
            기지국을 거치지 않고 고속 데이터 전송이 이루어짐
            lte-fdd의 경우 업링크 주파수에 lte-tdd의 경우 업링크 서비프레임에서 효율적으로 동작
            d2d 용도로 업링크 주파수 채널을 사용해 주변 영향을 최소화하며 기지국과의 동시통화 구현
            그러기 위해서는 하프 듀플렉스가 필연적
    
    재난 시 휴대전화는 더 높은 출력이 필요.

    IOPS  = NeNB(Nomad eNB)
            기지국에 초소형 코어망 기능을 탑재해 이동 기지국으 예상할 수 있는 기능
    
    GCSE(group call service enabler for lte)
            재난 상황 동영상을 브로드 OR 멀티캐스트 개념으로 전달하기 위한 개념
            E-MBMS에 ISM을 연동해 동작
    
    MCPTT(mission critical ptt)는 gcse,prose 기능을 바탕으로 재난 안전 통신 관련 기관들의 요구 사항을 반여한 기능
    
