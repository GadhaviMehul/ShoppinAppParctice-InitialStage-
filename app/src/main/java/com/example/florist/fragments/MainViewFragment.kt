package com.example.florist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.manager.SupportRequestManagerFragment
import com.example.florist.adapters.Adapter
import com.example.florist.App
import com.example.florist.R
import com.example.florist.databinding.FragmentMainViewBinding
import com.example.florist.viewmodels.MainViewModel
import com.example.florist.viewmodels.MainViewModelFactory
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainViewFragment : Fragment() {
    lateinit var mainViewModel: MainViewModel
    var adapter: Adapter? = null
    private lateinit var binding: FragmentMainViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        binding = FragmentMainViewBinding.inflate(inflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = (activity?.application as App).repository

        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository))[MainViewModel::class.java]

        mainViewModel.product.observe(viewLifecycleOwner) {
            adapter = Adapter(it, requireContext())
            binding.viewPager.adapter = adapter
            binding.viewPager.setPadding(0, 0, 130, 0)
        }
    }
}