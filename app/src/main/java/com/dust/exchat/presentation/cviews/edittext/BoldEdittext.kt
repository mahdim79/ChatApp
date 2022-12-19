package com.dust.exchat.presentation.cviews.edittext

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.dust.exchat.di.qualifiers.BoldFont
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class BoldEdittext:AppCompatEditText {
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