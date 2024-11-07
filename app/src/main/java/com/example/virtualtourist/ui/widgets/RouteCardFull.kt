package com.example.virtualtourist.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.compose.rememberAsyncImagePainter
import coil3.compose.rememberConstraintsSizeResolver
import coil3.request.ImageRequest
import com.example.virtualtourist.R
import com.example.virtualtourist.data.sources.network.model.UserRoute
import com.example.virtualtourist.ui.theme.ShadingElements
import com.example.virtualtourist.ui.theme.inter
import com.example.virtualtourist.ui.utils.buildPhotoUrl
import com.example.virtualtourist.ui.utils.timeString

@Composable
fun RouteCardFull(
    route: UserRoute,
    toggleSubscription: (Int, Boolean) -> Unit,
    onClick: () -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomStart) {
            Image(
                painter = rememberAsyncImagePainter(route.buildPhotoUrl()),
                contentDescription = "Фото: ${route.name}",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.77f)
                    .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
                contentScale = ContentScale.Crop
            )
            Row(Modifier.padding(start = 16.dp, bottom = 8.dp)) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(SpanStyle(fontWeight = FontWeight.Medium)) {
                            append("${route.price} ₽")
                        }
                        append(" за ${route.timeString()}")
                    },
                    fontFamily = inter,
                    color = colorScheme.background,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .background(ShadingElements, CircleShape)
                        .padding(horizontal = 12.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(ShadingElements, CircleShape)
                        .padding(horizontal = 12.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.star_1),
                        contentDescription = "Оценка",
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = route.mean_mark.toString(),
                        fontFamily = inter,
                        color = colorScheme.background,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp
                    )
                }
            }
        }
        Column(
            Modifier
                .fillMaxWidth()
                .background(
                    colorScheme.onSecondaryContainer,
                    RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
                )
                .padding(start = 1.dp, end = 1.dp, bottom = 1.dp)
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(
                        colorScheme.background,
                        RoundedCornerShape(bottomStart = 19.dp, bottomEnd = 19.dp)
                    )
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 12.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.weight(1f)
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(route.author.buildPhotoUrl()),
                            contentDescription = "Фото автора: ${route.author.name}",
                            modifier = Modifier
                                .size(36.dp)
                                .background(colorScheme.surface, CircleShape)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Column {
                            Text(
                                text = route.author.name,
                                fontFamily = inter,
                                fontWeight = FontWeight.Medium,
                                color = colorScheme.onSecondaryContainer,
                                fontSize = 12.sp,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                lineHeight = 12.sp
                            )
                            Text(
                                text = route.author.subscribers_count.toString(),
                                fontFamily = inter,
                                color = colorScheme.onSurface,
                                fontSize = 12.sp,
                                lineHeight = 12.sp
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    SubscribeButtonCompact(isSubscribed = route.author.is_subscribe, onClick = {
                        toggleSubscription(route.author.id, it)
                    }, variant = SubscribeButtonCompactVariant.Secondary)
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = route.name,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = inter,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 16.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = route.description,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = inter,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                    color = colorScheme.onSecondaryContainer,
                    lineHeight = 14.sp
                )
            }
        }
    }
}