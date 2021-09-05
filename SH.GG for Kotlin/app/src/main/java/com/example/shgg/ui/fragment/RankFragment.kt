package com.example.shgg.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.shgg.R
import com.example.shgg.databinding.FragmentRankBinding

class RankFragment : Fragment() {

    private lateinit var binding: FragmentRankBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRankBinding.inflate(inflater, container, false)

        binding.textDashboard.setText("binding success")

        return binding.root
    }
}