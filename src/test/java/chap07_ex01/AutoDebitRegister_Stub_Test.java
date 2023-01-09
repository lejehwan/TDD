//package chap07_ex01;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static chap07_ex01.CardValidity.INVALID;
//import static chap07_ex01.CardValidity.THEFT;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class AutoDebitRegister_Stub_Test {
//
//    private AutoDebitRegister register;
//    private StubCardNumberValidator stubValidator;
//    private StubAutoDebitInfoRepository stubRepository;
//
//    @BeforeEach
//    void setUp(){
//        stubValidator = new StubCardNumberValidator();
//        AutoDebitInfoRepository repository = new StubAutoDebitInfoRepository();
//        register = new AutoDebitRegister(stubValidator, repository);
//    }
//
//    @Test
//    void invalidCard(){
//        // 유효하지 않은 카드 번호 상황 흉내
//        stubValidator.setInvalidNo("111122223333");
//
//        AutoDebitReq req = new AutoDebitReq("user1", "111122223333");
//        RegisterResult result = register.register(req);
//
//        assertEquals(INVALID, result.getValidity());
//    }
//
//    @Test
//    void theftCard(){
//        stubValidator.setTheftNoNo("1234567890123456");
//
//        AutoDebitReq req = new AutoDebitReq("user1", "1234567890123456");
//        RegisterResult result = register.register(req);
//
//        assertEquals(THEFT, result.getValidity());
//    }
//}
