package com.example.testapp.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.testapp.R
import com.example.testapp.data.api.ApiFactory
import com.example.testapp.data.repositories.MainRepository
import com.example.testapp.domain.interactors.MainInteractor
import com.example.testapp.domain.models.Company
import com.example.testapp.presentation.adapters.CompanyListAdapter
import com.example.testapp.presentation.interfaces.CompanyListInterface
import com.example.testapp.presentation.presenters.CompanyListPresenter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_company_list.*

class CompanyListActivity : AppCompatActivity(), CompanyListInterface.View {
    lateinit var presenter: CompanyListInterface.Presenter
    private lateinit var rvAdapter: CompanyListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_list)

        presenter = CompanyListPresenter(MainInteractor.getInstance(MainRepository(ApiFactory.getRestClient(applicationContext))), this)
        presenter.init()
    }

    override fun initVars() {
        rvAdapter = CompanyListAdapter(mutableListOf(), presenter)

        rvCompanyList.setHasFixedSize(true)
        rvCompanyList.layoutManager = GridLayoutManager(applicationContext, 1)
        rvCompanyList.adapter = rvAdapter
    }

    override fun setListeners() {
        //TODO("Not yet implemented")
    }

    override fun updateCompanyList(list: List<Company>) {
        rvCompanyList.visibility = View.VISIBLE
        tvEmptyList.visibility = View.GONE

        rvAdapter.updateList(list)

        setLoadingProgressBarVisibility(false)
    }

    override fun updateCompanyListError(message: String) {
        Snackbar.make(clCompanyListActivity, message, Snackbar.LENGTH_LONG).show()
        setLoadingProgressBarVisibility(false)
    }

    override fun setLoadingProgressBarVisibility(visible: Boolean) {
        if (visible)
            pbLoading.visibility = View.VISIBLE
        else
            pbLoading.visibility = View.GONE
    }

    override fun openCompanyCardActivity() {
        val intent = Intent(this, CompanyCardActivity::class.java)
        startActivity(intent)
    }
}