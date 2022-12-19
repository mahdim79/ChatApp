package com.dust.exchat.presentation.cviews.checkbox

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatCheckBox
import com.dust.exchat.di.qualifiers.BoldFont
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class BoldCheckbox:AppCompatCheckBox {
    @Inject
    @BoldFont
    lateinit var boldFont: Typeface

    constructor(context: Context):super(context){
        typeface = boldFont
    }

    constructor(context: Context, attrs: AttributeSet):super(context,attrs){
        typeface = boldFont
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr:Int):super(context,attrs,defStyleAttr){
        typeface = boldFont
    }
}