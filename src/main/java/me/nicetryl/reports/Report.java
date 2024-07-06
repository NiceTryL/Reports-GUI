package me.nicetryl.reports;

import java.util.UUID;

public class Report {
    private final String reportReason;
    private final UUID reportUUID;
    private final String reportNameSt;
    private final String reporterNameSt;

    public Report(String reportReason, UUID reportUUID, String reportNameSt, String reporterNameSt) {
        this.reportReason = reportReason;
        this.reportUUID = reportUUID;
        this.reportNameSt = reportNameSt;
        this.reporterNameSt = reporterNameSt;
    }
    public String getReportReason() {
        return reportReason;
    }
    public String getReportNameSt() {
        return reportNameSt;
    }
    public UUID getReportUUID() {
        return reportUUID;
    }
    public String getReporterNameSt() {
        return reporterNameSt;
    }
}