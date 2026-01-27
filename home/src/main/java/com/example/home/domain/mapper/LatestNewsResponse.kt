package com.example.home.domain.mapper

import com.example.home.data.model.ArticleNetwork
import com.example.home.data.model.LatestNewsNetworkResponse
import com.example.home.domain.model.LatestNews

fun LatestNewsNetworkResponse.toDomain(): List<LatestNews> {
    return this.results.map { it.toDomain() }
}

fun ArticleNetwork.toDomain(): LatestNews {
    return LatestNews(
        articleId = this.article_id,
        link = this.link,
        title = this.title,
        description = this.description,
        content = this.content,
        keywords = this.keywords,
        creator = this.creator,
        language = this.language,
        country = this.country,
        category = this.category,
        datatype = this.datatype,
        pubDate = this.pubDate,
        pubDateTZ = this.pubDateTZ,
        imageUrl = this.image_url,
        videoUrl = this.video_url,
        sourceId = this.source_id,
        sourceName = this.source_name,
        sourceUrl = this.source_url,
        sourceIcon = this.source_icon,
        sentiment = this.sentiment
    )
}
