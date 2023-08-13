package com.umc.one_person_households_platform.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.umc.one_person_households_platform.R
import com.umc.one_person_households_platform.databinding.FragmentHomeBinding
import com.umc.one_person_households_platform.view.common.ViewModelFactory

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels { ViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.home = this
        setAdapter()
    }

    private fun setAdapter() {
        val communityAdapter = HomeCommunityAdapter()
        val groupBuyingListAdapter = HomeGroupBuyingAdapter()
        val hotRecipeAdapter = HomeHotRecipeAdapter()

        binding.rvCommunity.adapter = communityAdapter
        binding.rvGroupBuying.adapter = groupBuyingListAdapter
        binding.rvHotRecipe.adapter = hotRecipeAdapter

        viewModel.communityContent.observe(viewLifecycleOwner) {
            communityAdapter.submitList(it)
        }

        viewModel.groupBuyingContent.observe(viewLifecycleOwner) {
            groupBuyingListAdapter.submitList(it)
        }

        viewModel.hotRecipeContent.observe(viewLifecycleOwner) {
            hotRecipeAdapter.submitList(it)
        }
    }

    // 이동 버튼 클릭 이벤트
    fun onMoveButton(view: View) {
        when(view.id) {
            R.id.tv_community_more_detail -> findNavController().navigate(R.id.action_homeFragment_to_communityFragment)
            R.id.tv_group_buying_more_detail -> findNavController().navigate(R.id.action_homeFragment_to_groupBuyingFragment)
            R.id.tv_recipe_more_detail -> findNavController().navigate(R.id.action_homeFragment_to_recipemainFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}