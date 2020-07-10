package com.chiiia12.bottomnavigationsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.chiiia12.bottomnavigationsample.databinding.FragmentViewPager2Binding

class ViewPager2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentViewPager2Binding.inflate(layoutInflater)
        val param1 = arguments?.getString(ARG_PARAM_1) ?: ""
        binding.title.text = param1
        val pagerAdapter = ViewPager2PagerAdapter(this, listOf("aaa", "bbb"))
        binding.viewPager.apply {
            adapter = pagerAdapter
        }
        showToast(requireContext(), "$param1 MainFragment:onCreateView")
        return binding.root
    }

    companion object {
        private const val ARG_PARAM_1 = "ARG_PARAM_1"

        @JvmStatic
        fun newInstance(param1: String) = ViewPager2Fragment().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM_1, param1)
            }
        }
    }
}

class ViewPager2PagerAdapter(
    private val fragment: Fragment,
    private val textList: List<String>
) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = textList.size

    override fun createFragment(position: Int): Fragment {
        val fragment = fragment.childFragmentManager.findFragmentByTag(getFragmentTag(position))
        if (fragment != null) {
            return fragment
        }
        return ChildFragment.newInstance(textList[position])
    }

    private fun getFragmentTag(position: Int): String {
        return "android:switcher:" + R.id.viewPager + ":" + position
    }

}

