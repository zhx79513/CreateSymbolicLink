package org.billzx.main;

import org.billzx.main.exception.AppEntryException;
import org.billzx.main.factory.AppEntryAbstractFactory;
import org.billzx.main.factory.AppEntryFactoryCreator;
import org.billzx.main.factory.AppEntryFactoryType;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Application entry
 *
 * @project: CreateSymbolicLink
 * @author: Bill Zhang
 * @create: 2020-05-05 01:16
 */
public class AppEntry {

	private String[] arguments = {};


	/**
	 * Main entry
	 *
	 * @param args Command line input arguments.
	 * @return 运行结果状态
	 */
	public static int main(String[] args) {
		AppEntryAbstractFactory factory = AppEntryFactoryCreator
				.createAppEntryFactory(AppEntryFactoryType.DEFAULT);
		AppEntry appEntry = factory.getAppEntry();
		appEntry.parseArgs(args);

		// For test
		System.out.println("Arguments count: " + appEntry.arguments.length);

		for (String arg : appEntry.arguments) {
			System.out.println(arg);
		}

		if (appEntry.arguments.length == 0) {
			System.out.println("No target. Drag and drop a file or files on this batch.");
			return 1;
		}

		return 0;
	}

	/**
	 * Exit procedure.
	 */
	public void exitProc(ExitCode exitCode) {
		// TODO:
	}


	protected void parseArgs(String[] args) {
		if (args == null) {
			arguments = new String[]{};
			return;
		}

		arguments = args;
	}

	/**
	 * 退出状态代码
	 */
	public enum ExitCode {
		/**
		 * 未知退出代码
		 */
		UNKNOWN("unknown", -1),
		/**
		 * 成功退出
		 */
		SUCCESS("success", 0),
		/**
		 * 无参数
		 */
		NO_ARGS("no arguments", 1);

		/**
		 * 退出代码名称
		 */
		private String name = "";
		/**
		 * 退出代码
		 */
		private int code = 0;

		/**
		 * 默认两参数构造函数
		 * @param name 退出代码名称
		 * @param code 退出代码
		 */
		ExitCode(String name, int code) {
			this.name = name;
			this.code = code;
		}

		/**
		 * 通过退出代码获取退出代码名称
		 * @param code 退出代码
		 * @return 退出代码对应的名称
		 * @throws AppEntryException.UnknownExitCodeException
		 */
		@Contract(pure = true)
		public static String getNameByCode(int code)
				throws AppEntryException.UnknownExitCodeException {
			for (ExitCode ec : ExitCode.values()
			) {
				if (ec.code == code) {
					return ec.name;
				}
			}
			// 抛出未知的Code异常
			throw new AppEntryException.UnknownExitCodeException("Unknown exit code: " + code);
		}

		/**
		 * 通过退出代码名称获取退出代码
		 * @param name 退出代码名称
		 * @return 退出代码
		 * @throws AppEntryException.UnknownExitCodeException
		 */
		@Contract(pure = true)
		public static int getCodeByName(String name)
				throws AppEntryException.UnknownExitCodeException {
			for (ExitCode ec : ExitCode.values()
			) {
				if (ec.name == name) {
					return ec.code;
				}
			}

			throw new AppEntryException.UnknownExitCodeException("Unknown exit code name: " + name);
		}

		/**
		 * 获取退出代码名称
		 * @return 退出代码名称
		 */
		@Contract(pure = true)
		public String getName() {
			return name;
		}

		/**
		 * 获取退出代码
		 * @return 退出代码
		 */
		@Contract(pure = true)
		public int getCode() {
			return code;
		}

		@Contract(pure = true)
		@Override
		public @NotNull String toString() {
			return "ExitCode{" +
					"name='" + name + '\'' +
					", code=" + code +
					'}';
		}
	}
}


