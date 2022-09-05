package com.fpr.persistence;

import com.fpr.domain.Bookmark;
import com.fpr.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    List<Bookmark> findByMemberId(Long memberId);
}
