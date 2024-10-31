package com.niladri.RideSharingApplication.repository.payment;

import com.niladri.RideSharingApplication.model.payment.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentModel, Long> {
}
