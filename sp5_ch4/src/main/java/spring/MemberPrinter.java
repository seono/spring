package spring;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

public class MemberPrinter {
	
	@Autowired
	@Nullable
	private DateTimeFormatter dateTimeFormatter;
	
	public MemberPrinter() {
		dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
	}
	
	public void print(Member member) {
		if(dateTimeFormatter == null) {
			System.out.printf(
					"회원정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n",
					member.getId(), member.getEmail(),
					member.getName(), member.getRegisterDateTime());
		}else {
		System.out.printf(
				"회원정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%s\n",
				member.getId(), member.getEmail(),
				member.getName(),
				dateTimeFormatter.format(member.getRegisterDateTime()));
		}
	}
	//Autowired 애노테이션은 기본적으로 빈이 존재하지 않으면 익셉션 발생, print 메서드에서 필수가 아니므로 required = false
//	@Autowired(required = false)
//	public void setDateFormatter(DateTimeFormatter dateTimeFormatter) {
//		this.dateTimeFormatter = dateTimeFormatter;
//	Optional<T>owired

//	@Autowired
//	public void setDateFormatter(Optional<DateTimeFormatter> formatterOpt) {
//		if(formatterOpt.isPresent()) {
//			this.dateTimeFormatter = formatterOpt.get();
//		}else {
//			this.dateTimeFormatter = null;
//		}
//	}
	
	@Autowired
	public void setDateFormatter(@Nullable DateTimeFormatter dateTimeFormatter) {
		this.dateTimeFormatter = dateTimeFormatter;
	}
}
