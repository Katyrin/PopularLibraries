package com.katyrin.popularlibraries

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.katyrin.popularlibraries.databinding.ActivityMainBinding
import com.katyrin.popularlibraries.model.CountersModel
import com.katyrin.popularlibraries.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var vb: ActivityMainBinding
    private val presenter = MainPresenter(this, CountersModel())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb.root)

        vb.btnCounter1.setOnClickListener { presenter.counterClick(ButtonNumber.ONE) }
        vb.btnCounter2.setOnClickListener { presenter.counterClick(ButtonNumber.TWO) }
        vb.btnCounter3.setOnClickListener { presenter.counterClick(ButtonNumber.THREE) }
    }

    override fun setButtonTextOne(text: String) {
        vb.btnCounter1.text = text
    }

    override fun setButtonTextTwo(text: String) {
        vb.btnCounter2.text = text
    }

    override fun setButtonTextThree(text: String) {
        vb.btnCounter3.text = text
    }
}