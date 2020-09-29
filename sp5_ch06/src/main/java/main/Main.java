package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import config.AppCtx;
import spring.Client2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx =
				new AnnotationConfigApplicationContext(AppCtx.class);
		
		Client2 client2 = ctx.getBean(Client2.class);
		client2.send();
		
		Client2 client1 = ctx.getBean(Client2.class);
		client1.send();
		System.out.println("client1 == client2 : " + (client1 == client2 ));
		ctx.close();
	}

}
