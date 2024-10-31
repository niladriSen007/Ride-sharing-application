package com.niladri.RideSharingApplication.model.wallet;

import com.niladri.RideSharingApplication.model.user.UserModel;
import com.niladri.RideSharingApplication.model.walletTransaction.WalletTransactionModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WalletModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double balance;

	@OneToOne(fetch = FetchType.LAZY,optional = false)
	private UserModel user;

	@OneToMany(mappedBy = "wallet", fetch = FetchType.LAZY)
//	@JsonIgnore
	private List<WalletTransactionModel> walletTransactions;
}
