package com.example.mylibrary

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class vIEWMODEL:ViewModel() {


    companion object {
        fun Setcontext(thiscontext:Context){
            context =thiscontext
        }
        fun Autenticateuser() {


            CoroutineScope(Dispatchers.IO).launch {

                retrofitsetup.loginAuthentication(typedphoneno.value, typedpassword.value)
            }
        }
        fun settoast(str:String){
            CoroutineScope(Dispatchers.Main).launch {
                // Your code here
                myLibraryClass.showToast(context ,str)
            }
        }


        lateinit var context:Context
        val typedpassword = mutableStateOf("cityslicka")
        val typedphoneno  = mutableStateOf("eve.holt@reqres.in")
        val fieldText: String=""
        val passwordlabel: String="PASSWORD"
        val phonenolabel: String="EMAIL"
        val login:String="LOGIN"
        val retrofitsetup:RetrofitSetup= RetrofitSetup()
        val myLibraryClass = Mylibrary()
    }
    init {
        retrofitsetup.retrofitBuilder()
    }

}