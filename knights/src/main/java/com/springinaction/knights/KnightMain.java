package com.springinaction.knights;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightMain {
  public static void main(String[] args) {
    ApplicationContext context = 
        new ClassPathXmlApplicationContext("knights-aop.xml"); //<co id="co_loadKnightContext"/>
    
    Knight knight = (Knight) context.getBean("knight"); //<co id="co_getBeanKnight"/>    
    knight.embarkOnQuest();//<co id="co_useKnight"/>
    
    
    Knight knight1 = (Knight) context.getBean("knight1"); //<co id="co_getBeanKnight"/>
    knight1.embarkOnQuest();
    
    knight1.setQuest((Quest) context.getBean("quest"));
    knight1.embarkOnQuest();
    
    
    //System.out.println("Quest: " + knight1.getContQuest());
  }
}
