package com.example.hydromon.ui.profile

import android.annotation.SuppressLint
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.hydromon.R
import com.example.hydromon.databinding.FragmentHomeBinding
import com.example.hydromon.databinding.ProfileFragmentBinding
import com.example.hydromon.ui.authentication.login.LoginActivity
import com.example.hydromon.ui.authentication.login.LoginCookie
import com.example.hydromon.ui.home.HomeViewModel

class ProfileFragment : Fragment() {

    private var _binding: ProfileFragmentBinding? = null
    private lateinit var loginCookie : LoginCookie

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val profileViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = ProfileFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
//
//        val photo: ImageView = binding.imgItemPhoto
//        Glide.with(this)
//            .load(photo)
//            .circleCrop()
//            .into(binding.imgItemPhoto)
//        val textView: TextView = binding.textProfile
//        profileViewModel.text.observe(viewLifecycleOwner) {
//            photo.crop
//        }
//
        disableET(binding.etName)
        disableET(binding.etUsername)
        disableET(binding.etPassword)
        disableET(binding.etEmail)
        disableET(binding.etTokenTools)
        var flag = false

        val logoutButton : Button = binding.logoutButton
        logoutButton.setOnClickListener{
            loginCookie = LoginCookie(requireContext())
            loginCookie.deleteCookie()
            val moveToLogin = Intent(activity, LoginActivity::class.java)
            activity?.finish()
            startActivity(moveToLogin)

        }

        binding.editButton.setOnClickListener{
            if(flag){
                flag = false
                binding.editButton.setText("Save")
//                binding.etName.isFocusable = true
//                binding.etUsername.isFocusable = true
//                binding.etPassword.isFocusable = true
//                binding.etEmail.isFocusable = true
//                binding.etTokenTools.isFocusable = true
                enableET(binding.etName)
                enableET(binding.etUsername)
                enableET(binding.etPassword)
                enableET(binding.etEmail)
                enableET(binding.etTokenTools)
            }else{
                flag = true
                binding.editButton.setText("Edit Profile")
//                binding.editButton.text = "Edit Profile"
//                binding.etName.isFocusable = false
//                binding.etUsername.isFocusable = false
//                binding.etPassword.isFocusable = false
//                binding.etEmail.isFocusable = false
//                binding.etTokenTools.isFocusable = false
                disableET(binding.etName)
                disableET(binding.etUsername)
                disableET(binding.etPassword)
                disableET(binding.etEmail)
                disableET(binding.etTokenTools)
            }
        }


//        val textView: TextView = binding.textProfile
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun disableET(editText: EditText){
        with(editText) {
            isFocusable = false
            isEnabled = false
            setSelectAllOnFocus(false)
        }
    }

    private fun enableET(editText: EditText){
        with(editText) {
            isFocusable = true
            isEnabled = true
            setSelectAllOnFocus(true)
        }
    }

}