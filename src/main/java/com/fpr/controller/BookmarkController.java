package com.fpr.controller;

import com.fpr.dto.BookmarkResponseDto;
import com.fpr.service.BookmarkService;
import com.fpr.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;

    // 즐겨찾기 목록 조회
    @GetMapping("/bookmarks")
    public ResponseEntity<List<BookmarkResponseDto>> bookmarkList() {
        return ResponseEntity.ok(bookmarkService.getBookmarkList(SecurityUtil.getCurrentMemberId()));
    }

    // 즐겨찾기 담기
    @PostMapping("/bookmark/{productId}")
    public ResponseEntity<Objects> insertBookmark(@PathVariable Long productId) {
        bookmarkService.insertBookmark(SecurityUtil.getCurrentMemberId(), productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 즐겨찾기 전체 삭제
    @DeleteMapping("/bookmarks")
    public void deleteBookmark() {
        bookmarkService.deleteAllBookmark(SecurityUtil.getCurrentMemberId());
    }

    // 즐겨찾기 단일 삭제
    @DeleteMapping("/bookmark/{bookmarkItemId}")
    public void deleteOneBookmark(@PathVariable("bookmarkItemId") Long bookmarkItemId) {
        bookmarkService.deleteBookmark(SecurityUtil.getCurrentMemberId(), bookmarkItemId);
    }


}
