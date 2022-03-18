package com.dicoding.submission1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class UserDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)
        val actionbar = supportActionBar
        actionbar!!.title= "User Detail"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val avatar: ImageView = findViewById(R.id.detail_avatar)
        val tvName: TextView = findViewById(R.id.detail_name)
        val tvUsername: TextView = findViewById(R.id.detail_username)
        val tvFollowers: TextView = findViewById(R.id.detail_followers)
        val tvFollowing: TextView = findViewById(R.id.detail_following)
        val tvRepository: TextView = findViewById(R.id.detail_repository)
        val tvCompany: TextView = findViewById(R.id.detail_company)
        val tvLocation: TextView = findViewById(R.id.detail_location)

        val user = intent.getParcelableExtra<User>(DATA) as User

        avatar.setImageResource(user.avatar)
        tvName.text = user.name
        tvUsername.text = user.username
        tvFollowers.text = user.followers
        tvFollowing.text = user.following
        tvCompany.text = user.company
        tvLocation.text = user.location
        tvRepository.text = user.repository
    }

    companion object {
          const val DATA = "0"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}