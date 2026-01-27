package com.example.detail.domain.mapper

import com.example.detail.data.model.ArticleNetworkResponse
import com.example.detail.domain.model.Article


fun ArticleNetworkResponse.toArticle() : Article {
    return Article(
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