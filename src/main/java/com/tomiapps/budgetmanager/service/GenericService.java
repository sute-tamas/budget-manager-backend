package com.tomiapps.budgetmanager.service;

import jakarta.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public abstract class GenericService<T extends Serializable, REQ, RESP, REPO extends JpaRepository<T, Long>> {

    @Getter
    @Setter(value = AccessLevel.PROTECTED, onMethod = @__({ @Autowired}))
    private REPO repository;

    @Transactional
    public List<RESP> find() {
        List<T> models = repository.findAll();
        List<RESP> responses = new ArrayList<>();
        for (T model: models) {
            responses.add(convertResponse(model));
        }
        return responses;
    }

    @Transactional
    public RESP find(Long id) {
        T model = repository.findById(id).orElse(null);
        return convertResponse(model);
    }

    @Transactional
    public RESP save(REQ request) {
        T model = repository.save(convertRequest(request));
        return convertResponse(model);
    }

    @Transactional
    public RESP update(REQ request, Long id) {
        T model = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Entity not found with id: " + id));
        T modelFromRequest = convertRequest(request);
        BeanUtils.copyProperties(modelFromRequest, model);
        return convertResponse(repository.save(model));
    }

    @Transactional
    public void delete(Long id) {
        T model = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Entity not found with id: " + id));
        repository.delete(model);
    }

    protected abstract RESP convertResponse(T model);

    protected abstract T convertRequest(REQ request);

}
