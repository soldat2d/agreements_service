package net.da.net.agreements_service.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Statistics {
    private Integer count;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;
    private BigDecimal sum;
}
