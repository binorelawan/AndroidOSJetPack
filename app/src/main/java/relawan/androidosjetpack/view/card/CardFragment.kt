package relawan.androidosjetpack.view.card

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import relawan.androidosjetpack.adapter.CardAndroidOsAdapter
import relawan.androidosjetpack.databinding.FragmentCardBinding
import relawan.androidosjetpack.model.AndroidOs
import relawan.androidosjetpack.utils.AndroidOsData

/**
 * A simple [Fragment] subclass.
 */
class CardFragment : Fragment() {


    private var list: ArrayList<AndroidOs> = arrayListOf()

    lateinit var rvCategory: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentCardBinding.inflate(inflater)

        // lifeCycleOwner
        binding.lifecycleOwner = this

        rvCategory = binding.rvCategory


        list.addAll(AndroidOsData.getListData())

        showRecyclerCardView()

        return binding.root
    }


    private fun showRecyclerCardView() {
        val adapter = CardAndroidOsAdapter(context!!, CardAndroidOsAdapter.OnClickListener {
            Toast.makeText(context, it.name, Toast.LENGTH_LONG).show()
            val action = CardFragmentDirections.actionCardFragmentToDetailFragment(null, null, it)
            findNavController().navigate(action)
        })
        rvCategory.layoutManager = LinearLayoutManager(context)
        rvCategory.adapter = adapter
        adapter.data = list
    }

}
