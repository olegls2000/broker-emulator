package com.bta.brokeremulator.model;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TRADE_TRANSACTION")
public class TradeTransaction implements Serializable {
	@Id
	@SequenceGenerator(name = "TRADE_TRANSACTION_SEQ", sequenceName = "TRADE_TRANSACTION_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = SEQUENCE, generator = "TRADE_TRANSACTION_SEQ")
	private Long id;

	@Size(max = 10)
	@NotNull
	@Column(name = "sticker", length = 10, nullable = false)
	private String sticker;

	@Min(0)
	@NotNull
	@Column(name = "amount", nullable = false)
	private Integer amount;

	@NotNull
	@Column(name = "price", nullable = false)
	private Double price;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_account_id", nullable = false)
	private UserAccount userAccount;
}
