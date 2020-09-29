package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import aspect.ExeTimeAspect;
import chap07.Calculator;
import chap07.RecCalculator;

//proxyTargetClass=true 이용시 Calculator 인터페이스를 상속받지 않고 RecCalculator를 직접 상속 받아 프록시 생성
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppCtx {
	@Bean
	public ExeTimeAspect exeTimeAspect() {
		return new ExeTimeAspect();
	}
	//AOP 적용시 RecCalculator가 상속받은 Calculator 인터페이스를 이용해서 프록시 생성
	@Bean
	public Calculator calculator() {
		return new RecCalculator();
	}
	//ctx.getBean("calculator",RecCalculator.class)부분에서 "calculator"빈의 실제 타입은 Calculator를 상속한 프록시 타입
	//RecCalculator로 타입 변환을 할 수 없기 때문에 익셉션 발생
	//RecCalculator cal = ctx.getBean("calculator", RecCalculator.class);
}
