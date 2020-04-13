package relawan.androidosjetpack.view.detail

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import relawan.androidosjetpack.databinding.FragmentDetailBinding
import relawan.androidosjetpack.viewmodel.DetailModelFactory
import relawan.androidosjetpack.viewmodel.DetailViewModel

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {

    private lateinit var detailViewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentDetailBinding.inflate(inflater)

        val androidOs = arguments?.let { DetailFragmentArgs.fromBundle(it).android }


        val viewModelFactory = DetailModelFactory(androidOs)

        detailViewModel = ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)


        detailViewModel.androidName.observe(viewLifecycleOwner, Observer {
            binding.tvName.text = context?.getText(it)
        })

        detailViewModel.androidRemarks.observe(viewLifecycleOwner, Observer {
            binding.tvRemarks.text = context?.getText(it)
        })

        detailViewModel.androidImage.observe(viewLifecycleOwner, Observer {
            binding.imgPhoto.setImageResource(it)
        })

        detailViewModel.androidDetail.observe(viewLifecycleOwner, Observer {
            binding.tvDetail.text = context?.getText(it)
        })

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
    }

}
