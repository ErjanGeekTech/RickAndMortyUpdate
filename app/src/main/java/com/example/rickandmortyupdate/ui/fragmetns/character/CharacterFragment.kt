package com.example.rickandmortyupdate.ui.fragmetns.character

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyupdate.R
import com.example.rickandmortyupdate.base.BaseFragment
import com.example.rickandmortyupdate.databinding.FragmentCharacterBinding
import com.example.rickandmortyupdate.ui.adapters.CharacterAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterFragment : BaseFragment<FragmentCharacterBinding, CharacterViewModel>(
    R.layout.fragment_character
) {
    override val binding by viewBinding(FragmentCharacterBinding::bind)
    override val viewModel: CharacterViewModel by viewModels()
    private val characterAdapter = CharacterAdapter()

    override fun setupRequests() {
        super.setupRequests()
        fetchChacaters()
    }

    private fun fetchChacaters() {
        lifecycleScope.launch {
            viewModel.fetchCharacter().collectLatest {
                characterAdapter.submitData(it)
            }
        }
    }

    override fun setupViews() {
        super.setupViews()
        setupRecycler()
    }

    private fun setupRecycler() {
        binding.rv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = characterAdapter
        }
    }



}