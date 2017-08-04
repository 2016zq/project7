package imooc;

import java.util.*;  

public class Player {  
    public int id;  
    public String name;  
    public Set<Cards> handcards;  
    public Player(int id, String name){  
        this.id = id;  
        this.name = name;  
        this.handcards = new HashSet<Cards>();  
    }  
}  