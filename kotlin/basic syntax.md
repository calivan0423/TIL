
# 패키지 정의

    패키지 정의는 파일 최상단에 정의
    디렉터리와 패키지는 일치하지 않아도 됨

    package my.demo

    import java.util

# 함수 정의

        fun이라는 키워드로 정의
        
        fun sum(a:int, b:int): int{
                return a+b
        }

        fun sum(a:int, b:int)=a+b
        로 return 생략하여 표시 가능
        이 경우 return type이 추론

    리턴 할 값이 없는 경우 Unit(객체)으로 리턴
    java에서 void 리턴 역할
    
    fun printKotlin(): Unit{
            printfln("hello")
    }
    
    Unit 은 생략이 가능
    fun printKotlin(){
            println("hello")
    }

# 지역 변수 정의

    val : 읽기 전용 변수
    var : Mutable 변수
    
    val a: Int = 1
    val b =2 // 타입 추론
    val c: Int // 오류!! 값 초기화 필요
    c =3 // 읽기 전용이라 할당 불가능!

    var x =5
    x+=1 // var는 값 변화 가능

# 주성

    //한줄 주석
    /**/ 블록 주석
    /*   /*   */  */  중복 블록 주석 가능

# 문자열 템플릿

    var a=1
    val s1 = "a is $a"

    a=2
    val s2 = "${s1.replace("is","was")},but now is $a"

# 조건문

    fun maxOf(a : int, b:int):int{
        if(a>b){
            return a
        }
        else{
        return b
        }
    }

    fun maxOf(a:int, b:int)= if(a>b) a else b 
    두 함수는 같은 의미

# nullalble

    값이 null일 수 있는 경우 타입에 nullable 마크 명시!
    
    fun parseInt(str:string):int?{
        //정수가 아닌 경우 null 리턴
        //이 함수가 리턴 될때 null이 리턴 될 수 있기 때문에
        //명시없이 null 리턴시 오류
    }
    
    fun printf(arg1 :string , arg2:string){
        val x:int?= parseInt(arg1)
        val y:int? = parseInt(arg2)

        if(x!=null &&y!=null){
            println(x*y)
        }
        else{
            println("either '$arg1' or '$arg2' is not a number" )
        }
    }
    //null체크를 해줘야 컴파일 가능.

# 자동 타입 변환

    fun getStringLength(obj:Any):Int?{
        //Any는 자바의 object같이 최상위 클래스 
        if(obj is String){
            //obj가 자동으로 string으로 타입 변환
            return obj.length
        }
        return null
    }

# while loop

    val items=listOf("apple","banana","kiwi")
    var index=0
    while(index<itmes.sieze){
        println("itme at $index is ${items[index]}")
        index++
    }

# when expression
    //switch 처럼...?
    fun describe(obj:Any):String =
        when (obj){
                1->"one"
                "hello"->"greeitng"
                is Long -> "long"
                !is String -> "not a string"
                else -> "unknow"
        } 
    fun main()
    { 
        var a ="hello"
    println(describe(a))
        val b: Int =3
        println(b)
    }
    //when은 순차적으로 처음꺼가 맞으면 탈출
# ranges

    ln 연산자를 이용하여 숫자 범위 체크 가능

    var x=3
    if(x in 1..10){
        println("fits in range")
    }
    for(y in 1..5){
        print(y)
    }

# collections

    val items =listOf("apple","banana","kiwi")
    for(item in items){
        println(item)
    }

    when{
        "orange" in items->println("juicy")
        "apple" in items -> println("apple in fine too")
    }

    //

    val fruits= listOf("apple","banana","kiwi","avocado")
    fruits
        .filter{is.startWith("a")}
        .sortedBy{it}
        .map{it.toUpperCase()}