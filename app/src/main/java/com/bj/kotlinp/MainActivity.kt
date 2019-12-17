package com.bj.kotlinp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bj.library.Option
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun test() {
        val student = Student(name = "Ming", age = 10)
        val option = Option.fromNullable(student)
        val studentDefault = option.getOrElse {
            Student(name = null, age = 0)
        }
        studentDefault.age
        option.exists {
            //非空的情况下才执行里面的代码
            true
        }
//        arrow.core.Option
        option.doCall({ true }, {
            //满足第一个方法返回的结果,执行该方法代码
        })
    }
}
