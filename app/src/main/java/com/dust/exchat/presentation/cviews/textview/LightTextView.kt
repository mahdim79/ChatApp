package com.dust.exchat.presentation.cviews.textview

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.dust.exchat.di.qualifiers.BoldFont
import com.dust.exchat.di.qualifiers.LightFont
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LightTextView:AppCompatTextView {
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