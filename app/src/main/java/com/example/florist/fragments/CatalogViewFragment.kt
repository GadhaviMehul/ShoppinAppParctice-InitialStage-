package com.example.florist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.florist.App
import com.example.florist.adapters.MyAdapter
import com.example.florist.databinding.FragmentCatalogViewBinding
import com.example.florist.viewmodels.MainViewModel
import com.example.florist.viewmodels.MainViewModelFactory


class CatalogViewFragment : Fragment() {


    private lateinit var binding: FragmentCatalogViewBinding
    lateinit var mainViewModel: MainViewModel
    var MyAdapter = MyAdapter(this@CatalogViewFragment)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCatalogViewBinding.inflate(inflater, container, false)
        return (binding.root)
    }

    // (requireActivity() as MainActivity).getValue()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repository = (activity?.application as App).repository
        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.product.observe(viewLifecycleOwner) {
            binding.recycler.layoutManager = GridLayoutManager(requireContext(), 2)
            binding.recycler.adapter = MyAdapter
            MyAdapter.setData(this, it)
        }

        MyAdapter.onItemClick = {
            val action =
                CatalogViewFragmentDirections.actionCatalogViewFragmentToProductShoppingFragment(it)
            findNavController().navigate(action)
        }
    }
}