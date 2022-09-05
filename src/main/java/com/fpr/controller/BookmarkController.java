package com.fpr.controller;

import com.fpr.domain.Bookmark;
import com.fpr.dto.BookmarkResponseDto;
import com.fpr.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;

    // 즐겨찾기 등록
    @PostMapping("/bookmark/{memberId}/{productId}")
    public ResponseEntity insertBookmark(@PathVariable Long memberId, @PathVariable Long productId) {
        bookmarkService.insertBookmark(memberId, productId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    // 즐겨찾기 삭제
    @DeleteMapping("/bookmark/{bookmarkId}")
    public void deleteBookmark(@PathVariable Long bookmarkId) {
        bookmarkService.deleteBookmark(bookmarkId);
    }

    // 즐겨찾기 목록 조회
    @GetMapping("/bookmark/{memberId}")
    public ResponseEntity<List<Bookmark>> bookmarkList(@PathVariable Long memberId) {
        return ResponseEntity.ok(bookmarkService.getBookmarkList(memberId));
    }

}
