package com.library.service;

import com.library.dto.JournalDTO;
import com.library.model.entity.JournalDAO;
import org.springframework.stereotype.Component;

@Component
public class JournalConverter {
    public JournalDAO toJournalDAO (JournalDTO journalDTO) {
        return new JournalDAO(journalDTO.getId(), journalDTO.getName(), journalDTO.getCountPages(), journalDTO.getYear(),
                journalDTO.getDescription(), journalDTO.getJournalType(), journalDTO.getJournalNumber());
    }

    public JournalDTO fromJournalDAO (JournalDAO journalDAO) {
        return new JournalDTO(journalDAO.getId(), journalDAO.getName(), journalDAO.getCountPages(), journalDAO.getYear(),
                journalDAO.getDescription(), journalDAO.getJournalType(), journalDAO.getJournalNumber());
    }
}
