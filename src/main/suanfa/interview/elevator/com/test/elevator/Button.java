package suanfa.interview.elevator.com.test.elevator;

public class Button {

	private boolean upLightOn = false;
	private boolean downLightOn = false;
	private boolean innerLightOn = false;
	private Elevator ele;
	
	public Button(Elevator ele) {
		this.ele = ele;
	} 

	public void push(int floor, BtnDirec direct) throws Exception{
		if(this.ele == null || direct == null)throw new Exception("hehe~");
		switch (direct) {
		case UP:
			if(!this.isUpLightOn()){
				System.out.println(floor+" floor up light on");
				setUpLightOn(true);
				this.ele.addUpFloor(floor);
			}else if(this.isUpLightOn() || ele.getCurFloor() == floor){
				System.out.println(floor+" up push again!!");
			}
			break;
		case DOWN:	
			if(!this.isDownLightOn()){
				System.out.println(floor+" floor down light on");
				setDownLightOn(true);
				this.ele.addDownFloor(floor);
			}else if(this.isDownLightOn() || ele.getCurFloor() == floor){
				System.out.println(floor+" down push again!!");
			}
			break;

		default:
			break;
		}
	}
	
	public final Elevator getEle() {
		return ele;
	}

	public final void setEle(Elevator ele) {
		this.ele = ele;
	}

	public final boolean isUpLightOn() {
		return upLightOn;
	}

	public final void setUpLightOn(boolean upLightOn) {
		this.upLightOn = upLightOn;
	}

	public final boolean isDownLightOn() {
		return downLightOn;
	}

	public final void setDownLightOn(boolean downLightOn) {
		this.downLightOn = downLightOn;
	}

	public final boolean isInnerLightOn() {
		return innerLightOn;
	}

	public final void setInnerLightOn(boolean innerLightOn) {
		this.innerLightOn = innerLightOn;
	}


	enum BtnDirec{
		UP, DOWN
	}
	
}
