package guo.db;

import guo.db.util.DateUtil;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * OracleSQLStatement.java
 * @Author:¹ùÉÐ²¨
 * @Email:gsb7814@126.com
 * Nov 30, 2007 11:35:37 PM
 */
public class OracleSQLStatement extends SQLStatement {

	public OracleSQLStatement() {
	}

	public OracleSQLStatement(String strTemplate) {
		super(strTemplate);
	}

	public void setDateTime(int idx, Calendar value) {
		if (idx > paramCnt || idx <= 0 || paramCnt <= 0)
			return;
		String dateTimeStr = null;
		if (value != null) {
			dateTimeStr = DateUtil.getDateTimeInString(value);
			setStringNoQuote(idx, (new StringBuilder())
					.append("TO_TIMESTAMP('").append(dateTimeStr).append(
							"','yyyy-mm-dd HH24:MI:SS')").toString());
		} else {
			setString(idx, null);
		}
	}

	public void setDateTime(int idx, Date value) {
		if (idx > paramCnt || idx <= 0 || paramCnt <= 0)
			return;
		if (value != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(value);
			setDateTime(idx, cal);
		} else {
			setDateTime(idx, (Calendar) null);
		}
	}
}
