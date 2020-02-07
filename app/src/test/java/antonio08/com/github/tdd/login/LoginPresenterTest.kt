/**
 * Created by Antonio Lozano on 2020-02-06.
 */
package antonio08.com.github.tdd.login

import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify


class LoginPresenterTest{

    @Test
    fun checkIfLoginAttemptsIsExceeded () {
        // Arrange
        val loginView : LoginView = mock(LoginView::class.java)
        val loginPresenter = LoginPresenter(loginView)

        // Assert
        assertEquals(1, loginPresenter.incrementLoginAttempts())
        assertEquals(2, loginPresenter.incrementLoginAttempts())
        assertEquals(3, loginPresenter.incrementLoginAttempts())

        assertTrue(loginPresenter.isLoginAttemptsExceeded())
    }

    @Test
    fun checkStudentCredentialsAreCorrect () {
        // Arrange
        val userName = "Antonio"
        val userPassword = "password"
        val loginView : LoginView = mock(LoginView::class.java)
        val loginPresenter = LoginPresenter(loginView)

        // Act
        loginPresenter.doLogin(userName, userPassword)

        // Assert
        verify(loginView).showLoginSuccessMessage()
    }

}