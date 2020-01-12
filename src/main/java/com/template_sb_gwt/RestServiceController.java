package com.template_sb_gwt;

import com.template_sb_gwt.database.HumanRepository;
import com.template_sb_gwt.ui.shared.entities.Human;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/rest")
public class RestServiceController {
    private final HumanRepository repository;

    public RestServiceController(HumanRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/peoples")
    public List<Human> getAll() {
        return repository.findAll();
    }

    @GetMapping("/human")
    public Human getHuman(@RequestParam(value = "id", required = true) Long id) {
        return repository.getOne(id);
    }
}
