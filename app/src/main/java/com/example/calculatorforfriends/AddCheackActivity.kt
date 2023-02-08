package com.example.calculatorforfriends

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.calculatorforfriends.databinding.ActivityAddCheackBinding

class AddCheackActivity : AppCompatActivity() {
    lateinit var BindingClass: ActivityAddCheackBinding

    var counter_people_in = 0
    var counter_people_buy = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BindingClass = ActivityAddCheackBinding.inflate(layoutInflater)
        setContentView(BindingClass.root)

        counter_people_in = intent.getIntExtra(Constance.COUNTER_PEOPLE, 0)
        onPeopleIn(counter_people_in)
        onAddName()
    }
    fun onAddName(){
        BindingClass.apply{
            cbPerson1.text = intent.getStringExtra(Constance.NAME_1)
            cbPerson2.text = intent.getStringExtra(Constance.NAME_2)
            cbPerson3.text = intent.getStringExtra(Constance.NAME_3)
            cbPerson4.text = intent.getStringExtra(Constance.NAME_4)
        }
    }

    fun onClickButtonFinish(view: View){
        onCounterPeopleBuy()
        if(counter_people_buy != 0){
            intent.apply {
                putExtra(Constance.ADD_CHEAK, BindingClass.edtCheack.text.toString())
                putExtra(Constance.ADD_CHECK_COUNTER_PEOPLE, counter_people_buy)
                putExtra(Constance.CHECK_BOX_PERSON_1, BindingClass.cbPerson1.isChecked)
                putExtra(Constance.CHECK_BOX_PERSON_2, BindingClass.cbPerson2.isChecked)
                putExtra(Constance.CHECK_BOX_PERSON_3, BindingClass.cbPerson3.isChecked)
                putExtra(Constance.CHECK_BOX_PERSON_4, BindingClass.cbPerson4.isChecked)
                }
                setResult(RESULT_OK, intent)
                finish()
        }else
            BindingClass.tvErrorCounter.visibility = View.VISIBLE
    }
    fun onCounterPeopleBuy(){
         BindingClass.apply{
             if(cbPerson1.isChecked)
                 counter_people_buy++
             if(cbPerson2.isChecked)
                 counter_people_buy++
             if(cbPerson3.isChecked)
                 counter_people_buy++
             if(cbPerson4.isChecked)
                 counter_people_buy++
         }
     }
    fun onPeopleIn(counter: Int){
        BindingClass.apply {
            when (counter) {
                2 -> {
                    ivPerson3c.visibility = View.GONE
                    cbPerson3.visibility = View.GONE

                    ivPerson4c.visibility = View.GONE
                    cbPerson4.visibility = View.GONE
                }
                3 ->{
                    ivPerson4c.visibility = View.GONE
                    cbPerson4.visibility = View.GONE
                }
            }
        }
    }
}