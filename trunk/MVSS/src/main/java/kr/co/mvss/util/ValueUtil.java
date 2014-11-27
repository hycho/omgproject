package kr.co.mvss.util;



import java.io.Serializable;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValueUtil implements Serializable
{
	private static final long serialVersionUID = -8905477635096785762L;

	/**
	 * <pre>
	 * 주민번호가 올바른지 체크
	 * - 현재는 외국인 번호 체크 안됨
	 * 
	 * 예)
	 * </pre>
	 * 
	 * @param value 주민번호
	 * @return 올바른지 여
	 */
	public static boolean checkKRJuminNO(String value)
	{
		boolean _return_b = false;

		try
		{
			value = value.trim();

			if (value.length() == 13)
			{
				int _check_i = 0;
				int _j_11 = Integer.parseInt(value.substring(0, 1));
				int _j_12 = Integer.parseInt(value.substring(1, 2));
				int _j_13 = Integer.parseInt(value.substring(2, 3));
				int _j_14 = Integer.parseInt(value.substring(3, 4));
				int _j_15 = Integer.parseInt(value.substring(4, 5));
				int _j_16 = Integer.parseInt(value.substring(5, 6));
				int _j_21 = Integer.parseInt(value.substring(6, 7));
				int _j_22 = Integer.parseInt(value.substring(7, 8));
				int _j_23 = Integer.parseInt(value.substring(8, 9));
				int _j_24 = Integer.parseInt(value.substring(9, 10));
				int _j_25 = Integer.parseInt(value.substring(10, 11));
				int _j_26 = Integer.parseInt(value.substring(11, 12));
				int _j_27 = Integer.parseInt(value.substring(12, 13));
				int _j_month = Integer.parseInt(value.substring(2, 4));
				int _j_day = Integer.parseInt(value.substring(4, 6));

				if (_j_month <= 0 || _j_month > 12)
				{
					_return_b = false;
				}
				else if (_j_day <= 0 || _j_day > 31)
				{
					_return_b = false;
				}
				else if (_j_21 > 4 || _j_21 <= 0)
				{
					_return_b = false;
				}
				else
				{
					_check_i = (_j_11 * 2) + (_j_12 * 3) + (_j_13 * 4) + (_j_14 * 5) + (_j_15 * 6) + (_j_16 * 7) + (_j_21 * 8) + (_j_22 * 9) + (_j_23 * 2) + (_j_24 * 3) + (_j_25 * 4) + (_j_26 * 5);
					_check_i = _check_i % 11;
					_check_i = 11 - _check_i;
					_check_i = _check_i % 10;
					if (_check_i == _j_27)
					{
						_return_b = true;
					}
				}
			}
		}
		catch (Exception ex)
		{
			System.out.println("Error from ValueUtil.checkKRJuminNO(). ex - " + ex.getMessage());
		}

		return _return_b;
	}

	/**
	 * <pre>
	 * 내용중에 포함된 주민번호를 체크하고 주민 번호가 있을경우 그 값을 리턴
	 * - 현재는 외국인 번호 체크 안됨
	 * </pre>
	 * 
	 * @param value 기준 문자열
	 * @param nonallowchar 허락되지 않은 문자 배열
	 * @return 기준 문자열에 허락되지 않은 문자가 있을 경우 해당 문자 리턴
	 */
	public static String checkKRJuminNOPattern(String value, boolean checkpattern, boolean checkfully)
	{
		String _return_s = "";

		boolean _inner_debugging_b = true;

		try
		{
			String _str_value = "";

			Pattern _pattern = null;
			Matcher _matcher = null;
			ArrayList<String> _id_group = new ArrayList<String>();

			/*
			 * 주민번호 Pattern Checker...
			 */
			if (checkpattern && _return_s.equals(""))
			{
				// 영자, 숫자를 제외한 모든 캐릭터를 지움
				_pattern = Pattern.compile("[\\x00-\\x2F\\x3A-\\x40\\x5B-\\x60\\x7B-\\x7F]");
				_matcher = _pattern.matcher(value);
				_str_value = _matcher.replaceAll("");
				if (_inner_debugging_b)
				{
					System.out.println("주민번호 패턴 체크 - " + _str_value);
				}

				_pattern = Pattern.compile("[0-9]{2}[0-1]{1}[0-9]{1}[0-3]{1}[0-9]{1}[1-4]{1}[0-9]{6}");
				_matcher = _pattern.matcher(_str_value);
				while (_matcher.find())
				{
					String _s = _matcher.group();
					if (_inner_debugging_b) System.out.println("getting id : " + _s);

					int _j_month = Integer.parseInt(_s.substring(2, 4));
					int _j_day = Integer.parseInt(_s.substring(4, 6));
					if (_j_month <= 0 || _j_month > 12)
					{
						continue;
					}
					else if (_j_day <= 0 || _j_day > 31)
					{
						continue;
					}
					else
					{
						_id_group.add(_s);
					}
				}

				for (int id_i = 0; id_i < _id_group.size(); id_i++)
				{
					if (checkKRJuminNO((String) _id_group.get(id_i)))
					{
						_return_s = (String) _id_group.get(id_i);
						if (_inner_debugging_b)
						{
							System.out.println("주민번호 있음[By pattern checking] : " + _return_s);
						}
						break;
					}
				}
			}

			/*
			 * 주민번호 fully Checker... - 숫자만을 추출하여 한글자씩 재귀 호출하여 체크
			 */
			if (checkfully && _return_s.equals(""))
			{
				// 숫자를 제외한 모든 캐릭터를 지움
				_pattern = Pattern.compile("\\D");
				_matcher = _pattern.matcher(value);
				_str_value = _matcher.replaceAll("");
				if (_inner_debugging_b)
				{
					System.out.println("주민번호 fully 체크 - " + _str_value);
				}

				int intPos = 0;

				for (int i = 0; i < _str_value.length(); i++)
				{
					intPos = Integer.parseInt(_str_value.substring(i, i + 1));
					if ((i > 5) && (1 <= intPos) && (intPos <= 4) && (i + 7) <= _str_value.length())
					{
						if (checkKRJuminNO(_str_value.substring((i - 6), (i + 7))))
						{
							_return_s = _str_value.substring((i - 6), (i + 7));
							if (_inner_debugging_b)
							{
								System.out.println("주민번호 있음[By fully checking] : " + _return_s);
							}
							break;
						}
					}
				}
			}
		}
		catch (Exception ex)
		{
			System.out.println("Error from ValueUtil.checkKRJuminNOPattern(). ex - " + ex.getMessage());
		}

		return _return_s;
	}

/**
	 * 기준 문자열에 허락되지 않은 문자 가 있는지 체크
	 * 
	 * @return 기준 문자열에 허락되지 않은 문자가 있을 경우 해당 문자 리턴
	 * @param value 기준 문자열 
	 * @param nonallowchar 허락되지 않은 문자 배열
	 * 
	 * 예)
	 * ValueUtil.checkNoneAllowChar("test%test", new char[]{'<', '>', ''', '%'}) --> "%"
	 * ValueUtil.checkNoneAllowChar("test%test", new char[]{'<', '>', ''', '%'}) --> ""
	 */
	public static String checkNoneAllowChar(String value, char[] nonallowchar)
	{
		String _return_nonallow = "";

		if (value.trim().length() > 0)
		{
			char[] _array = new char[value.trim().length()];
			for (int i = 0; i < value.trim().length(); i++)
			{
				_array[i] = value.trim().charAt(i);
			}

			outer:
			for (int i = 0; i < _array.length; i++)
			{
				for (int j = 0; j < nonallowchar.length; j++)
				{
					if (_array[i] == nonallowchar[j])
					{
						if (nonallowchar[j] == ' ')
						{
							_return_nonallow = "space";
						}
						else
						{
							_return_nonallow = String.valueOf(nonallowchar[j]);
						}

						break outer;
					}
				}
			}
		}

		return _return_nonallow;
	}

	/**
	 * <pre>
	 * Entity class 내에 있는 변수 는 DB의 Column 과 밀접한 연관이 있게 된다.
	 * 이러한 Field 는 GUI의 특정 TextFiled에 표현되어야 하는 경우도 많으며
	 * String Filed 의 필드가 null 일 경우 오류 및 화면상에 "null" 이 찍히는 것을 방지하기 위해
	 * 일일이 검사를 하는것은 코드 수를 늘리게 된다.
	 * 이러한 null 을 fix 하여 Entity 에 셋팅하는 기능을 담당한다.
	 * - Member 변수 중 Array 성격의 Object 가 있으면 재귀적으로 나아 가서 처리한다. 재귀적으로 추적되는 만큼, 부모와 자식간에 서로 양방향 reference 를 갖고 있으면 Stack Overflow를 발생 시키고 이는 JVM 의 다운을 유발하게 된다.
	 * - String형을 blank string("")으로 만들어 준다.
	 * </pre>
	 * 
	 * @return void
	 * @param obj 엔티티 클래스
	 * @param istoarray 엔티티 클래스
	 */
	@SuppressWarnings("rawtypes")
	public static void fixNull(Object obj, boolean istoarray)
	{
		if (obj != null)
		{
			Class _class = obj.getClass();
			// 클래스가 원시형이 아니라면
			if (!_class.isPrimitive())
			{
				if (_class.isArray())
				{
					if (istoarray)
					{
						int _length = Array.getLength(obj);
						for (int i = 0; i < _length; i++)
						{
							Object _obj = Array.get(obj, i);
							ValueUtil.fixNull(_obj, istoarray);
						}
					}
				}
				else
				{
					Field[] fields = _class.getFields();
					for (int i = 0; i < fields.length; i++)
					{
						try
						{
							Class _field_type = fields[i].getType();
							Object _field_value = fields[i].get(obj);
							// 필드가 원시형이 아니라면
							if (!_field_type.isPrimitive())
							{
								if (_field_type.getName().indexOf("String") >= 0)
								{
									if (_field_value == null)
									{
										fields[i].set(obj, "");
									}
									else
									{
										fields[i].set(obj, _field_value);
									}
								}
							}
						}
						catch (Exception e)
						{}
					}
				}
			}
		}
	}

	/**
	 * @return boolean 입력값이 null, "null"(대소문자 구분 없음, trim 함) 이면 true 반환
	 * @param value 입력값
	 */
	public static boolean isNull(Object obj)
	{
		boolean _return = false;

		if (obj == null)
		{
			_return = true;
		}
		else
		{
			if (obj instanceof String && (((String) obj).trim().equals("") || ((String) obj).trim().equalsIgnoreCase("null")))
			{
				_return = true;
			}
		}

		return _return;
	}

	/**
	 * 넘어온 데이터가 숫자인지 체크
	 * 
	 * @return boolean 입력값이 null, "null"(대소문자 구분 없음, trim 함) 이면 true 반환
	 * @param value 입력값
	 */
	public static boolean isNumber(Object obj)
	{
		boolean _return = false;

		try
		{
			if (obj != null)
			{
				if (obj instanceof String && ((String) obj).trim().equalsIgnoreCase("null"))
				{
					_return = true;
				}
			}
		}
		catch (Exception ex)
		{}

		return _return;
	}

	/**
	 * @return boolean 입력값이 null 이 아니고 "true", "yes", "t", "y"(대소문자 구분 없음, trim 함)이면 true 반환
	 * @param value 입력값
	 */
	public static boolean isTrue(Object obj)
	{
		boolean _return = false;

		if (!isNull(obj))
		{
			if (obj instanceof String)
			{
				if (((String) obj).trim().equalsIgnoreCase("true") || ((String) obj).trim().equalsIgnoreCase("yes") || ((String) obj).trim().equalsIgnoreCase("t")
						|| ((String) obj).trim().equalsIgnoreCase("y"))
				{
					_return = true;
				}
			}
		}

		return _return;
	}
}
