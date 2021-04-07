package com.github.darul.archive.researchers.wikipedia.models;

import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

public class PageMap {
    private final Map<String, PageInfo> pages;

    public PageMap(Map<String, PageInfo> pages) {
        this.pages = pages;
    }

    public Map<String, PageInfo> getPages() {
        return pages;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PageMap)) return false;
        PageMap pageMap = (PageMap) obj;
        return Objects.equals(pages, pageMap.pages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pages);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "'" + PageMap.class.getSimpleName() + "': {", "}")
                .add("'pages': '" + pages + "'")
                .toString();
    }
}
