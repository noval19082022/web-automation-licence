package steps.pms.surveyTracker;

import com.microsoft.playwright.Page;
import config.playwright.context.ActiveContext;
import io.cucumber.java.en.And;
import pageobject.pms.surveyTracker.SurveyTrackerPO;
import pageobject.pms.tenantCommunication.TenantCommunicationPO;

public class SurveyTrackerSteps {
    Page page = ActiveContext.getActivePage();
    TenantCommunicationPO tenantCommunication = new TenantCommunicationPO(page);
    SurveyTrackerPO surveyTracker = new SurveyTrackerPO(page);

    @And("user choose {string} on filter Platform and {string} on filter status")
    public void userChooseOnFilterPlatformAndOnFilterStatus(String filterPlatform,String filterStatus) {
        surveyTracker.clickFilterPenyewa();
        surveyTracker.selectFilterTahapan(filterPlatform);
        surveyTracker.selectFilterStatus(filterStatus);
    }
}
