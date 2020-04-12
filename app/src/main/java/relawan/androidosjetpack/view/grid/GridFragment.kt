package relawan.androidosjetpack.view.grid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import relawan.androidosjetpack.R
import relawan.androidosjetpack.adapter.GridAndroidOsAdapter
import relawan.androidosjetpack.databinding.FragmentGridBinding
import relawan.androidosjetpack.model.AndroidOs
import relawan.androidosjetpack.utils.AndroidOsData
import relawan.androidosjetpack.view.list.ListFragmentDirections
import relawan.androidosjetpack.viewmodel.HomeViewModel

/**
 * A simple [Fragment] subclass.
 */
class GridFragment : Fragment() {

    private lateinit var gridViewModel: HomeViewModel

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

        gridViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        list.addAll(AndroidOsData.getListData())

        gridViewModel.modeGrid.observe(viewLifecycleOwner, Observer {
            setActionBarTitle(it)
        })
        showRecyclerGrid()

        return binding.root
    }

    private fun setActionBarTitle(title: String) {
        (activity as AppCompatActivity).supportActionBar?.title = title
    }

    private fun showRecyclerGrid() {
        val adapter = GridAndroidOsAdapter(GridAndroidOsAdapter.OnClickListener {
            Toast.makeText(context, it.name, Toast.LENGTH_LONG).show()
            val action = GridFragmentDirections.actionGridFragmentToDetailFragment(null, it, null)
            findNavController().navigate(action)
        })
        rvCategory.layoutManager = GridLayoutManager(context, 2)
        rvCategory.adapter = adapter
        adapter.data = list
    }

}
