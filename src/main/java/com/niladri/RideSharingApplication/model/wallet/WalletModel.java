package com.niladri.RideSharingApplication.model.wallet;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.niladri.RideSharingApplication.model.user.UserModel;
import com.niladri.RideSharingApplication.model.walletTransaction.WalletTransactionModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class WalletModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double balance;

	@OneToOne(fetch = FetchType.LAZY)
	private UserModel user;

	@OneToMany(mappedBy = "wallet", fetch = FetchType.LAZY)
//	@JsonIgnore
	private List<WalletTransactionModel> walletTransactionModel;
}
