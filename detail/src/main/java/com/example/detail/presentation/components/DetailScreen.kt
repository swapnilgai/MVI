package com.example.detail.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core.components.CoilImageComponent
import com.example.detail.domain.model.Article

@Composable
fun DetailScreen(article: Article) {

    Column(modifier = Modifier.fillMaxWidth()) {

        CoilImageComponent(imageUrl = article.imageUrl?:"", contentDescription = article.description?:"", modifier = Modifier.height(250.dp))

        Spacer(modifier = Modifier.padding(10.dp))

        Text(text = article.title?:"")

    }
}