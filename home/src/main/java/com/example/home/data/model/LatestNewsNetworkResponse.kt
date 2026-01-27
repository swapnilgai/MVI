package com.example.home.data.model

data class LatestNewsNetworkResponse(
    val status: String,
    val totalResults: Int,
    val results: List<ArticleNetwork>
)

data class ArticleNetwork(
    val article_id: String,
    val link: String?,
    val title: String?,
    val description: String?,
    val content: String?,
    val keywords: List<String>?,
    val creator: List<String>?,
    val language: String?,
    val country: List<String>?,
    val category: List<String>?,
    val datatype: String?,
    val pubDate: String?,
    val pubDateTZ: String?,
    val fetched_at: String?,
    val image_url: String?,
    val video_url: String?,
    val source_id: String?,
    val source_name: String?,
    val source_priority: Int?,
    val source_url: String?,
    val source_icon: String?,
    val sentiment: String?,
    val sentiment_stats: String?,
    val ai_tag: String?,
    val ai_region: String?,
    val ai_org: String?,
    val ai_summary: String?,
    val duplicate: Boolean?
)

