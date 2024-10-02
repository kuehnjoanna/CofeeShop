package de.syntax_institut.jpc

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
@Composable
fun SecondScreen(){
    val navigationBarItems = remember { NavigationBarItems.values()}
    var selectedIndex by remember {
        mutableStateOf(0)
    }}