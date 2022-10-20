package net.da.net.agreements_service.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Agreement {
    private Integer agreementId;
    private Integer clientId;
    private Integer productId;
    private BigDecimal amount;
    private Date startDate;
    private Date timestamp;
}
