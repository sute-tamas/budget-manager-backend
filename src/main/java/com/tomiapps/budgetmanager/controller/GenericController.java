package com.tomiapps.budgetmanager.controller;

import com.tomiapps.budgetmanager.service.GenericService;
import java.io.Serializable;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class GenericController <T extends Serializable, REQ, RESP, REPO extends JpaRepository<T, Long>, SER extends GenericService<T, REQ, RESP, REPO>> {

    @Getter(value = AccessLevel.PROTECTED)
    @Setter(value = AccessLevel.PROTECTED, onMethod = @__({@Autowired}))
    private SER service;

    @GetMapping(path = "")
    public List<RESP> find() {
        return service.find();
    }

    @GetMapping(path = "/{id}")
    public RESP find(@PathVariable Long id) {
        return service.find(id);
    }

    @PostMapping()
    public RESP save(@RequestBody REQ request) {
        return service.save(request);
    }

    @PutMapping(path = "{id}")
    public RESP update(@RequestBody REQ request, @PathVariable Long id) {
        return service.update(request, id);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}