package com.springinaction.knights;

import org.aspectj.lang.ProceedingJoinPoint;

public class Minstrel {
  public void singBeforeQuest() {     //<co id="co_singBefore"/>
    System.out.println("Fa la la; Toda historia comienza...");
  }
  
  public void singAroundQuest(ProceedingJoinPoint pjp) {     //<co id="co_singAfter"/>
	  
	  
	System.out.println("Me embarco en la aventura");
	
	Knight knight = (Knight) pjp.getTarget();
	knight.embarkOnQuest();
	  
    System.out.println("Aventura número: " + knight.getContQuest());
  }
  
  public void singAfterQuest() {     //<co id="co_singAfter"/>
	  
		  
	    System.out.println(
	            "Tee hee he; Te has embarcado en una nueva aventura!");
	  }
  
  
  /**
   * Ejecuta una excepción
   * @param dataAccessEx
   */
  public void doRecoveryActions(Exception dataAccessEx) {
	  	System.out.println(dataAccessEx.getMessage());  
  }
  
}
