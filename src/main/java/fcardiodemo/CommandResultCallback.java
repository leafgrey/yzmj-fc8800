package fcardiodemo;

import Net.PC15.Command.INCommandResult;
/**
 * @author zch
 * @ClassName: CommandResultCallback
 * @Description: TODO
 * @Date: 2019/9/12
 * @version : V1.0
 */
public interface CommandResultCallback {
	/**
	 * 日志
	 * @param strBuf strBuf
	 * @param result result
	 */
	void resultToLog(StringBuilder strBuf, INCommandResult result);
}