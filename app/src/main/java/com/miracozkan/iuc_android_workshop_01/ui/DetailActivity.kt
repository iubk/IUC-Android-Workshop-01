package com.miracozkan.iuc_android_workshop_01.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.miracozkan.iuc_android_workshop_01.R
import com.miracozkan.iuc_android_workshop_01.remote.model.Data
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private val movieItem by lazy { intent.getParcelableExtra<Data>("movieItem") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        initUi()
    }

    private fun initUi() {
        movieItem?.let {
            Picasso
                .get()
                .load(it.poster)
                .into(imgDetailPoster)

            txtMovieAbout.text = it.about
            txtMovieDirector.text = it.director
            txtMovieGenre.text = it.genre
            txtMovieYear.text = it.year
            txtMovieName.text = it.title
        }
    }
}
