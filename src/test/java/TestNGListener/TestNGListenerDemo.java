package TestNGListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestNGListenerDemo extends TestListenerAdapter{
    @Override
    public void onTestStart(ITestResult result) {

        System.out.println("***onTestStart****"+result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println("***onTestSuccess****"+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("***onTestFailure****"+result.getName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {

        System.out.println("***onTestSkipped****"+result.getName());

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
