package com.mad.budgetnode.service.implt;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mad.budgetnode.business.Node;
import com.mad.budgetnode.persistance.NodePersistance;
import com.mad.budgetnode.service.NodeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NodeServiceImplt implements NodeService {

    private final NodePersistance nodePersistance;

    @Override
    public List<Node> getNodes() {
        return nodePersistance.findAll();
    }

    @Override
    public Node addNode(Node node) {

        nodePersistance.save(node);

        return node;

    }

}
