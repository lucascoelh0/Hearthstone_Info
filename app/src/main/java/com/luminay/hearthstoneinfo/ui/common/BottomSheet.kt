package com.luminay.hearthstoneinfo.ui.common

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.luminay.hearthstoneinfo.theme.Gray40

@ExperimentalMaterial3Api
@Composable
fun BottomSheet(
    content: @Composable () -> Unit,
    onDismiss: () -> Unit,
) {
    val modalBottomSheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        containerColor = Gray40,
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = {
            Spacer(Modifier.height(0.dp))
        },
    ) {
        content()
    }
}