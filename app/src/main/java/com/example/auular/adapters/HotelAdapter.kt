package com.example.auular.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.auular.R
import com.example.auular.R.mipmap
import com.example.auular.domain.Hotel
import com.example.auular.fragments.HotelDetail
import com.squareup.picasso.Picasso

class HotelAdapter : RecyclerView.Adapter<HotelAdapter.HotelViewHolder>() {
    private var resultList: MutableList<Hotel>? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HotelViewHolder {
        val layout =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_hotel, parent, false)
        return HotelViewHolder(layout)
    }

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        val hotel = resultList!![position]
        holder.bind(hotel)


        holder.itemView.setOnClickListener {
            val hotel = resultList!![position]
            val intent = Intent(holder.itemView.context, HotelDetail::class.java)
            intent.putExtra("hotel", hotel);
            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return if (resultList == null) {
            0
        } else {
            resultList!!.size
        }
    }

    fun setResultList(hotels: List<Hotel>) {
        resultList = hotels.toMutableList()
        notifyDataSetChanged()
    }

    inner class HotelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val context = itemView.context

        private val hotelName: TextView = itemView.findViewById(R.id.name_hotel)
        private val hotelDescription: TextView = itemView.findViewById(R.id.descricao_hotel)
        private var hotelImage: ImageView = itemView.findViewById(R.id.hotel_image)

        fun bind(hotel: Hotel) {
            hotelName.text = hotel.name
            hotelDescription.text = hotel.description
            if (!hotel.imageByteArray.isNullOrEmpty()) {
                Picasso.get().load(hotel.imageByteArray).into(hotelImage);
            }
            else {
                  hotelImage.setImageResource(R.mipmap.pethotel);
            }
        }
    }
}