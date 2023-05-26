package com.example.myapplication

data class Data(
    val title: String,
    val content: String
)

val data: List<Data> = (1..200).map {
    Data(
        title = "Entry $it",
        content = "This is entry $it"
    )
}