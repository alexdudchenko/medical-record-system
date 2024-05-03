package com.alex.dudchenko.access.management.service.controller;

import com.alex.dudchenko.access.management.service.model.AccessRequest;
import com.alex.dudchenko.access.management.service.service.AccessRequestService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accessRequests")
@AllArgsConstructor
public class AccessRequestController {

    private final AccessRequestService accessRequestService;

    @GetMapping("/{id}")
    public AccessRequest getAccessRequest(@PathVariable Long id) {
        return accessRequestService.getAccessRequestById(id);
    }

    @PostMapping
    public AccessRequest createAccessRequest(@RequestBody AccessRequest accessRequest) {
        return accessRequestService.save(accessRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteAccessRequest(@PathVariable Long id) {
        accessRequestService.deleteAccessRequestById(id);
    }
}
