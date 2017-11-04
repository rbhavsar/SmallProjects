package StockMockitoTest;

import Stock.Portfolio;
import Stock.Stock;
import Stock.StockService;
import org.junit.Assert;
import org.junit.Before;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PortfolioTester {

    Portfolio portfolio;
    StockService stockService;



    @BeforeTest
    public void setUp() {
        //PortfolioTester tester = new PortfolioTester();
        portfolio = new Portfolio();
        stockService = mock(StockService.class);
        portfolio.setStockService(stockService);
    }

    @Test
    public void testMarketTest() {
        List<Stock> stocks = new ArrayList<Stock>();
        Stock googleStock = new Stock("1", "Google", 10);
        Stock miscrosoftStock = new Stock("2", "Microsoft", 100);

        stocks.add(googleStock);
        stocks.add(miscrosoftStock);

        portfolio.setStocks(stocks);

        when(stockService.getPrice(googleStock)).thenReturn(50.00);
        when(stockService.getPrice(miscrosoftStock)).thenReturn(1000.00);

        double marketValue = portfolio.getMarketValue();

        // return marketValue == 100500.00;
        Assert.assertTrue("Not Expected ", marketValue == 100500.00);
    }
}
