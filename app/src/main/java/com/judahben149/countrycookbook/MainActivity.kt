package com.judahben149.countrycookbook

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.apollographql.apollo3.ApolloClient
import com.judahben149.GetAllContinentsQuery
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            val response = apolloClient.query(GetAllContinentsQuery()).execute()
            Log.d("TAG", "Success ${response.data}")

            findViewById<TextView>(R.id.tv_countries).text = response.data.toString()
        }
    }
}