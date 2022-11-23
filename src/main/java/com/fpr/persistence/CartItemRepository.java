package com.fpr.persistence;

import com.fpr.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    Optional<CartItem> findById(Long id);
    Optional<CartItem> findByCartIdAndProductId(Long cartId, Long productId);

    List<CartItem> findAllByCartId(Long cartId);
}
