package com.example.myapplication

import java.util.regex.Matcher
import java.util.regex.Pattern

class LoginUtils {
    val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    var pattern: Pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE)

    fun validate(username:String,email:String,password:String,age:Int):String?{
        if(username.isEmpty()) return "Please enter user name"
        if(username.length<6) return "Very short user name"
        if(username.length>20) return "Long user name"

        if(email.isEmpty()) return "Please enter email"
        var matcher: Matcher = pattern.matcher(email)
        if(!matcher.matches()) return "Please enter valid email"

        if(password.isEmpty()) return "Please enter password"
        if(password.length<6) return "Please enter valid password"

        if(age == 0) return "Please enter valid age"
        if(age<18) return "User age is not valid"

        return "true"
    }
}