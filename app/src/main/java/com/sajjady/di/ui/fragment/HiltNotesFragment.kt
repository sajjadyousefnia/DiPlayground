package com.sajjady.di.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HiltNotesFragment : Fragment() {
    private val viewModel: HiltNotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val layout = LinearLayout(requireContext()).apply { orientation = LinearLayout.VERTICAL }
        viewModel.notes().forEach { note ->
            layout.addView(TextView(requireContext()).apply { text = note.title })
        }
        return layout
    }
}
