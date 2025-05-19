package com.navoditkapoor.catalifttask.uiForMainActivity

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import com.navoditkapoor.catalifttask.R
import java.text.NumberFormat

@Composable
fun PostCard() {
    val likeCount = remember { mutableStateOf(1546) }
    val isLiked = remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            ProfileRow()
            PostContent()
            PostImage()
            InteractionBar(
                likeCount = likeCount.value,
                isLiked = isLiked.value,
                onLikeClick = {
                    if (isLiked.value) {
                        likeCount.value -= 1
                    } else {
                        likeCount.value += 1
                    }
                    isLiked.value = !isLiked.value
                },
                onCommentClick = { println("Comment clicked") },
                onShareClick = { println("Share clicked") }
            )
        }
    }
}

@Composable
fun ProfileRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Gray, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Profile Placeholder",
                tint = Color.White
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = "Akhilesh Yadav", fontWeight = FontWeight.Bold)
            Text(text = "Founder at Google", color = Color.Gray, fontSize = 12.sp)
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Id • Edited", color = Color.Gray, fontSize = 10.sp)
        Spacer(modifier = Modifier.width(8.dp))
        IconButton(onClick = { /* Follow */ }) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Follow",
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
fun PostContent() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "The Briggs-Rauscher Reaction: A Mesmerizing Chemical Dance 🌈",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "This captivating process uses hydrogen peroxide, potassium iodate, malonic acid, manganese sulfate, and iodine and iodate ions interact to form compounds that shift the solution's color, while starch amplifies the blue color before it breaks down and starts again. 🌟",
            fontSize = 14.sp,
            style = TextStyle(lineHeight = 20.sp),
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Follow @Science for more",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 14.sp
        )
    }
}

@Composable
fun PostImage() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.man_walking),
            contentDescription = "Man Walking",
            modifier = Modifier.fillMaxSize(),
            contentScale = androidx.compose.ui.layout.ContentScale.Crop
        )
    }
}

@Composable
fun InteractionBar(
    likeCount: Int,
    isLiked: Boolean,
    onLikeClick: () -> Unit,
    onCommentClick: () -> Unit,
    onShareClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Stars",
                    tint = Color.Yellow
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "${NumberFormat.getInstance().format(likeCount)} Stars", fontWeight = FontWeight.Bold)
            }
            Text(text = "80 comments", fontWeight = FontWeight.Bold)
        }
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 8.dp),
            thickness = 1.dp,
            color = Color.LightGray
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconButton(onClick = onLikeClick) {
                Icon(
                    imageVector = if (isLiked) Icons.Filled.Star else Icons.Outlined.Star,
                    contentDescription = "Like",
                    tint = if (isLiked) Color.Yellow else MaterialTheme.colorScheme.primary
                )
            }
            HorizontalDivider(
                modifier = Modifier
                    .height(24.dp)
                    .width(1.dp),

                thickness = 1.dp,
                color = Color.LightGray
            )
            IconButton(onClick = onCommentClick) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.baseline_add_comment_24),
                    contentDescription = "Add Comment",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
            HorizontalDivider(
                modifier = Modifier
                    .height(24.dp)
                    .width(1.dp),
                thickness = 1.dp,
                color = Color.LightGray
            )
            IconButton(onClick = onShareClick) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = "Share",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}