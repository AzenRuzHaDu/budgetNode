package com.mad.budgetnode.business;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
// @NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
public class Node extends ParentNode {


    private float percentage = 100.0F; 
    @NonNull
    @ManyToOne
    private ParentNode parentNode;
   
    public Node() {
    this.parentNode = new ParentNode();
        ammountSetter();
    } 

    // TODO: AvantProd : passer cette fonction dans la couche service, on le garde dans la 
    // classe métier pour le dev
    private void ammountSetter (){
        float montant = (this.getParentNode().getMontant() * this.getPercentage()) / 100.0F;
        this.setMontant(montant);
    } 
    
    
}
