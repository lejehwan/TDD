//package chap07_ex01;
//
///**
// * 카드 정보 API를 대신해서 유효한 카드번호, 도난 카드번호와 같은 상황을 흉내내는 대역
// */
//public class StubCardNumberValidator extends CardNumberValidator{
//
//    private String invalidNo;
//    private String theftNo;
//
//    public void setInvalidNo(String invalidNo){
//        this.invalidNo = invalidNo;
//    }
//
//    public void setTheftNoNo(String theftNo){
//        this.theftNo = theftNo;
//    }
//
//    @Override
//    public CardValidity validity(String cardNumber) {
//        if (invalidNo != null && invalidNo.equals(cardNumber)){
//            return CardValidity.INVALID;
//        }
//        if (theftNo != null && theftNo.equals(cardNumber)){
//            return CardValidity.THEFT;
//        }
//        return CardValidity.VALID;
//    }
//}
