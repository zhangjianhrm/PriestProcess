package com.lenovo.lps.farseer.priest2.platform.entity;

import java.util.Map;

public class DataTransforEntity {

	private Save save;

	static class Save {
		private States states;

		static class States {
			private Map<String, Rect> rect;

			static class Rect {
				private String type;
				private String text;

				static class Attr {
					private String x;
					private String y;
					private String width;
					private String height;

					public String getX() {
						return x;
					}

					public void setX(String x) {
						this.x = x;
					}

					public String getY() {
						return y;
					}

					public void setY(String y) {
						this.y = y;
					}

					public String getWidth() {
						return width;
					}

					public void setWidth(String width) {
						this.width = width;
					}

					public String getHeight() {
						return height;
					}

					public void setHeight(String height) {
						this.height = height;
					}
				}

				private Map<String, String> props;

				public String getType() {
					return type;
				}

				public void setType(String type) {
					this.type = type;
				}

				public String getText() {
					return text;
				}

				public void setText(String text) {
					this.text = text;
				}

				public void setProps(Map<String, String> props) {
					this.props = props;
				}

				public Map<String, String> getProps() {
					return props;
				}
			}

			public void setRect(Map<String, Rect> rect) {
				this.rect = rect;
			}

			public Map<String, Rect> getRect() {
				return rect;
			}
		}

		public void setStates(States states) {
			this.states = states;
		}

		public States getStates() {
			return states;
		}
	}

	public void setSave(Save save) {
		this.save = save;
	}

	public Save getSave() {
		return save;
	}
}
