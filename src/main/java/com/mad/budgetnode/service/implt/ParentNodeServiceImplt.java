package com.mad.budgetnode.service.implt;

import java.util.List;

import org.aspectj.weaver.ast.Instanceof;
import org.springframework.stereotype.Service;

import com.mad.budgetnode.business.Node;
import com.mad.budgetnode.business.ParentNode;
import com.mad.budgetnode.persistance.NodePersistance;
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

    @Override
    public ParentNode getNodeById(Long nodeId) {

        return parentNodePersistance.findById(nodeId).orElse(null);
    }

    @Override
    public boolean deleteParentNode(Long id) {
        ParentNode pn = getNodeById(id);
        if (pn == null) {
            return false;
        }
        if (pn instanceof Node) {
            Node n = (Node) pn;
            n.getParentNode().getChildren().remove(n);
        }
        parentNodePersistance.delete(pn);
        return true;
    }

}
