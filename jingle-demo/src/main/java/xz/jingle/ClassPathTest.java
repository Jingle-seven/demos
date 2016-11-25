/**
 * Copyright 2015-2016 The OpenZipkin Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package xz.jingle;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;

import static java.lang.ClassLoader.getSystemResource;
import static java.lang.Thread.currentThread;

/**
 * Created by Jinhua on 2016/11/17.
 */
public class ClassPathTest {
	
	public static void main(String args[]){
		String s1 = new File("").getAbsolutePath();
		String s2 = ClassPathTest.class.getResource("/").getPath();//classpath根路径
		String s4 = ClassLoader.getSystemResource("").getPath();
		String s3 =ClassPathTest.class.getClass().getClassLoader().getResource("/").getPath();
		String s5 = Thread.currentThread().getContextClassLoader ().getResource("").getPath();
		Object.class.getResourceAsStream("/");
		String s6 = ClassPathTest.class.getClass().getResource("").getPath();//当前类路径
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s5);
		System.out.println(s6);
	}
}
