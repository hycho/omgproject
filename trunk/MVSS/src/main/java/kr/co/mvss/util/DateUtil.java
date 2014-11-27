package kr.co.mvss.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil
{
	public final static int SUNDAY = 1;
	public final static int MONDAY = 2;
	public final static int TUESDAY = 3;
	public final static int WEDNESDAY = 4;
	public final static int THURSDAY = 5;
	public final static int FRIDAY = 6;
	public final static int SATURDAY = 7;

	/**
	 * <pre>
	 * 일시에 일정 일시만끔 가감 한 일시를 구한다.
	 * - 특정 요일에 대해 포함할지 않을지를 선택 가능하다.
	 * - 업무 완료 기간 등을 구하는데 사용한다.
	 * 
	 * 예)
	 * 토요일을 기준 일시로 하고 A 라는 업무의 처리 기한이 3일이라고 가정할때 정상적인 계산은 3일 후인 화요일 일것이다.
	 * 이때, 중간에 휴일이 포함되어 있으므로 이러한 휴일에 대해 어떤 기준을 적용할지 설정할수 있다.
	 * 토/일요일에 대해 jump 를 하라고 인수를 설정(true)하면 목요일이 반환되게 되는것이다.
	 * 또한, 시작일자는 이러한 jump 할 계산에서 제외 한다고 설정(false)한다면 시작 토요일은 업무하는 날로 간주하여 수요일이 반환되게 된다.
	 * </pre>
	 * 
	 * @param date 기준 일시
	 * @param terms 가감할 일수
	 * @param jumpdays 인수 배열 길이 7, 일~토요일 순, 예)new boolean[]{true, false, false, false, false, false, true}
	 * @param isapplystartdate 시작일 부터 jumpdays 사항을 적용할지 여부, 아주 특이한 케이스에 한해 false 로 할것을 권고
	 * @return Date 계산된 일시를 반환한다.
	 * @throws Exception
	 */
	public static Date addDays(Date date, int terms, boolean[] jumpdays, boolean isapplystartdate) throws Exception
	{
		if (jumpdays != null)
		{
			if (jumpdays.length != 7)
			{
				throw new Exception("Wrong length error - parameter(boolean[] jumpdays) object length will be 7");
			}
			else if (jumpdays[0] && jumpdays[1] && jumpdays[2] && jumpdays[3] && jumpdays[4] && jumpdays[5] && jumpdays[6])
			{
				// 모든 요일에 대해 jump 하면 무한 루프이므로 이에 대해 잘못된 인수란 메세지를 뿌린다.
				throw new Exception("Wrong data set error - You can not set false value to all elements of parameter(boolean[] jumpdays)");
			}
		}
		Calendar _calendar = null;
		_calendar = Calendar.getInstance();
		_calendar.setTime(date);
		// 플러스 시킬 일시가 0 이 아니라면
		if (terms != 0)
		{
			int _term = 1;
			// 만약 이전 일시를 원하는 경우
			if (terms < 0)
			{
				_term *= -1;
			}
			for (int i = 0; i < (terms * _term);)
			{
				// 건너 뛸 요일에 대한 적용이 시작 일시 포함이 아니라면
				if (!isapplystartdate)
				{
					_calendar.set(Calendar.DATE, _calendar.get(Calendar.DATE) + (1 * _term));
				}
				// 실제로 plus 시킬 일시에 그냥 건녀뛰어야 하는 요일이 존재한다면 그냥 넘어가도록 한다.
				if (jumpdays == null)
				{
					i++;
				}
				else if (!((_calendar.get(Calendar.DAY_OF_WEEK) == SUNDAY && jumpdays[0]) || (_calendar.get(Calendar.DAY_OF_WEEK) == MONDAY && jumpdays[1]) || (_calendar.get(Calendar.DAY_OF_WEEK) == TUESDAY && jumpdays[2]) || (_calendar.get(Calendar.DAY_OF_WEEK) == WEDNESDAY && jumpdays[3])
						|| (_calendar.get(Calendar.DAY_OF_WEEK) == THURSDAY && jumpdays[4]) || (_calendar.get(Calendar.DAY_OF_WEEK) == FRIDAY && jumpdays[5]) || (_calendar.get(Calendar.DAY_OF_WEEK) == SATURDAY && jumpdays[6])))
				{
					i++;
				}
				// 건너 뛸 요일에 대한 적용이 시작 일시 포함이라면
				if (isapplystartdate)
				{
					_calendar.set(Calendar.DATE, _calendar.get(Calendar.DATE) + (1 * _term));
				}
			}
		}
		date = _calendar.getTime();
		return date;
	}

	/**
	 * @see #addDays(Date, int, boolean[], boolean)
	 * @throws Exception
	 */
	public static Date addDays(Date date, int terms) throws Exception
	{
		return addDays(date, terms, null, true);
	}

	/**
	 * @see #addDays(Date, int, boolean[], boolean)
	 * @throws Exception
	 */
	public static Date addDays(Date date, int terms, boolean[] jumpdays) throws Exception
	{
		return addDays(date, terms, jumpdays, true);
	}

	/**
	 * @see #addDays(Date, int, boolean[], boolean)
	 * @throws Exception
	 */
	public static Date addDays(int terms) throws Exception
	{
		// 현재 일시 기준
		return addDays(new Date(), terms, null, true);
	}

	/**
	 * @see #addDays(Date, int, boolean[], boolean)
	 * @throws Exception
	 */
	public static Date addDays(int terms, boolean[] jumpdays) throws Exception
	{
		// 현재 일시 기준
		return addDays(new Date(), terms, jumpdays, true);
	}

	/**
	 * @see #addDays(Date, int, boolean[], boolean)
	 * @throws Exception
	 */
	public static Date addDays(int terms, boolean[] jumpdays, boolean isapplystartdate) throws Exception
	{
		// 현재 일시 기준
		return addDays(new Date(), terms, jumpdays, isapplystartdate);
	}

	/**
	 * @see #addDays(Date, int, boolean[], boolean)
	 * @param value 포맷에 맞춘 기준 일시 값, as like : 20101130, 20101130120101
	 * @param format 기준 일시에 대한 포맷, as like : yyyyMMdd, yyyyMMddHHmmss
	 * @throws Exception
	 */
	public static Date addDays(String value, String format, int terms) throws Exception
	{
		return addDays((new SimpleDateFormat(format)).parse(value), terms, null, true);
	}

	/**
	 * @see #addDays(Date, int, boolean[], boolean)
	 * @param value 포맷에 맞춘 기준 일시 값, as like : 20101130, 20101130120101
	 * @param format 기준 일시에 대한 포맷, as like : yyyyMMdd, yyyyMMddHHmmss
	 * @throws Exception
	 */
	public static Date addDays(String value, String format, int terms, boolean[] jumpdays) throws Exception
	{
		return addDays((new SimpleDateFormat(format)).parse(value), terms, jumpdays, true);
	}

	/**
	 * @see #addDays(Date, int, boolean[], boolean)
	 * @param value 포맷에 맞춘 기준 일시 값, as like : 20101130, 20101130120101
	 * @param format 기준 일시에 대한 포맷, as like : yyyyMMdd, yyyyMMddHHmmss
	 * @throws Exception
	 */
	public static Date addDays(String value, String format, int terms, boolean[] jumpdays, boolean isapplystartdate) throws Exception
	{
		return addDays((new SimpleDateFormat(format)).parse(value), terms, jumpdays, isapplystartdate);
	}

	/**
	 * <pre>
	 * 일시에 일정 수치(수치의 의미는 타입에 의해 결정)만큼 가감한 일시를 구한다
	 * - 내부 메소드
	 * </pre>
	 * 
	 * @param date Date 기준 일시
	 * @param type 가감할 타입, Calendar.YEAR / Calendar.MONTH / Calendar.HOUR / Calendar.MINUTE
	 * @param terms 가감할 수
	 * @return Date 계산된 일시
	 */
	private static Date addDate(Date date, int type, int terms)
	{
		Calendar _calendar = null;
		_calendar = Calendar.getInstance();
		_calendar.setTime(date);
		_calendar.set(type, _calendar.get(type) + terms);
		date = _calendar.getTime();
		return date;
	}

	/**
	 * @see #addDate(Date, int, int)
	 */
	public static Date addHours(Date date, int terms)
	{
		return addDate(date, Calendar.HOUR, terms);
	}

	/**
	 * @see #addDate(Date, int, int)
	 */
	public static Date addHours(int terms)
	{
		// 현재 일시 기준
		return addDate(new Date(), Calendar.HOUR, terms);
	}

	/**
	 * @see #addDate(Date, int, int)
	 * @param value 포맷에 맞춘 기준 일시 값, as like : 20101130, 20101130120101
	 * @param format 기준 일시에 대한 포맷, as like : yyyyMMdd, yyyyMMddHHmmss
	 * @throws Exception
	 */
	public static Date addHours(String value, String format, int terms) throws Exception
	{
		return addDate((new SimpleDateFormat(format)).parse(value), Calendar.HOUR, terms);
	}

	/**
	 * @see #addDate(Date, int, int)
	 */
	public static Date addMinutes(Date date, int terms)
	{
		return addDate(date, Calendar.MINUTE, terms);
	}

	/**
	 * @see #addDate(Date, int, int)
	 */
	public static Date addMinutes(int terms)
	{
		// 현재 일시 기준
		return addDate(new Date(), Calendar.MINUTE, terms);
	}

	/**
	 * @see #addDate(Date, int, int)
	 * @param value 포맷에 맞춘 기준 일시 값, as like : 20101130, 20101130120101
	 * @param format 기준 일시에 대한 포맷, as like : yyyyMMdd, yyyyMMddHHmmss
	 * @throws Exception
	 */
	public static Date addMinutes(String value, String format, int terms) throws Exception
	{
		return addDate((new SimpleDateFormat(format)).parse(value), Calendar.MINUTE, terms);
	}

	/**
	 * @see #addDate(Date, int, int)
	 */
	public static Date addMonths(Date date, int terms)
	{
		return addDate(date, Calendar.MONTH, terms);
	}

	/**
	 * @see #addDate(Date, int, int)
	 */
	public static Date addMonths(int terms)
	{
		// 현재 일시 기준
		return addDate(new Date(), Calendar.MONTH, terms);
	}

	/**
	 * @see #addDate(Date, int, int)
	 * @param value 포맷에 맞춘 기준 일시 값, as like : 20101130, 20101130120101
	 * @param format 기준 일시에 대한 포맷, as like : yyyyMMdd, yyyyMMddHHmmss
	 * @throws Exception
	 */
	public static Date addMonths(String value, String format, int terms) throws Exception
	{
		return addDate((new SimpleDateFormat(format)).parse(value), Calendar.MONTH, terms);
	}

	/**
	 * @see #addDate(Date, int, int)
	 */
	public static Date addYears(Date date, int terms)
	{
		return addDate(date, Calendar.YEAR, terms);
	}

	/**
	 * @see #addDate(Date, int, int)
	 * @throws Exception
	 */
	public static Date addYears(int terms) throws Exception
	{
		// 현재 일시 기준
		return addDate(new Date(), Calendar.YEAR, terms);
	}

	/**
	 * @see #addDate(Date, int, int)
	 * @param value 포맷에 맞춘 기준 일시 값, as like : 20101130, 20101130120101
	 * @param format 기준 일시에 대한 포맷, as like : yyyyMMdd, yyyyMMddHHmmss
	 * @throws Exception
	 */
	public static Date addYears(String value, String format, int terms) throws Exception
	{
		return addDate((new SimpleDateFormat(format)).parse(value), Calendar.YEAR, terms);
	}

	/**
	 * <pre>
	 * 일시를 포맷에 맞춰 반환
	 * - 리턴 타입이 String 이므로 Exception 을 던지지 않는다.
	 * </pre>
	 * 
	 * @param date 기준 일시
	 * @param format 일시 포맷, as like : yyyyMMdd, yyyy/MM/dd, yyyy년 MM월 dd일, HHmmss, HH:mm:ss, HH : mm, ...
	 * @return String 포맷에 맞춘 일시
	 */
	public static String format(Date date, String format)
	{
		String _return = "";
		try
		{
			SimpleDateFormat _simpledateformat = new SimpleDateFormat(format);
			_return = _simpledateformat.format(date);
		}
		catch(Exception ex)
		{
			System.out.println("Error from DateUtil.format(). ex - " + ex.getMessage());
		}
		return _return;
	}

	/**
	 * @see #format(Date, String)
	 */
	public static String format(String format)
	{
		// 현재 일시 기준
		return format(new Date(), format);
	}

	/**
	 * <pre>
	 * Date[] 를 포맷에 맞춰 String[]으로 반환
	 * </pre>
	 * 
	 * @see #format(Date, String)
	 */
	public static String[] format(Date[] dates, String format)
	{
		String _return[] = null;
		if (dates != null && dates.length > 0)
		{
			_return = new String[dates.length];
			for (int i = 0; i < dates.length; i++)
			{
				_return[i] = format(dates[i], format);
			}
		}
		return _return;
	}

	/**
	 * <pre>
	 * Calendar 형식의 일시 반환
	 * </pre>
	 * 
	 * @param date 기준 일시
	 * @return Calendar
	 */
	public static Calendar getCalendar(Date date)
	{
		Calendar _calendar = Calendar.getInstance();
		_calendar.setTime(date);
		return _calendar;
	}

	/**
	 * @see #getCalendar(Date)
	 */
	public static Calendar getCalendar()
	{
		// 현재 일시 기준
		return getCalendar(new Date());
	}

	/**
	 * @see #getCalendar(Date)
	 * @param value 포맷에 맞춘 기준 일시 값, as like : 20101130, 20101130120101
	 * @param format 기준 일시에 대한 포맷, as like : yyyyMMdd, yyyyMMddHHmmss
	 * @throws Exception
	 */
	public static Calendar getCalendar(String value, String format) throws Exception
	{
		return getCalendar((new SimpleDateFormat(format)).parse(value));
	}

	/**
	 * <pre>
	 * Date 형식의 일시 반환
	 * </pre>
	 * 
	 * @param value 포맷에 맞춘 기준 일시 값, as like : 20101130, 20101130120101
	 * @param format 기준 일시에 대한 포맷, as like : yyyyMMdd, yyyyMMddHHmmss
	 * @return 반환할 Date 형 일시
	 * @throws Exception
	 */
	public static Date getDate(String value, String format) throws Exception
	{
		return (new SimpleDateFormat(format)).parse(value);
	}

	/**
	 * <pre>
	 * 기준 일시가 속한 주(일~토)에서 해당 요일의 일시를 구함
	 * </pre>
	 * 
	 * @see #addDays(Date, int)
	 * @see #getDayOfWeek(Date)
	 * @param date 기준 일시
	 * @param dayofweek 요일, 일(1)~토(7), 벗어난 값에 대해서는 그 수치에 해당하는 만큼 과거 미래에 해당하는 일시를 반환하도록 한다.
	 * @return 계산된 일시를 Date 형으로 반환한다.
	 * @throws Exception
	 */
	public static Date getDateByDayOfWeek(Date date, int dayofweek) throws Exception
	{
		int _term = dayofweek - getDayOfWeek(date);
		return addDays(date, _term);
	}

	/**
	 * @see #getDateByDayOfWeek(Date, int)
	 * @throws Exception
	 */
	public static Date getDateByDayOfWeek(int dayofweek) throws Exception
	{
		// 현재 일시 기준
		return getDateByDayOfWeek(new Date(), dayofweek);
	}

	/**
	 * @see #getDateByDayOfWeek(Date, int)
	 * @param value 포맷에 맞춘 기준 일시 값, as like : 20101130, 20101130120101
	 * @param format 기준 일시에 대한 포맷, as like : yyyyMMdd, yyyyMMddHHmmss
	 * @throws Exception
	 */
	public static Date getDateByDayOfWeek(String value, String format, int dayofweek) throws Exception
	{
		return getDateByDayOfWeek((new SimpleDateFormat(format)).parse(value), dayofweek);
	}

	/**
	 * <pre>
	 * 기준 일시가 속한 주(일&tilde;토)에서 해당 요일의 일시를 배열 로 반환한다.
	 * </pre>
	 * 
	 * @see #getDateByDayOfWeek(Date, int)
	 * @return 계산된 일시의 Date 형 array
	 * @throws Exception
	 */
	public static Date[] getDateByDayOfWeek(Date date, int[] daysofweek) throws Exception
	{
		Date[] _return = null;
		if (daysofweek.length > 0)
		{
			_return = new Date[daysofweek.length];
			for (int i = 0; i < daysofweek.length; i++)
			{
				_return[i] = getDateByDayOfWeek(date, daysofweek[i]);
			}
		}
		return _return;
	}

	/**
	 * @see #getDatesByDayOfWeek(Date, int)
	 * @param value 포맷에 맞춘 기준 일시 값, as like : 20101130, 20101130120101
	 * @param format 기준 일시에 대한 포맷, as like : yyyyMMdd, yyyyMMddHHmmss
	 * @throws Exception
	 */
	public static Date[] getDateByDayOfWeek(String value, String format, int[] daysofweek) throws Exception
	{
		return getDateByDayOfWeek((new SimpleDateFormat(format)).parse(value), daysofweek);
	}

	/**
	 * <pre>
	 * 기준 일시가 해당주 몇번째 일에 해당하는지 반환
	 * </pre>
	 * 
	 * @see #getCalendar(Date)
	 * @param date 기준 일시
	 * @return 해당일 위치, 1~, Java 의 주 단위 기준은 일(1)~토(7) 이다.
	 */
	public static int getDayOfWeek(Date date)
	{
		return getCalendar(date).get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * @see #getDayOfWeek(Date)
	 */
	public static int getDayOfWeek()
	{
		// 현재 일시 기준
		return getDayOfWeek(new Date());
	}

	/**
	 * @see #getDayOfWeek(Date)
	 * @param value 포맷에 맞춘 기준 일시 값, as like : 20101130, 20101130120101
	 * @param format 기준 일시에 대한 포맷, as like : yyyyMMdd, yyyyMMddHHmmss
	 * @throws Exception
	 */
	public static int getDayOfWeek(String value, String format) throws Exception
	{
		return getDayOfWeek((new SimpleDateFormat(format)).parse(value));
	}

	/**
	 * @see #getCalendar(Date)
	 * @param date 기준 일시
	 * @return 그달의 마지막 날짜를 반환
	 */
	public static int getLastDayOfMonth(Date date)
	{
		return getCalendar(date).getMinimum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * @see #getLastDayOfMonth(Date)
	 * @param value 포맷에 맞춘 기준 일시 값, as like : 20101130, 20101130120101
	 * @param format 기준 일시에 대한 포맷, as like : yyyyMMdd, yyyyMMddHHmmss
	 * @throws Exception
	 */
	public static int getLastDayOfMonth(String value, String format) throws Exception
	{
		return getLastDayOfMonth((new SimpleDateFormat(format)).parse(value));
	}

	/**
	 * @see #format(String)
	 * @return 현재 연도
	 */
	public static String getMonth()
	{
		return format("MM");
	}

	/**
	 * <pre>
	 * 두 일시에 대한 간격을 millisecond 으로 반환
	 * </pre>
	 * 
	 * @param starttime 시작일시에 대한 millisecond
	 * @param endiime 종료일시에 대한 millisecond
	 * @return 두 시간에 대한 millisecond 간격
	 */
	public static long getInterval(long starttime, long endiime)
	{
		return (endiime - starttime);
	}

	/**
	 * <pre>
	 * 기준 일시에 대한 milliseconds 을 반환한다.
	 * </pre>
	 * 
	 * @param date 기준 일시
	 * @return 일시에 대한 milliseconds
	 */
	public static long getTime(Date date)
	{
		return date.getTime();
	}

	/**
	 * @see #getTime(Date)
	 */
	public static long getTime()
	{
		// 현재 일시 기준
		return getTime(new Date());
	}

	/**
	 * <pre>
	 * 입력 받은 시간이 현재 시간 이후 얼마(millisecond) 남았는지를 반환
	 * - 24시간안에서 입력 받은 시간이 현재 시간 기준 얼마 뒤인지를 확인
	 * - 에러 발생시 Exception 없이 24시간에 대한 millisecond 을 리턴
	 * 
	 * 예)
	 * 1. 현재 시간이 10시일때 100001 를 넣으면 1초 에 대한 millisecond 를 리턴
	 * 2. 현재 시간이 10시일때 095959 를 넣으면 23시59분59초 에 대한 millisecond 를 리턴
	 * </pre>
	 * 
	 * @param start_hhmmss 포맷 HHmmss 포맷 에 맞춘 시간
	 * @return 남은 millisecond
	 */
	public static long getWaitingTime(String start_hhmmss)
	{
		long _return = 24 * 60L * 60L * 1000L;
		try
		{
			Date _now = new Date();
			Calendar _calendar = null;
			if (Long.parseLong((new SimpleDateFormat("HHmmss")).format(_now).toString()) > Long.parseLong(start_hhmmss))
			{
				// 0시를 기준으로 현재 시간이 배치 프로그램 시작 시간을 넘었음
				// '24시 - (현재 시간 - 배치 프로그램 시간)' 으로 배치 프로그램이 수행 되기 까지 기다릴 시간을 얻는다.
				Calendar _cal = Calendar.getInstance();
				_cal.setTime(_now); // 현재 시간 셋팅
				_cal.set(Calendar.HOUR, _cal.get(Calendar.HOUR) - Integer.parseInt(start_hhmmss.substring(0, 2)));
				_cal.set(Calendar.MINUTE, _cal.get(Calendar.MINUTE) - Integer.parseInt(start_hhmmss.substring(2, 4)));
				_cal.set(Calendar.SECOND, _cal.get(Calendar.SECOND) - Integer.parseInt(start_hhmmss.substring(4, 6)));
				_calendar = Calendar.getInstance();
				_calendar.set(0, 0, 0, 24, 0, 0); // 24시를 셋팅
				_calendar.set(Calendar.HOUR, _calendar.get(Calendar.HOUR) - _cal.get(Calendar.HOUR));
				_calendar.set(Calendar.MINUTE, _calendar.get(Calendar.MINUTE) - _cal.get(Calendar.MINUTE));
				_calendar.set(Calendar.SECOND, _calendar.get(Calendar.SECOND) - _cal.get(Calendar.SECOND));
			}
			else
			{
				// 0시를 기준으로 현재 시간이 배치 프로그램 시작 시간 보다 전임
				// '배치 프로그램 시간 - 현재 시간' 으로 배치 프로그램이 수행 되기 까지 기다릴 시간을 얻는다.
				_calendar = Calendar.getInstance();
				_calendar.setTime(_now);
				_calendar.set(Calendar.HOUR, Integer.parseInt(start_hhmmss.substring(0, 2)) - _calendar.get(Calendar.HOUR));
				_calendar.set(Calendar.MINUTE, Integer.parseInt(start_hhmmss.substring(2, 4)) - _calendar.get(Calendar.MINUTE));
				_calendar.set(Calendar.SECOND, Integer.parseInt(start_hhmmss.substring(4, 6)) - _calendar.get(Calendar.SECOND));
			}
			String _s = (new SimpleDateFormat("HHmmss")).format(_calendar.getTime());
			_return = (((Long.parseLong(_s.substring(0, 2)) * 60L * 60L) + (Long.parseLong(_s.substring(2, 4)) * 60L) + Long.parseLong(_s.substring(4, 6))) * 1000L);
		}
		catch(Exception ex)
		{
			System.out.println("Error from DateUtil.getWaitingTime(). ex - " + ex.getMessage());
		}
		return _return;
	}

	/**
	 * <pre>
	 * 기준 일시가 해당월 몇번째 주에 해당하는지 반환
	 * </pre>
	 * 
	 * @param date 기준 일시
	 * @return 해당주, 1~, Java 의 주 단위 기준은 일(1)~토(7) 이다.
	 */
	public static int getWeekOfMonth(Date date)
	{
		return getCalendar(date).get(Calendar.WEEK_OF_MONTH);
	}

	/**
	 * @see #getWeekOfMonth(Date)
	 */
	public static int getWeekOfMonth()
	{
		// 현재 일시 기준
		return getWeekOfMonth(new Date());
	}

	/**
	 * @see #getWeekOfMonth(Date)
	 * @param value 포맷에 맞춘 기준 일시 값, as like : 20101130, 20101130120101
	 * @param format 기준 일시에 대한 포맷, as like : yyyyMMdd, yyyyMMddHHmmss
	 * @throws Exception
	 */
	public static int getWeekOfMonth(String value, String format) throws Exception
	{
		return getWeekOfMonth((new SimpleDateFormat(format)).parse(value));
	}

	/**
	 * @see #format(String)
	 * @return 현재 연도
	 */
	public static String getYear()
	{
		return format("yyyy");
	}

	/**
	 * <pre>
	 * 기준 일시가 주어진 요일과 일치하는지 여부
	 * </pre>
	 * 
	 * @see #SUNDAY
	 * @see #MONDAY
	 * @see #TUESDAY
	 * @see #WEDNESDAY
	 * @see #THURSDAY
	 * @see #FRIDAY
	 * @see #SATURDAY
	 * @see #getDayOfWeek(Date)
	 * @see #getDateByDayOfWeek(int)
	 * @param date 기준 일시
	 * @param dayofweek 일(1)~토(7), 범위를 벋어나는 값에 대해서도 오류 없이 결과를 반환한다.
	 * @return 일치 여부에 대한 boolean 값
	 * @throws Exception
	 */
	public static boolean isDayOfWeek(Date date, int dayofweek) throws Exception
	{
		return (getDayOfWeek(date) == getDayOfWeek(getDateByDayOfWeek(dayofweek)));
	}

	/**
	 * @see #isDayOfWeek(Date, int)
	 * @throws Exception
	 */
	public static boolean isDayOfWeek(int dayofweek) throws Exception
	{
		// 현재 일시 기준
		return isDayOfWeek(new Date(), dayofweek);
	}

	/**
	 * @see #isDayOfWeek(Date, int)
	 * @param value 포맷에 맞춘 기준 일시 값, as like : 20101130, 20101130120101
	 * @param format 기준 일시에 대한 포맷, as like : yyyyMMdd, yyyyMMddHHmmss
	 * @throws Exception
	 */
	public static boolean isDayOfWeek(String value, String format, int dayofweek) throws Exception
	{
		return isDayOfWeek((new SimpleDateFormat(format)).parse(value), dayofweek);
	}

	/**
	 * <pre>
	 * 기준일자가 현재에 비해 주어진 일자 term 만큼의 과거 범위에 있는지 여부
	 * - 데이터가 화면에 표현될때 신규로 표시 될지 여부를 판단할때 사용
	 * - Exception 을 던지지 않는다.
	 * </pre>
	 * 
	 * @see #format(String)
	 * @see #format(Date, String)
	 * @see #addDays(String, String, int)
	 * @param value 포맷에 맞춘 기준 일시 값, as like : 20101130, 20101130120101
	 * @param format 기준 일시에 대한 포맷, as like : yyyyMMdd, yyyyMMddHHmmss
	 * @param dayterm 과거 몇시간까지
	 * @return 판단 여부
	 */
	public static boolean isNewByDay(String value, String format, int dayterm)
	{
		boolean _return = false;
		try
		{
			if (Long.parseLong(format("yyyyMMdd")) <= Long.parseLong(format(addDays(value, format, dayterm), "yyyyMMdd")))
			{
				_return = true;
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error from DateUtil.isNewByDay(). ex - " + ex.getMessage());
		}
		return _return;
	}

	/**
	 * <pre>
	 * 기준일자가 현재에 비해 주어진 시간 term 만큼의 과거 범위에 있는지 여부
	 * - 데이터가 화면에 표현될때 신규로 표시 될지 여부를 판단할때 사용
	 * - Exception 을 던지지 않는다.
	 * </pre>
	 * 
	 * @see #getTime()
	 * @see #getTime(Date)
	 * @see #getDate(String, String)
	 * @param value 포맷에 맞춘 기준 일시 값, as like : 20101130, 20101130120101
	 * @param format 기준 일시에 대한 포맷, as like : yyyyMMdd, yyyyMMddHHmmss
	 * @param hourterm 과거 몇시간까지
	 * @return 판단 여부
	 */
	public static boolean isNewByHour(String value, String format, int hourterm)
	{
		boolean _return = false;
		try
		{
			if ((getTime() < getTime(getDate(value, format)) + (hourterm * 60 * 60 * 1000)))
			{
				_return = true;
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error from DateUtil.isNewByHour(). ex - " + ex.getMessage());
		}
		return _return;
	}
}
