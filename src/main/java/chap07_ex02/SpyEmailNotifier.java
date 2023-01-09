package chap07_ex02;

public class SpyEmailNotifier implements EmailNotifier{

    private boolean called;
    private String email;

    public boolean isCalled() {
        return called;
    }

    public String getEmail() {
        return email;
    }

    // spy 대역 사용
    @Override
    public void sendRegisterEmail(String email) {
        this.called = true;
        this.email = email;
    }
}
