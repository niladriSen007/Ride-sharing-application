package com.niladri.RideSharingApplication.model.walletTransaction;

import com.niladri.RideSharingApplication.model.enums.TransactionMethod;
import com.niladri.RideSharingApplication.model.enums.TransactionType;
import com.niladri.RideSharingApplication.model.ride.RideModel;
import com.niladri.RideSharingApplication.model.wallet.WalletModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class WalletTransactionModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Double amount;

	private TransactionType transactionType;

	private TransactionMethod transactionMethod;

	@OneToOne(fetch = FetchType.LAZY)
	private RideModel ride;

	private String transactionId;

	@CreationTimestamp
	private LocalDateTime transactionTime;

	@ManyToOne
	private WalletModel wallet;
}
