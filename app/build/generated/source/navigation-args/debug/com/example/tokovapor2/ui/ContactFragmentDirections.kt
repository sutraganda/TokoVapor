package com.example.tokovapor2.ui

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.tokovapor2.R

public class ContactFragmentDirections private constructor() {
  public companion object {
    public fun actionContactFragmentToFirstFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_ContactFragment_to_FirstFragment)
  }
}
