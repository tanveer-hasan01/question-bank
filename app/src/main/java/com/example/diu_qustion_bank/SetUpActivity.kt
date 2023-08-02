package com.example.diu_qustion_bank

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.diu_qustion_bank.databinding.ActivitySetUpBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class SetUpActivity : AppCompatActivity() {

    @Inject
    lateinit var sharedPreference: SharedPreferences
    private lateinit var binding: ActivitySetUpBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySetUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val deptList = ArrayList<String>()
        deptList.add("CSE")
        deptList.add("EEE")
        deptList.add("CIS")

        val deptAdapter = ArrayAdapter(
            this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            deptList
        )
        binding.deptSpinner.setAdapter(deptAdapter)

        binding.deptSpinner.setOnItemClickListener { adapterView, view, i, l ->

            sharedPreference.edit().putString("dept", deptList[i]).apply()
            Utils.showToast(""+deptList[i],this)

        }






        /*  if (sharedPreference.getInt("dept",-1).toString().equals(0)){
              binding.deptSpinner.threshold=0
          }else if(sharedPreference.getInt("dept",-1).toString().equals(1)){
              binding.deptSpinner.text=
          }*/


    }
}