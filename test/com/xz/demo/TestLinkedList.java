package com.xz.demo;

import static org.junit.Assert.*;

import org.junit.Test;

import com.xz.demo.XzLinkedList;

public class TestLinkedList {

	@Test
	public void test() {
		XzLinkedList list = new XzLinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.reverse();
		list.display();
	}

}
