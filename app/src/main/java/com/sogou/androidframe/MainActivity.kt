package com.sogou.androidframe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sogou.androidframe.algorithm.Solution

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intArray = IntArray(6)
        intArray[0] = 1
        intArray[1] = 3
        intArray[2] = 5
        intArray[3] = 8
        intArray[4] = 10
        intArray[5] = 5
        Solution.getMaxProfit(intArray)
    }
}