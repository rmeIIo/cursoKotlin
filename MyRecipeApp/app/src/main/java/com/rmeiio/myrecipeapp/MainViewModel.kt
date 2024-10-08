package com.rmeiio.myrecipeapp

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel : ViewModel() {

    private val _categorieState = mutableStateOf(RecipeState())
    val categoriesState : State<RecipeState> = _categorieState

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            _categorieState.value = RecipeState(loading = true)
            try {
                val response = recipeService.getCategories()
                Log.d("API_RESPONSE", response.toString())

                _categorieState.value = RecipeState(
                    list = response.categories,
                    loading = false,
                    error = null
                )
            } catch (
                e : Exception
            ) {
                Log.e("API_ERROR", e.message ?: "Unknown error")

                _categorieState.value = RecipeState(
                    loading = false,
                    error = "Error fetching Categories: ${e.message}"
                )
            }
        }
    }

    data class RecipeState(
        val loading : Boolean = true,
        val list : List<Category> = emptyList(),
        val error : String? = null
    )

}