package com.example.rickandmortyupdate.ui.fragmetns.locaiton

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyupdate.R
import com.example.rickandmortyupdate.base.BaseFragment
import com.example.rickandmortyupdate.databinding.FragmentLocationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationFragment : BaseFragment<FragmentLocationBinding, LocationViewModel>(
    R.layout.fragment_location
) {
    override val binding by viewBinding(FragmentLocationBinding::bind)
    override val viewModel: LocationViewModel by viewModels()
}