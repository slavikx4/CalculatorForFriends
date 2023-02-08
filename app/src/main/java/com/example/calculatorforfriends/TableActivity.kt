package com.example.calculatorforfriends

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.calculatorforfriends.databinding.ActivityTableBinding

class TableActivity : AppCompatActivity() {

    lateinit var BindingClass: ActivityTableBinding

    var getResult: ActivityResultLauncher<Intent>? = null

    var check: Int = 0

    lateinit var counterPeople: String
    var counter_people_buy: Int = 0

    var name1: String = ""
    var pocket1: Int = 0
    var person1_buy: Boolean? = null

    var name2: String = ""
    var pocket2: Int = 0
    var person2_buy: Boolean? = null

    var name3: String = ""
    var pocket3: Int = 0
    var person3_buy: Boolean? = null

    var name4: String = ""
    var pocket4: Int = 0
    var person4_buy: Boolean? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BindingClass = ActivityTableBinding.inflate(layoutInflater)
        setContentView(BindingClass.root)
        BindingClass.bLetsGo.visibility = View.VISIBLE

        getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                val check_time: Int? = it.data?.getStringExtra(Constance.ADD_CHEAK)?.toInt()
                check = check_time!!

                counter_people_buy = it.data?.getIntExtra(Constance.ADD_CHECK_COUNTER_PEOPLE, 0)!!
                person1_buy = it.data?.getBooleanExtra(Constance.CHECK_BOX_PERSON_1, false)
                person2_buy = it.data?.getBooleanExtra(Constance.CHECK_BOX_PERSON_2, false)
                person3_buy = it.data?.getBooleanExtra(Constance.CHECK_BOX_PERSON_3,false)
                person4_buy = it.data?.getBooleanExtra(Constance.CHECK_BOX_PERSON_4, false)

                onDistributionCheck(check)
                onVisiblePocket()
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == Constance.MAIN_ACTIVITY_COUNTER_PEOPLE && resultCode == RESULT_OK && data != null){
            counterPeople = data.getStringExtra(Constance.COUNTER_PEOPLE)!!


            intent = Intent(this, MainActivity::class.java)
            intent.putExtra(Constance.KEY, Constance.ADD_NAME_TEXT)
            intent.putExtra(Constance.COUNTER_PEOPLE, counterPeople)
            startActivityForResult(intent, Constance.MAIN_ACTIVITY_NAME)
        }
        if(requestCode == Constance.MAIN_ACTIVITY_NAME && resultCode == RESULT_OK && data != null){

            BindingClass.bLetsGo.visibility = View.GONE
            BindingClass.tvSumma.visibility = View.VISIBLE
            BindingClass.bAddCheck.visibility = View.VISIBLE

            when(counterPeople){
                "2"->{
                    name1 = data.getStringExtra(Constance.NAME_1)!!
                    name2 = data.getStringExtra(Constance.NAME_2)!!

                    BindingClass.tvNick1.text = name1
                    BindingClass.tvNick2.text = name2

                    BindingClass.ivPerson1.visibility = View.VISIBLE
                    BindingClass.tvNick1.visibility = View.VISIBLE
                    BindingClass.tvKarman1.visibility = View.VISIBLE
                    BindingClass.ivPerson2.visibility = View.VISIBLE
                    BindingClass.tvNick2.visibility = View.VISIBLE
                    BindingClass.tvKarman2.visibility = View.VISIBLE
                }
                "3"->{
                    name1 = data.getStringExtra(Constance.NAME_1)!!
                    name2 = data.getStringExtra(Constance.NAME_2)!!
                    name3 = data.getStringExtra(Constance.NAME_3)!!

                    BindingClass.tvNick1.text = name1
                    BindingClass.tvNick2.text = name2
                    BindingClass.tvNick3.text = name3

                    BindingClass.ivPerson1.visibility = View.VISIBLE
                    BindingClass.tvNick1.visibility = View.VISIBLE
                    BindingClass.tvKarman1.visibility = View.VISIBLE
                    BindingClass.ivPerson2.visibility = View.VISIBLE
                    BindingClass.tvNick2.visibility = View.VISIBLE
                    BindingClass.tvKarman2.visibility = View.VISIBLE
                    BindingClass.ivPerson3.visibility = View.VISIBLE
                    BindingClass.tvNick3.visibility = View.VISIBLE
                    BindingClass.tvKarman3.visibility = View.VISIBLE
                }
                "4"->{
                    name1 = data.getStringExtra(Constance.NAME_1)!!
                    name2 = data.getStringExtra(Constance.NAME_2)!!
                    name3 = data.getStringExtra(Constance.NAME_3)!!
                    name4 = data.getStringExtra(Constance.NAME_4)!!

                    BindingClass.tvNick1.text = name1
                    BindingClass.tvNick2.text = name2
                    BindingClass.tvNick3.text = name3
                    BindingClass.tvNick4.text = name4

                    BindingClass.ivPerson1.visibility = View.VISIBLE
                    BindingClass.tvNick1.visibility = View.VISIBLE
                    BindingClass.tvKarman1.visibility = View.VISIBLE
                    BindingClass.ivPerson2.visibility = View.VISIBLE
                    BindingClass.tvNick2.visibility = View.VISIBLE
                    BindingClass.tvKarman2.visibility = View.VISIBLE
                    BindingClass.ivPerson3.visibility = View.VISIBLE
                    BindingClass.tvNick3.visibility = View.VISIBLE
                    BindingClass.tvKarman3.visibility = View.VISIBLE
                    BindingClass.ivPerson4.visibility = View.VISIBLE
                    BindingClass.tvNick4.visibility = View.VISIBLE
                    BindingClass.tvKarman4.visibility = View.VISIBLE
                }
            }
        }
    }

    fun onClickLetsGo(view: View){
        intent = Intent(this, MainActivity::class.java)
        intent.putExtra(Constance.KEY, Constance.LETS_GO_TEXT)
        startActivityForResult(intent, Constance.MAIN_ACTIVITY_COUNTER_PEOPLE)
    }

    fun onClickAddCheak(view: View){

        val intent = Intent(this, AddCheackActivity::class.java)
        intent.apply{
            putExtra(Constance.COUNTER_PEOPLE, counterPeople.toInt())

            putExtra(Constance.NAME_1, name1)
            putExtra(Constance.NAME_2, name2)
            putExtra(Constance.NAME_3, name3)
            putExtra(Constance.NAME_4, name4)
        }
        getResult?.launch(intent)
    }

    fun onDistributionCheck(check: Int){
        val part_check = check / counter_people_buy
        if(person1_buy!!)
            pocket1 += part_check
        if(person2_buy!!)
            pocket2 += part_check
        if(person3_buy!!)
            pocket3 += part_check
        if(person4_buy!!)
            pocket4 += part_check

        onDelBuy()
    }
    fun onDelBuy(){
        person1_buy = false
        person2_buy = false
        person3_buy = false
        person4_buy = false
    }

    fun onVisiblePocket(){
        BindingClass.apply{
            var pocket = "$pocket1$"
            tvKarman1.text = pocket
            pocket = "$pocket2$"
            tvKarman2.text = pocket
            pocket = "$pocket3$"
            tvKarman3.text = pocket
            pocket = "$pocket4$"
            tvKarman4.text = pocket
        }
    }
}