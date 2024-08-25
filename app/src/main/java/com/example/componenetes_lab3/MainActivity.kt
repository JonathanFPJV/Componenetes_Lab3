package com.example.componenetes_lab3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.componenetes_lab3.ui.theme.Componenetes_Lab3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldExample()
        }
    }
}

// Ejemplo de Scaffold
@Composable
fun ScaffoldExample() {
    // Scaffold con TopAppBar y FloatingActionButton
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Mi Aplicación de Componentes",
                        color = Color.White)
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* Acción al hacer clic en FAB */ }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
            }
        }
    ) { paddingValues ->
        // Contenido principal dentro del Scaffold
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp)) {

            // Ejemplo de Card
            Text("Ejemplo de Card:")
            CardExample()
            Spacer(modifier = Modifier.height(16.dp))

            // Ejemplo de Checkbox
            Text("Ejemplo de Checkbox:")
            CheckboxExample()
            Spacer(modifier = Modifier.height(16.dp))

            // Ejemplo de LazyColumn
            Text("Ejemplo de LazyColumn:")
            LazyColumnExample()
            Spacer(modifier = Modifier.height(16.dp))

            // Ejemplo de LazyRow
            Text("Ejemplo de LazyRow:")
            LazyRowExample()
            Spacer(modifier = Modifier.height(16.dp))

            // Ejemplo de ProgressBar
            Text("Ejemplo de ProgressBar:")
            ProgressBarExample()
            Spacer(modifier = Modifier.height(16.dp))

            // Ejemplo de Icono
            Text("Ejemplo de Icon:")
            IconExample()
        }
    }
}

// Ejemplo de LazyColumn
@Composable
fun LazyColumnExample() {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(4) {
            Text("Elemento $it", modifier = Modifier.padding(16.dp))
        }
    }
}
// Ejemplo de LazyRow
@Composable
fun LazyRowExample() {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(10) {
            Text("Item $it", modifier = Modifier.padding(16.dp))
        }
    }
}
// Ejemplo de AlertDialog
@Composable
fun AlertDialogExample() {
    val openDialog = remember { mutableStateOf(true) }
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            title = { Text(text = "Título") },
            text = { Text("Este es un AlertDialog.") },
            confirmButton = {
                Button(onClick = { openDialog.value = false }) {
                    Text("OK")
                }
            }
        )
    }
}
// Ejemplo de Card
@Composable
fun CardExample() {
    Card(
        modifier = Modifier.padding(16.dp),
        elevation = 8.dp
    ) {
        Text("Tarjeta de ejemplo", modifier = Modifier.padding(16.dp))
    }
}
// Ejemplo de Checkbox
@Composable
fun CheckboxExample() {
    val checkedState = remember { mutableStateOf(true) }
    Checkbox(
        checked = checkedState.value,
        onCheckedChange = { checkedState.value = it }
    )
}
// Otros componentes
@Composable
fun IconExample() {
    Icon(
        imageVector = Icons.Default.Phone,
        contentDescription = null,
        tint = Color.Green,
        modifier = Modifier.size(24.dp)
    )
}

@Composable
fun ProgressBarExample() {
    CircularProgressIndicator(
        modifier = Modifier.size(35.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Componenetes_Lab3Theme{
        ScaffoldExample()
    }
}