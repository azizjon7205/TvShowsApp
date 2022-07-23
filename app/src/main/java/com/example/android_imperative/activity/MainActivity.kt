package com.example.android_imperative.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.android_imperative.R
import com.example.android_imperative.adapter.TvShowAdapter
import com.example.android_imperative.databinding.ActivityMainBinding
import com.example.android_imperative.model.TVShow
import com.example.android_imperative.viewmodel.MainViewModel

class MainActivity : BaseActivity() {
    private val TAG = this::class.java.simpleName

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private val adapterTvShowAdapter by lazy { TvShowAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
//        initObserves()
    }

    private fun initViews() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bnvMain.setupWithNavController(navController)


//        val gridLayoutManager = GridLayoutManager(this, 2)
//        binding.rvHome.layoutManager = gridLayoutManager
//        binding.rvHome.adapter = adapterTvShowAdapter
//
//        adapterTvShowAdapter.onClick = { tvShow, ivMovie ->
//            callDetailsActivity(tvShow, ivMovie)
//            viewModel.insertTvShowToDB(tvShow)
//        }
//
//        binding.rvHome.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
//                if (gridLayoutManager.findLastCompletelyVisibleItemPosition() == adapterTvShowAdapter.itemCount - 1) {
//                    val nextPage = viewModel.tvShowPopular.value!!.page + 1
//                    val totalPages = viewModel.tvShowPopular.value!!.pages
//                    if (nextPage <= totalPages) {
//                        viewModel.apiTVShowPopular(nextPage)
//                    }
//                }
//            }
//        })
//
//        binding.bFab.setOnClickListener {
//            binding.rvHome.smoothScrollToPosition(0)
//        }
//
//        viewModel.apiTVShowPopular(1)
    }


//    private fun initObserves() {
//        // Retrofit
//        viewModel.tvShowsFromApi.observe(this, {
//            Logger.d(TAG, it.size.toString())
//            adapterTvShowAdapter.submitList(it)
////            adapter.setNewTvShows(it)
//        })
//        viewModel.errorMessage.observe(this, {
//            Logger.d(TAG, it.toString())
//        })
//        viewModel.isLoading.observe(this, {
//            Logger.d(TAG, it.toString())
//            if (it) {
//                binding.pbLoading.visibility = View.VISIBLE
//            } else {
//                binding.pbLoading.visibility = View.GONE
//            }
//        })
//
//
//        // Room
//    }

    private fun callDetailsActivity(tvShow: TVShow, sharedImageView: ImageView) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("show_id", tvShow.id)
        intent.putExtra("show_img", tvShow.image_thumbnail_path)
        intent.putExtra("show_name", tvShow.name)
        intent.putExtra("show_network", tvShow.network)
        intent.putExtra("iv_movie", ViewCompat.getTransitionName(sharedImageView))

        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
            this,
            sharedImageView,
            ViewCompat.getTransitionName(sharedImageView)!!
        )

        startActivity(intent, options.toBundle())
    }
}