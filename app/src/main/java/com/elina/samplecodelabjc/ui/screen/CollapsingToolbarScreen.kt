package com.elina.samplecodelabjc.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elina.samplecodelabjc.data.network.model.BookModel
import com.elina.samplecodelabjc.data.network.model.DEFAULT_BOOKS
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import com.elina.samplecodelabjc.utils.constants.Constants.COLLAPSED_TOP_BAR_HEIGHT
import com.elina.samplecodelabjc.utils.constants.Constants.EXPANDED_TOP_BAR_HEIGHT

/**
 * Created by Elina on 05/07/2023.
 */

@Composable
fun CollapsingToolbarScreen() {
    ScaffoldLibrary(DEFAULT_BOOKS)
}

@Composable
fun Books(modifier: Modifier = Modifier, model: BookModel) =
    Card(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(model.title)
            Text(model.author)
            Text("${model.pageCount} pages")
        }
    }

@Composable
fun ScaffoldLibrary(books: List<BookModel> = DEFAULT_BOOKS) {
    val listState = rememberLazyListState()
    val isCollapsed: Boolean by remember {
        derivedStateOf { listState.firstVisibleItemIndex > 0 }
    }
    Scaffold(
        topBar = { CollapsedTopBar(isCollapsed = isCollapsed) },
        bottomBar = {}
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(padding),
            state = listState
        ) {
            item { ExpandedTopBar() }
            items(items = books) { book ->
                Books(model = book)
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Composable
 fun CollapsedTopBar(modifier: Modifier = Modifier, isCollapsed: Boolean) {
    val color: Color by animateColorAsState(
        if (isCollapsed) MaterialTheme.colors.background
        else MaterialTheme.colors.primaryVariant
    )
    Box(
        modifier = modifier
            .background(color)
            .fillMaxWidth()
            .height(COLLAPSED_TOP_BAR_HEIGHT)
            .padding(16.dp),
        contentAlignment = Alignment.BottomStart
    ) {
        AnimatedVisibility(visible = isCollapsed) {
            Text(text = "Library", style = MaterialTheme.typography.h6)
        }
    }
}

@Composable
private fun ExpandedTopBar() {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.primaryVariant)
            .fillMaxWidth()
            .height(EXPANDED_TOP_BAR_HEIGHT - COLLAPSED_TOP_BAR_HEIGHT),
        contentAlignment = Alignment.BottomStart
    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Library",
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.h3,
        )
    }
}
