package ch.zhaw.mima;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;

public abstract class BaseModule extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7313827698172638045L;
	/**
   * @uml.property  name="app"
   * @uml.associationEnd  multiplicity="(1 1)"
   */
	private App app;

	public BaseModule(App app) throws HeadlessException {
		super();
		this.app = app;
	}

	public BaseModule(App app, GraphicsConfiguration gc) {
		super(gc);

		this.app = app;
	}

	public BaseModule(App app, String title) throws HeadlessException {
		super(title);

		this.app = app;
	}

	public BaseModule(App app, String title, GraphicsConfiguration gc) {
		super(title, gc);

		this.app = app;
	}

	/**
   * @return
   * @uml.property  name="app"
   */
	public App getApp() {
		return app;
	}

}