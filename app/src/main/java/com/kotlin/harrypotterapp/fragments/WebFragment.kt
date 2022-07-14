package com.kotlin.harrypotterapp.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.kotlin.harrypotterapp.databinding.FragmentVideosBinding


class WebFragment : Fragment() {


    private var _binding: FragmentVideosBinding? = null
    private val binding get() = _binding!!

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVideosBinding.inflate(inflater, container, false)

        webView()


        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun webView() {

        binding.webView.webViewClient = WebViewClient()

        binding.webView.apply {
             loadUrl("https://www.wizardstore.com.ar/")
             settings.javaScriptEnabled = true
             settings.safeBrowsingEnabled = true
        }

    }

}