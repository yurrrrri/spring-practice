package spring.core.order;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import spring.core.discount.FixDiscountPolicy;
import spring.core.member.*;

class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
    OrderService orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "yuri", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        Assertions.assertEquals(order.getDiscountPrice(), 1000);
    }
}
