package com.ketarketir.tiketkuioflight.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ketarketir.tiketkuioflight.R
import com.ketarketir.tiketkuioflight.databinding.FragmentResetPasswordBinding
import com.ketarketir.tiketkuioflight.viewmodel.UserViewModel

class ResetPasswordFragment : Fragment() {
    private var _binding: FragmentResetPasswordBinding? = null
    private val binding get() = _binding!!

    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResetPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userViewModel = ViewModelProvider(requireActivity()).get(UserViewModel::class.java)

        binding.btnSimpan.setOnClickListener {
            val newPassword = binding.tieEnterNerPassword.text.toString()
            // Call API to reset password with new password
            userViewModel.resetPassword("","","Sekaradmin123.","Sekaradmin123.")
            navigateToLoginFragment()
        }
    }

    private fun navigateToLoginFragment() {
        findNavController().navigate(R.id.action_resetPasswordFragment_to_loginFragment2)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
