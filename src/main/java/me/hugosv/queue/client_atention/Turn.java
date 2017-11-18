package me.hugosv.queue.client_atention;


public class Turn {
	private String name;
	private int waitingTime;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getWaitingTime() {
		return waitingTime;
	}
	
	public void setWaitingTime(int waitingTime) {
		this.waitingTime = waitingTime;
	}

	@Override
	public String toString() {
		return "Turn [name=" + name + ", waitingTime=" + waitingTime + "]";
	}
	
}
