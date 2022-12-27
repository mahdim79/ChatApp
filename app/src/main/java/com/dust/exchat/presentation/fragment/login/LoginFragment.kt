package com.dust.exchat.presentation.fragment.login

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.dust.exchat.BuildConfig
import com.dust.exchat.R
import com.dust.exchat.databinding.FragmentLoginBinding
import com.dust.exchat.framework.firebase.ProcessState
import com.dust.exchat.utils.Constants
import dagger.hilt.android.AndroidEntryPoint
import java.util.regex.Pattern

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private lateinit var mBinding: FragmentLoginBinding
    private val viewModel by viewModels<LoginFragmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentLoginBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initLiveData()
    }

    private fun initLiveData() {
        viewModel.signUpLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is ProcessState.Success -> {
                    setLoading(false)
                    findNavController().setGraph(R.navigation.nav_main)
                }

                is ProcessState.Failure -> {
                    setLoading(false)
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }

                is ProcessState.Loading -> {
                    setLoading(true)
                }
            }
        }

        viewModel.signInLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is ProcessState.Success -> {
                    setLoading(false)
                    findNavController().setGraph(R.navigation.nav_main)
                }

                is ProcessState.Failure -> {
                    setLoading(false)
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }

                is ProcessState.Loading -> {
                    setLoading(true)
                }
            }
        }

    }

    private fun initViews() {
        if (BuildConfig.DEBUG){
            mBinding.tilLoginEmail.editText?.setText(Constants.TestLoginEmail)
            mBinding.tilLoginPassword.editText?.setText(Constants.TestLoginPassword)
            mBinding.tilLoginPasswordConfirm.editText?.setText(Constants.TestLoginPassword)
        }
        mBinding.btnLoginLogin.setOnClickListener {
            if (validateEntries()) {
                viewModel.signIn(
                    mBinding.tilLoginEmail.editText?.text.toString(),
                    mBinding.tilLoginPassword.editText?.text.toString()
                )
            }
        }
        mBinding.btnLoginSignup.setOnClickListener {
            if (validateEntries()) {
                viewModel.signUp(
                    mBinding.tilLoginEmail.editText?.text.toString(),
                    mBinding.tilLoginPassword.editText?.text.toString()
                )
            }
        }
    }

    private fun setLoading(loading: Boolean) {
        if (loading) {
            mBinding.llLoginLoginSignup.visibility = View.INVISIBLE
            mBinding.pbLoginProgressbar.visibility = View.VISIBLE
        } else {
            mBinding.llLoginLoginSignup.visibility = View.VISIBLE
            mBinding.pbLoginProgressbar.visibility = View.INVISIBLE
        }
    }

    private fun validateEntries(): Boolean {
        //   mBinding.tilLoginUserName.error = null
        mBinding.tilLoginEmail.error = null
        //  mBinding.tilLoginPhoneNumber.error = null
        mBinding.tilLoginPassword.error = null
        mBinding.tilLoginPasswordConfirm.error = null

        var error = false

        /*if (mBinding.tilLoginUserName.editText?.text.toString().isEmpty()) {
            error = true
            mBinding.tilLoginUserName.error = "Please enter username"
        } else {
            if (mBinding.tilLoginUserName.editText?.text.toString().length < 5 || mBinding.tilLoginUserName.editText?.text.toString().length < 25) {
                error = true
                mBinding.tilLoginUserName.error = "Username length must be between 5 and 25"
            }
        }*/

        if (mBinding.tilLoginEmail.editText?.text.toString().isEmpty()) {
            error = true
            mBinding.tilLoginEmail.error = "Please enter email"
        } else {
            if (!validateEmail(mBinding.tilLoginEmail.editText?.text.toString())) {
                error = true
                mBinding.tilLoginEmail.error = "Email is not valid"
            }
        }

        /*if (mBinding.tilLoginPhoneNumber.editText?.text.toString().isEmpty()) {
            error = true
            mBinding.tilLoginPhoneNumber.error = "Please enter phone number"
        } else {
            if (!validatePhoneNumber(mBinding.tilLoginPhoneNumber.editText?.text.toString())) {
                error = true
                mBinding.tilLoginEmail.error = "Phone Number is not valid"
            }
        }*/

        if (mBinding.tilLoginPassword.editText?.text.toString().isEmpty()) {
            error = true
            mBinding.tilLoginPassword.error = "Please enter password"
        } else {
            val validPass = validatePassword(mBinding.tilLoginPassword.editText?.text.toString())
            if (validPass.isNotEmpty()) {
                error = true
                mBinding.tilLoginEmail.error = validPass
            }
        }

        if (mBinding.tilLoginPasswordConfirm.editText?.text.toString().isEmpty()) {
            error = true
            mBinding.tilLoginPasswordConfirm.error = "Please enter confirm password"
        } else {
            if (mBinding.tilLoginPassword.editText?.text.toString() != mBinding.tilLoginPasswordConfirm.editText?.text.toString()) {
                error = true
                mBinding.tilLoginPasswordConfirm.error = "Passwords doesn't match!"
            }
        }

        return !error
    }

    private fun validatePhoneNumber(toString: String): Boolean {
        return if (toString.startsWith("09") && toString.length == 11) true
        else toString.startsWith("9") && toString.length == 10
    }

    private fun validateEmail(email: String): Boolean {
        var isValid = true
        val expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(email)
        if (!matcher.matches()) {
            isValid = false
        }
        return isValid
    }

    private fun validatePassword(password: String): String {
        if (password.length < 8 || password.length >= 20)
            return "Password length must be between 8 and 20"

        val expression = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,20}$"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(password)
        if (!matcher.matches()) {
            return "Password length must be between 8 and 20,and contains at least one uppercase letter, one lowercase letter and one number"
        }
        return ""
    }
}