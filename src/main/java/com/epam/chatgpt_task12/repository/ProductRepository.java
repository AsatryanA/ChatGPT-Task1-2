package com.epam.chatgpt_task12.repository;

import com.epam.chatgpt_task12.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}