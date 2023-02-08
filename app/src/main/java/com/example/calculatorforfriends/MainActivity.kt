package com.example.calculatorforfriends

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.calculatorforfriends.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var BindingClass: ActivityMainBinding

    lateinit var key: String
    lateinit var counterPeople: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(BindingClass.root)

        key = intent.getStringExtra(Constance.KEY)!!

        if(key == Constance.LETS_GO_TEXT){
            BindingClass.tvCounterPeople.visibility = View.VISIBLE
            BindingClass.bOkey.visibility = View.VISIBLE
            BindingClass.ptCounterPeople.visibility = View.VISIBLE
        }
        if(key == Constance.ADD_NAME_TEXT){
            counterPeople = intent.getStringExtra(Constance.COUNTER_PEOPLE)!!
            when(counterPeople){
                "2"->{
                    BindingClass.setNick.visibility = View.VISIBLE
                    BindingClass.nick1.visibility = View.VISIBLE
                    BindingClass.num1.visibility = View.VISIBLE
                    BindingClass.nick2.visibility = View.VISIBLE
                    BindingClass.num2.visibility = View.VISIBLE
                    BindingClass.bGo.visibility = View.VISIBLE
                }
                "3"->{
                    BindingClass.setNick.visibility = View.VISIBLE
                    BindingClass.nick1.visibility = View.VISIBLE
                    BindingClass.num1.visibility = View.VISIBLE
                    BindingClass.nick2.visibility = View.VISIBLE
                    BindingClass.num2.visibility = View.VISIBLE
                    BindingClass.nick3.visibility = View.VISIBLE
                    BindingClass.num3.visibility = View.VISIBLE
                    BindingClass.bGo.visibility = View.VISIBLE
                }
                "4"->{
                    BindingClass.setNick.visibility = View.VISIBLE
                    BindingClass.nick1.visibility = View.VISIBLE
                    BindingClass.num1.visibility = View.VISIBLE
                    BindingClass.nick2.visibility = View.VISIBLE
                    BindingClass.num2.visibility = View.VISIBLE
                    BindingClass.nick3.visibility =View.VISIBLE
                    BindingClass.num3.visibility = View.VISIBLE
                    BindingClass.nick4.visibility = View.VISIBLE
                    BindingClass.num4.visibility = View.VISIBLE
                    BindingClass.bGo.visibility = View.VISIBLE
                }
            }
        }
    }

    fun onClickOkey(view: View){
        var counterP = BindingClass.ptCounterPeople.text.toString().toInt()
        if(0 < counterP && counterP <= 4) {
            intent.putExtra(Constance.COUNTER_PEOPLE, counterP.toString())
            setResult(RESULT_OK, intent)
            finish()
        }else{
            BindingClass.apply{
                tvCounterPeople.visibility = View.GONE
                bOkey.visibility = View.GONE
                ptCounterPeople.visibility = View.GONE

                tvError.visibility = View.VISIBLE
                bSorry.visibility = View.VISIBLE
                bSorry.setOnClickListener{

                    tvCounterPeople.visibility = View.VISIBLE
                    bOkey.visibility = View.VISIBLE
                    ptCounterPeople.visibility = View.VISIBLE

                    tvError.visibility = View.GONE
                    bSorry.visibility = View.GONE
                }
            }
        }
    }
     fun onClickGo(view: View){
         when(counterPeople){
             "2"->{
                 intent.putExtra(Constance.NAME_1, BindingClass.nick1.text.toString())
                 intent.putExtra(Constance.NAME_2, BindingClass.nick2.text.toString())
                 setResult(RESULT_OK, intent)
                 finish()
             }
             "3"->{
                 intent.putExtra(Constance.NAME_1, BindingClass.nick1.text.toString())
                 intent.putExtra(Constance.NAME_2, BindingClass.nick2.text.toString())
                 intent.putExtra(Constance.NAME_3, BindingClass.nick3.text.toString())
                 setResult(RESULT_OK, intent)
                 finish()
             }
             "4"->{
                 intent.putExtra(Constance.NAME_1, BindingClass.nick1.text.toString())
                 intent.putExtra(Constance.NAME_2, BindingClass.nick2.text.toString())
                 intent.putExtra(Constance.NAME_3, BindingClass.nick3.text.toString())
                 intent.putExtra(Constance.NAME_4, BindingClass.nick4.text.toString())
                 setResult(RESULT_OK, intent)
                 finish()
             }
         }
     }
}