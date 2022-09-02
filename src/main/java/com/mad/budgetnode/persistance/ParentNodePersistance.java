package com.mad.budgetnode.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mad.budgetnode.business.ParentNode;

public interface ParentNodePersistance extends JpaRepository<ParentNode, Long> {
    
}
