package com.compose.material3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import kotlin.random.Random

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ImageCard(
    title: String, description: String, modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier, colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant
        ), shape = MaterialTheme.shapes.large
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(500.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = "https://picsum.photos/seed/${Random.nextInt()}/400/500"
                ),
                contentDescription = null,
                modifier = Modifier
                    .clip(MaterialTheme.shapes.large)
                    .fillMaxWidth()
                    .aspectRatio(3f / 4f)
            )

            ForcedGradient()

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                PostMetaSection(title, description)
                PostFlowRowSection()
            }
        }
    }
}

@Composable
private fun ForcedGradient() {
    val colorStops = arrayOf(
        0.0f to Color.Black.copy(alpha = 0.8f),
        0.15f to Color.Black.copy(alpha = 0.4f),
        0.2f to Color.Black.copy(alpha = 0.2f),
        0.5f to Color.Black.copy(alpha = 0f),
        0.7f to Color.Black.copy(alpha = 0f),
        0.8f to Color.Black.copy(alpha = 0.6f),
        1f to Color.Black.copy(alpha = 0.7f)
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                Brush.verticalGradient(
                    colorStops = colorStops
                )
            ),
        contentAlignment = Alignment.TopCenter
    ) {

    }
}

@Composable
private fun PostMetaSection(title: String, description: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            color = Color.Yellow,
            modifier = Modifier
                .padding(start = 2.dp)
                .weight(0.9f)
        )
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = null,
            modifier = Modifier
                .padding(end = 2.dp)
                .weight(0.1f),
            tint = Color.Red
        )
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.Red,
        )
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
@OptIn(ExperimentalLayoutApi::class)
private fun PostFlowRowSection() {
    FlowRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        AssistChip(
            onClick = {},
            colors = AssistChipDefaults.assistChipColors(
                leadingIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                containerColor = Color.Black
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Star,
                    contentDescription = null,
                    tint = Color.Cyan
                )
            },
            label = {
                Text(text = "Bookmark", color = Color.Cyan)
            }
        )
        Spacer(modifier = Modifier.width(8.dp))
        AssistChip(
            onClick = {},
            colors = AssistChipDefaults.assistChipColors(
                leadingIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Done,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            label = {
                Text(text = "Like", color = MaterialTheme.colorScheme.primary)
            }
        )
        Spacer(modifier = Modifier.width(8.dp))
        AssistChip(
            onClick = {},
            colors = AssistChipDefaults.assistChipColors(
                leadingIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                containerColor = MaterialTheme.colorScheme.errorContainer
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Close,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.error
                )
            },
            label = {
                Text(text = "Dislike", color = MaterialTheme.colorScheme.error)
            }
        )
        Spacer(modifier = Modifier.width(8.dp))
        AssistChip(
            onClick = {},
            colors = AssistChipDefaults.assistChipColors(
                leadingIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                containerColor = Color.Black
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Share,
                    contentDescription = null,
                    tint = Color.Cyan
                )
            },
            label = {
                Text(text = "Share", color = Color.Cyan)
            }
        )
    }
}