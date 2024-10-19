package hello.core.discount;

import hello.core.member.Member;
import org.springframework.core.annotation.Order;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
