package conn.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardVO {
	 private int bno ;
	 private String title;
	 private String content;
	 private String writer;
	 private String imageFileName;
	 private Date writedate;
	 private int replyCount;
}
