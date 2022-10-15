package com.example.moviesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.moviesapp.DB.MyDbHelper
import com.example.moviesapp.databinding.FragmentShowBinding

class ShowFragment : Fragment() {
    lateinit var binding: FragmentShowBinding
    lateinit var myDbHelper: MyDbHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentShowBinding.inflate(layoutInflater)

        myDbHelper = MyDbHelper(binding.root.context)

        var list = myDbHelper.getUser()

        binding.showName.text = list[movies.index].name
        binding.showAuthors.text = list[movies.index].authors
        binding.showAbout.text = list[movies.index].about
        binding.showDate.text = list[movies.index].date

        binding.btnClose.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }


}