package com.katyrin.githubusers.ui

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.katyrin.githubusers.R
import com.katyrin.githubusers.data.GithubUsersRepo
import com.katyrin.githubusers.databinding.ActivityMainBinding
import com.katyrin.githubusers.presenter.MainPresenter
import com.katyrin.githubusers.presenter.MainView
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    private val presenter by moxyPresenter { MainPresenter(GithubUsersRepo()) }
    private var adapter: UsersRVAdapter? = null
    private var vb: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)
    }

    override fun init() {
        vb?.rvUsers?.layoutManager = LinearLayoutManager(this)
        adapter = UsersRVAdapter(presenter.usersListPresenter)
        vb?.rvUsers?.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }
}