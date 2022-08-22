package com.hana897trx.beetestandroidkt.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hana897trx.beetestandroidkt.R
import com.kumulos.android.Kumulos
import com.kumulos.android.KumulosConfig
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var config: KumulosConfig

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Kumulos.initialize(application, config)
    }
}