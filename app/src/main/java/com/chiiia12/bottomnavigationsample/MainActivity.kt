package com.chiiia12.bottomnavigationsample

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.chiiia12.bottomnavigationsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu1, R.id.menu2 -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(
                            R.id.container,
                            ViewPager2Fragment.newInstance(it.title.toString())
                        )
                        commit()
                    }
                }
                else -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(
                            R.id.container,
                            ViewPagerFragment.newInstance(it.title.toString())
                        )
                        commit()
                    }
                }
            }
            true
        }
        binding.bottomNav.selectedItemId = R.id.menu1
    }
}

fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}