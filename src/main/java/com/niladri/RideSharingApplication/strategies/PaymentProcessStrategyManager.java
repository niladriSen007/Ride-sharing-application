package com.niladri.RideSharingApplication.strategies;

import com.niladri.RideSharingApplication.model.enums.PaymentMethods;
import com.niladri.RideSharingApplication.strategies.processPayment.CashPaymentProcess;
import com.niladri.RideSharingApplication.strategies.processPayment.PaymentProcessInterface;
import com.niladri.RideSharingApplication.strategies.processPayment.WalletPaymentProcess;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentProcessStrategyManager {

	private final CashPaymentProcess cashPaymentProcess;
	private final WalletPaymentProcess walletPaymentProcess;

	public PaymentProcessInterface paymentProcessStrategy(PaymentMethods paymentMethod) {
		return switch (paymentMethod) {
			case CASH -> cashPaymentProcess;
			case WALLET -> walletPaymentProcess;
			default -> throw new IllegalArgumentException("Invalid payment method");
		};

	}
}
