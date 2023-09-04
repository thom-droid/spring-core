package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixedRateDiscountTest {

    FixedRateDiscount fixedRateDiscount = new FixedRateDiscount();

    @Test
    @DisplayName("VIP 할인은 10%")
    void vip_discount_10() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        int discountPrice = fixedRateDiscount.discount(member, 10000);

        //then
        assertEquals(discountPrice, 1000);
    }

    @Test
    @DisplayName("VIP 아니면 할인 0")
    void normal_discount_0() {

        //given
        Member member = new Member(1L, "memberB", Grade.NORMAL);

        //when
        int discountPrice = fixedRateDiscount.discount(member, 10000);

        //then
        org.assertj.core.api.Assertions.assertThat(discountPrice).isEqualTo(0);
    }
}