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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            .background(color = Color(205, 235, 236, 50))
            )
    {
//        .background(color = Color(155, 135, 106))
        Column (
            modifier
                .fillMaxSize()
                .padding(vertical = 50.dp),
            Arrangement.SpaceBetween
            ) {
            Column(modifier = Modifier){
                SootheBottomNavigation()
                Search()
            }
            PasteTextOrWebLink()


        }

//        Column (
//            modifier
//                .fillMaxSize()
//                .padding(vertical = 50.dp, horizontal = 20.dp),
////                .background(color = Color(155, 135, 106)),
//            Arrangement.SpaceBetween)
//        {
//            SearchBar()
//            PasteTextOrWebLink()
////            PlayButtons(modifier = Modifier)
//
//        }

    }


}

@Composable
fun Search(
    modifier: Modifier = Modifier
) {
    TextField(
        value = "",
        onValueChange = {},
        label = null,
        shape = RoundedCornerShape(topStart = 20.dp, bottomEnd = 20.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.colors(
//            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
//            focusedContainerColor = Color(205, 135, 136,2),
        ),

        placeholder = {
            Text(stringResource(R.string.placeholder_search))
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
            .padding(vertical = 4.dp, horizontal = 20.dp)
            .background(Color(205, 235, 236, 150), shape = RoundedCornerShape(25.dp))

    )
}

@Composable
fun PasteTextOrWebLink(modifier: Modifier = Modifier){
    Button(onClick = { },
        modifier.fillMaxWidth().padding(horizontal = 30.dp),
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(155, 135, 86))) {
//        .background(color = Color(155, 135, 106))
        Row (modifier.padding(8.dp)) {
            Image(painter = painterResource(id = R.drawable.baseline_content_paste_24), contentDescription = "paste")
            Spacer(modifier = Modifier.padding(horizontal = 5.dp))
            Text(text = stringResource(id = R.string.paste_text_or_webLink), modifier,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,)
        }

    }

}

@Composable
fun PlayButtons(modifier: Modifier){
    Row (modifier.background(Color.LightGray)){
        Column (modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.2f)) {
            Text(
                text = stringResource(id = R.string.chapter_title),
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
                )
            Spacer(modifier = modifier.padding(2.dp))
            Text(text = stringResource(id = R.string.chapter_num),
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium
            )
        }
        Row {
            Button(onClick = { }) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_pause_24),
                    contentDescription = "Pause button" )
            }
            Button(onClick = {  }) {
                Icons.Default.PlayArrow
            }
        }

    }
}


@Composable
private fun SootheBottomNavigation(modifier: Modifier = Modifier) {
    Box(
        modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        contentAlignment = Alignment.Center ) {
            Text(text = stringResource(id = R.string.app_name),
                modifier
                    .background(
                        Color(205, 235, 236, 150),
                        shape = CircleShape
                    )
                    .padding(25.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,

                )
    }

}


//@Preview(apiLevel = 34)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ReadOnTheme {
        Main()
    }
}