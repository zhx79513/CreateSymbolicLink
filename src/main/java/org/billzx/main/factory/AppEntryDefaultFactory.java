package org.billzx.main.factory;

import org.billzx.main.AppEntry;

/**
 * 默认实现，只创建一个AppEntry实例
 * @project: CreateSymbolicLink
 * @author: Bill Zhang
 * @create: 2020-05-05 02:06
 */
public class AppEntryDefaultFactory extends AppEntryAbstractFactory {

	protected AppEntry thisAppEntry = null;

	/**
	 * 返回AppEntry类对象
	 *
	 * @return
	 */
	@Override
	public AppEntry getAppEntry() {
		if (thisAppEntry == null) {
			thisAppEntry = new AppEntry();
		}

		return thisAppEntry;
	}
}
