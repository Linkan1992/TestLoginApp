package a740362.testloginapp.util

object Validator {

  fun isValidateCredential(userDefinedId : String, userDefinedPass : String, id : String, pass : String): Boolean {

    return userDefinedId.trim().equals(id) && userDefinedPass.trim().equals(pass)
  }

}
