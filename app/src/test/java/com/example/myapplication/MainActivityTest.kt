package com.example.myapplication


import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class MainActivityTest {
    private lateinit var loginValidation:LoginUtils
    @Before
    fun setUp() {
        loginValidation= LoginUtils()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun username_is_empty()
    {
        val username=""
        val result= loginValidation.validate(username,"ajitkumar@gmail.com","12sjhyu", 20)
       // assert(result==null)
        assertThat(result).isEqualTo("true")
    }

    @Test
    fun username_length_less_6(){
        val username= "Ajit"
        val result= loginValidation.validate(username,"ajitkumar@gmail.com","12sjhyu", 20)
        // assert(result==null)
        assertThat(result).isEqualTo("true")
    }

    @Test
    fun username_length_very_long(){
        val username= "Ajit Kumar hjgh jg hjg hj hjghjghjg jhj"
        val result= loginValidation.validate(username,"ajitkumar@gmail.com","12sjhyu", 20)
        // assert(result==null)
        assertThat(result).isEqualTo("true")
    }

    @Test
    fun email_empty()
    {
        val email="ajitkumarkx@gmail.com"
        val result= loginValidation.validate("Ajit Kumar",email,"12sjhyu", 20)
        assertThat(result).isEqualTo("true")
    }

    @Test
    fun email_invalide()
    {
        val email="ajitkumarkxgmail.com"
        val result= loginValidation.validate("Ajit Kumar",email,"12sjhyu", 20)
        assertThat(result).isEqualTo("true")
    }

    @Test
    fun password_empty(){
        val password=""
        val result= loginValidation.validate("Ajit Kumar","ajitkumarkx@gmail.com",password, 20)
        assertThat(result).isEqualTo("true")
    }

    @Test
    fun password_invalide(){
        val password="ghf"
        val result= loginValidation.validate("Ajit Kumar","ajitkumarkx@gmail.com",password, 20)
        assertThat(result).isEqualTo("true")
    }

    @Test
    fun age_invalide(){
        val age=0
        val result= loginValidation.validate("Ajit Kumar","ajitkumarkx@gmail.com","password", age)
        assertThat(result).isEqualTo("true")
    }

    @Test
    fun age_underage(){
        val age=19
        val result= loginValidation.validate("Ajit Kumar","ajitkumarkx@gmail.com","password", age)
        assertThat(result).isEqualTo("true")
    }
}