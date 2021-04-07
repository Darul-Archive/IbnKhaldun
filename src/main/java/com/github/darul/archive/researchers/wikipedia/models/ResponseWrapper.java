package com.github.darul.archive.researchers.wikipedia.models;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;
import java.util.StringJoiner;

public class ResponseWrapper {
    @SerializedName("query")
    private final PageMap results;

    public ResponseWrapper(PageMap results) {
        this.results = results;
    }

    public PageMap getResults() {
        return results;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ResponseWrapper)) return false;
        ResponseWrapper that = (ResponseWrapper) obj;
        return Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "'" + ResponseWrapper.class.getSimpleName() + "': {", "}")
                .add("'query': '" + results + "'")
                .toString();
    }
}
