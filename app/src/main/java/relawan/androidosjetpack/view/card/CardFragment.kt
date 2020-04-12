package relawan.androidosjetpack.view.card

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import relawan.androidosjetpack.R
import relawan.androidosjetpack.adapter.CardAndroidOsAdapter
import relawan.androidosjetpack.adapter.ListAndroidOsAdapter
import relawan.androidosjetpack.databinding.FragmentCardBinding
import relawan.androidosjetpack.model.AndroidOs
import relawan.androidosjetpack.utils.AndroidOsData
import relawan.androidosjetpack.view.list.ListFragmentDirections
import relawan.androidosjetpack.viewmodel.HomeViewModel

/**
 * A simple [Fragment] subclass.
 */
class CardFragment : Fragment() {

    private lateinit var cardViewModel: HomeViewModel

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

        cardViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        list.addAll(AndroidOsData.getListData())

        cardViewModel.modeCard.observe(viewLifecycleOwner, Observer {
            setActionBarTitle(it)
        })
        showRecyclerCardView()

        return binding.root
    }

    private fun setActionBarTitle(title: String) {
        (activity as AppCompatActivity).supportActionBar?.title = title
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
