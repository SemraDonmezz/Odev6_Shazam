package com.example.odev6_shazam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.odev6_shazam.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var tasarim:FragmentMainBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        tasarim=FragmentMainBinding.inflate(inflater, container, false)

        tasarim.toolbarMain.title="Shazam"

        val musicList=ArrayList<MyMusics>()
        val m1=MyMusics(1,"Pink Floyd","Comfortably Numb","pinkfloyd","The Wall",1979)
        val m2=MyMusics(2,"Gökçe Kılınçer","Güneşin Kızkardeşi","gokcekilincer","Kalbimde İzi Var",2016)
        val m3=MyMusics(3,"London Grammer","Strong","londongrammer","If You Wait",2013)
        val m4=MyMusics(4,"Erica Jenning","It's a Lovely Day","ericajenning","Living Theater",2008)
        val m5=MyMusics(5,"Childish Gambino","Les","childishgambino","Camp",2011)
        musicList.add(m1)
        musicList.add(m2)
        musicList.add(m3)
        musicList.add(m4)
        musicList.add(m5)
        tasarim.rv.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        val adapter=MusicAdapter(requireContext(),musicList)
        tasarim.rv.adapter=adapter


        return  tasarim.root
    }
}