package com.github.darul.archive.researchers.wikipedia;

import com.github.darul.archive.researchers.wikipedia.models.PageInfo;
import com.github.darul.archive.researchers.wikipedia.models.ResponseWrapper;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;

public class WikipediaResearcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(WikipediaResearcher.class);

    private static final String BASE_URL =
            "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=info&generator=prefixsearch&inprop=url&gpssearch=%s";

    private final HttpClient client;

    public WikipediaResearcher(HttpClient client) {
        this.client = client;
    }

    public Map<String, PageInfo> findData(String searchQuery) throws IOException, InterruptedException {
        LOGGER.info("Retrieving Wikipedia data for {}", searchQuery);

        // TODO: Test this with other characters
        var sanitizedQuery = URLEncoder.encode(searchQuery, StandardCharsets.UTF_8);
        URI uri;

        try {
            uri = new URI(String.format(BASE_URL, sanitizedQuery));
        } catch (URISyntaxException ex) {
            LOGGER.error("Invalid search terms", ex);
            return Collections.emptyMap();
        }

        var request = HttpRequest.newBuilder(uri).build();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        LOGGER.debug("Received response: {}", response.body());

        // TODO: Could this be pulled into the abstract class with generics?
        var gson = new GsonBuilder().create();
        var queryResults = gson.fromJson(response.body(), ResponseWrapper.class);

        if (queryResults == null || queryResults.getResults() == null) return Collections.emptyMap();

        var pageMap = queryResults.getResults();

        var foundExactMatch = pageMap.getPages()
                .entrySet().stream()
                .filter(it -> it.getValue().getTitle().equalsIgnoreCase(searchQuery))
                .findAny();

        // TODO: Once the response structure has been worked out, map this
        if (foundExactMatch.isPresent()) {
            LOGGER.debug("Found exact match");
            var match = foundExactMatch.get();
            return Collections.singletonMap(match.getKey(), match.getValue());
        } else {
            LOGGER.warn("Exact match, not found. Responding with multiple.");
            return pageMap.getPages();
        }
    }
}
