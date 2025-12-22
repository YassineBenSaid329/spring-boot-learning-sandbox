package org.bootcamp.spring_boot_learning_sandbox.phase1.finalboss;

public class ReportOptions {
    private String adminName;
    private String format; // "PDF" or "EXCEL"
    private boolean includeSensitiveData;

    // GETTERS AND SETTERS ARE MANDATORY FOR JACKSON
    // (Generate them using Alt+Insert or right-click -> Generate)
    public String getAdminName() { return adminName; }
    public void setAdminName(String adminName) { this.adminName = adminName; }

    public String getFormat() { return format; }
    public void setFormat(String format) { this.format = format; }

    public boolean isIncludeSensitiveData() { return includeSensitiveData; }
    public void setIncludeSensitiveData(boolean includeSensitiveData) { this.includeSensitiveData = includeSensitiveData; }
}