package com.paba.projectpaba.getyoutubevideo

import com.google.gson.annotations.SerializedName

data class YoutubeResponse(

	@field:SerializedName("items")
	val items: List<ItemsItem?>? = null
)

data class Standard(

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
)

data class Thumbnails(

	@field:SerializedName("standard")
	val standard: Standard? = null,

	@field:SerializedName("default")
	val jsonMemberDefault: JsonMemberDefault? = null,

	@field:SerializedName("high")
	val high: High? = null,

	@field:SerializedName("maxres")
	val maxres: Maxres? = null,

	@field:SerializedName("medium")
	val medium: Medium? = null
)

data class Snippet(

	@field:SerializedName("publishedAt")
	val publishedAt: String? = null,

	@field:SerializedName("defaultAudioLanguage")
	val defaultAudioLanguage: String? = null,

	@field:SerializedName("localized")
	val localized: Localized? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("thumbnails")
	val thumbnails: Thumbnails? = null,

	@field:SerializedName("channelId")
	val channelId: String? = null,

	@field:SerializedName("categoryId")
	val categoryId: String? = null,

	@field:SerializedName("channelTitle")
	val channelTitle: String? = null,

	@field:SerializedName("tags")
	val tags: List<String?>? = null,

	@field:SerializedName("liveBroadcastContent")
	val liveBroadcastContent: String? = null
)

data class Maxres(

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
)

data class High(

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
)

data class Statistics(

	@field:SerializedName("viewCount")
	val viewCount: String? = null,

	@field:SerializedName("favoriteCount")
	val favoriteCount: String? = null,

	@field:SerializedName("commentCount")
	val commentCount: String? = null
)

data class ItemsItem(

	@field:SerializedName("snippet")
	val snippet: Snippet? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("statistics")
	val statistics: Statistics? = null
)

data class Localized(

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)

data class Medium(

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
)

data class JsonMemberDefault(

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
)
