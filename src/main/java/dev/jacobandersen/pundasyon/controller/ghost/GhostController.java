package dev.jacobandersen.pundasyon.controller.ghost;

import dev.jacobandersen.pundasyon.obj.ghost.GhostInfo;
import dev.jacobandersen.pundasyon.svc.GhostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cms")
public class GhostController {
    private final GhostService service;

    @Autowired
    public GhostController(GhostService service) {
        this.service = service;
    }

    @GetMapping(value = "info", produces = MediaType.APPLICATION_JSON_VALUE)
    public GhostInfo info() {
        return service.getInfo();
    }
}
