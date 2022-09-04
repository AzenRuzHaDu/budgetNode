package com.mad.budgetnode.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mad.budgetnode.business.Node;
import com.mad.budgetnode.business.ParentNode;
import com.mad.budgetnode.service.NodeService;
import com.mad.budgetnode.service.ParentNodeService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RequestMapping("/api/")
public class NodeRestController {

    private final ParentNodeService parentNodeService;
    private final NodeService nodeService;
    
    @GetMapping("Nodes")
    public List<ParentNode> getNodes() {

        List<ParentNode> result = new ArrayList<>();

        for (ParentNode n : parentNodeService.getParentNodes()){
            if (!(n instanceof Node)){
                result.add(n); 
            }
        }
        return result;
    }

}
