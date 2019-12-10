import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import Book_5_7_1.*;


public class UserServiceImplTest {

    @Test
    public void verifyUserGetsThePassword() throws Exception {
        //arrange
        User user = mock(User.class);
        UserDAO userDao = mock(UserDAO.class);
        SecurityService securityService = mock(SecurityService.class);
        UserServiceImpl userService = new UserServiceImpl(userDao, securityService);
        when(user.getPassword()).thenReturn("testPassword");
        //act
        userService.assignPassword(user);
        //assert
        verify(user).setPassword(any());
        verify(user).getPassword();
        verify(userDao).updateUser(user);


    }
}