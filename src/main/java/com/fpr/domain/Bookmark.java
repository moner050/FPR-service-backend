package com.fpr.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookmarkId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "member_Id")
//    private Member member;

    @OneToMany(mappedBy = "bookmark", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BookmarkItem> bookmarkItems;

}
