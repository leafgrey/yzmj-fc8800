package fcardutils;
import Net.PC15.FC8800.Command.Card.*;
import Net.PC15.FC8800.Command.DateTime.ReadTime;
import Net.PC15.FC8800.Command.DateTime.WriteTime;
import Net.PC15.FC8800.Command.DateTime.WriteTimeBroadcast;
import Net.PC15.FC8800.Command.DateTime.WriteTimeDefine;
import Net.PC15.FC8800.Command.Door.*;
import Net.PC15.FC8800.Command.System.*;
import Net.PC15.FC8800.Command.Transaction.*;
import fcardiodemo.FormMain;
import org.apache.log4j.Logger;

import java.util.concurrent.ConcurrentHashMap;
/***
 * @class FormUtils
 * @description main窗口工具类
 * @author zch
 * @date 2019/9/10
 * @version V0.0.1.201909102004.01
 * @modfiyDate 201909102004
 * @createDate 201909102004
 * @package fcardutils
 */
public class FormUtils {
	private final static Object LOG_LOCK = new Object();
	private final static String NEXT_LINE = "\n";
	public static ConcurrentHashMap<String, String> CommandName = new ConcurrentHashMap<>();
	// 在txt窗口中添加日志
	public static void addTxtLog(String log) {
		synchronized (LOG_LOCK) {
			Logger.getRootLogger().info(log);
			log = StringUtil.getNowTimeFortest() + ":" + log + NEXT_LINE + FormMain.txtLog.getText();
			FormMain.txtLog.setText(log);
		}
	}
	public static void iniCommandName() {
		if (CommandName.size() > 0) {
			return;
		}
		CommandName.put(WriteSN.class.getName(), "写控制器SN");
		CommandName.put(WriteSN_Broadcast.class.getName(), "通过广播写SN");
		CommandName.put(ReadSN.class.getName(), "从控制器中读取SN");
		CommandName.put(WriteConnectPassword.class.getName(), "修改控制器通讯密码");
		CommandName.put(ReadConnectPassword.class.getName(), "从控制器中获取通讯密码");
		CommandName.put(ResetConnectPassword.class.getName(), "重置控制器通讯密码");
		CommandName.put(ReadTCPSetting.class.getName(), "读取控制器TCP网络参数");
		CommandName.put(WriteTCPSetting.class.getName(), "修改控制器TCP网络参数");
		CommandName.put(ReadDeadline.class.getName(), "读取控制器有效期剩余天数");
		CommandName.put(WriteDeadline.class.getName(), "写入控制器有效期");
		CommandName.put(ReadVersion.class.getName(), "获取控制器版本号");
		CommandName.put(ReadSystemStatus.class.getName(), "读取设备运行信息");
		CommandName.put(ReadAllSystemSetting.class.getName(), "获取所有系统参数");
		CommandName.put(ReadRecordMode.class.getName(), "读取记录存储方式");
		CommandName.put(WriteRecordMode.class.getName(), "写入记录存储方式");
		CommandName.put(ReadKeyboard.class.getName(), "读取读卡器密码键盘启用功能开关");
		CommandName.put(WriteKeyboard.class.getName(), "写入读卡器密码键盘启用功能开关");
		CommandName.put(ReadLockInteraction.class.getName(), "读取互锁功能开关");
		CommandName.put(WriteLockInteraction.class.getName(), "写入互锁功能开关");
		CommandName.put(ReadFireAlarmOption.class.getName(), "读取消防报警功能参数");
		CommandName.put(WriteFireAlarmOption.class.getName(), "写入消防报警功能参数");
		CommandName.put(ReadOpenAlarmOption.class.getName(), "读取匪警报警功能参数");
		CommandName.put(WriteOpenAlarmOption.class.getName(), "写入匪警报警功能参数");
		CommandName.put(ReadReaderIntervalTime.class.getName(), "读取读卡间隔时间参数");
		CommandName.put(WriteReaderIntervalTime.class.getName(), "写入读卡间隔时间参数");
		CommandName.put(ReadBroadcast.class.getName(), "读取语音段开关参数");
		CommandName.put(WriteBroadcast.class.getName(), "写入语音段开关参数");
		CommandName.put(ReadReaderCheckMode.class.getName(), "读取读卡器校验参数");
		CommandName.put(WriteReaderCheckMode.class.getName(), "写入读卡器校验参数");
		CommandName.put(ReadBuzzer.class.getName(), "读取主板蜂鸣器参数");
		CommandName.put(WriteBuzzer.class.getName(), "写入主板蜂鸣器参数");
		CommandName.put(ReadSmogAlarmOption.class.getName(), "读取烟雾报警功能参数");
		CommandName.put(WriteSmogAlarmOption.class.getName(), "写入烟雾报警功能参数");
		CommandName.put(ReadEnterDoorLimit.class.getName(), "读取门内人数上限参数");
		CommandName.put(WriteEnterDoorLimit.class.getName(), "写入门内人数上限参数");
		CommandName.put(ReadTheftAlarmSetting.class.getName(), "读取智能防盗主机参数");
		CommandName.put(WriteTheftAlarmSetting.class.getName(), "写入智能防盗主机参数");
		CommandName.put(ReadCheckInOut.class.getName(), "读取防潜回参数");
		CommandName.put(WriteCheckInOut.class.getName(), "写入防潜回参数");
		CommandName.put(ReadCardPeriodSpeak.class.getName(), "读取卡片到期提示参数");
		CommandName.put(WriteCardPeriodSpeak.class.getName(), "写入卡片到期提示参数");
		CommandName.put(ReadReadCardSpeak.class.getName(), "读取定时读卡播报语音参数");
		CommandName.put(WriteReadCardSpeak.class.getName(), "写入定时读卡播报语音参数");
		CommandName.put(BeginWatch.class.getName(), "开始数据监控");
		CommandName.put(BeginWatch_Broadcast.class.getName(), "广播开启监控");
		CommandName.put(CloseWatch.class.getName(), "关闭数据监控");
		CommandName.put(CloseWatch_Broadcast.class.getName(), "广播关闭监控");
		CommandName.put(SendFireAlarm.class.getName(), "通知设备触发消防报警");
		CommandName.put(CloseFireAlarm.class.getName(), "解除消防报警");
		CommandName.put(ReadFireAlarmState.class.getName(), "读取消防报警状态");
		CommandName.put(SendSmogAlarm.class.getName(), "通知设备触发烟雾报警");
		CommandName.put(CloseSmogAlarm.class.getName(), "解除烟雾报警");
		CommandName.put(ReadSmogAlarmState.class.getName(), "获取烟雾报警状态");
		CommandName.put(CloseAlarm.class.getName(), "解除报警");
		CommandName.put(ReadWorkStatus.class.getName(), "获取控制器各端口工作状态信息");
		CommandName.put(ReadTheftAlarmState.class.getName(), "获取防盗主机布防状态");
		CommandName.put(FormatController.class.getName(), "初始化控制器");
		CommandName.put(SearchEquptOnNetNum.class.getName(), "搜索控制器");
		CommandName.put(WriteEquptNetNum.class.getName(), "根据SN设置网络标记");
		CommandName.put(WriteKeepAliveInterval.class.getName(), "写入保活间隔时间");
		CommandName.put(ReadKeepAliveInterval.class.getName(), "读取保活间隔时间");
		CommandName.put(SetTheftDisarming.class.getName(), "防盗报警撤防");
		CommandName.put(SetTheftFortify.class.getName(), "防盗报警布防");
		CommandName.put(WriteBalcklistAlarmOption.class.getName(), "写入黑名单报警功能开关");
		CommandName.put(ReadBalcklistAlarmOption.class.getName(), "读取黑名单报警功能开关");
		CommandName.put(ReadExploreLockMode.class.getName(), "读取防探测功能开关");
		CommandName.put(WriteExploreLockMode.class.getName(), "写入防探测功能开关");
		CommandName.put(ReadCheck485Line.class.getName(), "读取485线路反接检测开关");
		CommandName.put(WriteCheck485Line.class.getName(), "写入485线路反接检测开关");
		CommandName.put(ReadCardDeadlineTipDay.class.getName(), "读取有效期即将过期提醒时间");
		CommandName.put(WriteCardDeadlineTipDay.class.getName(), "写入有效期即将过期提醒时间");
		CommandName.put(ReadTime.class.getName(), "从控制器中读取控制器时间");
		CommandName.put(WriteTime.class.getName(), "将电脑的最新时间写入到控制器中");
		CommandName.put(WriteTimeBroadcast.class.getName(), "校时广播");
		CommandName.put(WriteTimeDefine.class.getName(), "写入自定义时间到控制器");
		CommandName.put(WriteReaderOption.class.getName(), "写入控制器4个门的读卡器字节数");
		CommandName.put(ReadReaderOption.class.getName(), "读取控制器4个门的读卡器字节数");
		CommandName.put(ReadRelayOption.class.getName(), "读取控制器继电器参数");
		CommandName.put(WriteRelayOption.class.getName(), "写入控制器继电器参数");
		CommandName.put(OpenDoor.class.getName(), "远程开门指令");
		CommandName.put(CloseDoor.class.getName(), "远程关门指令");
		CommandName.put(HoldDoor.class.getName(), "远程保持门常开");
		CommandName.put(LockDoor.class.getName(), "远程锁定门");
		CommandName.put(UnlockDoor.class.getName(), "远程解除门锁定状态");
		CommandName.put(ReadReaderWorkSetting.class.getName(), "读取门的读卡器验证方式参数");
		CommandName.put(WriteReaderWorkSetting.class.getName(), "设置门的读卡器验证方式参数");
		CommandName.put(ReadDoorWorkSetting.class.getName(), "读取门的工作模式");
		CommandName.put(WriteDoorWorkSetting.class.getName(), "写入门的工作模式");
		CommandName.put(ReadAutoLockedSetting.class.getName(), "读取定时锁定门");
		CommandName.put(WriteAutoLockedSetting.class.getName(), "写入定时锁定门");
		CommandName.put(ReadRelayReleaseTime.class.getName(), "读取开门保持时间");
		CommandName.put(WriteRelayReleaseTime.class.getName(), "写入开门保持时间");
		CommandName.put(ReadReaderInterval.class.getName(), "读取重复读卡间隔");
		CommandName.put(WriteReaderInterval.class.getName(), "写入重复读卡间隔");
		CommandName.put(ReadInvalidCardAlarmOption.class.getName(), "读取未注册卡读卡时报警功能");
		CommandName.put(WriteInvalidCardAlarmOption.class.getName(), "写入未注册卡读卡时报警功能");
		CommandName.put(ReadAlarmPassword.class.getName(), "读取胁迫报警功能");
		CommandName.put(WriteAlarmPassword.class.getName(), "写入胁迫报警功能");
		CommandName.put(ReadAntiPassback.class.getName(), "读取防潜返");
		CommandName.put(WriteAntiPassback.class.getName(), "写入防潜返");
		CommandName.put(WriteOvertimeAlarmSetting.class.getName(), "写入开门超时报警功能");
		CommandName.put(ReadOvertimeAlarmSetting.class.getName(), "读取开门超时报警功能");
		CommandName.put(WritePushButtonSetting.class.getName(), "写入出门按钮功能");
		CommandName.put(ReadPushButtonSetting.class.getName(), "读取出门按钮功能");
		CommandName.put(ReadSensorAlarmSetting.class.getName(), "读取门磁报警功能");
		CommandName.put(WriteSensorAlarmSetting.class.getName(), "写入门磁报警功能");
		CommandName.put(ReadAnyCardSetting.class.getName(), "读取全卡开门功能");
		CommandName.put(WriteAnyCardSetting.class.getName(), "写入全卡开门功能");
		CommandName.put(ReadReadingBroadcast.class.getName(), "");
		CommandName.put(WriteReadingBroadcast.class.getName(), "");
		CommandName.put(ReadCardDatabaseDetail.class.getName(), "读取控制器中的卡片数据库信息");
		CommandName.put(ClearCardDataBase.class.getName(), "清空卡片数据库");
		CommandName.put(ReadCardDataBase.class.getName(), "从控制器中读取卡片数据");
		CommandName.put(ReadCardDetail.class.getName(), "读取单个卡片在控制器中的信息");
		CommandName.put(WriteCardListBySequence.class.getName(), "将卡片列表写入到控制器非排序区");
		CommandName.put(Net.PC15.FC89H.Command.Card.WriteCardListBySequence.class.getName(), "将卡片列表写入到控制器非排序区");
		CommandName.put(WriteCardListBySort.class.getName(), "将卡片列表写入到控制器排序区");
		CommandName.put(Net.PC15.FC89H.Command.Card.WriteCardListBySort.class.getName(), "将卡片列表写入到控制器排序区");
		CommandName.put(DeleteCard.class.getName(), "删除卡片");
		CommandName.put(Net.PC15.FC89H.Command.Card.DeleteCard.class.getName(), "删除卡片");
		CommandName.put(ReadTransactionDatabaseDetail.class.getName(), "读取控制器中的卡片数据库信息");
		CommandName.put(TransactionDatabaseEmpty.class.getName(), "清空所有类型的记录数据库");
		CommandName.put(ClearTransactionDatabase.class.getName(), "清空指定类型的记录数据库");
		CommandName.put(WriteTransactionDatabaseReadIndex.class.getName(), "修改指定记录数据库的读索引");
		CommandName.put(WriteTransactionDatabaseWriteIndex.class.getName(), "修改指定记录数据库的写索引");
		CommandName.put(ReadTransactionDatabaseByIndex.class.getName(), "读取记录");
		CommandName.put(ReadTransactionDatabase.class.getName(), "读取新记录");
		CommandName.put(Net.PC15.FC89H.Command.Transaction.ReadTransactionDatabaseByIndex.class.getName(), "读取记录");
		CommandName.put(Net.PC15.FC89H.Command.Transaction.ReadTransactionDatabase.class.getName(), "读取新记录");
	}
}