/**
 * Created by Antonio Lozano
 *
 * 02/04/2020
 *
 */

package antonio08.com.github.tdd.login

class LoginPresenter (loginView: LoginView){

    private val MAX_LOGIN_ATTEMPT = 3
    private val mLoginView : LoginView = loginView
    private var mLoginAttempts : Int = 0

    // Dummy user
    private val USER_NAME = "Antonio"
    private val USER_PASSWORD = "password"

    /**
     * Increments the number of attempts made by the user
     */
    fun incrementLoginAttempts () : Int {
        mLoginAttempts++
        return mLoginAttempts
    }

    private fun resetLoginAttempts () {
        mLoginAttempts = 0
    }

    /**
     * Return true if the login attempts has been exceeded; false otherwise
     */
    fun isLoginAttemptsExceeded () : Boolean {
        return mLoginAttempts >= MAX_LOGIN_ATTEMPT
    }

    fun doLogin (userName : String, password : String){
        if (isLoginAttemptsExceeded()){
            mLoginView.showErrorMessageForMaxLoginAttempt()
            return
        }

        // This will validate the user, usually you shouldn't do this but since is a dummy example
        // it will do the trick
        if (USER_NAME.equals(userName) && USER_PASSWORD.equals(password)){
            mLoginView.showLoginSuccessMessage()
            resetLoginAttempts()
        }
        else {
            incrementLoginAttempts()
            mLoginView.showErrorMessageForUserNamePassword()
        }
    }

}