package com.example.compsedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.compsedemo.ui.theme.CompseDemoTheme
import java.text.NumberFormat

class TipCalculator : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompseDemoTheme(dynamicColor = false) {
                CalculateTips()
            }
        }
    }
}


@Composable
fun CalculateTips() {
    var inputAmount by remember {
        mutableStateOf("")
    }
    val totalAmount : Double = inputAmount.toDoubleOrNull() ?: 0.00
    val tip = calculateTotalTip(totalAmount , 15.0)

    Column(
        Modifier.padding(40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.calculate_tip))
        EditInputField(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
            value = inputAmount,
            onValueChanged = {
                inputAmount = it
            })
        Text(text = stringResource(id = R.string.tips_amount, tip))
    }

}

fun calculateTotalTip(totalAmount: Double , totalTip : Double) : String {
    val tip = totalTip / 100 * totalAmount
    return NumberFormat.getNumberInstance().format(tip)

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditInputField(modifier: Modifier, value: String, onValueChanged: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = onValueChanged,
        singleLine = true,
        label = { Text(stringResource(R.string.bill_amount)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = modifier
    )
}