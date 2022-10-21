package net.da.net.agreements_service.repository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Statistics {
    private Integer count;
    private String minAmount;
    private String maxAmount;
    private String sum;
}
