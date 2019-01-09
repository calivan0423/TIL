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
     val items =listOf("apple","banana","kiwi")
    for(item in items){
        println(item)
    }

    when{
        "orange" in items->println("juicy")
        "apple" in items -> println("apple in fine too")
    }

    val fruits= listOf("apple","banana","kiwi","avocado")
    println(fruits.filter{is.startWith("a")})
      

    var index=0
    while(index < items.size){
        println("itme at $index is ${items[index]}")
        index++
    }
   }
