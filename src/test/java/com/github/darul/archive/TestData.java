package com.github.darul.archive;

import com.github.darul.archive.researchers.wikipedia.models.PageInfo;

import java.util.function.Supplier;

public class TestData {

    public static final String EMPTY_WIKIPEDIA_RESPONSE = "{\"batchcomplete\":\"\"}";

    public static final String IBN_KHALDUN_REQUEST_URL =
            "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=info&generator=prefixsearch&inprop=url&gpssearch=Ibn+Khaldun";
    public static final String IBN_KHALDUN_RAW_RESPONSE =
            "{\"batchcomplete\":\"\",\"query\":{\"pages\":{" +
                    "\"64321067\":{\"pageid\":64321067,\"ns\":0," +
                    "\"title\":\"Ibn Haldun University\",\"index\":4,\"contentmodel\":\"wikitext\"," +
                    "\"pagelanguage\":\"en\",\"pagelanguagehtmlcode\":\"en\",\"pagelanguagedir\":\"ltr\"," +
                    "\"touched\":\"2020-12-19T18:16:50Z\",\"lastrevid\":981800529,\"length\":39,\"redirect\":\"\"," +
                    "\"fullurl\":\"https://en.wikipedia.org/wiki/Ibn_Haldun_University\"," +
                    "\"editurl\":\"https://en.wikipedia.org/w/index.php?title=Ibn_Haldun_University&action=edit\"," +
                    "\"canonicalurl\":\"https://en.wikipedia.org/wiki/Ibn_Haldun_University\"}," +
                    "\"199169\":{\"pageid\":199169,\"ns\":0,\"title\":\"Ibn Khaldun\",\"index\":1," +
                    "\"contentmodel\":\"wikitext\",\"pagelanguage\":\"en\",\"pagelanguagehtmlcode\":\"en\"," +
                    "\"pagelanguagedir\":\"ltr\",\"touched\":\"2021-04-07T14:02:21Z\",\"lastrevid\":1016386294," +
                    "\"length\":64982,\"fullurl\":\"https://en.wikipedia.org/wiki/Ibn_Khaldun\"," +
                    "\"editurl\":\"https://en.wikipedia.org/w/index.php?title=Ibn_Khaldun&action=edit\"," +
                    "\"canonicalurl\":\"https://en.wikipedia.org/wiki/Ibn_Khaldun\"}," +
                    "\"49491326\":{\"pageid\":49491326,\"ns\":0,\"title\":\"Ibn Khaldun (horse)\",\"index\":2," +
                    "\"contentmodel\":\"wikitext\",\"pagelanguage\":\"en\",\"pagelanguagehtmlcode\":\"en\"," +
                    "\"pagelanguagedir\":\"ltr\",\"touched\":\"2021-04-02T20:11:43Z\",\"lastrevid\":983193826," +
                    "\"length\":10857,\"fullurl\":\"https://en.wikipedia.org/wiki/Ibn_Khaldun_(horse)\"," +
                    "\"editurl\":\"https://en.wikipedia.org/w/index.php?title=Ibn_Khaldun_(horse)&action=edit\"," +
                    "\"canonicalurl\":\"https://en.wikipedia.org/wiki/Ibn_Khaldun_(horse)\"}}}}";

    public static final Supplier<PageInfo> IBN_KHALDUN_PAGE_INFO =
            () -> new PageInfo(199169L, "Ibn Khaldun", "https://en.wikipedia.org/wiki/Ibn_Khaldun");

    private TestData() {
    }
}
