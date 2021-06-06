package team.triplog.presentation.util

import android.content.Context
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat


/**
 * @author mjkim
 * @since 2021/06/06
 **/
interface ResourcesProvider {
    @ColorInt
    fun getColor(@ColorRes resId: Int): Int
    fun getString(@StringRes resId: Int): String
    fun getString(@StringRes resId: Int, vararg args: Any): String
    fun getDimen(@DimenRes resId: Int): Float
    fun getDimenInt(@DimenRes resId: Int): Int

    //... other things, above methods just for the example
}

@Suppress("TooManyFunctions")
inline class AppResourcesProvider(
    private val context: Context
) : ResourcesProvider {
    @ColorInt
    override fun getColor(resId: Int) = ContextCompat.getColor(context, resId)

    override fun getString(resId: Int) = context.getString(resId)

    override fun getString(resId: Int, vararg args: Any) = context.getString(resId, *args)

    override fun getDimen(resId: Int): Float = context.resources.getDimension(resId)

    override fun getDimenInt(resId: Int) = context.resources.getDimensionPixelSize(resId)

    //implementation for another methods

}