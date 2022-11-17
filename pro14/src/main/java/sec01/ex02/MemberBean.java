package sec01.ex02;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberBean {
	
	private int mno;
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joinDate;
	
	private Address address;
	
	

}
