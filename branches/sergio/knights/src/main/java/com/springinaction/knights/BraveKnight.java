package com.springinaction.knights;

public class BraveKnight implements Knight {
	private Quest quest;
	private int contQuest;

	public BraveKnight(Quest quest) {
		this.quest = quest;       //<co id="co_injectedQuest"/>
		this.contQuest = 0;
	}

	public void embarkOnQuest() throws QuestException {
		quest.embark();
		this.contQuest++;
	}

	public void setQuest(Quest quest) {
		this.quest = quest;

	}

	public int getContQuest() {
		// TODO Auto-generated method stub
		return this.contQuest;
	}
}
