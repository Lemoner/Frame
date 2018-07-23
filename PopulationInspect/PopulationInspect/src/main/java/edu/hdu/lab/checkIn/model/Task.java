package edu.hdu.lab.checkIn.model;

public class Task {
	private int taskId;					//任务编号
	private String policeId;			//警员id
	private String policeName;			//警员姓名
	private double longitude;			//经度
	private double latitude;			//纬度
	private String deadLine;			//截止日期
	private String community;			//社区名
	private String room;				//房间名
	private String type;				//任务类型
	private String content;				//任务内容
	private int state;					//完成状态
	
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getPoliceId() {
		return policeId;
	}
	public void setPoliceId(String policeId) {
		this.policeId = policeId;
	}
	public String getPoliceName() {
		return policeName;
	}
	public void setPoliceName(String policeName) {
		this.policeName = policeName;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public String getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(String deadLine) {
		this.deadLine = deadLine;
	}
	public String getCommunity() {
		return community;
	}
	public void setCommunity(String community) {
		this.community = community;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Task(int taskId, String policeId, String policeName, double longitude, double latitude,
			String deadLine, String community, String room, String type,
			String content, int state) {
		super();
		this.taskId = taskId;
		this.policeId = policeId;
		this.policeName = policeName;
		this.longitude = longitude;
		this.latitude = latitude;
		this.deadLine = deadLine;
		this.community = community;
		this.room = room;
		this.type = type;
		this.content = content;
		this.state = state;
	}
	public Task() {

	}
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", policeId=" + policeId
				+ ", policeName=" + policeName
				+ ", longitude=" + longitude + ", latitude=" + latitude
				+ ", deadLine=" + deadLine + ", community=" + community
				+ ", room=" + room + ", type=" + type + ", content=" + content
				+ ", state=" + state + "]";
	}
}
