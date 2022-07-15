package com.kotlin.harrypotterapp.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.kotlin.harrypotterapp.databinding.FragmentWebBinding


class WebFragment : Fragment() {


    private var _binding: FragmentWebBinding? = null
    private val binding get() = _binding!!

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWebBinding.inflate(inflater, container, false)

        binding.progressBarWeb.visibility = View.VISIBLE

        webView()


        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun webView() {

        binding.webView.webViewClient = WebViewClient()

        binding.webView.settings.javaScriptEnabled = true

        binding.webView.webViewClient = object : WebViewClient(){
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                binding.progressBarWeb.visibility = View.GONE
                //binding.progressBarWeb.visibility = View.VISIBLE
            }
        }
        binding.webView.loadUrl("https://www.wizardstore.com.ar/")


    }

}