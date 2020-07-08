package com.chiiia12.bottomnavigationsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.chiiia12.bottomnavigationsample.databinding.FragmentChildBinding

private const val ARG_PARAM1 = "param1"

class ChildFragment : Fragment() {
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentChildBinding.inflate(inflater)
        binding.title.text = param1
//        showToast(requireContext(), "$param1 ChildFragment:onCreateView")
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            ChildFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}