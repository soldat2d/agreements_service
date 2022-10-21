package net.da.net.agreements_service.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Agreement {
	@Null
	private Integer agreementId;
	@NotNull
	private Integer clientId;
	@NotNull
	private Integer productId;
	@NotNull
	private BigDecimal amount;
	@NotNull
	private Date startDate;
	@Null
	private Date timestamp;

	public Agreement(Integer clientId, Integer productId, String amount, Date startDate) {
		this.clientId = clientId;
		this.productId = productId;
		this.amount = new BigDecimal(amount);
		this.startDate = startDate;
	}

	public Agreement agreementId(Integer id) {
		this.agreementId = id;
		return this;
	}
}
