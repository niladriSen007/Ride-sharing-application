package com.niladri.RideSharingApplication.dto.wallet;

import com.niladri.RideSharingApplication.dto.user.UserResponseDto;
import com.niladri.RideSharingApplication.dto.walletTransaction.WalletTransactionDto;
import lombok.Data;

import java.util.List;

@Data
public class WalletDto {
	private Long id;
	private Double balance;

	private UserResponseDto user;

	private List<WalletTransactionDto> walletTransactions;
}
