package mowitnow;


public enum Orientation {

	N("North") {

		@Override
		public Orientation getFromDirection(boolean right) {
			return right ? Orientation.E: Orientation.W;
		}

		@Override
		public int getFollowingFrom(boolean isX) {
			return isX ? 0 : 1;
		}
	},
	E("East") {

		@Override
		public Orientation getFromDirection(boolean right) {
			return right ? Orientation.S: Orientation.N;
		}

		@Override
		public int getFollowingFrom(boolean isX) {
			return isX ? 1 : 0;
		}
	},
	W("West") {

		@Override
		public Orientation getFromDirection(boolean right) {
			return right ? Orientation.N: Orientation.S;
		}

		@Override
		public int getFollowingFrom(boolean isX) {
			return isX ? -1 : 0;
		}
	},
	S("South") {
		

		@Override
		public Orientation getFromDirection(boolean right) {
			return right ? Orientation.W: Orientation.E;
		}

		@Override
		public int getFollowingFrom(boolean isX) {
			return isX ? 0 : -1;
		}
	};
	private String caption;
	public abstract int getFollowingFrom(boolean isX);
	
	public int getFollowingX() {
		return getFollowingFrom(true);
	}

	public int getFollowingY() {
		return getFollowingFrom(false);
	}
	

	Orientation(String caption){
		setCaption(caption);
	}

	
	public Orientation getNext(){
		return getFromDirection(true);
	}
	public Orientation getPrevious(){
		return getFromDirection(false);
	}

	public abstract Orientation getFromDirection(boolean right);

	
	private void setCaption(String caption) {
		this.caption = caption;
	}

	public String getCaption() {
		return caption;
	}
	
	
}
