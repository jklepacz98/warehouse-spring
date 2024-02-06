package com.example.warehousespring;

import com.example.warehousespring.model.Contractor;
import com.example.warehousespring.model.DocumentItem;
import com.example.warehousespring.model.ReceiptDocument;
import com.example.warehousespring.repository.ContractorRepository;
import com.example.warehousespring.repository.DocumentItemReposiotory;
import com.example.warehousespring.repository.ReceiptDocumentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(
            ContractorRepository contractorRepository,
            ReceiptDocumentRepository receiptDocumentRepository,
            DocumentItemReposiotory documentItemReposiotory
    ) {
        return args -> {
            Contractor contractor1 = new Contractor("symbol1", "name1");
            Contractor contractor2 = new Contractor("symbol2", "name2");
            log.info("Preloading " + contractorRepository.save(contractor1));
            log.info("Preloading " + contractorRepository.save(contractor2));
            ReceiptDocument receiptDocument1 = new ReceiptDocument("symbol1", contractor1, Collections.emptyList());
            log.info("Preloading " + receiptDocumentRepository.save(receiptDocument1));
            DocumentItem documentItem1 = new DocumentItem("productName1", "kg", 100.0F, receiptDocument1);
            log.info("Preloading " + documentItemReposiotory.save(documentItem1));
        };
    }
}