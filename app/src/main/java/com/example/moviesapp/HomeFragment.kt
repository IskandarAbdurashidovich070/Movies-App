package com.example.moviesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.moviesapp.DB.MyDbHelper
import com.example.moviesapp.Models.User
import com.example.moviesapp.databinding.FragmentHomeBinding
import com.example.moviesapp.databinding.FragmentShowBinding
import com.example.moviesapp.databinding.ItemRvBinding

class HomeFragment : Fragment(), RvAdaper.RvClick {
    lateinit var binding: FragmentHomeBinding
    lateinit var rvAdaper: RvAdaper
    lateinit var list: ArrayList<User>
    lateinit var myDbHelper: MyDbHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        myDbHelper = MyDbHelper(binding.root.context)
        list = myDbHelper.getUser()



        binding.apply {
            add.setOnClickListener {
                findNavController().navigate(R.id.addFragment)
            }
        }

        rvAdaper = RvAdaper(this,list)

        binding.rv.adapter = rvAdaper

        return binding.root
    }

    override fun itemClick(user: User) {
        list.removeAt(list.indexOf(user))
        myDbHelper.deleteUser(user)
        rvAdaper.notifyItemRemoved(list.indexOf(user))    }

    override fun clickCard(position: Int) {
        movies.index = position
        findNavController().navigate(R.id.showFragment)
    }

    override fun editClick(position: Int) {
        movies.index = position
        findNavController().navigate(R.id.editFragment)
    }
}

object movies{
    var index = 0
    var index2 = 0

}