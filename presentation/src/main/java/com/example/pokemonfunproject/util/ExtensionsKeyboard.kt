package com.example.pokemonfunproject.util

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

fun Activity.hideKeyboard() {
    val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    var view = this.currentFocus
    if (view == null) {
        view = View(this)
    }
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Activity.clearFocus() {
    this.currentFocus?.clearFocus()
}

fun Fragment.hideKeyboard() =
    requireActivity().hideKeyboard()

fun Fragment.clearFocus() =
    requireActivity().clearFocus()