package relawan.androidosjetpack.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import relawan.androidosjetpack.databinding.ItemGridAndroidosBinding
import relawan.androidosjetpack.model.AndroidOs

class GridAndroidOsAdapter(private val onClickListener: OnClickListener) : RecyclerView.Adapter<GridAndroidOsAdapter.GridViewHolder>() {

    var data = listOf<AndroidOs>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        return GridViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(data[position].photo)
            .apply(RequestOptions().override(350, 350))
            .into(holder.imgPhoto)

        val item = data[position]
        holder.itemView.setOnClickListener {
            onClickListener.onClick(item)
        }
    }

    class GridViewHolder(val binding: ItemGridAndroidosBinding) : RecyclerView.ViewHolder(binding.root) {

        val imgPhoto = binding.imageView

        companion object {
            // binding viewHolder
            fun from(parent: ViewGroup): GridViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)

                val binding = ItemGridAndroidosBinding.inflate(layoutInflater, parent, false)
                return GridViewHolder(binding)
            }
        }
    }

    // click listener
    class OnClickListener(val clickListener: (android: AndroidOs) -> Unit) {
        fun onClick(android: AndroidOs) = clickListener(android)
    }

}