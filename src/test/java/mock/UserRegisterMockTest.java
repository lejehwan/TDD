package mock;

import chap07_ex02.EmailNotifier;
import chap07_ex02.UserRegister;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

public class UserRegisterMockTest {

    private UserRegister userRegister;
    private EmailNotifier mockEmailNotifier = mock(EmailNotifier.class);


    @DisplayName("가입하면 메일을 전송함")
    @Test
    void whenRegisterThenSendMail(){
        userRegister.register("id", "pw", "email@email.com");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        then(mockEmailNotifier)
                .should().sendRegisterEmail(captor.capture());

        String realEmail = captor.getValue();
        Assertions.assertEquals("email@email.com", realEmail);
    }
}
