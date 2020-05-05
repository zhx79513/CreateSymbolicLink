package org.billzx.main.factory;

import org.billzx.main.AppEntry;

/**
 * AppEntry abstract factory.
 *
 * @project: CreateSymbolicLink
 * @author: Bill Zhang
 * @create: 2020-05-05 02:03
 */
public abstract class AppEntryAbstractFactory {
	/**
	 * 返回AppEntry类对象
	 * @return
	 */
	public abstract AppEntry getAppEntry();
}
