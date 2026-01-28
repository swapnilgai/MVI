package com.example.home.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core.components.CoilImageComponent
import com.example.home.domain.model.LatestNews


@Composable
fun HomeScreen(list: List<LatestNews>, onClick: (String) -> Unit){

    Column {
        Row(modifier = Modifier.fillMaxWidth().padding(20.dp).wrapContentHeight()) {
            Button(onClick = {}, modifier = Modifier.padding(5.dp)) {
                Text("Refresh")
            }
            Button(onClick = {}, modifier = Modifier.padding(5.dp)) {
                Text("Delete")
            }
        }

        LazyColumn(modifier = Modifier.fillMaxWidth().weight(1f)) {

            items(list, key = { it.articleId }) { item ->
                NewsItem(data = item, onClick = onClick)
            }

        }
    }
}

@Composable
fun NewsItem(data: LatestNews, onClick: (String) -> Unit){
    Column(modifier = Modifier.fillMaxWidth().height(200.dp).clickable{ onClick(data.articleId) }) {
        Text(data.title?:"", modifier = Modifier.padding(10.dp))

        CoilImageComponent(
            imageUrl = data.imageUrl!!,
            contentDescription = data.title?:"",
            modifier = Modifier.fillMaxWidth().weight(1f)
        )
    }
}