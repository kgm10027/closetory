package com.example.closetory.search;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchDataController {

    private final List<com.example.closetory.search.SearchItem> items = List.of(
            // ===== 메인(index) 관련 =====
            new com.example.closetory.search.SearchItem(
                    "home-today",
                    "오늘의 코디, Closetory",
                    "메인",
                    "날씨·시간·상황에 맞춰 코디를 추천해 주는 메인 화면",
                    "/index.html",
                    List.of("오늘의 코디", "메인", "홈", "날씨 코디", "실시간 기온")
            ),
            new com.example.closetory.search.SearchItem(
                    "home-weekend-trip",
                    "주말 여행 코디",
                    "여행 코디",
                    "후드 + 경량 패딩 + 청바지로 이동하기 편한 여행 룩",
                    "/index.html",
                    List.of("여행", "주말", "후드", "패딩", "청바지")
            ),
            new com.example.closetory.search.SearchItem(
                    "home-campus",
                    "캠퍼스 캐주얼 코디",
                    "데일리룩",
                    "후드티와 패딩, 조거 팬츠 조합의 캠퍼스 데일리룩",
                    "/index.html",
                    List.of("캠퍼스", "데일리룩", "후드", "조거팬츠", "패딩")
            ),
            new com.example.closetory.search.SearchItem(
                    "home-presentation",
                    "발표용 코디",
                    "발표/면접",
                    "화이트 셔츠 + 슬랙스로 단정하게 준비하는 발표 룩",
                    "/index.html",
                    List.of("발표", "프레젠테이션", "셔츠", "슬랙스")
            ),

            // ===== 옷장(closet) 페이지 =====
            new com.example.closetory.search.SearchItem(
                    "closet-all",
                    "나의 옷장",
                    "옷장",
                    "보유한 상·하의·아우터·신발을 한 번에 관리하는 옷장 페이지",
                    "/closet.html",
                    List.of("옷장", "아이템", "상의", "바지", "신발", "아우터")
            ),

            // ===== 색감(color) 페이지 =====
            new com.example.closetory.search.SearchItem(
                    "color-match",
                    "색감별 코디 추천",
                    "색 조합",
                    "퍼스널 컬러와 톤에 맞는 색 조합 코디를 보여주는 페이지",
                    "/color.html",
                    List.of("색 조합", "컬러", "톤", "퍼스널컬러")
            ),

            // ===== 상황별(situation) 페이지 =====
            new com.example.closetory.search.SearchItem(
                    "situation-interview",
                    "면접/발표 코디 모음",
                    "상황별",
                    "면접, 발표 등 포멀한 자리에서 입기 좋은 코디 모음",
                    "/situation.html",
                    List.of("면접", "발표", "정장", "포멀")
            ),

            // ===== 캘린더(calendar) 페이지 =====
            new com.example.closetory.search.SearchItem(
                    "calendar-daily",
                    "코디 기록 캘린더",
                    "달력",
                    "날짜별로 착용한 코디를 기록하고 확인하는 달력",
                    "/calendar.html",
                    List.of("캘린더", "코디 기록", "달력", "기록")
            ),

            // ===== 랭킹(ranking) 페이지 =====
            new com.example.closetory.search.SearchItem(
                    "ranking-popular",
                    "인기 코디 랭킹",
                    "랭킹",
                    "좋아요 수 기준으로 인기 있는 코디를 모아 보여주는 페이지",
                    "/ranking.html",
                    List.of("인기", "랭킹", "좋아요", "베스트 코디")
            ),

            // ===== 로그인/회원 =====
            new com.example.closetory.search.SearchItem(
                    "login",
                    "로그인",
                    "계정",
                    "Closetory 계정으로 로그인하는 페이지",
                    "/login.html",
                    List.of("로그인", "계정", "회원", "접속")
            ),
            new com.example.closetory.search.SearchItem(
                    "signup",
                    "회원가입",
                    "계정",
                    "이메일/비밀번호로 새로운 계정을 만드는 페이지",
                    "/signup.html",
                    List.of("회원가입", "계정 생성", "가입")
            ),
            new com.example.closetory.search.SearchItem(
                    "mypage",
                    "마이페이지",
                    "계정",
                    "내 정보, 보유 옷, 즐겨찾기 코디를 확인하는 마이페이지",
                    "/mypage.html",
                    List.of("마이페이지", "내 정보", "즐겨찾기", "프로필")
            )
    );

    // 외부 API가 아니라 우리 서버 안에서 고정 데이터만 내려줌
    @GetMapping("/api/search-data")
    public List<com.example.closetory.search.SearchItem> getAll() {
        return items;
    }
}
