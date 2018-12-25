package com.ads.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/**
 * @NoArgsConstructor:生成一个无参数的构造方法
 * @RequiredArgsConstructor:该注解使用在类上,使用类中所有带有 @NonNull 注解的或者带有final修饰的成员变量生成对应的构造方法
 * @AllArgsContructor:会生成一个包含所有变量,同时如果变量使用了NotNull,会进行是否为空的校验
 * @Data:包含了 @ToString、@EqualsAndHashCode、@Getter、@Setter和@RequiredArgsConstructor的功能
 *
 */
// 对构造方法进行
@AllArgsConstructor(access = AccessLevel.PUBLIC)
// 生成toString()方法,默认情况下,它会按顺序（以逗号分隔）打印你的类名称以及每个字段。
@ToString(exclude = { "id" })
// 生成hashCode()和equals()方法
@EqualsAndHashCode(of = { "id" })
public class Person {

	@Getter(AccessLevel.PROTECTED)
	@Setter
	@NonNull
	private Integer id;

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private Integer age;
	
}
