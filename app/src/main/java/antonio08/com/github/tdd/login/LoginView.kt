/**
 * Created by Antonio Lozano
 *
 * 02/04/2020
 *
 */

package antonio08.com.github.tdd.login

interface LoginView {

    fun showErrorMessageForUserNamePassword()

    fun showErrorMessageForMaxLoginAttempt()

    fun showLoginSuccessMessage()
}