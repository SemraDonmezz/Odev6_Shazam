package com.example.odev6_shazam

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.odev6_shazam.databinding.MusicCardViewBinding
import com.google.android.material.snackbar.Snackbar

class MusicAdapter(var mContext: Context, var musicListesi:List<MyMusics>)
    :RecyclerView.Adapter<MusicAdapter.CardTasarimTutucu>() {

    inner class  CardTasarimTutucu(tasarim: MusicCardViewBinding): RecyclerView.ViewHolder(tasarim.root){
        var tasarim:MusicCardViewBinding
        init {
            this.tasarim=tasarim
        }
    }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
            val tasarim= MusicCardViewBinding.inflate(LayoutInflater.from(mContext), parent, false)
            return CardTasarimTutucu(tasarim)
        }

        override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
            val music=musicListesi.get(position)
            val t=holder.tasarim
            t.imageSongPicture.setImageResource(mContext.resources.getIdentifier(
                music.musicPictureName,"drawable",mContext.packageName))
            t.textMusicName.text=music.musicName
            t.textSingerName.text=music.musicSingerName
            t.btnMusic.setOnClickListener {
                Snackbar.make(it,"Play it free ${music.musicName}",Snackbar.LENGTH_SHORT)
                    .setAction("OKAY"){
                    }.show()
            }
            t.imageSongPicture.setOnClickListener {
                var passing=MainFragmentDirections.detailPassing(music=music)
                Navigation.findNavController(it).navigate(passing)
            }
        }

        override fun getItemCount(): Int {
            return musicListesi.size
        }
    }

