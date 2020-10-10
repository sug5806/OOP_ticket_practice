package Discount;

import Money.Money;
import Screening.Screening;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {
    private List<DiscountPolicy> conditions = new ArrayList<>();

    public DiscountPolicy(DiscountPolicy ... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    // 부모 클래스에서 기본적인 알고리즘의 흐름을 구현하고 중간에 필요한 처리를
    // 자식 클래스에게 위임하는 패턴 (템플릿 패턴)
    public Money calculateDiscountAmount(Screening screening) {
        for(DiscountPolicy each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }

        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Screening screening);
}

