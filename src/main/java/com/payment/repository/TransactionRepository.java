package com.payment.repository;

import com.payment.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<User, Long> {

}
