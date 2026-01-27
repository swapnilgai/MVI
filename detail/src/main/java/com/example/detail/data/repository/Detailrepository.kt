package com.example.detail.data.repository

import com.example.detail.data.DetailApi
import com.example.detail.data.model.ArticleNetworkResponse
import com.example.detail.data.model.DetailNetworkResponse
import com.example.network.extensions.handleCall
import javax.inject.Inject

interface Detailrepository {
    suspend fun getArticleDetail(articleId: String): ArticleNetworkResponse?
}

internal class DetailrepositoryImpl @Inject constructor(val detailApi: DetailApi): Detailrepository {
    override suspend fun getArticleDetail(articleId: String): ArticleNetworkResponse? {
       return handleCall {
           detailApi.getNewsDetail(articleId)
       }.results.firstOrNull()
    }
}