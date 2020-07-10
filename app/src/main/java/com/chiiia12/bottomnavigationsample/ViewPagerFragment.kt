package com.chiiia12.bottomnavigationsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.chiiia12.bottomnavigationsample.databinding.FragmentViewPagerBinding

class ViewPagerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentViewPagerBinding.inflate(layoutInflater)
        val param1 = arguments?.getString(ARG_PARAM_1) ?: ""
        binding.title.text = param1
        val pagerAdapter = ViewPagerPagerAdapter(requireFragmentManager(), listOf("aaa", "bbb"))
        binding.viewPager.apply {
            adapter = pagerAdapter
        }
        showToast(requireContext(), "$param1 MainFragment:onCreateView")
        return binding.root
    }

    companion object {
        private const val ARG_PARAM_1 = "ARG_PARAM_1"

        @JvmStatic
        fun newInstance(param1: String) = ViewPagerFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM_1, param1)
            }
        }
    }
}

class ViewPagerPagerAdapter(
    private val fragmentManager: FragmentManager,
    private val textList: List<String>
) : FragmentStatePagerAdapter(fragmentManager) {

    private fun getFragmentTag(position: Int): String {
        return "android:switcher:" + R.id.viewPager + ":" + position
    }

    override fun getItem(position: Int): Fragment {
        val fragment = fragmentManager.findFragmentByTag(getFragmentTag(position))
        if (fragment != null) {
            return fragment
        }
        return ChildFragment.newInstance(textList[position])
    }

    override fun getCount(): Int {
        return textList.size
    }

}
