package Discount;

import Screening.Screening;

public interface DiscountCondition{
    boolean isSatisfiedBy(Screening screening);
}