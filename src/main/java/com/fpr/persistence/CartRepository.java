package com.fpr.persistence;

import com.fpr.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
//    Optional<Cart> findByMemberId(Long memberId);
//    Optional<Cart> findById(Long cartId);
    Cart findByMemberId(Long memberId);
}
