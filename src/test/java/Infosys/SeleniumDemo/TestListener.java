package Infosys.SeleniumDemo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseTest implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Testcase starts");
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Testcase success");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Testcase fails");
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Testcase skipped");
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Testcase failed but with success percentage");
	}
	@Override
	public void onStart(ITestContext context) {
		System.out.println("*********\nTests start");
	}
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Tests finish\n*********");
	}
}
