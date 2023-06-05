package com.bhagyawant.moviedb.data.model

import com.google.gson.annotations.SerializedName


data class RatingsDto (
  @SerializedName("Source" ) var Source : String? = null,
  @SerializedName("Value"  ) var Value  : String? = null
)