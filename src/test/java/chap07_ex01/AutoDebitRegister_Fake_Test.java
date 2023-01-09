//package chap07_ex01;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDateTime;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class AutoDebitRegister_Fake_Test {
//
//    private AutoDebitRegister register;
//    private StubCardNumberValidator cardNumberValidator;
//    private MemoryAutoDebitInfoRepository repository;
//
//    @BeforeEach
//    void setUp(){
//        CardNumberValidator validator = new CardNumberValidator();
//        repository = new MemoryAutoDebitInfoRepository();
//        register = new AutoDebitRegister(cardNumberValidator, repository);
//    }
//
//    @Test
//    void alreadyRegistered_InfoUpdated(){
//        // 이미 자동이체 정보가 존재하는 상황 흉내
//        repository.save(new AutoDebitInfo("user1", "111222333444", LocalDateTime.now()));
//
//        AutoDebitReq req = new AutoDebitReq("user1", "1234567890123");
//        RegisterResult result = register.register(req);
//
//        AutoDebitInfo saved = repository.findOne("user1");
//        assertEquals("1234567890123", saved.getCardNumber());
//    }
//
//    @Test
//    void notYetRegistered_newInfoRegistered(){
//        AutoDebitReq req = new AutoDebitReq("user1", "1234123412341234");
//        RegisterResult result = register.register(req);
//
//        AutoDebitInfo saved = repository.findOne("user1");
//        assertEquals("1234123412341234", saved.getCardNumber());
//    }
//}
