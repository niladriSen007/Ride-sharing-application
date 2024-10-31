package com.niladri.RideSharingApplication.model.payment;

import com.niladri.RideSharingApplication.model.enums.PaymentMethods;
import com.niladri.RideSharingApplication.model.enums.PaymentStatus;
import com.niladri.RideSharingApplication.model.ride.RideModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private PaymentMethods paymentMethod;

	@OneToOne(fetch = FetchType.LAZY)
	private RideModel ride;

	private Double amount;

	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;

	@CreationTimestamp
	private LocalDateTime paymentTime;
}
