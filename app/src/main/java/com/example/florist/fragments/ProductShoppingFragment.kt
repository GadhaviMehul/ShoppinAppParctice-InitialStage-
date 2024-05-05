package com.example.florist.fragments

import android.os.Bundle
import android.view.*
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.florist.App
import com.example.florist.databinding.FragmentProductShoppingBinding
import com.example.florist.viewmodels.MainViewModel
import com.example.florist.viewmodels.MainViewModelFactory


class ProductShoppingFragment : Fragment() {

    private lateinit var binding: FragmentProductShoppingBinding
    private val args by navArgs<ProductShoppingFragmentArgs>()
    private lateinit var MainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductShoppingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = (activity?.application as App).repository

        MainViewModel = ViewModelProvider(
            this,
            MainViewModelFactory(repository)
        )[com.example.florist.viewmodels.MainViewModel::class.java]
        binding.title.text = args.currentProduct.title
        binding.price.text = "$" + args.currentProduct.price.toString()
        Glide.with(this@ProductShoppingFragment).load(args.currentProduct.image).into(binding.productimage)
    }
}
