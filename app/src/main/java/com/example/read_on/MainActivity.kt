package com.example.read_on

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.read_on.ui.theme.ReadOnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ReadOnTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Green),
                    color = MaterialTheme.colorScheme.background,

                ){
                    Main()
                }
            }
        }
    }
}

@Composable
fun Main(modifier: Modifier = Modifier){
    Box(
        modifier
//            .padding(vertical = 20.dp, horizontal = 20.dp)
            .fillMaxSize()
            .background(color = Color(205, 235, 236, 50))) {
        Column (
            modifier
                .fillMaxSize()
                .padding(vertical = 50.dp, horizontal = 20.dp),
//                .background(color = Color(155, 135, 106)),
            Arrangement.SpaceBetween)
        {
            SearchBar()
            PasteTextOrWebLink()
        }
    }

}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedContainerColor = MaterialTheme.colorScheme.surface
        ),
        placeholder = {
            Text(stringResource(R.string.placeholder_search))
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)

    )
}

@Composable
fun PasteTextOrWebLink(modifier: Modifier = Modifier){
    Button(onClick = { /*TODO*/ }, modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(containerColor = Color(15,210,200))) {
        Row {
            Image(painter = painterResource(id = R.drawable.baseline_content_paste_24), contentDescription = "paste")
            Spacer(modifier = Modifier.padding(horizontal = 5.dp))
            Text(text = stringResource(id = R.string.paste_text_or_webLink))
        }

    }
}

@Preview(apiLevel = 34)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ReadOnTheme {
        Main()
    }
}