package com.dust.exchat.presentation.cviews.checkbox

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatCheckBox
import com.dust.exchat.di.qualifiers.LightFont
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LightCheckbox:AppCompatCheckBox {
    @Inject
    @LightFont
    lateinit var lightFont: Typeface

    constructor(context: Context):super(context){
        typeface = lightFont
    }

    constructor(context: Context, attrs: AttributeSet):super(context,attrs){
        typeface = lightFont
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr:Int):super(context,attrs,defStyleAttr){
        typeface = lightFont
    }
}