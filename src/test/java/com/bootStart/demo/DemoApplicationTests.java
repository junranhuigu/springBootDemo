package com.bootStart.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Mock
	private List<String> mocklist;
	
	@Test
	public void contextLoads() {
		Mockito.when(mocklist.get(Mockito.anyInt())).thenReturn("呱呱呱瓜~~");
		Mockito.when(mocklist.get(0)).thenReturn("Heloo WOrld");
		
		System.out.println(mocklist.get(0));
		System.out.println(mocklist.get(999));
		
		List<String> mocklist2 = Mockito.mock(ArrayList.class);
		mocklist2.add("one");
		mocklist2.add("two");
		//验证mocklist2是否做过相关操作
		Mockito.verify(mocklist2).add("one");
		
		//验证执行顺序
		InOrder inOrder = Mockito.inOrder(mocklist2);
		inOrder.verify(mocklist2).add("one");
		inOrder.verify(mocklist2).add("two");
		
		//验证某个交互是否从未被执行
		Mockito.verify(mocklist2, Mockito.never()).size();
		
		//验证超时
		Mockito.verify(mocklist2, Mockito.timeout(1000L)).add("two");
		
		
	}

}
