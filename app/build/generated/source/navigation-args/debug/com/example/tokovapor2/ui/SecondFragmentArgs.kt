package com.example.tokovapor2.ui

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.example.tokovapor2.model.Vapors
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class SecondFragmentArgs(
  public val vapors: Vapors?
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
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

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(Vapors::class.java)) {
      result.set("vapors", this.vapors as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(Vapors::class.java)) {
      result.set("vapors", this.vapors as Serializable?)
    } else {
      throw UnsupportedOperationException(Vapors::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): SecondFragmentArgs {
      bundle.setClassLoader(SecondFragmentArgs::class.java.classLoader)
      val __vapors : Vapors?
      if (bundle.containsKey("vapors")) {
        if (Parcelable::class.java.isAssignableFrom(Vapors::class.java) ||
            Serializable::class.java.isAssignableFrom(Vapors::class.java)) {
          __vapors = bundle.get("vapors") as Vapors?
        } else {
          throw UnsupportedOperationException(Vapors::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"vapors\" is missing and does not have an android:defaultValue")
      }
      return SecondFragmentArgs(__vapors)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): SecondFragmentArgs {
      val __vapors : Vapors?
      if (savedStateHandle.contains("vapors")) {
        if (Parcelable::class.java.isAssignableFrom(Vapors::class.java) ||
            Serializable::class.java.isAssignableFrom(Vapors::class.java)) {
          __vapors = savedStateHandle.get<Vapors?>("vapors")
        } else {
          throw UnsupportedOperationException(Vapors::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"vapors\" is missing and does not have an android:defaultValue")
      }
      return SecondFragmentArgs(__vapors)
    }
  }
}
