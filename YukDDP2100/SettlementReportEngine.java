package YukDDP2100;

import java.util.List;

// TOPICS COVERED: Interface Segregation Principle (ISP) //
public interface SettlementReportEngine {
    void generateAuditorSpreadsheet(List<DeliveryTransaction> dataset, String analyticsOutputPath);
}