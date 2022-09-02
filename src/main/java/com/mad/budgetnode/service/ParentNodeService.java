package com.mad.budgetnode.service;

import java.util.List;

import com.mad.budgetnode.business.ParentNode;

public interface ParentNodeService {
    

    public List<ParentNode> getParentNodes();

    public ParentNode addNode(ParentNode parentnode);
}
