package com.example.fitnesstracker.navigation

import androidx.navigation.NavController
import com.example.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}