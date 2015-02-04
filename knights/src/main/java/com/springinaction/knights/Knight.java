package com.springinaction.knights;

public interface Knight {
  
	void embarkOnQuest() throws QuestException;
  
	void setQuest(Quest quest);
	
	int getContQuest();
	
	  
  
}
