


일단 아무것도 할 줄 모르니

버튼 만들기와 텍스트 출력부터 해보자

MainActivity.xml 이라는 프로젝트를 생성하고 가장 기본적으로 생성 된 xml 파일에 
어플의 기본 모양새를 그려 넣어보도록 하자.

        <?xml version="1.0" encoding="utf-8"?>
        <LinearLayout
            xmlns:android="http://schemas.android.com/apk/res/android"
            xmlns:tools="http://schemas.android.com/tools"
            xmlns:app="http://schemas.android.com/apk/res-auto"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical"
            tools:context="com.example.kogr.myapplication.MainActivity">

            <TextView
                    android:id="@+id/txt_hello"
                    android:layout_width="wrap_content"
                    android:layout_height="50dp"
                    android:textSize="30dp"
                    android:textStyle="bold"
                    android:gravity="center" />

            <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="100dp"
                    android:orientation="horizontal">

                <Button
                        android:id="@+id/btn_one"
                        android:text="trip_1"
                        android:layout_width="match_parent"
                        android:layout_weight="1"
                        android:layout_height="50dp"
                />
                <Button
                        android:id="@+id/btn_two"
                        android:text="trip_2"
                        android:layout_width="match_parent"
                        android:layout_weight="1"
                        android:layout_height="50dp"
                />

            </LinearLayout>

            <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="100dp"
                    android:orientation="horizontal">

                <Button
                        android:id="@+id/btn_three"
                        android:text="trip_3"
                        android:layout_width="match_parent"
                        android:layout_weight="1"
                        android:layout_height="50dp"
                />
                <Button
                        android:id="@+id/btn_four"
                        android:text="trip_4"
                        android:layout_width="match_parent"
                        android:layout_weight="1"
                        android:layout_height="50dp"
                />

            </LinearLayout>

        </LinearLayout>

대충 이런 식이다.

xml은 마크업 언어로 html의 단점을 보완하기 위해서 생겼다고 하는데 자세히는 나중에~ 다루겠다.

레이아웃을 그리는 방법은 좀 참으로 복잡하면서 쉬운듯하다.
이에 대해서는 따로 다루어 봐야할 듯 하다.

match_parent로 하면 부모레이어와 사이즈를 같게 한다는 듯하다.
dp라는 단위를 이용하여 크기를 정할 수 있고
orientataion 속성을 이용하여 배열을 가로 혹은 세로로 정할 수 있다.
id 속성으로 각 개체? 들의 id를 지정한다.  html이랑 비슷한 느낌인 듯....

심심삼아 버튼 4개와 텍스트를 쓸 수 있는 공간을 만들었다.



xml 을 꾸며 봤으면 그 xml에서 각 개체들의 동작? 을 만들어 줘야한다.
그것은 MainActivity.kt (통신사 아니고 코틀린 약자....죄송...;;)


          package com.example.kogr.myapplication

          import android.support.v7.app.AppCompatActivity
          import android.os.Bundle
          import kotlinx.android.synthetic.main.activity_main.*


          class MainActivity : AppCompatActivity() {

              override fun onCreate(savedInstanceState: Bundle?) {
                  super.onCreate(savedInstanceState)
                  setContentView(R.layout.activity_main)

                  txt_hello.text="hello kotlin"

                  btn_one.setOnClickListener {
                      txt_hello.setText("trip_one")
                  }

                  btn_two.setOnClickListener{
                      val str1: String = "trip_two"
                      txt_hello.setText("hello $str1")
                  }

                  btn_three.setOnClickListener {
                      var str2:String="trip_three"
                      str2 ="trip_3"
                      txt_hello.setText("$str2")
                  }

                  btn_four.setOnClickListener {
                      txt_hello.setText("trip_four")
                  }
              }
          }
          
          
 대충 이런 식이다.
 
 메인 클래스와 overrid fun oncreate 는 기본적으로 만들어져있었다.
 
 안드로이드에서 클래스를 하나 생성하면 oncreate 함수 하나를 무조건 생성해야한다고 한다.
setContentVie는 현재 디자인을 지정한 xml파일에서 가져온다는 것을 의미한다고 한다.

자바로 안드로이드를 짜본 적이 없기 때문에 코틀린이 얼마나 간단한 지는 모르겠지만 간단해 보이기는 한다.

개체의 id로 불러와 함수들로 어떤 동작이 될지 정하고
어떤 개체가 어떻게 동작할지도 간단히 정해지는 듯하다.

