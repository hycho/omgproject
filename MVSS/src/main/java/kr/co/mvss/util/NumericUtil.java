package kr.co.mvss.util;



import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 숫자 처리와 관련된 메소드 모음
 * 
 * @author hun-jung, Park / 2010-11 / 초기 작성
 */
public class NumericUtil
{
	public final static String DEFAULT_FORMAT = "#,##0";
	public final static String DEFAULT_VALUE = "0";

	/**
	 * @return 계산 된 수
	 * @param value 나누어질 값
	 * @param divisor 나눌 값
	 * @param scale 올림을 적용할 위치, +1 위치의 값에 따라 적용할 위치의 값을 조정한다.
	 * @param roundingmode 올림 모드
	 */
	public static BigDecimal divide(BigDecimal value, BigDecimal divisor, int scale, int roundingmode)
	{
		if (value.doubleValue() == 0 || divisor.doubleValue() == 0)
		{
			return new java.math.BigDecimal(0);
		}
		else
		{
			value = value.divide(divisor, scale, roundingmode);
			return value;
		}
	}

	/**
	 * 예) NumericUtil.divideRoundUp(10.0, 3, 1) --> 3.4 NumericUtil.divideRoundUp(10.2, 4, 1) --> 2.6 NumericUtil.divideRoundUp(11.0, 3, 1) --> 3.7
	 */
	public static BigDecimal divideRoundUp(BigDecimal value, BigDecimal divisor, int scale)
	{
		// 항상 0이 아닌 버릴 부분 앞자리를 증가시킨다.
		return divide(value, divisor, scale, BigDecimal.ROUND_UP);
	}

	/**
	 * 예) NumericUtil.divideRoundDown(10.0, 3, 1) --> 3.3 NumericUtil.divideRoundDown(10.2, 4, 1) --> 2.5 NumericUtil.divideRoundDown(11.0, 3, 1) --> 3.6
	 */
	public static BigDecimal divideRoundDown(BigDecimal value, BigDecimal divisor, int scale)
	{
		// 버릴 부분 앞자리를 결코 증가시키지 않습니다(예: 절단)
		return divide(value, divisor, scale, BigDecimal.ROUND_DOWN);
	}

	/**
	 * 예) NumericUtil.divideRoundHalfUp(10.0, 3, 1) --> 3.3 NumericUtil.divideRoundHalfUp(10.2, 4, 1) --> 2.6 NumericUtil.divideRoundHalfUp(11.0, 3, 1) --> 3.7
	 */
	public static BigDecimal divideRoundHalfUp(BigDecimal value, BigDecimal divisor, int scale)
	{
		// 버릴 부분이 .5보다 크거나 같은 경우 ROUND_UP으로 작동하며, 그렇지 않은 경우 ROUND_DOWN으로 작동
		return divide(value, divisor, scale, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 예) NumericUtil.divideRoundHalfDown(10.0, 3, 1) --> 3.3 NumericUtil.divideRoundHalfDown(10.2, 4, 1) --> 2.5 NumericUtil.divideRoundHalfDown(11.0, 3, 1) --> 3.7
	 */
	public static BigDecimal divideRoundHalfDown(BigDecimal value, BigDecimal divisor, int scale)
	{
		// 버릴 부분이 .5보다 큰 경우 ROUND_UP으로 작동합니다. 그렇지 않은 경우, ROUND_DOWN으로 작동
		return divide(value, divisor, scale, BigDecimal.ROUND_HALF_DOWN);
	}

	/**
	 * 예) NumericUtil.divideRoundCeiling(10.0, 3, 1) --> 3.4 NumericUtil.divideRoundCeiling(10.2, 4, 1) --> 2.6 NumericUtil.divideRoundCeiling(11.0, 3, 1) --> 3.7
	 */
	public static BigDecimal divideRoundCeiling(BigDecimal value, BigDecimal divisor, int scale)
	{
		// BigDecimal이 양수인 경우, ROUND_UP으로 작동하며, 음수인 경우 ROUND_DOWN으로 작동
		return divide(value, divisor, scale, BigDecimal.ROUND_CEILING);
	}

	public static BigDecimal divideRoundUp(Object value, Object divisor, int scale)
	{
		return divideRoundUp(new BigDecimal(value.toString()), new BigDecimal(divisor.toString()), scale);
	}

	public static BigDecimal divideRoundDown(Object value, Object divisor, int scale)
	{
		return divideRoundDown(new BigDecimal(value.toString()), new BigDecimal(divisor.toString()), scale);
	}

	public static BigDecimal divideRoundHalfUp(Object value, Object divisor, int scale)
	{
		return divideRoundHalfUp(new BigDecimal(value.toString()), new BigDecimal(divisor.toString()), scale);
	}

	public static BigDecimal divideRoundHalfDown(Object value, Object divisor, int scale)
	{
		return divideRoundHalfDown(new BigDecimal(value.toString()), new BigDecimal(divisor.toString()), scale);
	}

	public static BigDecimal divideRoundCeiling(Object value, Object divisor, int scale)
	{
		return divideRoundCeiling(new BigDecimal(value.toString()), new BigDecimal(divisor.toString()), scale);
	}

	/**
	 * 수치를 포맷에 맞춰 반환 - 리턴 타입이 String 이므로 Exception 을 던지지 않는다.
	 * 
	 * @return 변환된 문자열을 리턴한다. 기본값 0
	 * @param value 변환할 수치
	 * @param format 포맷, as like : #,##0 / #,##0.0 / ###,###,### / ...
	 */
	public static String format(Object value, String format, String defaultvalue)
	{
		String _return_s = "";
		try
		{
			DecimalFormat _format = new DecimalFormat(format);
			if (!value.getClass().isPrimitive())
			{
				// 원시형이 아니라면 
				if (value.toString().indexOf(".") > -1)
				{
					_return_s = _format.format(Double.parseDouble(value.toString()));
				}
				else
				{
					_return_s = _format.format(Long.parseLong(value.toString()));
				}
			}
			else
			{
				_return_s = _format.format(value);
			}
		}
		catch (Exception ex)
		{
			System.out.println("Error from NumericUtil.format(). ex - " + ex.getMessage());
			if (defaultvalue != null)
			{
				_return_s = defaultvalue;
			}
		}
		return _return_s;
	}

	/**
	 * @see #format(Object, String, String)
	 */
	public static String format(Object value, String format)
	{
		return format(value, format, DEFAULT_VALUE);
	}

	/**
	 * @see #format(Object, String, String)
	 */
	public static String format(Object value)
	{
		return format(value, DEFAULT_FORMAT, DEFAULT_VALUE);
	}

	/**
	 * 문자열을 정수로 변환한다. - 입력 문자열이 null 이면 0 리턴
	 * 
	 * @return 변환된 값
	 * @param value 입력
	 */
	public static int intValue(String value)
	{
		return intValue(value, 0);
	}
	public static int intValue(String value, int defaultvalue)
	{
		int _return = defaultvalue;
		if (value != null && value.trim().length() > 0)
		{
			try
			{
				_return = Integer.valueOf(value).intValue();
			}
			catch(Exception ex)
			{}
		}
		return _return;
	}
	/**
	 * 문자열을 double 로 변환한다. - 입력 문자열이 null 이면 0 리턴
	 * 
	 * @return 변환된 값
	 * @param value 입력
	 */
	public static double doubleValue(String value)
	{
		double _return = 0;
		if (value != null && value.trim().length() > 0)
		{
			_return = Double.valueOf(value).doubleValue();
		}
		return _return;
	}

	/**
	 * 문자열을 double 로 변환한다. - 입력 문자열이 null 이면 0 리턴
	 * 
	 * @return 변환된 값
	 * @param value 입력
	 */
	public static long longValue(String value)
	{
		long _return = 0;
		if (value != null && value.trim().length() > 0)
		{
			_return = Long.valueOf(value).longValue();
		}
		return _return;
	}
}
