package com.example.auular.utils

object Validator  {
  fun validateEmail(email: String) : Boolean {
    return !(email.isEmpty() || email.isBlank() || email.contains("@"));
  }

  fun validatePassword(password: String) : Boolean {
    return !(password.isEmpty() || password.isBlank());
  }

}