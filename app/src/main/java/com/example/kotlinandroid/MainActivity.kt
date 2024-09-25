package com.example.kotlinandroid

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinandroid.ui.theme.KotlinAndroidTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalConfiguration
import java.text.NumberFormat
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType

//import androidx.compose.material.icons.rounded.Email


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GreetingText("Happy Birthday",  "Valdes!!")
                }
            }
        }
    }
}


@Preview(showBackground = true )
@Composable
fun BirthdayCardPreview() {
    //GreetingText("Happy Birthday",  "Valdes!!")
    //Article()
    //ToDoList()
    //QuadrantCompose()
    //carteVisite()
    //DiceWithButtonAndImage()
    //TipTimeLayout()
    ArtSpace()
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center
        ) {
        Box(modifier = modifier,
            ){
            Text(
                text = message,
                fontSize = 100.sp,
                lineHeight = 116.sp,
                color = Color.Cyan,
                textAlign = TextAlign.Center,
            )
        }
        Row(
            modifier = modifier.background(Color.Cyan)

        ){
            Text(
                text = from,
                fontSize = 36.sp,
                textAlign = TextAlign.Right,
                modifier = modifier.padding(8.dp)

            )
        }
    }
}


@Composable
fun Article(  modifier: Modifier=Modifier){
        Column(modifier) {

            Image(
                painter = painterResource(R.drawable.bg_compose_background),
                contentDescription = null,
                contentScale = ContentScale.Fit
            )

            Text(text = stringResource(R.string.title),
                fontSize = 30.sp, modifier = modifier.padding(16.dp),
            fontWeight = FontWeight.Bold
            )
            Text(text = stringResource(R.string.articleContent1) ,
                fontSize = 24.sp, modifier = modifier.padding(16.dp), textAlign = TextAlign.Justify
            )
            Text(text =  stringResource(R.string.articleContent2),
                    fontSize = 24.sp, modifier = modifier.padding(16.dp), textAlign = TextAlign.Justify
            )
        }
}

@Composable
fun ToDoList(modifier: Modifier=Modifier){

    Column(modifier.padding(45.dp, 100.dp, 45.dp, 100.dp), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(R.drawable.ic_task_completed),
            contentDescription = null,
            contentScale = ContentScale.Fit,
        )
        Text(text = stringResource(R.string.todoTitle) ,
            fontSize = 24.sp, fontWeight = FontWeight.Bold,
            modifier = modifier.padding(0.dp, 16.dp, 0.dp, 16.dp)
        )
        Text(text =  stringResource(R.string.todoContent),
            fontSize = 16.sp, modifier = modifier.padding(16.dp)
        )
    }
}

@Composable
fun componentColumn(title : String, content : String, backgroundColumn : Color, modifier: Modifier=Modifier){
    Column(
        modifier
            .background(backgroundColumn)
            .padding(8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,

    ) {
        Text(text = title,
            fontSize = 24.sp, fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
        Text(text = content,
            fontSize = 24.sp,
            textAlign = TextAlign.Justify,

        )
    }
}

@Composable
fun QuadrantCompose(modifier: Modifier=Modifier){
    Column(modifier.fillMaxSize()) {
        Row(modifier.weight(1f)) {
            componentColumn(
                title = stringResource(R.string.quandrantTitleColumn1),
                content = stringResource(R.string.quandrantContentColumn1),
                backgroundColumn = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            componentColumn(
                title = stringResource(R.string.quandrantTitleColumn2),
                content = stringResource(R.string.quandrantContentColumn2),
                backgroundColumn = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row(modifier.weight(1f) ) {
            componentColumn(
                title = stringResource(R.string.quandrantTitleColumn1),
                content = stringResource(R.string.quandrantContentColumn1),
                backgroundColumn = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            componentColumn(
                title = stringResource(R.string.quandrantTitleColumn2),
                content = stringResource(R.string.quandrantContentColumn2),
                backgroundColumn = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun contactFooter(icon : Image, text : String, modifier: Modifier=Modifier){
    Row(modifier) {

    }
}

@Composable
fun carteVisite(modifier: Modifier=Modifier){

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp // Largeur en dp
    val screenHeight = configuration.screenHeightDp

    Column(modifier.background(Color(0xFF75d2ac))) {
        Row(modifier = Modifier
            .height((screenHeight * 0.7).dp) ) {
            Column(modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier
                        .width(100.dp)
                        .height(100.dp)
                        .background(Color(0xFF110047))
                ) {
                    Image(
                        painter = painterResource(R.drawable.android_logo),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                    )
                }
                Text(text = stringResource(R.string.carteTitle) ,
                    fontSize = 40.sp, fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                )

                Text(text = stringResource(R.string.carteContent) ,
                    fontSize = 15.sp, fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF118200)
                )
            }
        }
        Row(modifier = Modifier
            .height((screenHeight * 0.3).dp) ) {
            Column(modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    modifier
                        .padding(0.dp, 0.dp, 0.dp, 20.dp)
                        .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                    Icon(Icons.Rounded.Phone, contentDescription = "Localized description",
                    modifier=modifier.padding(0.dp, 0.dp, 20.dp, 0.dp))
                    Text(text = "+11 (123) 444 555 666")
                }
                Row(modifier.padding(0.dp, 0.dp, 0.dp, 20.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                    Icon(Icons.Rounded.Share, contentDescription = "Localized description",
                    modifier=modifier.padding(0.dp, 0.dp, 20.dp, 0.dp))
                    Text(text = "https://github.com/chrisvaldes")
                }
                Row(modifier.padding(0.dp, 0.dp, 0.dp, 20.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                    Icon(Icons.Rounded.Email, contentDescription = "Localized description",
                    modifier=modifier.padding(0.dp, 0.dp, 20.dp, 0.dp))
                    Text(text = "valdesfeutseu@gmail.com")
                }
            }
        }
    }
}


@Composable
fun DiceWithButtonAndImage(modifier : Modifier = Modifier){
    var result by remember { mutableStateOf(1) }
    val imageResource = when (result){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column(modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString()
        )
        Spacer(modifier.height(16.dp))
        Button( onClick = { result = (1..6).random()}) {
            Text(text = stringResource(R.string.roll))
        }
    }
}

private fun calculateTip(amount : Double, tipPercent : Double = 15.0) : String{
    val tip = tipPercent / 100*amount
    return  NumberFormat.getCurrencyInstance().format(tip)
}

@VisibleForTesting
internal fun calculateTip(amount : Double, tipPercent : Double = 15.0, roundUp : Boolean) : String{
    var tip = tipPercent / 100*amount
    if(roundUp){
        tip = kotlin.math.ceil(tip)
    }
    return  NumberFormat.getCurrencyInstance().format(tip)
}


@Composable
fun EditNumberField(value: String,
                    onValueChange: (String) -> Unit,modifier: Modifier = Modifier) {
    /* var amountInput by remember {
        mutableStateOf("0")
    }

    val amount = amountInput.toDoubleOrNull()?:0.0
    val tip = calculateTip(amount)*/

    TextField(
        //value = amountInput,
        value= value,
        //onValueChange = { amountInput = it },
        onValueChange = onValueChange,
        singleLine = true,
        label = { Text(stringResource(R.string.bill_amount)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = modifier
    )
}

@Composable
fun TipTimeLayout(modifier: Modifier=Modifier.fillMaxSize()){
    var amountInput by remember {
        mutableStateOf("0")
    }

    val amount = amountInput.toDoubleOrNull()?:0.0
    val tip = calculateTip(amount)

    Column(modifier = Modifier
        .statusBarsPadding()
        .padding(horizontal = 40.dp)
        .verticalScroll(rememberScrollState())
        .safeDrawingPadding()
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = stringResource(R.string.calculate_tip),
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.Start)
            )

        EditNumberField(
            value = amountInput,
            onValueChange = {amountInput = it},
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth())

        Text(text = stringResource(R.string.tip_amount, tip),
            style = MaterialTheme.typography.h5
            )
        Spacer(modifier = Modifier.height(150.dp))
    }
}

@Composable
fun ArtSpace(modifier: Modifier=Modifier){
    // get screen dimensions
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp // Largeur en dp
    val screenHeight = configuration.screenHeightDp

    Column(
        modifier
            .fillMaxSize(1f)
            .padding(horizontal = 16.dp)
    ) {
        Row(modifier = Modifier
            .height((screenHeight * 0.7).dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center

            ) {
                Row(modifier = Modifier
                    .height((screenHeight * 0.6).dp)
                    .width((screenWidth * 1).dp)
                    .padding(30.dp)
                    .background(Color.White)
                    .clip(RoundedCornerShape(16.dp)) // applique un border radius de 16.dp
                    .shadow(4.dp, RoundedCornerShape(16.dp)), // applique une ombre avec un rayon de 16.dp
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {
                    Box(modifier = Modifier
                        .padding(25.dp)
                        .background(Color.Cyan)
                    ){
                        Image(
                            painter = painterResource(R.drawable.dice_6),
                            contentDescription = null,
                        )
                    }
                }
        }
        Row(
            modifier
                .fillMaxWidth()
                .padding(40.dp)
                .background(Color.LightGray)) {
          Column(modifier = Modifier
              .padding(15.dp)) {
              Text(text = stringResource(R.string.artwork_title),
              fontSize = 20.sp,
              fontWeight = FontWeight.Normal,
              fontFamily = FontFamily.SansSerif)
              Row(modifier) {
                  Text(text = stringResource(R.string.artwork_artist_name),
                      fontSize = 15.sp,
                      fontWeight = FontWeight.Bold,
                      fontFamily = FontFamily.SansSerif
                  )
                  Spacer(modifier = Modifier.width(5.dp))
                  Text(text = stringResource(R.string.artwork_artist_year),
                  )
              }
          }  
        }
        Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround) {
           Button(onClick = { /*TODO*/ }, modifier = Modifier.width(150.dp)
               .clip(RoundedCornerShape(100.dp))) {
               Text(text = stringResource(R.string.previous))
           }
            Button(onClick = { /*TODO*/ }, modifier = Modifier.width(150.dp)
                .clip(RoundedCornerShape(100.dp))) {
                Text(text = stringResource(R.string.next))
            }
        }
    }
}








