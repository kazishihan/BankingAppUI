package com.kazishihan.bankingappui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kazishihan.bankingappui.data.Finance
import com.kazishihan.bankingappui.ui.theme.BlueStart
import com.kazishihan.bankingappui.ui.theme.GreenStart
import com.kazishihan.bankingappui.ui.theme.OrangeStart
import com.kazishihan.bankingappui.ui.theme.PurpleStart


val financeList = listOf(
    Finance(
        icon = Icons.Rounded.StarHalf,
        name = "My\nBusiness",
        background = OrangeStart
    ),
    
    Finance(
        icon = Icons.Rounded.Wallet,
        name = "My\nWallet",
        background = BlueStart
    ),
    
    Finance(
        icon = Icons.Rounded.StarHalf,
        name = "Finance\nAnalytics",
        background = PurpleStart
    ),
    
    Finance(
        icon = Icons.Rounded.MonetizationOn,
        name = "My\nTransactions",
        background = GreenStart
    ),
)

@Preview
@Composable
fun FinanceSection() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Finance",
            fontSize = 17.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
        LazyRow {
            items(cards.size) { index ->
                FinanceCard(index)
            }
        }
    }
}

@Preview
@Composable
fun FinanceCard(index: Int = 1) {
    val finance = financeList[index]
    var lastItemPaddingEnd = 0.dp
    if (index == cards.lastIndex) {
        lastItemPaddingEnd = 16.dp
    }
    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPaddingEnd)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .background(color = MaterialTheme.colorScheme.secondaryContainer)
                .width(100.dp)
                .height(100.dp)
                .padding(horizontal = 8.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(finance.background)
                    .padding(4.dp)
                    
            ) {
                Icon(
                    imageVector = finance.icon,
                    contentDescription = null,
                    tint = Color.White
                )
            }
            
            Text(
                text = finance.name,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp
            )
        }
    }
}