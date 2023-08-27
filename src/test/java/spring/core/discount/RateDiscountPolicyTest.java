package spring.core.discount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spring.core.member.Grade;
import spring.core.member.Member;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_successTest() {
        // given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        // when
        int discount = rateDiscountPolicy.discount(member, 10000);

        // then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_failTest() {
        // given
        Member member = new Member(1L, "memberBasic", Grade.BASIC);

        // when
        int discount = rateDiscountPolicy.discount(member, 10000);

        // then
        assertThat(discount).isZero();
    }
}