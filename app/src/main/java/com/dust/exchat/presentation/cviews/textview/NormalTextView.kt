package com.dust.exchat.presentation.cviews.textview

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.dust.exchat.di.qualifiers.BoldFont
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NormalTextView:AppCompatTextView {
    @Inject
    @BoldFont
    lateinit var normalFont: Typeface

    constructor(context: Context):super(context){
        typeface = normalFont
    }

    constructor(context: Context, attrs: AttributeSet):super(context,attrs){
        typeface = normalFont
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr:Int):super(context,attrs,defStyleAttr){
        typeface = normalFont
    }
}