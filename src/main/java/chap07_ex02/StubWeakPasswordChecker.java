package chap07_ex02;


public class StubWeakPasswordChecker implements WeakPasswordChecker {

    private boolean weak;

    public void setWeak(boolean weak){
        this.weak = weak;
    }

    // stub 대역 사용
    @Override
    public boolean checkPasswordWeak(String pw) {
        return weak;
    }
}
