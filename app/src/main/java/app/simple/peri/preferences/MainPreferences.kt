package app.simple.peri.preferences

import app.simple.peri.utils.WallpaperSort

object MainPreferences {

    private const val STORAGE_URI = "storageUri"
    private const val NOMEDIA_DIALOG = "nomediaDialog"
    private const val BLUR = "blur"
    private const val REMEMBER_SCROLL_POSITION = "remember_scroll_position"
    private const val SCROLL_POSITION = "scrollPosition"
    private const val CROP_WALLPAPER = "crop_wallpaper"
    private const val DIFFERENT_WALLPAPER = "different_wallpaper_for_lock_screen"
    private const val WALLPAPER_WHEN_SLEEPING = "wallpaper_when_sleeping"
    private const val WALLPAPER_SET_FOR = "auto_wallpaper_set_for"
    private const val REDUCE_MOTION = "reduce_motion"
    private const val REQUEST_ADD_TILE = "request_add_tile"
    private const val LAST_WALLPAPER_POSITION = "last_wallpaper_position"

    const val IS_BIOMETRIC = "is_biometric"
    const val SORT = "sort"
    const val ORDER = "order"
    const val NAME = "is_name"
    const val GRID_SPAN = "grid_span"
    const val DETAILS = "is_details"
    const val MARGIN_BETWEEN = "margin_between_wallpapers"
    const val MAIN_SCREEN_BACKGROUND = "main_screen_background"
    const val SWIPE_TO_DELETE = "swipe_to_delete"
    const val AUTO_WALLPAPER_INTERVAL = "auto_wallpaper_interval_1"
    const val TWEAKS = "tweaks"

    const val SPAN_ONE = "1"
    const val SPAN_TWO = "2"
    const val SPAN_DYNAMIC = "3"

    const val BOTH = "3"
    const val HOME = "1"
    const val LOCK = "2"

    const val IGNORE_DOT_FILES = "1"
    const val IGNORE_SUB_DIRS = "2"
    const val LINEAR_AUTO_WALLPAPER = "3"

    fun getStorageUri(): String? {
        return SharedPreferences.getSharedPreferences().getString(STORAGE_URI, null)
    }

    fun setStorageUri(uri: String?) {
        SharedPreferences.getSharedPreferences().edit().putString(STORAGE_URI, uri).apply()
    }

    fun getSort(): String? {
        return SharedPreferences.getSharedPreferences().getString(SORT, WallpaperSort.DATE)
    }

    fun setSort(sort: String) {
        SharedPreferences.getSharedPreferences().edit().putString(SORT, sort).apply()
    }

    fun getOrder(): String? {
        return SharedPreferences.getSharedPreferences().getString(ORDER, WallpaperSort.DESC)
    }

    fun setOrder(order: String) {
        SharedPreferences.getSharedPreferences().edit().putString(ORDER, order).apply()
    }

    fun getName(): Boolean {
        return SharedPreferences.getSharedPreferences().getBoolean(NAME, true)
    }

    fun getGridSpan(): String {
        return SharedPreferences.getSharedPreferences().getString(GRID_SPAN, SPAN_DYNAMIC)!!
    }

    fun isSpanDynamic(): Boolean {
        return getGridSpan() == SPAN_DYNAMIC
    }

    fun getShowNomediaDialog(): Boolean {
        return SharedPreferences.getSharedPreferences().getBoolean(NOMEDIA_DIALOG, true)
    }

    fun setShowNomediaDialog(show: Boolean) {
        SharedPreferences.getSharedPreferences().edit().putBoolean(NOMEDIA_DIALOG, show).apply()
    }

    fun getBlur(): Boolean {
        return SharedPreferences.getSharedPreferences().getBoolean(BLUR, true)
    }

    fun getDetails(): Boolean {
        return SharedPreferences.getSharedPreferences().getBoolean(DETAILS, true)
    }

    fun isBiometric(): Boolean {
        return SharedPreferences.getSharedPreferences().getBoolean(IS_BIOMETRIC, false)
    }

    fun isRememberScrollPosition(): Boolean {
        return SharedPreferences.getSharedPreferences().getBoolean(REMEMBER_SCROLL_POSITION, false)
    }

    fun getScrollPosition(): Int {
        return SharedPreferences.getSharedPreferences().getInt(SCROLL_POSITION, 0)
    }

    fun setScrollPosition(position: Int) {
        SharedPreferences.getSharedPreferences().edit().putInt(SCROLL_POSITION, position).apply()
    }

    fun getMarginBetween(): Boolean {
        return SharedPreferences.getSharedPreferences().getBoolean(MARGIN_BETWEEN, false)
    }

    fun setMarginBetween(marginBetween: Boolean) {
        SharedPreferences.getSharedPreferences().edit().putBoolean(MARGIN_BETWEEN, marginBetween).apply()
    }

    fun getMainScreenBackground(): String? {
        return SharedPreferences.getSharedPreferences().getString(MAIN_SCREEN_BACKGROUND, "1")
    }

    fun getSwipeToDelete(): Boolean {
        return SharedPreferences.getSharedPreferences().getBoolean(SWIPE_TO_DELETE, true)
    }

    fun getAutoWallpaperInterval(): String {
        return SharedPreferences.getSharedPreferences().getString(AUTO_WALLPAPER_INTERVAL, "0")!!
    }

    fun setAutoWallpaperInterval(interval: String) {
        SharedPreferences.getSharedPreferences().edit().putString(AUTO_WALLPAPER_INTERVAL, interval).apply()
    }

    fun isAutoWallpaperIntervalEnabled(): Boolean {
        return SharedPreferences.getSharedPreferences().getString(AUTO_WALLPAPER_INTERVAL, "0") != "0"
    }

    fun turnOffAutoWallpaperInterval() {
        SharedPreferences.getSharedPreferences().edit().putString(AUTO_WALLPAPER_INTERVAL, "0").apply()
    }

    fun getCropWallpaper(): Boolean {
        return SharedPreferences.getSharedPreferences().getBoolean(CROP_WALLPAPER, false)
    }

    fun setCropWallpaper(cropWallpaper: Boolean) {
        SharedPreferences.getSharedPreferences().edit().putBoolean(CROP_WALLPAPER, cropWallpaper).apply()
    }

    fun isDifferentWallpaperForLockScreen(): Boolean {
        return SharedPreferences.getSharedPreferences().getBoolean(DIFFERENT_WALLPAPER, false)
    }

    fun setDifferentWallpaperForLockScreen(differentWallpaper: Boolean) {
        SharedPreferences.getSharedPreferences().edit().putBoolean(DIFFERENT_WALLPAPER, differentWallpaper).apply()
    }

    fun isWallpaperWhenSleeping(): Boolean {
        return SharedPreferences.getSharedPreferences().getBoolean(WALLPAPER_WHEN_SLEEPING, true)
    }

    fun setWallpaperWhenSleeping(isWallpaperWhenSleeping: Boolean) {
        SharedPreferences.getSharedPreferences().edit().putBoolean(WALLPAPER_WHEN_SLEEPING, isWallpaperWhenSleeping).apply()
    }

    fun getWallpaperSetFor(): String {
        return SharedPreferences.getSharedPreferences().getString(WALLPAPER_SET_FOR, BOTH)!!
    }

    fun isSettingForHomeScreen(): Boolean {
        return getWallpaperSetFor() == HOME || getWallpaperSetFor() == BOTH
    }

    fun isSettingForLockScreen(): Boolean {
        return getWallpaperSetFor() == LOCK || getWallpaperSetFor() == BOTH
    }

    fun isSettingForBoth(): Boolean {
        return getWallpaperSetFor() == BOTH
    }

    fun setWallpaperSetFor(wallpaperSetFor: String) {
        SharedPreferences.getSharedPreferences().edit().putString(WALLPAPER_SET_FOR, wallpaperSetFor).apply()
    }

    fun getReduceMotion(): Boolean {
        return SharedPreferences.getSharedPreferences().getBoolean(REDUCE_MOTION, false)
    }

    fun setReduceMotion(reduceMotion: Boolean) {
        SharedPreferences.getSharedPreferences().edit().putBoolean(REDUCE_MOTION, reduceMotion).apply()
    }

    fun shouldRequestAddTile(): Boolean {
        return SharedPreferences.getSharedPreferences().getBoolean(REQUEST_ADD_TILE, true)
    }

    fun setRequestAddTile(requestAddTile: Boolean) {
        SharedPreferences.getSharedPreferences().edit().putBoolean(REQUEST_ADD_TILE, requestAddTile).apply()
    }

    fun getLastWallpaperPosition(): Int {
        return SharedPreferences.getSharedPreferences().getInt(LAST_WALLPAPER_POSITION, 0)
    }

    fun setLastWallpaperPosition(position: Int) {
        SharedPreferences.getSharedPreferences().edit().putInt(LAST_WALLPAPER_POSITION, position).apply()
    }

    private fun getTweaks(): Set<String>? {
        return SharedPreferences.getSharedPreferences().getStringSet(TWEAKS, null)
    }

    fun isTweakOptionSelected(option: String): Boolean {
        val tweaks = getTweaks()
        return tweaks?.contains(option) ?: false
    }

    fun isIgnoreDotFiles(): Boolean {
        return isTweakOptionSelected(IGNORE_DOT_FILES)
    }

    fun isIgnoreSubDirs(): Boolean {
        return isTweakOptionSelected(IGNORE_SUB_DIRS)
    }

    fun isLinearAutoWallpaper(): Boolean {
        return isTweakOptionSelected(LINEAR_AUTO_WALLPAPER)
    }

    fun setIgnoreDotFiles(ignoreDotFiles: Boolean) {
        setTweakOption(IGNORE_DOT_FILES, ignoreDotFiles)
    }

    fun setIgnoreSubDirs(ignoreSubDirs: Boolean) {
        setTweakOption(IGNORE_SUB_DIRS, ignoreSubDirs)
    }

    fun setLinearAutoWallpaper(linearAutoWallpaper: Boolean) {
        setTweakOption(LINEAR_AUTO_WALLPAPER, linearAutoWallpaper)
    }

    private fun setTweakOption(option: String, enabled: Boolean) {
        val tweaks = getTweaks()?.toMutableSet() ?: mutableSetOf()
        if (enabled) {
            tweaks.add(option)
        } else {
            tweaks.remove(option)
        }
        SharedPreferences.getSharedPreferences().edit().putStringSet(TWEAKS, tweaks).apply()
    }
}
