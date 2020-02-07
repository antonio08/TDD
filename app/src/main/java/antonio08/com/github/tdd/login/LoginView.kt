/**
 * Created by Antonio Lozano on 2020-02-04.
 */

package antonio08.com.github.tdd.login

interface LoginView {

    fun showErrorMessageForUserNamePassword()

    fun showErrorMessageForMaxLoginAttempt()

    fun showLoginSuccessMessage()
}