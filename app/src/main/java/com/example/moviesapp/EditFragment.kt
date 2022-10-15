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
import com.example.moviesapp.databinding.FragmentEditBinding
import com.example.moviesapp.databinding.FragmentShowBinding

class EditFragment : Fragment() {
    lateinit var binding: FragmentEditBinding
    lateinit var myDbHelper: MyDbHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditBinding.inflate(layoutInflater)

        myDbHelper = MyDbHelper(binding.root.context)

        var list = myDbHelper.getUser()

        binding.movieEdtName.setText(list[movies.index2].name)
        binding.movieEdtAuthors.setText(list[movies.index2].authors)
        binding.aboutEdtMovie.setText(list[movies.index2].about)
        binding.movieEdtDate.setText(list[movies.index2].date)

        binding.btnEdtFragment.setOnClickListener {
           val name = binding.movieEdtName.text.toString()
           val authors = binding.movieEdtAuthors.text.toString()
           val about = binding.aboutEdtMovie.text.toString()
           val date = binding.movieEdtDate.text.toString()
            if (name.isNotEmpty() && authors.isNotEmpty() && about.isNotEmpty() && date.isNotEmpty()){
                val user = list[movies.index2]
                user.name = name
                user.authors = authors
                user.about = about
                user.date = date
                myDbHelper.updateUser(user)
                findNavController().popBackStack()
            }else{
                Toast.makeText(context, "Empty", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }
}