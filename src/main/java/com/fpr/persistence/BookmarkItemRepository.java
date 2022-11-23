package com.fpr.persistence;

import com.fpr.domain.BookmarkItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookmarkItemRepository extends JpaRepository<BookmarkItem, Long> {

    Optional<BookmarkItem> findById(Long id);
    Optional<BookmarkItem> findByBookmarkIdAndProductId(Long BookmarkId, Long productId);

    List<BookmarkItem> findAllByBookmarkId(Long BookmarkId);
}
