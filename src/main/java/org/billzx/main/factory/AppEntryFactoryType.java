package org.billzx.main.factory;

/**
 * @project: CreateSymbolicLink
 * @author: Bill Zhang
 * @create: 2020-05-05 02:56
 */
public enum AppEntryFactoryType {
	/**
	 * 默认构造工厂
	 */
	DEFAULT("Default");

	private final String thisFactoryType;

	AppEntryFactoryType(String factoryType) {
		thisFactoryType = factoryType;
	}

	/**
	 * 获取当前工厂类型
	 * @return 当前工厂类型字符串
	 */
	public String getFactoryType() {
		return thisFactoryType;
	}

	@Override
	public String toString() {
		return thisFactoryType;
	}
}
