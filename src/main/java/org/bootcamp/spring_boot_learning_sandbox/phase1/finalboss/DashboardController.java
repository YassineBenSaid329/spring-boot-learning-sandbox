package org.bootcamp.spring_boot_learning_sandbox.phase1.finalboss;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phase1/dashboard")
public class DashboardController {
    @PostMapping("/reports/{departmentId}")
    public String generateReport(
            @PathVariable String departmentId,
            @RequestParam int year,
            @RequestBody ReportOptions options
    ) {
        return "Generating " + options.getFormat() +
                " report for: " + departmentId +
                " (Year: " + year + ")" +
                " requested by: " + options.getAdminName();
    }
}