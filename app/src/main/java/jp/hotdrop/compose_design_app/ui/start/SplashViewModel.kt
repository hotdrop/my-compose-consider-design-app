package jp.hotdrop.compose_design_app.ui.start

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jp.hotdrop.compose_design_app.models.AppSetting
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class SplashViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow<SplashState>(SplashState.Loading())
    val state = _state.asStateFlow()

    init {
        initialization()
    }

    private fun initialization() {
        viewModelScope.launch {
            // TODO アプリ設定情報をappSettingRepositoryから取得する
            // await ref.read(appSettingRepositoryProvider).init();
            // final appSetting = await ref.read(appSettingRepositoryProvider).find();
            val appSetting = AppSetting()
            val uiData = SplashUiData(appSetting)
            _state.value = SplashState.Success(uiData)
        }
    }
}

data class SplashUiData(val appSetting: AppSetting) {
    fun getUserId(): String? {
        return appSetting.userId
    }

    companion object {
        fun createEmpty(): SplashUiData {
            return SplashUiData(AppSetting())
        }
    }
}

sealed class SplashState {
    data class Success(val uiData: SplashUiData): SplashState()
    data class Error(val errorMsg: String): SplashState()
    data class Loading(val uiData: SplashUiData = SplashUiData.createEmpty()): SplashState()
}