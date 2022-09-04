package com.mad.budgetnode.business;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
public class ParentNode {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id; 
    @NonNull
    private String name;
    @NonNull
    private String color = "#CECECE";
    private float montant = 2000F; 
    @OneToMany(mappedBy="parentNode", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Node> children;  
    
}
