package lombokTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor // 모든 필드를 가지는 생성자
@NoArgsConstructor // 기본생성자 
@EqualsAndHashCode

public class MemberDTO {
	private String id;
	private String name;
	private String password;
	private String email;
	
	public static void main(String[] args) {
		MemberDTO dto1 = new MemberDTO("aaa", "aaaa", "1234", "aaa@naver.com");
		MemberDTO dto2 = new MemberDTO("aaa", "aaaa", "1234", "aaa@naver.com");
		System.out.println(dto1.equals(dto2));
	}
}
