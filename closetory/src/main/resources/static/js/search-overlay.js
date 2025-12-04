// src/main/resources/static/js/search-overlay.js

document.addEventListener("DOMContentLoaded", () => {
  console.log("CLO search script loaded");

  let CLO_SEARCH_INDEX = [];
  let cloSearchLoaded = false;

  // --- 검색 데이터 가져오기 ---
  async function cloLoadSearchIndex() {
    if (cloSearchLoaded) return;
    try {
      const res = await fetch("/api/search-data");
      if (!res.ok) throw new Error("search-data api error");
      CLO_SEARCH_INDEX = await res.json();
      cloSearchLoaded = true;
      console.log("CLO search data loaded:", CLO_SEARCH_INDEX.length);
    } catch (err) {
      console.error("검색 데이터 로딩 실패:", err);
    }
  }

  // --- 필터 ---
  function cloFilterIndex(query) {
    const q = query.trim().toLowerCase();
    if (!q) return [];

    return CLO_SEARCH_INDEX.filter((item) => {
      const text =
        (item.title || "") +
        " " +
        (item.category || "") +
        " " +
        (item.description || "") +
        " " +
        (item.keywords || []).join(" ");

      return text.toLowerCase().includes(q);
    });
  }

  // --- DOM 요소 찾기 ---
  const overlayEl = document.getElementById("cloSearchOverlay");
  const fieldEl   = document.getElementById("cloSearchField");
  const resultEl  = document.getElementById("cloSearchResult");
  const closeBtn  = document.getElementById("cloSearchClose");
  const openBtn   = document.getElementById("cloSearchOpenBtn");
  const headerSearchInput = document.getElementById("headerSearchInput");

  if (!overlayEl || !fieldEl || !resultEl) {
    console.warn("CLO search overlay elements not found");
    return;
  }

  // --- 오버레이 열기/닫기 ---
  async function openSearchOverlay() {
    await cloLoadSearchIndex();
    overlayEl.style.display = "flex";
    document.body.style.overflow = "hidden";
    fieldEl.value = "";
    renderEmpty();
    fieldEl.focus();
  }

  function closeSearchOverlay() {
    overlayEl.style.display = "none";
    document.body.style.overflow = "";
  }

  overlayEl.addEventListener("click", (e) => {
    if (e.target === overlayEl) closeSearchOverlay();
  });

  if (openBtn) {
    openBtn.addEventListener("click", openSearchOverlay);
  }
  if (headerSearchInput) {
    headerSearchInput.addEventListener("focus", openSearchOverlay);
    // 엔터 눌렀을 때도 열리게
    headerSearchInput.addEventListener("keydown", (e) => {
      if (e.key === "Enter") {
        e.preventDefault();
        openSearchOverlay();
        fieldEl.value = headerSearchInput.value;
        const results = cloFilterIndex(fieldEl.value);
        renderResults(results, fieldEl.value);
      }
    });
  }

  if (closeBtn) {
    closeBtn.addEventListener("click", closeSearchOverlay);
  }

  document.addEventListener("keydown", (e) => {
    if (e.key === "Escape" && overlayEl.style.display === "flex") {
      closeSearchOverlay();
    }
  });

  // --- 검색 입력 ---
  fieldEl.addEventListener("input", () => {
    const q = fieldEl.value;
    const results = cloFilterIndex(q);
    renderResults(results, q);
  });

  function renderEmpty() {
    resultEl.innerHTML =
      '<p class="clo-search-empty">검색어를 입력하면 결과가 여기에 나타납니다.</p>';
  }

  function renderResults(list, query) {
    const q = query.trim();
    if (!q) return renderEmpty();

    if (!list.length) {
      resultEl.innerHTML =
        '<p class="clo-search-empty">"' +
        q +
        '" 에 대한 결과가 없습니다.</p>';
      return;
    }

    const html = list
      .map(
        (item) => `
        <a href="${item.url}" class="clo-search-item">
          <div class="clo-search-item-title">${item.title}</div>
          <div class="clo-search-item-meta">${item.category}</div>
          <div class="clo-search-item-desc">${item.description}</div>
        </a>
      `
      )
      .join("");

    resultEl.innerHTML = html;
  }
});