package com.example.tokovapor2.ui

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.tokovapor2.R

public class CatalogFragmentDirections private constructor() {
  public companion object {
    public fun actionCatalogFragmentToFirstFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_CatalogFragment_to_FirstFragment)
  }
}
