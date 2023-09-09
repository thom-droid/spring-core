package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("fixedPriceDiscount")
@Primary
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
