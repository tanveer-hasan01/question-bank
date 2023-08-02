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

    var selectedDept=""


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
        binding.deptSpinner.setText(sharedPreference.getString("dept",""), false);


        binding.deptSpinner.setOnItemClickListener { adapterView, view, i, l ->
            selectedDept=deptList[i]
        }






       binding.save.setOnClickListener {
           if (!selectedDept.isNullOrEmpty()){
               sharedPreference.edit().putString("dept",selectedDept).apply()
               Utils.showSnackBar("Updated",it)
           }

       }


    }
}