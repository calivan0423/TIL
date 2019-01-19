

안드로이드 스튜디오 3.0 부터는 코틀린 언어를 플러그인 설치 없이 지원한다.


프로젝트 생성 후 
프로젝트 그래들의 build.gradle(Project: )에서

      buildscript {
          ext.kotlin_version = '1.3.11'
          }

 위와 같이 되어있는 것을 볼 수 있다.
 1.3.0이상이어야 제대로 작동하는 듯하다.. 코틀린 언어를 라이브러리 처럼 사용한다는 뜻이라고 한다.
 
 build.gradle(Module:app)에 가보면 
 
        dependencies {
        implementation fileTree(dir: 'libs', include: ['*.jar'])
        implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
