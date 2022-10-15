package com.example.moviesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.moviesapp.DB.MyDbHelper
import com.example.moviesapp.Models.User
import com.example.moviesapp.databinding.FragmentAddBinding
import com.example.moviesapp.databinding.FragmentHomeBinding

class AddFragment : Fragment() {
    lateinit var binding: FragmentAddBinding
    lateinit var list: ArrayList<User>
    lateinit var myDbHelper: MyDbHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(layoutInflater)
        myDbHelper = MyDbHelper(binding.root.context)
        list = myDbHelper.getUser()
        binding.btnStart.setOnClickListener {
            val user = User(
                binding.movieName.text.toString(),
                binding.movieAuthors.text.toString(),
                binding.aboutMovie.text.toString(),
                binding.movieDate.text.toString(),
            )
            list.add(user)
            myDbHelper.addUser(user)
            findNavController().popBackStack()
        }


        return binding.root
    }
}