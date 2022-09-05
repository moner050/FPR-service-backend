package com.fpr.persistence;

import com.fpr.domain.Bookmark;
import com.fpr.domain.BookmarkItem;
import com.fpr.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookmarkItemRepository extends JpaRepository<BookmarkItem, Long> {

//    Optional<BookmarkItem> findByBookmarkIdAndProductId(Long bookmarkId, Long productId);

//    List<Bookmark> findAllByMemberMemberId(Long memberId);
}
