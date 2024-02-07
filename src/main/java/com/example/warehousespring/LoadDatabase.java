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
            Contractor contractor1 = new Contractor("ASD/213", "John Smith");
            Contractor contractor2 = new Contractor("PWQ/4563", "Jan Kowalski");
            Contractor contractor3 = new Contractor("LDS/143", "Barbara Nowak");
            Contractor contractor4 = new Contractor("JGS/4583", "Małgorzata Bubel");
            Contractor contractor5 = new Contractor("EDC/453", "Bożydar Kowalski");
            log.info("Preloading " + contractorRepository.save(contractor1));
            log.info("Preloading " + contractorRepository.save(contractor2));
            log.info("Preloading " + contractorRepository.save(contractor3));
            log.info("Preloading " + contractorRepository.save(contractor4));
            log.info("Preloading " + contractorRepository.save(contractor5));
            ReceiptDocument receiptDocument1 = new ReceiptDocument("DSFF/1234/32153", contractor1, Collections.emptyList());
            ReceiptDocument receiptDocument2 = new ReceiptDocument("IFA/321/654", contractor1, Collections.emptyList());
            ReceiptDocument receiptDocument3 = new ReceiptDocument("FJKL/321/435", contractor1, Collections.emptyList());
            ReceiptDocument receiptDocument4 = new ReceiptDocument("JJKL/321/43", contractor1, Collections.emptyList());
            ReceiptDocument receiptDocument5 = new ReceiptDocument("SAJK/943/1", contractor2, Collections.emptyList());
            ReceiptDocument receiptDocument6 = new ReceiptDocument("LSDA/3214", contractor3, Collections.emptyList());
            log.info("Preloading " + receiptDocumentRepository.save(receiptDocument1));
            log.info("Preloading " + receiptDocumentRepository.save(receiptDocument2));
            log.info("Preloading " + receiptDocumentRepository.save(receiptDocument3));
            log.info("Preloading " + receiptDocumentRepository.save(receiptDocument4));
            log.info("Preloading " + receiptDocumentRepository.save(receiptDocument5));
            log.info("Preloading " + receiptDocumentRepository.save(receiptDocument6));
            DocumentItem documentItem1 = new DocumentItem("Butter", "g", 10.0F, receiptDocument1.getId());
            DocumentItem documentItem2 = new DocumentItem("Milk", "l", 1.0F, receiptDocument1.getId());
            DocumentItem documentItem3 = new DocumentItem("Eggs", "kg", 0.5F, receiptDocument1.getId());
            DocumentItem documentItem4 = new DocumentItem("Flour", "kg", 100.0F, receiptDocument1.getId());
            DocumentItem documentItem5 = new DocumentItem("Rice", "kg", 0.4F, receiptDocument1.getId());
            DocumentItem documentItem6 = new DocumentItem("water", "l", 5.0F, receiptDocument2.getId());
            log.info("Preloading " + documentItemReposiotory.save(documentItem1));
            log.info("Preloading " + documentItemReposiotory.save(documentItem2));
            log.info("Preloading " + documentItemReposiotory.save(documentItem3));
            log.info("Preloading " + documentItemReposiotory.save(documentItem4));
            log.info("Preloading " + documentItemReposiotory.save(documentItem5));
            log.info("Preloading " + documentItemReposiotory.save(documentItem6));
        };
    }
}