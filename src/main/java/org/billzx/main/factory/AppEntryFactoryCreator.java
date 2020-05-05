package org.billzx.main.factory;

/**
 * AppEntryFactory creator
 *
 * @project: CreateSymbolicLink
 * @author: Bill Zhang
 * @create: 2020-05-05 02:50
 */
public class AppEntryFactoryCreator {

	/**
	 * 创建对应的AppEntry工厂
	 *
	 * @return AppEntry工厂
	 */
	public static AppEntryAbstractFactory createAppEntryFactory(AppEntryFactoryType factoryType) {
		switch (factoryType) {
			case DEFAULT:
				return new AppEntryDefaultFactory();
			default:
				return null;
		}
	}
}
