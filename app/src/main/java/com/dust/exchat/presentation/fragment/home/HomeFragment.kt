package com.dust.exchat.presentation.fragment.home

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.dust.exchat.R
import com.dust.exchat.databinding.FragmentHomeBinding
import com.dust.exchat.presentation.cviews.button.BoldButton
import com.dust.exchat.presentation.cviews.textview.BoldTextView
import com.dust.exchat.presentation.cviews.textview.NormalTextView
import com.dust.exchat.utils.UserContainer
import dagger.hilt.android.AndroidEntryPoint
import de.hdodenhof.circleimageview.CircleImageView

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val mViewModel by viewModels<HomeFragmentViewModel>()

    private lateinit var mBinding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initViews()
    }

    private fun initToolbar() {
        mBinding.tbHomeToolbar.apply {
            setNavigationIcon(R.drawable.humberger)
            setNavigationOnClickListener {
                mBinding.dlHomeDrawer.openDrawer(Gravity.START)
            }
        }

        mBinding.nvHomeNavView.getHeaderView(0).apply {

            findViewById<BoldButton>(R.id.bbtn_navigationHeader_logout).setOnClickListener {
                mViewModel.logout()
                findNavController().setGraph(R.navigation.nav_login_signup)
            }

            UserContainer.getCurrentUser()?.let {
                if (it.userName.isNotEmpty())
                    findViewById<BoldTextView>(R.id.btv_navigationHeader_userName).text =
                        it.userName
                findViewById<NormalTextView>(R.id.btv_navigationHeader_email).text = it.email
                Glide.with(requireContext()).load(it.profilePic.ifEmpty { null })
                    .placeholder(R.drawable.ic_intersect_settings)
                    .into(findViewById<CircleImageView>(R.id.civ_navigationHeader_avatar))

            }

        }

        mBinding.nvHomeNavView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.profile -> {
                    findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
                }
                R.id.settings -> {
                    findNavController().navigate(R.id.action_homeFragment_to_settingsFragment)
                }
            }
            return@setNavigationItemSelectedListener true
        }

    }

    private fun initViews() {

    }
}