package com.teamsparta.todolist.domain.card.dto

data class CreateCardRequest(
    val title: String,
    val content:String,
    val name:String,
    val date:String
)