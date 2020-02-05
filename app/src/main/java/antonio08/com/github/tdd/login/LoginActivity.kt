/**
 * Created by Antonio Lozano
 *
 * 02/04/2020
 *
 */

package antonio08.com.github.tdd.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import antonio08.com.github.tdd.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


class LoginActivity : AppCompatActivity(), LoginView {

    private var mLoginPresenter : LoginPresenter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // We initialize the presenter
        initializePresenter()

        mLoginButton.setOnClickListener {
            mLoginPresenter?.doLogin(mUserNameInput.text.toString(), mUserPassword.text.toString())
        }
    }

    override fun showErrorMessageForUserNamePassword() {
        Snackbar.make(mUserPassword, getString(R.string.incorrect_access), Snackbar.LENGTH_LONG)
            .show()
    }

    override fun showErrorMessageForMaxLoginAttempt() {
        Snackbar.make(mUserPassword, getString(R.string.attempts_exceed), Snackbar.LENGTH_LONG)
            .show()
    }

    override fun showLoginSuccessMessage() {
        Snackbar.make(mUserPassword, getString(R.string.login_successful), Snackbar.LENGTH_LONG)
            .show()
    }

    private fun initializePresenter(){
        mLoginPresenter = LoginPresenter(this)
    }
}
