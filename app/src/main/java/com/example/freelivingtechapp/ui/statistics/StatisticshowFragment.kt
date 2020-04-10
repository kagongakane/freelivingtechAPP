package com.example.freelivingtechapp.ui.statistics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.freelivingtechapp.R

class StatisticshowFragment : Fragment() {

    private lateinit var statisticsViewModel: StatisticsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        statisticsViewModel =
            ViewModelProviders.of(this).get(StatisticsViewModel::class.java)


        return inflater.inflate(R.layout.fragment_statistics, container, false)
    }


}
/*        val textView: TextView = root.findViewById(R.id.text_slideshow)
statisticsViewModel.text.observe(this, Observer {
    textView.text = it
})*/
