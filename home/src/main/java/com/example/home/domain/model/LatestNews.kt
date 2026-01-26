package com.example.home.domain.model

data class LatestNews(
    val articleId: String,
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
    val imageUrl: String?,
    val videoUrl: String?,
    val sourceId: String?,
    val sourceName: String?,
    val sourceUrl: String?,
    val sourceIcon: String?,
    val sentiment: String?
)
