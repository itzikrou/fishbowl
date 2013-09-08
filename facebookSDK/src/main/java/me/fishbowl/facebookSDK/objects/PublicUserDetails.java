package me.fishbowl.facebookSDK.objects;

public class PublicUserDetails {
	private String uid;
	private String name;
	private String first_name;
	private String middle_name;
	private String last_name;
	private String sex;
	private String locale;
	private String pic_small;
	private String pic_big;
	private String pic_square;
	private String pic;
	private String username;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getPic_small() {
		return pic_small;
	}

	public void setPic_small(String pic_small) {
		this.pic_small = pic_small;
	}

	public String getPic_big() {
		return pic_big;
	}

	public void setPic_big(String pic_big) {
		this.pic_big = pic_big;
	}

	public String getPic_square() {
		return pic_square;
	}

	public void setPic_square(String pic_square) {
		this.pic_square = pic_square;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "PublicUserDetails [uid=" + uid + ", name=" + name
				+ ", first_name=" + first_name + ", middle_name=" + middle_name
				+ ", last_name=" + last_name + ", sex=" + sex + ", locale="
				+ locale + ", pic_small=" + pic_small + ", pic_big=" + pic_big
				+ ", pic_square=" + pic_square + ", pic=" + pic + ", username="
				+ username + ", getUid()=" + getUid() + ", getName()="
				+ getName() + ", getFirst_name()=" + getFirst_name()
				+ ", getMiddle_name()=" + getMiddle_name()
				+ ", getLast_name()=" + getLast_name() + ", getSex()="
				+ getSex() + ", getLocale()=" + getLocale()
				+ ", getPic_small()=" + getPic_small() + ", getPic_big()="
				+ getPic_big() + ", getPic_square()=" + getPic_square()
				+ ", getPic()=" + getPic() + ", getUsername()=" + getUsername()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
