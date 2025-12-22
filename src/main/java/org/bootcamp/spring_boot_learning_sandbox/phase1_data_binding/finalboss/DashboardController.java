package org.bootcamp.spring_boot_learning_sandbox.phase1_data_binding.finalboss;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phase1/dashboard")
public class DashboardController {

    @PostMapping("/reports/{departmentId}")
    public String generateReport(
            // 1. Path Variable: Which department?
            @PathVariable String departmentId,

            // 2. Query Param: Which year? (Default to current year if missing is optional, but let's keep it simple)
            @RequestParam int year,

            // 3. Request Body: Who is asking and how do they want it?
            @RequestBody ReportRequest request
    ) {
        // --- LOGIC SIMULATION ---

        // 1. Check format
        if (!request.getFormat().equals("PDF") && !request.getFormat().equals("EXCEL")) {
            return "Error: Unsupported format. Please choose PDF or EXCEL.";
        }

        // 2. Simulate complexity
        String sensitivity = request.isIncludeSensitiveData() ? "WITH sensitive data" : "WITHOUT sensitive data";

        // 3. Construct Response
        return String.format(
                "Generating %s report for department [%s] for year [%d]. Requested by Admin: %s (%s).",
                request.getFormat(),
                departmentId,
                year,
                request.getAdminName(),
                sensitivity
        );
    }
}