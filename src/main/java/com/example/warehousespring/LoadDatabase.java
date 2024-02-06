package com.example.warehousespring;

import com.example.warehousespring.model.Contractor;
import com.example.warehousespring.model.ReceiptDocument;
import com.example.warehousespring.repository.ContractorRepository;
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
    CommandLineRunner initDatabase(ContractorRepository contractorRepository) {
        return args -> {
            Contractor contractor1 = new Contractor("symbol1", "name1");
            Contractor contractor2 = new Contractor("symbol2", "name2");
            log.info("Preloading " + contractorRepository.save(contractor1));
            log.info("Preloading " + contractorRepository.save(contractor2));
            ReceiptDocument receiptDocument1 = new ReceiptDocument("symbol1", contractor1, Collections.emptyList());
        };
    }
}