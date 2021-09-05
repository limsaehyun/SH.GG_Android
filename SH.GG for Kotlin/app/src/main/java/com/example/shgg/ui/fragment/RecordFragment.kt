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
import com.example.shgg.databinding.FragmentRecordBinding

class RecordFragment : Fragment() {

    private lateinit var binding: FragmentRecordBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRecordBinding.inflate(inflater, container, false)

        binding.textNotifications.setText("binding success")

        return binding.root
    }
}