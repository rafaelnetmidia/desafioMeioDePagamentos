package com.payment.domain.transaction;

import com.payment.domain.user.User;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name="transactions")
@Table(name="transactions")
@Getter
@Setter
@EqualsAndHashCode(of="id")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name="sender_id")
    private User userSender;
    @ManyToOne
    @JoinColumn(name="receiver_id")
    private User userReceiver;
    private LocalDateTime timestamp;
}
