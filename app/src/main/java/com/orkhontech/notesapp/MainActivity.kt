package com.orkhontech.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesApp() {
    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }
    var isSearching by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    if (isSearching) {
                        SearchBar(searchQuery) { query ->
                            searchQuery = query
                        }
                    } else {
                        Text("Notes", fontWeight = FontWeight.Bold, color = Color.White)
                    }
                },
                actions = {
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .background(
                                color = Color(0xFF4e5371),
                                shape = RoundedCornerShape(12.dp)
                            )
                    ) {
                        IconButton(onClick = { isSearching = !isSearching }) {
                            Icon(
                                imageVector = if (isSearching) Icons.Default.Close else Icons.Default.Search,
                                contentDescription = "Search",
                                tint = Color.White
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF222433))
            )
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFF222433))
        ) {
            NotesGrid(searchQuery.text)
        }
    }
}

@Composable
fun SearchBar(searchQuery: TextFieldValue, onQueryChange: (TextFieldValue) -> Unit) {
    BasicTextField(
        value = searchQuery,
        onValueChange = onQueryChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp),
        singleLine = true
    )
}

@Composable
fun NotesGrid(searchQuery: String) {
    val allNotes = listOf(
        "İlk Not", "İkinci Not", "Üçüncü Not",
        "Dördüncü Not", "Beşinci Not", "Altıncı Not",
        "Yedinci Not", "Sekizinci Not", "Dokuzuncu Not",
        "Onuncu Not", "On Birinci Not", "On İkinci Not",
        "On Üçüncü Not", "On Dördüncü Not", "On Beşinci Not",
        "On Altıncı Not", "On Yedinci Not", "On Sekizinci Not"
    )

    val filteredNotes = allNotes.filter { it.contains(searchQuery, ignoreCase = true) }

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 150.dp),
        modifier = Modifier
            .background(Color(0xFF222433))

    ) {
        items(filteredNotes.size) { index ->
            NoteCard(title = filteredNotes[index]) {}
        }
    }
}

@Composable
fun NoteCard(title: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            Text(
                text = "Bu notun içeriği burada gösterilecek.",
                fontSize = 14.sp,
                color = Color.DarkGray
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF222433)
@Composable
fun NotesAppPreview() {
    NotesApp()
}
