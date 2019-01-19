

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

처럼 코틀린 라이브러리가 컴파일 되어 있다는 것을 볼 수 있다고 한다...


사실 라이브러리고 뭐고 잘 모르겠어서..잘 모르겠다.. 더 공부해보자



코틀린 라이브러리를 사용할 때 anko라는 라이브러리를 추가로 사용하면 아주 편리하다고 하는데 
anko를 잘 모르지만 편리할 수 있다고 하니 추가해보자.
xml 작성시 가독성이 높은 코드로 작성할 수 있다고 한다..


그래들에
      
      그래들 프로젝트에
      buildscript {
             ext.kotlin_version = '1.3.11'
             ext.anko_version = '0.10.3' 
             
     그래들 모듈에
      dependencies {
                implementation fileTree(dir: 'libs', include: ['*.jar'])
                implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
  
  를 추가해주면 된다고 한다.  
  
  
  
  코틀린 플러그인을 업데이트 하기 위해서는
  
  tools->kotlin 에서 높은 버전을 설치하거나 업데이트 하면 된다.
  
  
