package com.github.darul.archive.researchers.wikipedia.models;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;
import java.util.StringJoiner;

public class PageInfo {
    @SerializedName("pageid")
    private final long pageId;
    private final String title;
    @SerializedName("fullurl")
    private final String url;

    public PageInfo(long pageId, String title, String url) {
        this.pageId = pageId;
        this.title = title;
        this.url = url;
    }

    public long getPageId() {
        return pageId;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PageInfo)) return false;
        PageInfo pageInfo = (PageInfo) obj;
        return pageId == pageInfo.pageId
                && Objects.equals(title, pageInfo.title)
                && Objects.equals(url, pageInfo.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageId, title, url);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "'" + PageInfo.class.getSimpleName() + "': {", "}")
                .add("'pageId': '" + pageId + "'")
                .add("'title': '" + title + "'")
                .add("'url': '" + url + "'")
                .toString();
    }
}
