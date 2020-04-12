package relawan.androidosjetpack.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import relawan.androidosjetpack.databinding.ItemListAndroidosBinding
import relawan.androidosjetpack.model.AndroidOs

class ListAndroidOsAdapter(private val context: Context, private val onClickListener: OnClickListener) : RecyclerView.Adapter<ListAndroidOsAdapter.ListViewHolder>() {

    var data = listOf<AndroidOs>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(data[position].photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgItemPhoto)

        holder.tvName.text = context.getText(data[position].name)
        holder.tvRemarks.text = context.getText(data[position].remarks)

        val item = data[position]
        holder.itemView.setOnClickListener {
            onClickListener.onClick(item)
        }
    }

    class ListViewHolder(private val binding: ItemListAndroidosBinding) : RecyclerView.ViewHolder(binding.root) {

        var tvName = binding.tvItemName
        var tvRemarks = binding.tvItemRemarks
        var imgItemPhoto = binding.imgItemPhoto


        companion object {
            // binding viewHolder
            fun from(parent: ViewGroup): ListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)

                val binding = ItemListAndroidosBinding.inflate(layoutInflater, parent, false)
                return ListViewHolder(binding)
            }
        }
    }

    // click listener
    class OnClickListener(val clickListener: (android: AndroidOs) -> Unit) {
        fun onClick(android: AndroidOs) = clickListener(android)
    }


}