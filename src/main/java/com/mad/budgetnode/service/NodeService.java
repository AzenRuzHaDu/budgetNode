package com.mad.budgetnode.service;

import java.util.List;

import com.mad.budgetnode.business.Node;

public interface NodeService {
    
    public List<Node> getNodes();

    public Node addNode(Node node);

}
