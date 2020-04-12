package relawan.androidosjetpack.view.list

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import relawan.androidosjetpack.R
import relawan.androidosjetpack.adapter.GridAndroidOsAdapter
import relawan.androidosjetpack.adapter.ListAndroidOsAdapter
import relawan.androidosjetpack.databinding.FragmentListBinding
import relawan.androidosjetpack.model.AndroidOs
import relawan.androidosjetpack.utils.AndroidOsData
import relawan.androidosjetpack.viewmodel.HomeViewModel

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    private lateinit var listViewModel: HomeViewModel

    private var list: ArrayList<AndroidOs> = arrayListOf()

    lateinit var rvCategory: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentListBinding.inflate(inflater)

        // lifeCycleOwner
        binding.lifecycleOwner = this

        rvCategory = binding.rvCategory

        listViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        list.addAll(AndroidOsData.getListData())

        listViewModel.modeList.observe(viewLifecycleOwner, Observer {
            setActionBarTitle(it)
        })
        showRecyclerList()

        return binding.root
    }

    private fun setActionBarTitle(title: String) {
        (activity as AppCompatActivity).supportActionBar?.title = title
    }


    private fun showRecyclerList() {
        val adapter = ListAndroidOsAdapter(context!!, ListAndroidOsAdapter.OnClickListener {
            Toast.makeText(context, it.name, Toast.LENGTH_LONG).show()
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(it, null, null)
            findNavController().navigate(action)
        })
        rvCategory.layoutManager = LinearLayoutManager(context)
        rvCategory.adapter = adapter
        adapter.data = list
    }
}
