package com.example.instaui

import android.media.Image
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfScreen(){
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxSize()){
        TopBar(name = "Nancy Nyabuti", modifier = Modifier
            .padding(10.dp))
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(25.dp))
        ButtonSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(25.dp))
       HighlightSection(
           highlights = listOf(
               ImageWithText(
                   image = painterResource(id = R.drawable.nan),
                   text = "Nancy"
               ),
                       ImageWithText(
                       image = painterResource(id = R.drawable.socials),
               text = "Nancy"
           ),
                   ImageWithText(
                   image = painterResource(id = R.drawable.nan),
           text = "Nancy"
       ),
        ImageWithText(
            image = painterResource(id = R.drawable.socials),
            text = "Nancy"
        ),
           ),
           modifier = Modifier
               .fillMaxWidth()
               .padding(horizontal = 20.dp)
       )

        Spacer(modifier = Modifier.height(10.dp))
        PostTabView(
            imageWithText = listOf(
                ImageWithText(
                  image =  painterResource(id = R.drawable.nan),
                    text = "Posts"),

                ImageWithText(
                    image =  painterResource(id = R.drawable.nan),
                    text = "Reels"),
                ImageWithText(
                    image =  painterResource(id = R.drawable.nan),
                    text = "ICGT"),
                ImageWithText(
                    image =  painterResource(id = R.drawable.nan),
                    text = "Profile"),
                ImageWithText(
                    image =  painterResource(id = R.drawable.nan),
                    text = "Posts"),
            )
        ){
            selectedTabIndex = it
        }
        when(selectedTabIndex){
            0 -> PostSection(posts = listOf(
                painterResource(id = R.drawable.book),
                painterResource(id = R.drawable.book),
                painterResource(id = R.drawable.book),
                painterResource(id = R.drawable.book),
                painterResource(id = R.drawable.book),
                painterResource(id = R.drawable.book),
            ))
        }
    }
}

@Composable
fun TopBar(
    name: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Icon(imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(20.dp))

        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp)

        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "Notification",
            tint = Color.Black,
            modifier = Modifier.size(24.dp))

        Icon(painter = painterResource(id = R.drawable.ic_dotmenu),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp))
    }
}
@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
){
    
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            
            RoundImage(image = painterResource(id = R.drawable.nan), modifier = Modifier
                .size(100.dp)
                .weight(3f))
            
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(modifier = Modifier.weight(7f))
            
        }
        ProfileDescription(displayName = "Programming Mentor",
            description = "ten years of experience" +
                    "want an app?" +
                    "Subscribe",
            url = "https://youtube.com/c/PhhilipLackner",
            followedBy = listOf("coding con", "holawik"),
            otherCount = 17 )
    }
}
@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
){
androidx.compose.foundation.Image(painter = image, 
    contentDescription = null,
modifier = modifier
    .aspectRatio(1f, matchHeightConstraintsFirst = true)
    .border(
        width = 1.dp,
        color = Color.LightGray,
        shape = CircleShape
    )
    .padding(3.dp)
    .clip(CircleShape)
)
}

@Composable
fun StatSection(modifier: Modifier= Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {

        ProfileStat(numberText = "601", text = "Posts")
        ProfileStat(numberText = "100k", text = "Followers")
        ProfileStat(numberText = "71", text = "Following")

    }
}
@Composable
fun ProfileStat(
    numberText : String,
    text: String,
    modifier: Modifier = Modifier
){

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
    ) {
//this is the number
        Text(
            text = numberText,
            fontSize = 20.sp,
        fontWeight = FontWeight.Bold
            )
        
        //applying space between the two composable
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = text )
    }
}

@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url : String,
    followedBy: List<String>,
    otherCount: Int
){
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {

       Text(
           text = displayName,
          fontWeight = FontWeight.Bold,
           letterSpacing = letterSpacing,
          lineHeight = lineHeight)

        Text(
            text = displayName,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight)

        if (followedBy.isNotEmpty()){
            Text(
                text = buildAnnotatedString {
                    val boldstyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold)
                    append("Followed by ")
                    pushStyle(boldstyle)
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldstyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1){
                            append(",")
                        }
                    }
                    if (otherCount > 2){
                        append(" and ")
                            pushStyle(boldstyle)
                        append("$otherCount others")
                        } },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }
    }
}
@Composable
fun ButtonSection(
    modifier: Modifier= Modifier
){
    val midWidth = 95.dp
    val height = 30.dp

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
    ){
        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
              //  .defaultMinSize(midWidth = midWidth)
                .height(height)
        )


       ActionButton(
           text = "Message",
           modifier = Modifier
            //  .defaultMinSize(midWidth = midWidth)
            .height(height)
        )

        ActionButton(
            text = "Email",
            modifier = Modifier
                //  .defaultMinSize(midWidth = midWidth)
                .height(height)
        )

        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                //  .defaultMinSize(midWidth = midWidth)
                .height(height)
        )


    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null
){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ) {
        if(text != null){
            Text(
                text = text,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp) }
        if (icon != null){
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black

            )
        }
    }
}

@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    highlights : List<ImageWithText>
){

    LazyRow(modifier = modifier){
        items(highlights.size){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(end = 15.dp)
            ){
                RoundImage(
                    image = highlights[it].image,
                modifier = Modifier.size(70.dp))

                Text(text = highlights[it].text,
                    overflow = TextOverflow.Ellipsis,
                )

            }
        }
    }
}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithText: List<ImageWithText>,
    onTabSelected: (selectedIndex : Int) -> Unit
)
{
    var selectedTabIndex by remember {
        mutableStateOf(0)}
            val inactiveColor = Color(0xff777777)
    TabRow(
        selectedTabIndex = selectedTabIndex,
    backgroundColor = Color.Transparent,
    contentColor = Color.Black,
    modifier = modifier){
        imageWithText.forEachIndexed { index, item ->
            Tab (
                selected = selectedTabIndex == 0,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(0)
                }){
                Icon (
                  //  painter = painterResource(id = R.drawable.nan),
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if (selectedTabIndex == index) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(10.dp)
                )
            }
        }
    }
        }
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostSection(
    posts : List<Painter>,
    modifier: Modifier = Modifier
){
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
    modifier = modifier
        .scale(1.01f)
        )
    {
        items(posts.size){
            Image(
                painter = posts[it],
                contentDescription =null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White)
            )
        }
    }
}

