package jp.hotdrop.compose_design_app.ui.start

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow<SplashState>(SplashState.Loading)
    val state = _state.asStateFlow()

    init {

    }

    private fun initialization() {
        viewModelScope.launch {
            // アプリ設定情報をappSettingRepositoryから取得する
            _state.value = SplashState.Success
        }
    }
}

sealed class SplashState {
    data object Success: SplashState()
    data class Error(val errorMsg: String): SplashState()
    data object Loading: SplashState()
}