package com.mad.budgetnode.initialisation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mad.budgetnode.business.Node;
import com.mad.budgetnode.business.ParentNode;
import com.mad.budgetnode.persistance.NodePersistance;
import com.mad.budgetnode.persistance.ParentNodePersistance;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor

public class AddInitialValues implements CommandLineRunner {

    private static final int COUNTER = 4;
    private final ParentNodePersistance parentNodePersistance;
    private final NodePersistance nodePersistance;

    @Override
    public void run(String... args) throws Exception {

        addParentNode();
        addNodes(); 
    }

    private void addParentNode() {

        if (parentNodePersistance.count() == 0) {

            for (int i = 0; i < COUNTER; i++) {
                ParentNode pn = new ParentNode();
                pn.setName("parentNode " + i);
                parentNodePersistance.save(pn);
            }

        }

    }

    private void addNodes() {
        
        if (nodePersistance.count() == 0) {
            float i = 100; 
            for (ParentNode pn : parentNodePersistance.findAll()){
                Node n = new Node(); 
                n.setParentNode(pn);
                n.setName("Node " + pn.getId());
                n.setPercentage(i);
                n.setMontant((n.getParentNode().getMontant() * n.getPercentage()) / 100);
                nodePersistance.save(n);
                i -= 20; 
            }

        }

        ParentNode pn = parentNodePersistance.findById(5L).orElse(null);  

        Node n = new Node();
        n.setName("test");
        n.setPercentage(5);
        n.setParentNode(pn);
        n.setMontant((n.getParentNode().getMontant() * n.getPercentage()) / 100);
        nodePersistance.save(n);
    }

}
