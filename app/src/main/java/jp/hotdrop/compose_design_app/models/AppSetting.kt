package jp.hotdrop.compose_design_app.models

data class AppSetting(
    val userId: String? = null,
    val nickName: String? = null,
    val email: String? = null
) {
    fun isInitialized(): Boolean {
        return userId != null
    }
}