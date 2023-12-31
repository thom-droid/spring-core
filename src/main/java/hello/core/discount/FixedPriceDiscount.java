package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("fixedPriceDiscount")
//@Primary
@MainDiscountPolicy
public class FixedPriceDiscount implements DiscountPolicy {

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        Grade grade = member.getGrade();

        if (grade == Grade.VIP) {
            return discountFixAmount;
        }

        return 0;
    }
}
