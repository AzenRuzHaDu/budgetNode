package com.mad.budgetnode.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mad.budgetnode.business.Node;

public interface NodePersistance extends JpaRepository<Node, Long> {
    
}
