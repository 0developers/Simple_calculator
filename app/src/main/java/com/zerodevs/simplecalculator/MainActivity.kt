package com.zerodevs.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.zerodevs.simplecalculator.databinding.ActivityMainBinding
import java.lang.Exception
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    var tempNum1 = 0
    var tempNum2 = 0
    var tempSign: String? = null
    var sBuilder1: StringBuilder? = StringBuilder()
    var sBuilder2: StringBuilder? = StringBuilder()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        supportActionBar!!.hide()

        //on click listeners (numbers)
        binding!!.butn1.setOnClickListener { setOutput(1, null) }
        binding!!.butn2.setOnClickListener { setOutput(2, null) }
        binding!!.butn3.setOnClickListener { setOutput(3, null) }
        binding!!.butn4.setOnClickListener { setOutput(4, null) }
        binding!!.butn5.setOnClickListener { setOutput(5, null) }
        binding!!.butn6.setOnClickListener { setOutput(6, null) }
        binding!!.butn7.setOnClickListener { setOutput(7, null) }
        binding!!.butn8.setOnClickListener { setOutput(8, null) }
        binding!!.butn9.setOnClickListener { setOutput(9, null) }
        binding!!.butn0.setOnClickListener { setOutput(0, null) }
        //on click listeners (signs)
        binding!!.plus.setOnClickListener { setOutput(0, "+") }
        binding!!.minus.setOnClickListener { setOutput(0, "-") }
        binding!!.multiply.setOnClickListener { setOutput(0, "*") }
        binding!!.divide.setOnClickListener { setOutput(0, "/") }
        binding!!.butnanswer.setOnClickListener { answer() }
        binding!!.clear.setOnClickListener {
            tempNum1 = 0
            tempNum2 = 0
            sBuilder1 = StringBuilder()
            sBuilder2 = StringBuilder()
            tempSign = null
            binding!!.output.text = "0"
        }
    }

    fun setOutput(input: Int, sign: String?) {
        if (binding!!.output.text.toString() == "0") {
            if (sign != null) return
            binding!!.output.text = ""
        }
        if (sign != null) {
            if (tempSign != null) return
            //set the sign
            tempSign = sign
            binding!!.output.append(sign)
        } else {
            if (tempSign != null) {
                sBuilder2!!.append(input)
                binding!!.output.append(input.toString())
            } else {
                sBuilder1!!.append(input)
                binding!!.output.append(input.toString())
            }
        }
    }

    fun answer() {
        //this method will show the results
        try {
            var ansr = 0
            if (tempSign == "+") {
                tempNum1 = if (sBuilder1 != null) sBuilder1.toString().toInt() else return
                tempNum2 = if (sBuilder2 != null) sBuilder2.toString().toInt() else return
                ansr = tempNum1 + tempNum2
                binding!!.output.append(" = $ansr")
                tempNum1 = 0
                tempNum2 = 0
                tempSign = null
                sBuilder1 = StringBuilder()
                sBuilder1!!.append(ansr)
                sBuilder2 = StringBuilder()
            } else if (tempSign == "-") {
                tempNum1 = if (sBuilder1 != null) sBuilder1.toString().toInt() else return
                tempNum2 = if (sBuilder2 != null) sBuilder2.toString().toInt() else return
                ansr = tempNum1 - tempNum2
                binding!!.output.append(" = $ansr")
                tempNum1 = 0
                tempNum2 = 0
                tempSign = null
                sBuilder1 = StringBuilder()
                sBuilder1!!.append(ansr)
                sBuilder2 = StringBuilder()
            } else if (tempSign == "*") {
                tempNum1 = if (sBuilder1 != null) sBuilder1.toString().toInt() else return
                tempNum2 = if (sBuilder2 != null) sBuilder2.toString().toInt() else return
                ansr = tempNum1 * tempNum2
                binding!!.output.append(" = $ansr")
                tempNum1 = 0
                tempNum2 = 0
                tempSign = null
                sBuilder1 = StringBuilder()
                sBuilder1!!.append(ansr)
                sBuilder2 = StringBuilder()
            } else if (tempSign == "/") {
                tempNum1 = if (sBuilder1 != null) sBuilder1.toString().toInt() else return
                tempNum2 = if (sBuilder2 != null) sBuilder2.toString().toInt() else return
                ansr = tempNum1 / tempNum2
                binding!!.output.append(" = $ansr")
                tempNum1 = 0
                tempNum2 = 0
                tempSign = null
                sBuilder1 = StringBuilder()
                sBuilder1!!.append(ansr)
                sBuilder2 = StringBuilder()
            }
        } catch (e: Exception) {
        }
    }
}