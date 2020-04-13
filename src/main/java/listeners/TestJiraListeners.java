//package listeners;
//
//import org.apache.commons.lang.exception.ExceptionUtils;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import util.JiraPolicy;
//import util.JiraServiceProvider;
//
//public class TestJiraListeners implements ITestListener{
//
//	@Override
//	public void onTestStart(ITestResult result) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onTestSuccess(ITestResult result) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onTestFailure(ITestResult result) {
//		// TODO Auto-generated method stub
//		JiraPolicy jiraPolicy = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraPolicy.class);
//		boolean isTicketReady = jiraPolicy.logTicketReady();
//		if(isTicketReady) { 
//			//raise JIRA Ticket
//			System.out.println("JIRA ticket is ready: " + isTicketReady);
//			
//			JiraServiceProvider jiraServProv = new JiraServiceProvider("https://anujam.atlassian.net/", "anujam.mondal@cerner.com", "asdfvcxz!@#4", "SBT");
//			String issueSummary = result.getMethod().getConstructorOrMethod().getMethod().getName() + "got failed due to some assertion or exception.";
//			String issueDescription = result.getThrowable().getMessage() + "\n";
//			issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));
//			
//			jiraServProv.createJiraTicket("Bug", issueSummary, issueDescription, "Anujam");
//			
//		}
//	}
//
//	@Override
//	public void onTestSkipped(ITestResult result) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onStart(ITestContext context) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onFinish(ITestContext context) {
//		// TODO Auto-generated method stub
//		
//	}
//
//}
