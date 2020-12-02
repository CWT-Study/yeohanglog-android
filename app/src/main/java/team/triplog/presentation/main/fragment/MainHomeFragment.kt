package team.triplog.presentation.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import team.triplog.data.local.TripLog
import team.triplog.databinding.FragmentMainHomeBinding
import team.triplog.presentation.main.adapter.MainHomeAdapter
import team.triplog.presentation.main.viewmodel.MainViewModel
import team.triplog.presentation.main.viewmodel.TripLogViewModel
import team.triplog.presentation.main.viewmodel.UserViewModel

class MainHomeFragment : Fragment(), MainHomeAdapter.OnItemClickListener {
    private lateinit var binding: FragmentMainHomeBinding

    private val mainViewModel: MainViewModel by sharedViewModel()
    private val tripLogViewModel: TripLogViewModel by viewModel()
    private val userViewModel: UserViewModel by viewModel()

    private val mainHomeAdapter: MainHomeAdapter by lazy {
        MainHomeAdapter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun setup() {
        setViewModel()
        setRecyclerView()
    }

    private fun setViewModel() {
        binding.mainViewModel = mainViewModel
        binding.userViewModel = userViewModel
        binding.tripLogViewModel = tripLogViewModel
    }

    private fun setRecyclerView() {
        binding.recyclerLookBack.adapter = mainHomeAdapter
    }

    /**
     * 톺아보기 메뉴 아이템 클릭
     */
    override fun onItemClick(item: TripLog) {
        // TODO : 아이템 클릭시 화면 출력
    }
}