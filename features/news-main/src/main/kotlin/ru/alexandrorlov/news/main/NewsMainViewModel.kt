package ru.alexandrorlov.news.main

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

internal class NewsMainViewModel : ViewModel() {

    private val _state: MutableStateFlow<State> = MutableStateFlow(State.Init)
    val state: StateFlow<State>
        get() = _state.asStateFlow()
}

sealed class State {
    data object Init: State()
    data object Loading: State()
    data class Error(): State()
    data class Content(val listArticle: List<Article>)
}