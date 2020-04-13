package relawan.androidosjetpack.view.list

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import relawan.androidosjetpack.adapter.ListAndroidOsAdapter
import relawan.androidosjetpack.databinding.FragmentListBinding
import relawan.androidosjetpack.model.AndroidOs
import relawan.androidosjetpack.utils.AndroidOsData

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {


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


        list.addAll(AndroidOsData.getListData())

        showRecyclerList()

        return binding.root
    }



    private fun showRecyclerList() {
        val adapter = ListAndroidOsAdapter(context!!, ListAndroidOsAdapter.OnClickListener {
            Toast.makeText(context, it.name, Toast.LENGTH_LONG).show()
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(it)
            findNavController().navigate(action)
        })
        rvCategory.layoutManager = LinearLayoutManager(context)
        rvCategory.adapter = adapter
        adapter.data = list
    }
}
