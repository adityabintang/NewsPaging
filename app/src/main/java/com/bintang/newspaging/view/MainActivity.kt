package com.bintang.newspaging.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bintang.newspaging.R
import com.bintang.newspaging.adapter.AdapterPlayer
import com.bintang.newspaging.databinding.ActivityListItemPlayerBinding
import com.bintang.newspaging.databinding.ActivityMainBinding
import com.bintang.newspaging.viewmodel.PlayerViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: PlayerViewModel
    lateinit var adapter: AdapterPlayer
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this).get(PlayerViewModel::class.java)
        adapter = AdapterPlayer()

        setUpAdapter()
        startJob()
    }

    private fun setUpAdapter() {
        binding.listPlayer.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        binding.listPlayer.adapter = adapter
    }

    private fun startJob() {
        lifecycleScope.launch {
            viewModel.getPlayer()?.collect {
                adapter.submitData(it)
            }
        }
    }
}