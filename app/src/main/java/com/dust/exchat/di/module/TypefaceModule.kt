package com.dust.exchat.di.module

import android.content.Context
import android.graphics.Typeface
import com.dust.exchat.di.qualifiers.BoldFont
import com.dust.exchat.di.qualifiers.LightFont
import com.dust.exchat.di.qualifiers.NormalFont
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TypefaceModule {

    @Singleton
    @NormalFont
    @Provides
    fun provideNormalFont(@ApplicationContext context: Context):Typeface{
        return Typeface.createFromAsset(context.assets,"fonts/yekan_bakh_regular.ttf")
    }

    @Singleton
    @BoldFont
    @Provides
    fun provideBoldFont(@ApplicationContext context: Context):Typeface{
        return Typeface.createFromAsset(context.assets,"fonts/yekan_bakh_bold.ttf")
    }

    @Singleton
    @LightFont
    @Provides
    fun provideLightFont(@ApplicationContext context: Context):Typeface{
        return Typeface.createFromAsset(context.assets,"fonts/yekan_bakh_light.ttf")
    }
}