package com.example.timemanager.notes_feature.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()

}