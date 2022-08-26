package com.fpr.fprservicebackend.persistance;

import com.fpr.fprservicebackend.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByMemberId(Long memberId);

}
