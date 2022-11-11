package com.lixoten.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lixoten.businesscard.ui.theme.BusinessCardTheme
import com.lixoten.businesscard.ui.theme.AndroidGreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val name = stringResource(id = R.string.name)
    val title = stringResource(id = R.string.title)
    val infoPhone = stringResource(id = R.string.info_phone)
    val infoShare = stringResource(id = R.string.info_share)
    val infoEmail = stringResource(id = R.string.info_email)

    Column(
        modifier = Modifier
            .background(Color(0xFF003A4A)),
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .weight(2f)
                .fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.android_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                )
                Text(
                    text = name,
                    fontSize = 40.sp,
                    color = Color.LightGray
                )
                Text(
                    text = title,
                    fontSize = 32.sp,
                    color = AndroidGreen
                )
            }
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                var label = stringResource(id = R.string.info_phone_label)
                var picture = painterResource(id = R.drawable.ic_phone)
                ContactInfoLine(info = infoPhone, picture = picture, label = label)

                label = stringResource(id = R.string.info_share_label)
                picture = painterResource(id = R.drawable.ic_share)
                ContactInfoLine(info = infoShare, picture = picture, label = label)

                label = stringResource(id = R.string.info_email_label)
                picture = painterResource(id = R.drawable.ic_email)
                ContactInfoLine(info = infoEmail, picture = picture, label = label)
            }
        }
    }
}


@Composable
fun ContactInfoLine(picture: Painter, info: String, label: String) {
    Divider(
        color = Color.LightGray,
    )
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(8.dp)
    ) {
        Icon(
            painter = picture,
            contentDescription = label,
            tint = AndroidGreen,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = info,
            color = Color.LightGray,
            fontSize = 24.sp,
            modifier = Modifier.weight(4f)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme() {
        MyApp()
    }
}