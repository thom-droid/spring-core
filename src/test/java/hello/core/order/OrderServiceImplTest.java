package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixedPriceDiscount;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceImplTest {

    @Test
    void createdOrder(){

        MemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "member1", Grade.VIP));
        DiscountPolicy discountPolicy = new FixedPriceDiscount();

        OrderService orderService = new OrderServiceImpl(memberRepository, discountPolicy);
        Order order = orderService.createOrder(1L, "itemA", 10000);

        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}