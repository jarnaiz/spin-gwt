package com.banana.client.view.widget.components;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * Loading creado: http://fgnass.github.com/spin.js
 * 
 * @author Javier Arnáiz, javier[at]bananacampus.com
 * 
 */
public class SpinLoading {

	private JavaScriptObject spin;

	private IsWidget innerWidget;
	/**
	 * Constructor con parametros por defecto
	 * @see SpinOpts
	 */
	public SpinLoading() {
		this(new SpinOpts());
	}
	/**
	 * Construye un spin loading con las opciones especificadas por parametro
	 * @param opts {@link SpinOpts} opciones
	 */
	public SpinLoading(SpinOpts opts) {

		spin = _init(opts.getLine(), opts.getLength(), opts.getWidth(),
				opts.getRadius(), opts.getRotate(), opts.getColor(),
				opts.getSpeed(), opts.getTrail(), opts.isShadow(),
				opts.isHwaccel(), opts.getClassName(), opts.getzIndex(),
				opts.getTop(), opts.getLeft());
	}

	/**
	 * Añade el cargando al widget pasado por parametros y lo añade al dom
	 * @param widget IsWidget
	 */
	public <T extends IsWidget & HasWidgets> IsWidget spin(T widget) {
		// llamamos al método spin para el widget asociado
		_spin(widget.asWidget().getElement());
		// devolvemos un widget
		Element element = Element.as(getInnerElement());
		innerWidget = new FocusWidget(element) {
		};
	
		widget.add(innerWidget.asWidget());
		
		return innerWidget;
	}

	/**
	 * Para el spin y lo elimina.
	 */
	public void stop() {
		if (innerWidget != null) {
			innerWidget.asWidget().removeFromParent();
		}
		_stop();
	}

	private native void _spin(JavaScriptObject element)/*-{
		var spinner = this.@com.banana.client.view.widget.components.SpinLoading::spin;
		spinner.spin(element);
	}-*/;

	private native void _stop()/*-{
		var spinner = this.@com.banana.client.view.widget.components.SpinLoading::spin;
		spinner.stop();
	}-*/;

	private native JavaScriptObject getInnerElement()/*-{
		var spinner = this.@com.banana.client.view.widget.components.SpinLoading::spin;
		return spinner.el;
	}-*/;

	private native JavaScriptObject _init(int lines, int length, int width,
			int radius, int rotate, String color, double speed, double trail,
			boolean shadow, boolean hwaccel, String className, double zIndex,
			String top, String left) /*-{

		return new $wnd.Spinner({
			lines : lines,
			length : length,
			width : width,
			radius : radius,
			rotate : rotate,
			color : color,
			speed : speed,
			trail : trail,
			shadow : shadow,
			hwaccel : hwaccel,
			className : className,
			zIndex : zIndex,
			top : top,
			left : left
		});
	}-*/;

	/**
	 * Opciones que puede tener el spin loading
	 * @author Javier Arnáiz, javier[at]bananacampus.com
	 * 
	 */
	public static class SpinOpts {
		private int line, length, width, radius, rotate;

		private String color, className, top, left;

		private double zIndex, speed, trail;

		private boolean shadow, hwaccel;
		
		public SpinOpts() {
			this(13, 7, 4, 10, 0, "#ffffff", "spinner", "auto", "auto", 1000, 1,
					100, true, false);
		}

		public SpinOpts(int line, int length, int width, int radius,
				int rotate, String color, String className, String top,
				String left, double zIndex, double speed, double trail,
				boolean shadow, boolean hwaccel) {
			this.line = line;
			this.length = length;
			this.width = width;
			this.radius = radius;
			this.rotate = rotate;
			this.zIndex = zIndex;
			this.color = color;
			this.className = className;
			this.top = top;
			this.left = left;
			this.speed = speed;
			this.trail = trail;
			this.shadow = shadow;
			this.hwaccel = hwaccel;
		}

		public int getLine() {
			return line;
		}

		public void setLine(int line) {
			this.line = line;
		}

		public int getLength() {
			return length;
		}

		public void setLength(int length) {
			this.length = length;
		}

		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public int getRadius() {
			return radius;
		}

		public void setRadius(int radius) {
			this.radius = radius;
		}

		public int getRotate() {
			return rotate;
		}

		public void setRotate(int rotate) {
			this.rotate = rotate;
		}

		public double getzIndex() {
			return zIndex;
		}

		public void setzIndex(int zIndex) {
			this.zIndex = zIndex;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String getClassName() {
			return className;
		}

		public void setClassName(String className) {
			this.className = className;
		}

		public String getTop() {
			return top;
		}

		public void setTop(String top) {
			this.top = top;
		}

		public String getLeft() {
			return left;
		}

		public void setLeft(String left) {
			this.left = left;
		}

		public double getSpeed() {
			return speed;
		}

		public void setSpeed(double speed) {
			this.speed = speed;
		}

		public double getTrail() {
			return trail;
		}

		public void setTrail(double trail) {
			this.trail = trail;
		}

		public boolean isShadow() {
			return shadow;
		}

		public void setShadow(boolean shadow) {
			this.shadow = shadow;
		}

		public boolean isHwaccel() {
			return hwaccel;
		}

		public void setHwaccel(boolean hwaccel) {
			this.hwaccel = hwaccel;
		}
	}
}