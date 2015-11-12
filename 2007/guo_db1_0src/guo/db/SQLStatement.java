package guo.db;

import guo.db.util.DateUtil;
import java.io.InputStream;
import java.sql.Blob;
import java.util.*;

/**
 * 
 * SQLStatement.java
 * @Author:¹ùÉÐ²¨
 * @Email:gsb7814@126.com
 * Nov 30, 2007 11:36:25 PM
 */
public class SQLStatement {

	public SQLStatement() {
		paramCnt = 0;
		hasBinaryData = false;
	}

	public SQLStatement(String strTemplate) {
		paramCnt = 0;
		hasBinaryData = false;
		setTemplate(strTemplate);
	}

	public String getTemplate() {
		return strTemplate;
	}

	@SuppressWarnings("unchecked")
	public void setTemplate(String strTemplate) {
		this.strTemplate = strTemplate;
		if (values != null) {
			values.clear();
			values = null;
		}
		if (strTemplate == null) {
			paramCnt = 0;
		} else {
			for (int from = 0; (from = strTemplate.indexOf('?', from)) >= 0; from++)
				paramCnt++;

			if (paramCnt > 0) {
				values = new ArrayList();
				for (int i = 0; i < paramCnt; i++)
					values.add(null);

			}
		}
	}

	public String toString() {
		return getSQLString();
	}

	@SuppressWarnings("unchecked")
	public void setInt(int idx, int value) {
		if (idx > paramCnt || idx <= 0 || paramCnt <= 0) {
			return;
		} else {
			values.set(idx - 1, new Integer(value));
			return;
		}
	}

	@SuppressWarnings("unchecked")
	public void setLong(int idx, long value) {
		if (idx > paramCnt || idx <= 0 || paramCnt <= 0) {
			return;
		} else {
			values.set(idx - 1, new Long(value));
			return;
		}
	}

	@SuppressWarnings("unchecked")
	public void setFloat(int idx, float value) {
		if (idx > paramCnt || idx <= 0 || paramCnt <= 0) {
			return;
		} else {
			values.set(idx - 1, new Float(value));
			return;
		}
	}

	@SuppressWarnings("unchecked")
	public void setDouble(int idx, double value) {
		if (idx > paramCnt || idx <= 0 || paramCnt <= 0) {
			return;
		} else {
			values.set(idx - 1, new Double(value));
			return;
		}
	}

	@SuppressWarnings("unchecked")
	public void setNumber(int idx, Number value) {
		if (idx > paramCnt || idx <= 0 || paramCnt <= 0) {
			return;
		} else {
			values.set(idx - 1, value);
			return;
		}
	}

	@SuppressWarnings("unchecked")
	public void setBoolean(int idx, boolean value) {
		if (idx > paramCnt || idx <= 0 || paramCnt <= 0) {
			return;
		} else {
			values.set(idx - 1, new Boolean(value));
			return;
		}
	}

	@SuppressWarnings("unchecked")
	public void setString(int idx, String value) {
		if (idx > paramCnt || idx <= 0 || paramCnt <= 0)
			return;
		if (value == null)
			values.set(idx - 1, "null");
		else
			values.set(idx - 1, (new StringBuilder()).append("'").append(value)
					.append("'").toString());
	}

	@SuppressWarnings("unchecked")
	public void setStringNoQuote(int idx, String value) {
		if (idx > paramCnt || idx <= 0 || paramCnt <= 0)
			return;
		if (value == null)
			value = "null";
		values.set(idx - 1, value);
	}

	public void setDateTime(int idx, Calendar value) {
		if (idx > paramCnt || idx <= 0 || paramCnt <= 0)
			return;
		String dateTimeStr = null;
		if (value != null)
			dateTimeStr = DateUtil.getDateTimeInString(value);
		setString(idx, dateTimeStr);
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

	@SuppressWarnings("unchecked")
	public void setBlob(int idx, Blob x) {
		if (idx > paramCnt || idx <= 0 || paramCnt <= 0)
			return;
		if (x != null) {
			values.set(idx - 1, x);
			hasBinaryData = true;
		} else {
			values.set(idx - 1, "null");
		}
	}

	@SuppressWarnings("unchecked")
	public void setBinaryStream(int idx, InputStream inputStream, int length) {
		if (idx > paramCnt || idx <= 0 || paramCnt <= 0)
			return;
		if (inputStream != null) {
			BinaryInputData bid = new BinaryInputData(inputStream, length);
			values.set(idx - 1, bid);
			hasBinaryData = true;
		}
	}

	public boolean hasBinaryData() {
		return hasBinaryData;
	}

	public Object getObject(int idx) {
		return values.get(idx - 1);
	}

	public int getParameterCount() {
		return paramCnt;
	}

	@SuppressWarnings("unchecked")
	public String getSQLString() {
		if (strTemplate == null)
			return null;
		if (paramCnt <= 0)
			return strTemplate;
		StringBuffer buff = new StringBuffer();
		List strs = new ArrayList();
		int from = 0;
		for (int to = 0; (to = strTemplate.indexOf('?', from)) >= 0;) {
			if (to > from)
				strs.add(strTemplate.substring(from, to));
			strs.add("?");
			from = to + 1;
		}

		if (from < strTemplate.length())
			strs.add(strTemplate.substring(from));
		int idx = 0;
		for (int i = 0; i < strs.size(); i++) {
			String str = (String) strs.get(i);
			if (!str.equals("?")) {
				buff.append(str);
				continue;
			}
			Object val = values.get(idx++);
			if (val != null && !(val instanceof Blob)
					&& !(val instanceof BinaryInputData))
				buff.append(val.toString());
			else
				buff.append("?");
		}

		return buff.toString();
	}

	protected String strTemplate;
	protected List values;
	protected int paramCnt;
	protected boolean hasBinaryData;
}
