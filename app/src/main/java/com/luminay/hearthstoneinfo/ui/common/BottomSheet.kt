package com.luminay.hearthstoneinfo.ui.common

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luminay.hearthstoneinfo.features.cardlist.presentation.mocks.getMockCard
import com.luminay.hearthstoneinfo.features.cards.presentation.ui.CardDetails

@ExperimentalMaterial3Api
@Composable
fun BottomSheet(
    content: @Composable () -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val modalBottomSheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        containerColor = Color.Transparent,
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = {
            Spacer(Modifier.height(0.dp))
        },
        modifier = modifier.height(IntrinsicSize.Min),
    ) {
        content()
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun PreviewBottomSheet() {
    BottomSheet(
        content = {
            CardDetails(card = getMockCard())
        },
        onDismiss = {},
    )
}
