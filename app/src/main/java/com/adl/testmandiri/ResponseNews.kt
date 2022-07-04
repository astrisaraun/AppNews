package com.adl.testmandiri

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseNews(

	@field:SerializedName("sources")
	val sources: List<SourcesItem?>? = null,

	@field:SerializedName("status")
	val status: String? = null
) : Parcelable

@Parcelize
data class SourcesItem(

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("language")
	val language: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("category")
	val category: String? = null,

	@field:SerializedName("url")
	val url: String? = null
) : Parcelable

data class Result2(

	@field:SerializedName("data")
	val data: List<SourcesItem>? = null,
)
