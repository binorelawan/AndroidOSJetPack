package relawan.androidosjetpack.view.grid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import relawan.androidosjetpack.adapter.GridAndroidOsAdapter
import relawan.androidosjetpack.databinding.FragmentGridBinding
import relawan.androidosjetpack.model.AndroidOs
import relawan.androidosjetpack.utils.AndroidOsData

/**
 * A simple [Fragment] subclass.
 */
class GridFragment : Fragment() {


    private var list: ArrayList<AndroidOs> = arrayListOf()

    lateinit var rvCategory: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentGridBinding.inflate(inflater)

        // lifeCycleOwner
        binding.lifecycleOwner = this

        rvCategory = binding.rvCategory


        list.addAll(AndroidOsData.getListData())

        showRecyclerGrid()

        return binding.root
    }


    private fun showRecyclerGrid() {
        val adapter = GridAndroidOsAdapter(GridAndroidOsAdapter.OnClickListener {
            Toast.makeText(context, it.name, Toast.LENGTH_LONG).show()
            val action = GridFragmentDirections.actionGridFragmentToDetailFragment(it)
            findNavController().navigate(action)
        })
        rvCategory.layoutManager = GridLayoutManager(context, 2)
        rvCategory.adapter = adapter
        adapter.data = list
    }

}
