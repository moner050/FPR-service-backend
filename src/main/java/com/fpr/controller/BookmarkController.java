package com.fpr.controller;

import com.fpr.domain.Bookmark;
import com.fpr.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;

    // 즐겨찾기 등록
//    @PostMapping("/bookmark/{memberId}/{productId}")
//    public void insertBookmark(@PathVariable Long memberId, @PathVariable Long productId) {
//
//    }

    // 즐겨찾기 삭제
    @DeleteMapping("/bookmark/{bookmarkId}")
    public void deleteBookmark(@PathVariable Long bookmarkId) {
        bookmarkService.deleteBookmark(bookmarkId);
    }

    // 즐겨찾기 목록 조회
    @GetMapping("/bookmark/{memberId}")
    public List<Bookmark> bookmarkList(@PathVariable Long memberId) {
        return bookmarkService.getBookmarkList(memberId);
    }

}
