package ch.zhaw.mima;

import java.util.ArrayList;
import java.util.List;

public class Ticker extends Thread {

	private static final int TICK_TIME = 1000;
	/**
   * @uml.property  name="tickables"
   * @uml.associationEnd  multiplicity="(0 -1)" elementType="ch.zhaw.mima.Tickable"
   */
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
		// System.out.println("tick");
		for (Tickable tickable : tickables)
			tickable.onTick();
	}

}
