package relawan.androidosjetpack.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import relawan.androidosjetpack.databinding.ItemCardAndroidosBinding
import relawan.androidosjetpack.model.AndroidOs

class CardAndroidOsAdapter(private val context: Context, private val onClickListener: OnClickListener) : RecyclerView.Adapter<CardAndroidOsAdapter.CardViewHolder>() {

    var data = listOf<AndroidOs>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(data[position].photo)
            .apply(RequestOptions().override(350, 350))
            .into(holder.imgPhoto)

        holder.tvName.text = context.getText(data[position].name)
        holder.tvRemarks.text = context.getText(data[position].remarks)

        holder.btnFavorite.setOnClickListener {
            Toast.makeText(context, data[position].name, Toast.LENGTH_LONG).show()
        }

        holder.btnShare.setOnClickListener {
            Toast.makeText(context, data[position].name, Toast.LENGTH_LONG).show()
        }

        val item = data[position]
        holder.itemView.setOnClickListener {
            onClickListener.onClick(item)
        }
    }

    class CardViewHolder(val binding: ItemCardAndroidosBinding) : RecyclerView.ViewHolder(binding.root) {

        val imgPhoto = binding.imgItemPhoto
        val tvName = binding.tvItemName
        val tvRemarks = binding.tvItemRemarks
        val btnFavorite = binding.btnSetFavorite
        val btnShare = binding.btnSetShare

        companion object {
            // binding viewHolder
            fun from(parent: ViewGroup): CardViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)

                val binding = ItemCardAndroidosBinding.inflate(layoutInflater, parent, false)
                return CardViewHolder(binding)
            }
        }
    }

    // click listener
    class OnClickListener(val clickListener: (android: AndroidOs) -> Unit) {
        fun onClick(android: AndroidOs) = clickListener(android)
    }
}