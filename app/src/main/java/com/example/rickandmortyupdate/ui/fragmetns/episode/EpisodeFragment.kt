package com.example.rickandmortyupdate.ui.fragmetns.episode

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyupdate.R
import com.example.rickandmortyupdate.base.BaseFragment
import com.example.rickandmortyupdate.databinding.FragmentEpisodeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodeFragment : BaseFragment<FragmentEpisodeBinding, EpisodeViewModel>(
    R.layout.fragment_episode
) {
    override val binding by viewBinding(FragmentEpisodeBinding::bind)
    override val viewModel: EpisodeViewModel by viewModels()
}