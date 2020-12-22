package com.bsu.framework.test;

import com.bsu.framework.page.LandingPage;
import com.google.common.collect.Ordering;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SearchResultsTests extends CommonConditions {
    private final String SEARCH_QUERY = "blackpink the album";

    @Test
    public void searchResultsSortByNewestDateTest() {
        List<Date> actual = new LandingPage(driver)
                .openPage()
                .enterSearchRequest(SEARCH_QUERY)
                .search()
                .sortByNewest()
                .getResultItemsDates();
        assertThat(Ordering.natural().reverse().isOrdered(actual), is(true));
    }

    @Test
    public void searchResultsSortByBestSalesTest() {
        List<Integer> actual = new LandingPage(driver)
                .openPage()
                .enterSearchRequest(SEARCH_QUERY)
                .search()
                .sortByBestSales()
                .getResultItemsSales();
        assertThat(Ordering.natural().reverse().isOrdered(actual), is(true));
    }

    @Test
    public void searchResultsSortByNameUpTest() {
        List<String> actual = new LandingPage(driver)
                .openPage()
                .enterSearchRequest(SEARCH_QUERY)
                .search()
                .sortByNameUp()
                .getResultItemsNames();
        assertThat(Ordering.natural().isOrdered(actual), is(true));
    }

    @Test
    public void searchResultsSortByNameDownTest() {
        List<String> actual = new LandingPage(driver)
                .openPage()
                .enterSearchRequest(SEARCH_QUERY)
                .search()
                .sortByNameDown()
                .getResultItemsNames();
        assertThat(Ordering.natural().reverse().isOrdered(actual), is(true));
    }

    @Test
    public void searchResultsExcludeOutOfStockItems() {
        boolean isThereAnyOutOfStockItems = new LandingPage(driver)
                .openPage()
                .enterSearchRequest(SEARCH_QUERY)
                .search()
                .excludeOutOfStockItems()
                .anyOutOfStockInItems();
        assertThat(isThereAnyOutOfStockItems, is(false));
    }

}
