package com.niladri.RideSharingApplication.dto.walletTransaction;

import com.niladri.RideSharingApplication.dto.ride.RideDto;
import com.niladri.RideSharingApplication.dto.wallet.WalletDto;
import com.niladri.RideSharingApplication.model.enums.TransactionMethod;
import com.niladri.RideSharingApplication.model.enums.TransactionType;
import com.niladri.RideSharingApplication.model.ride.RideModel;
import com.niladri.RideSharingApplication.model.wallet.WalletModel;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
public class WalletTransactionDto {
	private Long id;

	private Double amount;

	private TransactionType transactionType;

	private TransactionMethod transactionMethod;

	private RideDto ride;

	private String transactionId;

	private LocalDateTime transactionTime;

	private WalletDto wallet;
}
