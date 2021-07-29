package com.library.controller;

import com.library.dto.JournalDTO;
import com.library.service.JournalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping(path = "/journals")
public class JournalController {

    private static final Logger LOGGER = LoggerFactory.getLogger(JournalController.class);

    private final JournalService journalService;

    @Autowired
    public JournalController(JournalService journalService) {
        this.journalService = journalService;
    }

    @GetMapping
    public String showJournalsPage(Model model) {
        LOGGER.info("showJournalsPage");
        List<JournalDTO> journals = journalService.findAll();
        model.addAttribute("journals", journals);
        return "journals";
    }
}
