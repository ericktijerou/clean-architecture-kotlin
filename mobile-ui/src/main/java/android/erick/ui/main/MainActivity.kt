package android.erick.ui.main

import android.erick.presentation.main.MainUsersContract
import android.erick.presentation.model.UserView
import android.erick.ui.R
import android.erick.ui.mapper.UserMapper
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity: AppCompatActivity(), MainUsersContract.View {

    @Inject lateinit var onboardingPresenter: MainUsersContract.Presenter
    @Inject lateinit var browseAdapter: MainAdapter
    @Inject lateinit var mapper: UserMapper

    override fun setPresenter(presenter: MainUsersContract.Presenter) {
        onboardingPresenter = presenter
    }

    override fun hideProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun showProgress() {
        progress.visibility = View.GONE
    }

    override fun showUsers(users: List<UserView>) {
        browseAdapter.users = users.map { mapper.mapToViewModel(it) }
        browseAdapter.notifyDataSetChanged()
        recycler_browse.visibility = View.VISIBLE
    }

    override fun hideUsers() {
        recycler_browse.visibility = View.VISIBLE
    }

    override fun showErrorState() {
    }

    override fun hideErrorState() {
    }

    override fun showEmptyState() {
    }

    override fun hideEmptyState() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
        setupBrowseRecycler()
    }

    override fun onStart() {
        super.onStart()
        onboardingPresenter.start()
    }

    private fun setupBrowseRecycler() {
        recycler_browse.layoutManager = LinearLayoutManager(this)
        recycler_browse.adapter = browseAdapter
    }

}