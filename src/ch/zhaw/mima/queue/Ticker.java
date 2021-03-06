package ch.zhaw.mima.queue;

import java.util.ArrayList;
import java.util.List;

public class Ticker extends Thread {

	private static final int TICK_TIME = 1000;
	private List<Tickable> tickables;

	public Ticker() {
		tickables = new ArrayList<Tickable>();
	}

	public void addTickable(Tickable tickable) {
		tickables.add(tickable);
	}

	@Override
	public void run() {
		while (true) {
			tick();
			try {
				Thread.sleep(TICK_TIME);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

	private void tick() {
		//System.out.println("tick: " + new Date().toString());
		for (Tickable tickable : tickables)
			tickable.onTick();
	}

}
