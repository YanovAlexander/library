package com.library.service;

import com.library.dto.JournalDTO;
import com.library.model.entity.JournalDAO;
import com.library.model.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JournalService {

    private final JournalRepository repository;
    private final JournalConverter journalConverter;

    @Autowired
    public JournalService(JournalRepository repository, JournalConverter journalConverter) {
        this.repository = repository;
        this.journalConverter = journalConverter;
    }

    public List<JournalDTO> findAll() {
        List<JournalDAO> journalDAOList = repository.findAll();
        return  journalDAOList.stream()
                .map(journalConverter::fromJournalDAO)
                .collect(Collectors.toList());
    }
}
