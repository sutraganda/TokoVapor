package com.example.tokovapor2.ui

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.tokovapor2.R
import com.example.tokovapor2.model.Vapors
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class FirstFragmentDirections private constructor() {
  private data class ActionFirstFragmentToSecondFragment(
    public val vapors: Vapors?
  ) : NavDirections {
    public override val actionId: Int = R.id.action_FirstFragment_to_SecondFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(Vapors::class.java)) {
          result.putParcelable("vapors", this.vapors as Parcelable?)
        } else if (Serializable::class.java.isAssignableFrom(Vapors::class.java)) {
          result.putSerializable("vapors", this.vapors as Serializable?)
        } else {
          throw UnsupportedOperationException(Vapors::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  public companion object {
    public fun actionFirstFragmentToSecondFragment(vapors: Vapors?): NavDirections =
        ActionFirstFragmentToSecondFragment(vapors)

    public fun actionFirstFragmentToAboutFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_FirstFragment_to_AboutFragment)

    public fun actionFirstFragmentToCatalogFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_FirstFragment_to_CatalogFragment)

    public fun actionFirstFragmentToContactFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_FirstFragment_to_ContactFragment)
  }
}
