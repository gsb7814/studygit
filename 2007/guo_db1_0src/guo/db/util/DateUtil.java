package guo.db.util;

import java.util.Calendar;

/**
 * 
 * DateUtil.java
 * @Author:¹ùÉÐ²¨
 * @Email:gsb7814@126.com
 * Nov 30, 2007 11:35:11 PM
 */
public class DateUtil {

	public DateUtil() {
	}

	public static String date2String(Calendar cal) {
		String strResult = "";
		long millis = cal.getTimeInMillis();
		strResult = (new StringBuilder(String.valueOf(cal.get(1)))).append("-")
				.toString();
		if (cal.get(2) + 1 < 10)
			strResult = (new StringBuilder(String.valueOf(strResult))).append(
					"0").toString();
		strResult = (new StringBuilder(String.valueOf(strResult))).append(
				cal.get(2) + 1).append("-").toString();
		if (cal.get(5) < 10)
			strResult = (new StringBuilder(String.valueOf(strResult))).append(
					"0").toString();
		strResult = (new StringBuilder(String.valueOf(strResult))).append(
				cal.get(5)).toString();
		return strResult;
	}

	public static String getDateInString(Calendar cal) {
		return date2String(cal);
	}

	public static String getTimeInString(Calendar cal) {
		String timeStr = "";
		int n = cal.get(10);
		int ampm = cal.get(9);
		if (ampm == 1)
			n += 12;
		if (n < 10)
			timeStr = (new StringBuilder(String.valueOf(timeStr))).append("0")
					.append(n).toString();
		else
			timeStr = (new StringBuilder(String.valueOf(timeStr))).append(n)
					.toString();
		timeStr = (new StringBuilder(String.valueOf(timeStr))).append(":")
				.toString();
		n = cal.get(12);
		if (n < 10)
			timeStr = (new StringBuilder(String.valueOf(timeStr))).append("0")
					.append(n).toString();
		else
			timeStr = (new StringBuilder(String.valueOf(timeStr))).append(n)
					.toString();
		timeStr = (new StringBuilder(String.valueOf(timeStr))).append(":")
				.toString();
		n = cal.get(13);
		if (n < 10)
			timeStr = (new StringBuilder(String.valueOf(timeStr))).append("0")
					.append(n).toString();
		else
			timeStr = (new StringBuilder(String.valueOf(timeStr))).append(n)
					.toString();
		return timeStr;
	}

	public static String timeSpan2String(int timeSpanSecond) {
		String timeStr = "";
		int h = timeSpanSecond / 3600;
		timeStr = (new StringBuilder(String.valueOf(timeStr))).append(h)
				.toString();
		timeStr = (new StringBuilder(String.valueOf(timeStr))).append(":")
				.toString();
		int m = (timeSpanSecond - h * 3600) / 60;
		if (m < 10)
			timeStr = (new StringBuilder(String.valueOf(timeStr))).append("0")
					.append(m).toString();
		else
			timeStr = (new StringBuilder(String.valueOf(timeStr))).append(m)
					.toString();
		timeStr = (new StringBuilder(String.valueOf(timeStr))).append(":")
				.toString();
		int s = timeSpanSecond - h * 3600 - m * 60;
		if (s < 10)
			timeStr = (new StringBuilder(String.valueOf(timeStr))).append("0")
					.append(s).toString();
		else
			timeStr = (new StringBuilder(String.valueOf(timeStr))).append(s)
					.toString();
		return timeStr;
	}

	public static Calendar string2Date(String dateStr) {
		if (dateStr == null)
			throw new AssertionError("invalid param: null");
		String datePat = "(\\d{1,4}(-|\\/)\\d{1,2}\\2\\d{1,2})( +\\d+:\\d{1,2}:\\d{1,2})?";
		if (!dateStr.matches(datePat))
			throw new AssertionError(
					(new StringBuilder("invalid param: \""))
							.append(dateStr)
							.append(
									"\". It is not a valid time span. The correct format is \"YYYY-M-D h:m:s\" or \"YYYY/M/D h:m:s\".")
							.toString());
		String parts[] = dateStr.split("-|\\/|:| ");
		int idx = 0;
		int year = Integer.valueOf(parts[idx++]).intValue();
		int month = Integer.valueOf(parts[idx++]).intValue() - 1;
		if (month > 11)
			throw new AssertionError((new StringBuilder("invalid param: \""))
					.append(dateStr).append("\".(1<=month<=12).").toString());
		int dayOfMonth = Integer.valueOf(parts[idx++]).intValue();
		int dayCntOfMonth[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (dayOfMonth > dayCntOfMonth[month]) {
			if (month != 1)
				throw new AssertionError(
						(new StringBuilder("invalid param: \""))
								.append(dateStr)
								.append(
										"\".(the day value can not be greater than ")
								.append(dayCntOfMonth[month]).append(
										" in month ").append(month + 1).append(
										".").toString());
			if (!isLeapYear(year) && dayOfMonth > 28)
				throw new AssertionError(
						(new StringBuilder("invalid param: \""))
								.append(dateStr)
								.append(
										"\".(the day value can not be greater than 29 in ")
								.append(year).append("-2.").toString());
		}
		int hour = 0;
		int minute = 0;
		int second = 0;
		if (parts.length > 3) {
			hour = Integer.valueOf(parts[idx++]).intValue();
			if (hour >= 24)
				throw new AssertionError(
						(new StringBuilder("invalid param: \""))
								.append(dateStr).append("\".(0<=hour<=23).")
								.toString());
			minute = Integer.valueOf(parts[idx++]).intValue();
			if (minute >= 60)
				throw new AssertionError(
						(new StringBuilder("invalid param: \""))
								.append(dateStr).append("\".(0<=minute<=59).")
								.toString());
			second = Integer.valueOf(parts[idx++]).intValue();
			if (second >= 60)
				throw new AssertionError(
						(new StringBuilder("invalid param: \""))
								.append(dateStr).append("\".(0<=second<=59).")
								.toString());
		}
		Calendar cal = Calendar.getInstance();
		cal.set(1, year);
		cal.set(2, month);
		cal.set(5, dayOfMonth);
		cal.set(11, hour);
		cal.set(12, minute);
		cal.set(13, second);
		cal.set(14, 0);
		long l = cal.getTimeInMillis();
		Calendar cal2 = Calendar.getInstance();
		cal2.setTimeInMillis(l);
		return cal2;
	}

	public static Calendar dateAdd(Calendar cal, int field, int value) {
		Calendar newCal = Calendar.getInstance();
		newCal.setTimeInMillis(cal.getTimeInMillis());
		switch (field) {
		case 0: // '\0'
		{
			int year = newCal.get(1);
			year += value;
			newCal.set(1, year);
			break;
		}

		case 1: // '\001'
		{
			int year = newCal.get(1);
			int month = newCal.get(2);
			int addYear = value / 12;
			month += value % 12;
			if (month > 11) {
				month -= 12;
				addYear++;
				newCal.set(1, year + addYear);
				newCal.set(2, month);
			} else {
				newCal.set(1, year + addYear);
				newCal.set(2, month);
			}
			break;
		}

		case 2: // '\002'
		{
			long millis = newCal.getTimeInMillis();
			millis += 0x5265c00 * value;
			newCal.setTimeInMillis(millis);
			break;
		}

		case 3: // '\003'
		{
			long millis = newCal.getTimeInMillis();
			millis += 0x36ee80 * value;
			newCal.setTimeInMillis(millis);
			break;
		}

		case 4: // '\004'
		{
			long millis = newCal.getTimeInMillis();
			millis += 60000 * value;
			newCal.setTimeInMillis(millis);
			break;
		}

		case 5: // '\005'
		{
			long millis = newCal.getTimeInMillis();
			millis += 1000 * value;
			newCal.setTimeInMillis(millis);
			break;
		}

		case 6: // '\006'
		{
			long millis = newCal.getTimeInMillis();
			millis += 0x240c8400 * value;
			newCal.setTimeInMillis(millis);
			break;
		}

		default: {
			throw new AssertionError("not recognized field");
		}
		}
		return newCal;
	}

	public static Calendar dateDiff(Calendar cal, int field, int value) {
		Calendar newCal = Calendar.getInstance();
		newCal.setTimeInMillis(cal.getTimeInMillis());
		switch (field) {
		case 0: // '\0'
		{
			int year = newCal.get(1);
			year -= value;
			newCal.set(1, year);
			break;
		}

		case 1: // '\001'
		{
			int year = newCal.get(1);
			int month = newCal.get(2);
			int diffYear = value / 12;
			month -= value % 12;
			if (month < 0) {
				month += 12;
				diffYear++;
				newCal.set(1, year - diffYear);
				newCal.set(2, month);
			} else {
				newCal.set(1, year - diffYear);
				newCal.set(2, month);
			}
			break;
		}

		case 2: // '\002'
		{
			long millis = newCal.getTimeInMillis();
			millis -= 0x5265c00 * value;
			newCal.setTimeInMillis(millis);
			break;
		}

		case 3: // '\003'
		{
			long millis = newCal.getTimeInMillis();
			millis -= 0x36ee80 * value;
			newCal.setTimeInMillis(millis);
			break;
		}

		case 4: // '\004'
		{
			long millis = newCal.getTimeInMillis();
			millis -= 60000 * value;
			newCal.setTimeInMillis(millis);
			break;
		}

		case 5: // '\005'
		{
			long millis = newCal.getTimeInMillis();
			millis -= 1000 * value;
			newCal.setTimeInMillis(millis);
			break;
		}

		case 6: // '\006'
		{
			long millis = newCal.getTimeInMillis();
			millis -= 0x240c8400 * value;
			newCal.setTimeInMillis(millis);
			break;
		}

		default: {
			throw new AssertionError("not recognized field");
		}
		}
		return newCal;
	}

	public static String getCurDateTimeInString() {
		return (new StringBuilder(String.valueOf(getCurDateInString())))
				.append(" ").append(getCurTimeInString()).toString();
	}

	public static String getDateTimeInString(Calendar cal) {
		return (new StringBuilder(String.valueOf(date2String(cal))))
				.append(" ").append(getTimeInString(cal)).toString();
	}

	public static String getCurDateInString() {
		Calendar cal = Calendar.getInstance();
		String dateStr = date2String(cal);
		return dateStr;
	}

	public static String getCurTimeInString() {
		Calendar cal = Calendar.getInstance();
		return getTimeInString(cal);
	}

	public static int string2TimeSpan(String strTimeSpan) {
		if (strTimeSpan == null)
			throw new AssertionError("invalid param: null");
		String timePat = "\\d+:\\d{1,2}:\\d{1,2}";
		if (!strTimeSpan.matches(timePat))
			throw new AssertionError(
					(new StringBuilder("invalid param: \""))
							.append(strTimeSpan)
							.append(
									"\". It is not a valid time span. The correct format is \"h:m:s\"(h>=0, 0<=m<=59, 0<=s<=59).")
							.toString());
		String parts[] = strTimeSpan.split(":");
		int h = Integer.parseInt(parts[0]);
		int m = Integer.parseInt(parts[1]);
		if (m >= 60)
			throw new AssertionError(
					(new StringBuilder("invalid param: \""))
							.append(strTimeSpan)
							.append(
									"\". It is not a valid time span. The correct format is \"h:m:s\"(h>=0, 0<=m<=59, 0<=s<=59).")
							.toString());
		int s = Integer.parseInt(parts[2]);
		if (s >= 60)
			throw new AssertionError(
					(new StringBuilder("invalid param: \""))
							.append(strTimeSpan)
							.append(
									"\". It is not a valid time span. The correct format is \"h:m:s\"(h>=0, 0<=m<=59, 0<=s<=59).")
							.toString());
		else
			return h * 3600 + m * 60 + s;
	}

	public static String timeSpanAdd(String timeSpan, int field, int value) {
		int oldval = string2TimeSpan(timeSpan);
		switch (field) {
		case 2: // '\002'
			oldval += 0x15180 * value;
			break;

		case 3: // '\003'
			oldval += 3600 * value;
			break;

		case 4: // '\004'
			oldval += 60 * value;
			break;

		case 5: // '\005'
			oldval += value;
			break;

		case 6: // '\006'
			oldval += 0x93a80 * value;
			break;

		default:
			throw new AssertionError(
					"not recognized field or the field can not identify a constant value");
		}
		return timeSpan2String(oldval);
	}

	public static String timeSpanDiff(String timeSpan, int field, int value) {
		return timeSpanAdd(timeSpan, field, -value);
	}

	public static boolean isLeapYear(int year) {
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}

	public static final int YEAR = 0;
	public static final int MONTH = 1;
	public static final int DAY = 2;
	public static final int HOUR = 3;
	public static final int MINUTE = 4;
	public static final int SECOND = 5;
	public static final int WEEK = 6;
}
