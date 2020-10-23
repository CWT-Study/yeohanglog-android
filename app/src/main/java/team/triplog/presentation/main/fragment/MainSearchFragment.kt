package team.triplog.presentation.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import team.triplog.databinding.FragmentMainSearchBinding

class MainSearchFragment : Fragment() {
    private lateinit var binding: FragmentMainSearchBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainSearchBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        return binding.root
    }
}