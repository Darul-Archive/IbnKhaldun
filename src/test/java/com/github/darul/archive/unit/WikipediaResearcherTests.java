package com.github.darul.archive.unit;

import com.github.darul.archive.researchers.wikipedia.WikipediaResearcher;
import org.junit.After;
import org.junit.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.github.darul.archive.TestData.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SuppressWarnings("unchecked")
public class WikipediaResearcherTests {

    private final HttpClient client = mock(HttpClient.class);

    @SuppressWarnings("rawtypes")
    private final HttpResponse response = mock(HttpResponse.class);

    @After
    public void resetData() {
        reset(client, response);
    }

    @Test
    public void givenUnintelligibleSearchParams_whenResearchRequested_thenExpectNoResults() throws Exception {
        when(response.body()).thenReturn(EMPTY_WIKIPEDIA_RESPONSE);
        when(client.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class))).thenReturn(response);

        var researcher = new WikipediaResearcher(client);
        var result = researcher.findData("asdlfjilu");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void givenReasonableSearchTerms_whenResearchRequested_thenExpectOneResult() throws Exception {
        var testUri = new URI(IBN_KHALDUN_REQUEST_URL);
        var testRequest = HttpRequest.newBuilder(testUri).build();

        when(response.body()).thenReturn(IBN_KHALDUN_RAW_RESPONSE);
        when(client.send(eq(testRequest), any(HttpResponse.BodyHandler.class))).thenReturn(response);

        var researcher = new WikipediaResearcher(client);
        var result = researcher.findData("Ibn Khaldun");
        assertNotNull(result);
        assertEquals(1, result.size());

        var resultDetails = result.get("199169");
        assertNotNull(resultDetails);
        assertEquals(IBN_KHALDUN_PAGE_INFO.get(), resultDetails);
    }

    // Response with multiple results
    @Test
    public void givenPartialSearchTerms_whenResearchRequested_thenExpectThreeResults() throws Exception {
        when(response.body()).thenReturn(IBN_KHALDUN_RAW_RESPONSE);
        when(client.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class))).thenReturn(response);

        var researcher = new WikipediaResearcher(client);
        var result = researcher.findData("Ibn");
        assertNotNull(result);
        assertEquals(3, result.size());

        var resultDetails = result.get("199169");
        assertNotNull(resultDetails);
        assertEquals(IBN_KHALDUN_PAGE_INFO.get(), resultDetails);
    }
}
