package com.example.tokovapor2.ui

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.tokovapor2.R

public class AboutFragmentDirections private constructor() {
  public companion object {
    public fun actionAboutFragmentToFirstFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_AboutFragment_to_FirstFragment)
  }
}
