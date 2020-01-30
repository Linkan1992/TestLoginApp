package a740362.testloginapp.util

object Validator {


    fun isValidateCredential(userDefinedId: String, userDefinedPass: String, id: String, pass: String): Boolean {

        return userDefinedId.trim().equals(id) && userDefinedPass.trim().equals(pass)
    }

    fun validateField(userDefinedId: String?, userDefinedPass: String?): HashMap<String, Boolean> {

        val validationMap = hashMapOf<String, Boolean>()

        validationMap[AppConstants.VALID] = userDefinedId?.length in 8..16 && userDefinedPass?.length in 8..16

        if (validationMap[AppConstants.VALID]!!)
            return validationMap

        validationMap[AppConstants.ID] = userDefinedId?.length in 8..16

        validationMap[AppConstants.PASS] = userDefinedPass?.length in 8..16

        return validationMap

    }

}
