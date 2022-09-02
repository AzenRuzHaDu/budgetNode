package com.mad.budgetnode.service.implt;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mad.budgetnode.business.ParentNode;
import com.mad.budgetnode.persistance.ParentNodePersistance;
import com.mad.budgetnode.service.ParentNodeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ParentNodeServiceImplt implements ParentNodeService {

private ParentNodePersistance parentNodePersistance; 

    @Override
    public List<ParentNode> getParentNodes() {
        return parentNodePersistance.findAll();
    }

    @Override
    public ParentNode addNode(ParentNode parentnode) {
        parentNodePersistance.save(parentnode); 
        return parentnode; 
    }
    
}
