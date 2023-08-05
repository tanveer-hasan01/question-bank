package com.example.diu_qustion_bank.fragment

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.diu_qustion_bank.MainActivity
import com.example.diu_qustion_bank.SplashActivity
import com.example.diu_qustion_bank.Utils
import com.example.diu_qustion_bank.databinding.FragmentProfileBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    @Inject
    lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding:FragmentProfileBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        auth = FirebaseAuth.getInstance()
        binding = FragmentProfileBinding.inflate(inflater,container,false);

        Glide.with(this).load(sharedPreferences.getString("photo","")).into(binding.profileImage);
        binding.name.text = sharedPreferences.getString("name","")
        binding.email.text = sharedPreferences.getString("email","")

        binding.logout.setOnClickListener {
            logout()
        }


        return binding.root;

    }

    private fun logout(){

        auth.signOut()
        GoogleSignIn.getClient(requireContext(), GoogleSignInOptions.DEFAULT_SIGN_IN).signOut();
        Utils.showSnackBar("Logout successfully",requireView())
        val intent = Intent(context, SplashActivity::class.java) // New activity
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        requireActivity()!!.finish()

    }


}