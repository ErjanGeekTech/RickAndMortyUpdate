package com.example.rickandmortyupdate.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.example.rickandmortyupdate.R

abstract class BaseFragment<B: ViewBinding, V: ViewModel>(
    @LayoutRes layoutId: Int
): Fragment(layoutId) {

    protected abstract val binding: B
    protected abstract val viewModel: V

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupViews()
        setupListener()
        setupRequests()
        setupObserve()
    }

    open fun initialize() {}

    open fun setupViews() {}

    open fun setupListener() {}

    open fun setupRequests() {}

    open fun setupObserve() {}

}