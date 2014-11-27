package kr.co.mvss.util;



import java.util.StringTokenizer;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtil
{
	/**
	 * <pre>
	 * 문자열의 일부분을 랜덤하게 Asterisk 로 치환
	 * 주의)
	 * 1. 화면상에 표현되는 정보에 사용할 경우 반복된 조회(조회시 마다 * 처리되는 부분이 다르므로)를 통해 모든 문자열을 알아낼수 있으므로 사용에 유의한다.
	 * - 로그인한 유저가 자신의 정보를 조회할때는 자신의 정보를 안다는 전제 조건이 성립된다. 이러한 경우 일부 정보는 로그인한 사람도 * 처리하여 보여주는 부분이 필요할때 사용한다.
	 * - 카드정보 / 로그인 ID 정보 등등 
	 *  
	 * 예)
	 * makeAsterisk("Test User ID") --> "T*st Us** **"
	 * makeAsterisk("Test User ID") --> "*est Us****D"
	 * makeAsterisk("Test User ID") --> "***t*U******"
	 * makeAsterisk("Test User ID") --> "***t**se**ID"
	 * makeAsterisk("Test User ID") --> "T*st*User***"
	 * makeAsterisk("720309-1234567") --> "*20*09**2*456*"
	 * makeAsterisk("720309-1234567") --> "720*09*12*4*6*"
	 * makeAsterisk("720309-1234567") --> "7*03****2**567"
	 * makeAsterisk("720309-1234567") --> "*2**09*1*3**67"
	 * makeAsterisk("720309-1234567") --> "****0*-**3**67"
	 * </pre>
	 * 
	 * @param value
	 * @return
	 */
	public static String makeAsterisk(String value)
	{
		String _format = "";
		value = getString(value);

		if (value.length() == 1)
		{
			_format = "*";
		}
		else
		{
			for (int i = 0; i < value.length(); i++)
			{
				_format += (RandomUtil.getBoolean()) ? "*" : "s";
			}
		}

		return makeAsterisk(value, _format);
	}

	/**
	 * <pre>
	 * 예)
	 * makeAsterisk(null, "ss**") --> ""
	 * makeAsterisk("", "ss**") --> ""
	 * makeAsterisk(" ", "ss**") --> ""
	 * makeAsterisk("720309-1234567", "sssssss*******") --> "720309-*******"
	 * makeAsterisk("720309-1234567", "sssssSS*******") --> "" / Error from StringUtil.format(). ex - format 은 's', '*' 만 허용됩니다. - 입력된 format 값 : sssssSS*******
	 * makeAsterisk("Test User ID", "ssss****") --> "Test****r ID" / 포맷이 value 값보다 작을 경우
	 * makeAsterisk("Test User ID", "ssssssssssss****") --> "" / Error from StringUtil.format(). ex - format 은 1개 이상의 '*' 를 포함해야 합니다. - 입력된 format 값 : ssssssssssss**** / value 값의 길이에 맞춰 가공된 format 값 : ssssssssssss
	 * makeAsterisk("Test User ID", "ss**ss**") --> "Te** U**r ID"
	 * makeAsterisk("Test User ID", "ss**ss**ss**ss**ss**") --> "Te** U**r **"
	 * </pre>
	 * 
	 * @param value
	 * @param format
	 * @return
	 */
	public static String makeAsterisk(String value, String format)
	{
		String _return = "";

		try
		{
			if (!isBlank(value))
			{
				if (isBlank(format))
				{
					throw new Exception("format 값이 없습니다.");
				}
				else
				{
					// s, * 를 제외한 모든 캐릭터를 지움
					String _check_format = "";
					Pattern _pattern = Pattern.compile("[^s|^\\*]");
					Matcher _matcher = _pattern.matcher(format);
					_check_format = _matcher.replaceAll("");

					if (format.trim().length() != _check_format.trim().length())
					{
						throw new Exception("format 은 's', '*' 만 허용됩니다. - 입력된 format 값 : " + format);
					}
					// 가공된 format 체크
					if (_check_format.indexOf('*') == -1)
					{
						throw new Exception("format 은 1개 이상의 '*' 를 포함해야 합니다. - 입력된 format 값 : " + format);
					}

					if (value.length() > _check_format.length())
					{
						// value 값이 format 보다 크다면 value 길이에 맞춰 format 뒤에 's' 를 붙인다.
						_check_format = padding(_check_format, value.length(), false, 's', true);
					}
					else if (value.length() < _check_format.length())
					{
						// value 값이 format 보다 작다면 value 길이에 맞춰 format 을 자른다.
						_check_format = _check_format.substring(0, value.length());
					}

					// 가공된 format 재체크
					if (_check_format.indexOf('*') == -1)
					{
						throw new Exception("format 은 1개 이상의 '*' 를 포함해야 합니다. - 입력된 format 값 : " + format + " / value 값의 길이에 맞춰 가공된 format 값 : " + _check_format);
					}

					// format 에 맞춰 value 가공
					for (int i = 0; i < _check_format.length(); i++)
					{
						if (_check_format.charAt(i) == 's')
						{
							_return += value.charAt(i);
						}
						else
						{
							_return += _check_format.charAt(i);
						}
					}
				}
			}
		}
		catch (Exception ex)
		{
			System.out.println("Error from StringUtil.format(). ex - " + ex.getMessage());
		}
		return _return;
	}

	/**
	 * <pre>
	 * 인수1 이 인수2 와 같은 경우 인수3 을 반환
	 * 
	 * 예)
	 * decode("test", "", "1"); --> test 
	 * decode("test", null, "1"); --> test 
	 * decode(null, "", "1"); --> null 
	 * decode(null, null, "1"); --> 1 
	 * decode("test", "test", "1"); --> 1 
	 * decode("", "", "1"); --> 1
	 * </pre>
	 * 
	 * @param value 문자열
	 * @param from 문자열과 비교할 값
	 * @param to 바뀔 문자열
	 * @return 변환된 문자역
	 */
	public static String decode(String value, String from, String to)
	{
		String _return = value;
		if (value == from || value.equals(from))
		{
			_return = to;
		}
		return _return;
	}

	/**
	 * <pre>
	 * 문자열에서 숫자만 얻어낸다.
	 * 
	 * 예)
	 * StringUtil.getOnlyNumber("test1test2") --> 12
	 * </pre>
	 * 
	 * @see #getString(String)
	 * @param value 입력문자열
	 * @return 변환된 문자열(숫자로만 구성)
	 */
	public static String getOnlyNumber(String value)
	{
		try
		{
			value = getString(value);
			Pattern _pattern = null;
			Matcher _matcher = null;
			_pattern = Pattern.compile("\\D"); // \D는 비숫자 를 의
			_matcher = _pattern.matcher(value);
			value = _matcher.replaceAll("");
		}
		catch (Exception ex)
		{
			System.out.println("Error from StringUtil.getOnlyNumber(). ex - " + ex.getMessage());
		}
		return value;
	}

	/**
	 * <pre>
	 * null을 none("")으로 변환 
	 * - getString 이라는것은 어떤 입력이더라도 String 을 받겠다는 의미이다. 즉, String 이 아닌것은 null 뿐이며 이때 반환할 String 은 "" 이 합당하다.
	 * 
	 * 예)
	 * getString("test"); --> test 
	 * getString(" "); --> " "
	 * getString(""); --> ""
	 * getString(null); --> ""
	 * </pre>
	 * 
	 * @see #decode(String, String, String)
	 * @param value 입력문자열
	 * @return 변환된 문자열
	 */
	public static String getString(String value)
	{
		return decode(value, null, "");
	}

	/**
	 * <pre>
	 * 입력 값이 있으면 그대로 없으면 기본값 반환 
	 * - 기본값을 가진다는 의미는 '입력문자열의 값이 없다면 기본값으로' 해석 가능하다. 이때, 값이 없다는것은 null 과 "" 에 해당할것이다.
	 * 
	 * 예)
	 * getString("test", "") --> test
	 * getString(" ", "") --> " "
	 * getString("", "") --> ""
	 * getString(null, "") --> ""
	 * getString("test", "1") --> test
	 * getString(" ", "1") --> " "
	 * getString("", "1") --> 1
	 * getString(null, "1") --> 1
	 * </pre>
	 * 
	 * @see #decode(String, String, String)
	 * @param value 입력문자열
	 * @return 변환된 문자열
	 */
	public static String getString(String value, String defaultvalue)
	{
		return decode(decode(value, null, defaultvalue), "", defaultvalue);
	}

	/**
	 * <pre>
	 * 아무값도 없는지 여부 
	 * - Blank 의미는 텅빈/값이 없다는 것이다. 즉, 값이 없다는것은 null("null" 포함) 과 "", " " 에 해당할것이다.
	 * 
	 * 예)
	 * isBlank(null, false) --> true
	 * isBlank("null", false) --> true
	 * isBlank("NULL", false) --> true
	 * isBlank("", false) --> true
	 * isBlank(" ", false) --> false
	 * isBlank("test", false) --> false
	 * </pre>
	 * 
	 * @see ValueUtil#isNull(Object)
	 * @param value 입력값이 null, ""(trim 적용 여부는 인수에 의해 적용) 이면 true 반환
	 * @param istrim 입력값을 trim 할것인지 여부
	 * @return
	 */
	public static boolean isBlank(String value, boolean istrim)
	{
		if (ValueUtil.isNull(value))
		{
			return true;
		}
		else
		{
			if (istrim)
			{
				value = value.trim();
			}
			return (value.length() == 0);
		}
	}

	/**
	 * <pre>
	 * 예)
	 * isBlank(null) --> true
	 * isBlank("null") --> true
	 * isBlank("NULL") --> true
	 * isBlank("") --> true
	 * isBlank(" ") --> true
	 * isBlank("test") --> false
	 * </pre>
	 */
	public static boolean isBlank(String value)
	{
		return isBlank(value, true);
	}

	/**
	 * <pre>
	 * 문자열 배열을 주어진 separator 로 연결하여 문자열을 생성한다
	 * <br>
	 * 
	 * 예)
	 * join(new String[]{"test", "test"}, "-") --> test-test
	 * </pre>
	 * 
	 * @see #getString(String)
	 * @param value 문자열 배열
	 * @param couplechar 중간 연결자
	 * @return 합쳐진 문자열
	 */
	public static String join(String[] value, String couplevalue)
	{
		StringBuffer _return = new StringBuffer();
		for (int i = 0; i < value.length; i++)
		{
			if (i > 0)
			{
				_return.append(getString(couplevalue));
			}
			_return.append(getString(value[i]));
		}
		return _return.toString();
	}

	/**
	 * <pre>
	 * 예)
	 * join(new String[]{"test", "test"}) --> testtest
	 * </pre>
	 * 
	 * @see #join(String[], String)
	 */
	public static String join(String[] value)
	{
		return join(value, "");
	}

	/**
	 * <pre>
	 * 캐릭터로 주어진 길이만큼 문자열 생성
	 * 
	 * 예)
	 * make('*', 5) --> *****
	 * </pre>
	 */
	public static String make(char value, int length)
	{
		String _return = "";
		if (length > 0)
		{
			for (int i = 0; i < length; i++)
			{
				_return += value;
			}
		}
		return _return;
	}

	/**
	 * <pre>
	 * 특정 캐릭터를 찾아 두개로 만든다.
	 * </pre>
	 * 
	 * @param value 기준 문자열
	 * @param charvalue 두개로 만들 캐릭
	 * @return 가공된 문자열
	 */
	public static String makeDouble(String value, char charvalue)
	{
		StringBuffer _return = new StringBuffer(value);
		for (int i = 0; i < _return.length(); i++)
		{
			if (_return.charAt(i) == charvalue)
			{
				_return.replace(i, i + 1, String.valueOf(charvalue) + String.valueOf(charvalue));
				i++;
			}
		}
		return _return.toString();
	}

	/**
	 * <pre>
	 * DB에서 insert/update 와 같은 명령구문을 문자열로 작성할때 필드의 값에 특정 캐릭터(') 가 있다면 문제가 발생한다.이를 대비하여 '' 와 같이 연속으로 두개를 쓰게 되면 ' 로 들어가므로 이 메소드를 쓴다.
	 * </pre>
	 * 
	 * @see #makeDouble(String, char)
	 * @param value 기준 문자열
	 * @return 가공된 문자열
	 */
	public static String makeDoubleQuote(String value)
	{
		return makeDouble(value, '\'');
	}

	/**
	 * <pre>
	 * padding 가공된 문자열을 반환
	 * - 기준 문자의 길이가 length 보다 큰 경우 원본 문자열을 반환
	 * - 기준 문자의 길이가 length 보다 작은 경우 나머지 부분에 대해 주어진 캐릭터를 채워서 반환
	 * 
	 * 예) 
	 * padding("방송", 5, false, '대', true) --> 방송대대대 
	 * padding("방송", 5, true, '대', true) --> 방송 
	 * padding("방송", 6, false, '대', true) --> 방송대대대대 
	 * padding("방송", 6, true, '대', true) --> 방송대 
	 * padding("방송", 7, false, '대', true) --> 방송대대대대대 
	 * padding("방송", 7, true, '대', true) --> 방송대
	 * </pre>
	 * 
	 * @see #make(char, int)
	 * @param value 기준 문자
	 * @param length 리턴될 문자열 전체 길이
	 * @param lengthbybyte 기준문자 와 캐릭터의 길이를 byte 로 체크할것인지 여부
	 * @param paddingchar 주어진 길이를 채우는데 사용할 캐릭터
	 * @param toright 기준 문자의 오른쪽에 채울지 여부, false 일 경우 문자열 앞(왼쪽)에 붙인다.
	 * @return 가공된 문자열
	 */
	public static String padding(String value, int length, boolean lengthbybyte, char paddingchar, boolean toright)
	{
		String _return = "";
		if (value != null)
		{
			int _length = 0;
			if (lengthbybyte)
			{
				_length = value.getBytes().length;
			}
			else
			{
				_length = value.length();
			}
			if (_length < length)
			{
				_return = make(paddingchar, (length - _length) / ((lengthbybyte && (String.valueOf(paddingchar).getBytes().length == 2)) ? 2 : 1));
				if (toright)
				{
					_return = value + _return;
				}
				else
				{
					_return = _return + value;
				}
			}
			else
			{
				_return = value;
			}
		}
		return _return;
	}

	/**
	 * <pre>
	 * 기준 문자열의 길이가 주어진 길이보다 작은 경우 앞에 '0'을 패딩한다.
	 * </pre>
	 * 
	 * @see #padding(String, int, char, boolean)
	 */
	public static String paddingZero2Left(String value, int length)
	{
		return padding(value, length, false, '0', false);
	}

	/**
	 * <pre>
	 * 기준 문자열의 길이가 주어진 길이보다 작은 경우 뒤에 '0'을 패딩한다.
	 * </pre>
	 * 
	 * @see #padding(String, int, char, boolean)
	 */
	public static String paddingZero2Right(String value, int length)
	{
		return padding(value, length, false, '0', true);
	}

	/**
	 * <pre>
	 * 문자열을 주어진 최대 길이(byte 길이) 로 줄인다.
	 * - 문자열이 최대 길이에 못 미치는 경우 그대로 반환
	 * - 문자열이 최대 길이를 넘는 경우 적절히 자르고 뒤에 접미사를 붙인다.
	 * - 웹 화면에서 문장을 표시할때 너무 길면 뒤에 ... 를 붙여서 표현한다. 이때 한글/영문 구분 없이 캐릭터 길이로 자르면 화면상에 표현되는 그 넓이가 일정하지 못하므로 이때 사용한다. 
	 * 예)
	 * StringUtil.reduce("test", "...", 9) --> test
	 * StringUtil.reduce("testtesttest", "...", 9) --> testtestt...
	 * StringUtil.reduce("test테스트", "...", 9) --> test테스트...
	 * StringUtil.reduce("테스트테스트", "...", 9) --> 테스트테스...
	 * </pre>
	 * 
	 * @param value 기준 문자열
	 * @param suffix 접미사
	 * @param bytemaxlen 바이트 최대 길이
	 * @return 가공된 문자열
	 */
	public static String reduce(String value, String suffix, int bytemaxlen)
	{
		String _return = "";
		value = getString(value);
		if (value.getBytes().length > bytemaxlen)
		{
			String _s = "";
			int _added_byte_count = 0;
			for (int i = 0; i < value.length(); i++)
			{
				_s = String.valueOf(value.charAt(i));
				_return += _s;
				_added_byte_count += _s.getBytes().length;
				if (_added_byte_count >= bytemaxlen)
				{
					break;
				}
			}
			_return += suffix;
		}
		else
		{
			_return = value;
		}
		return _return;
	}

	/**
	 * <pre>
	 * 원본문자열 에서 제거할 문자열을 찾아 제거한다.
	 * </pre>
	 * 
	 * @param value 기준 문자열
	 * @param removevalue 제거할 문자열
	 * @return 변환된 문자열
	 */
	public static String remove(String value, String removevalue)
	{
		StringBuffer _return = new StringBuffer();
		StringTokenizer _token = new StringTokenizer(value, removevalue);
		while (_token.hasMoreTokens())
		{
			_return.append(_token.nextToken());
		}
		return _return.toString();
	}

	/**
	 * <pre>
	 * 원본문자열 에서 제거할 캐릭터 를 찾아 제거한다.
	 * </pre>
	 * 
	 * @see #remove(String, String)
	 */
	public static String remove(String value, char removevalue)
	{
		return remove(value, String.valueOf(removevalue));
	}

	/**
	 * <pre>
	 * 원본문자열 에서 제거할 문자열을 찾아 마지막 값만 제거한다.
	 * </pre>
	 * 
	 * @param value 기준 문자열
	 * @param removevalue 제거할 문자열
	 * @return 변환된 문자열
	 */
	public static String removeLast(String value, String removevalue)
	{
		String _return = "";
		if (value != null)
		{
			int _pos = value.lastIndexOf(removevalue);
			if (_pos == -1)
			{
				_return = value;
			}
			else
			{
				_return = value.substring(0, _pos) + value.substring(_pos + 1);
			}
		}
		return _return;
	}

	/**
	 * @see #removeLast(String, String)
	 */
	public static String removeLast(String value, char removevalue)
	{
		return removeLast(value, String.valueOf(removevalue));
	}

	/**
	 * <pre>
	 * 문자열 변경
	 * 
	 * 예)
	 * StringUtil.replace("tststststst", "tst", "11111111111111tst") --> 11111111111111tsts11111111111111tsts11111111111111tst
	 * </pre>
	 * 
	 * @see #getString(String)
	 * @param value 원본 문자열
	 * @param oldvalue 변경할 특정 문자열
	 * @param newvalue 대체할 특정 문자열
	 * @return 변환된 문자열
	 */
	public static String replace(String value, String oldvalue, String newvalue)
	{
		value = getString(value);
		for (int index = 0; (index = value.indexOf(oldvalue, index)) >= 0; index += newvalue.length())
		{
			value = value.substring(0, index) + newvalue + value.substring(index + oldvalue.length());
		}
		return value;
	}

	/**
	 * <pre>
	 * 예)
	 * StringUtil.replace("tststststst", 's', '1') --> t1t1t1t1t1t
	 * </pre>
	 */
	public static String replace(String value, char oldvalue, char newvalue)
	{
		return replace(value, String.valueOf(oldvalue), String.valueOf(newvalue));
	}

	/**
	 * <pre>
	 * 대상문자열 검색할 문자열이 검색된 횟수를 반환 - 검색할 문자열이 없으면 0 을 반환 - 검색이 완료된 위치 다음부터 검색하므로 중복은 허용되지 않는다.
	 * 
	 * 예)
	 * searchCount("aaaaa", "a") --> 5 
	 * searchCount("aaaaa", "aa") --> 2 
	 * searchCount("aaaaa", "aaa") --> 1 
	 * searchCount("aaaaa", "aaaa") --> 1
	 * </pre>
	 * 
	 * @param value 대상문자열
	 * @param searchvalue 검색할 문자열
	 * @return 검색된 횟수
	 */
	public static int searchCount(String value, String searchvalue)
	{
		int _return = 0;
		String _s = getString(value);
		for (int i = 0; i < value.length();)
		{
			int _loc = _s.indexOf(searchvalue);
			if (_loc == -1)
			{
				break;
			}
			else
			{
				_return++;
				i = _loc + searchvalue.length();
				_s = _s.substring(i);
			}
		}
		return _return;
	}

	/**
	 * <pre>
	 * 입력문자열을 주어진 separator 로 쪼개어 문자배열을 반환
	 * 
	 * 예)
	 * split("foo|+:|+:bo|+:o|+:", "|+:", false) --> {"foo", "", "bo", "o", ""} 
	 * split("foo|+:|+:bo|+:o|+:", "|+:", true) --> {"foo", "bo", "o"}
	 * </pre>
	 * 
	 * @param value 원본문자열
	 * @param separator 원하는 token 문자열
	 * @param isskipnone 빈문자열("") 을 skip 할것인지 여부
	 * @return 쪼개진 값 배열
	 */
	public static String[] split(String value, String separator, boolean isskipnone)
	{
		String[] _return = null;
		if (!isskipnone)
		{
			int _index = 0;
			_return = new String[searchCount(value, separator) + 1];
			String _s = getString(value);
			while (_s.length() != 0)
			{
				int begin = _s.indexOf(separator);
				if (begin == -1)
				{
					_return[_index] = _s;
					break;
				}
				else
				{
					int end = begin + separator.length();
					_return[_index++] = _s.substring(0, begin);
					_s = _s.substring(end);
					if (_s.length() == 0)
					{
						_return[_index] = _s;
						break;
					}
				}
			}
		}
		else
		{
			StringTokenizer _st = new StringTokenizer(value, separator);
			_return = new String[_st.countTokens()];
			int _pos = 0;
			while (_st.hasMoreTokens())
			{
				_return[_pos++] = _st.nextToken();
			}
		}
		return _return;
	}

	/**
	 * @see #split(String, String, boolean)
	 */
	public static String[] split(String value, String separator)
	{
		return split(value, separator, true);
	}

	/**
	 * <pre>
	 * 아주 긴 문자열을 주어진 byte 길이로 나누어서 반환
	 * </pre>
	 * 
	 * @param value 기준 문자열
	 * @param maxbytelength 문자열을 자를 byte 길
	 * @return 배열
	 */
	public static Vector<String> splitByLen(String value, int maxbytelength)
	{
		Vector<String> _return = new Vector<String>();
		StringBuffer _sb = new StringBuffer();
		char _c;
		int _byte_len = 0;
		int _plus_byte_len;
		for (int i = 0; i < value.length(); i++)
		{
			_c = value.charAt(i);
			if (_c < 0xac00 || 0xd7a3 < _c)
			{
				_plus_byte_len = 1;
			}
			else
			{
				_plus_byte_len = 2; // 한글
			}
			if (_byte_len + _plus_byte_len > maxbytelength)
			{
				// 지금까지의 값 저장
				_return.add(_sb.toString());
				// 초기화
				_sb = new StringBuffer();
				_byte_len = _plus_byte_len;
			}
			else
			{
				_byte_len += _plus_byte_len;
			}
			_sb.append(_c);
		}
		// 마지막 값을 셋팅
		if (_sb.toString().length() > 0)
		{
			_return.add(_sb.toString());
		}
		return _return;
	}

	/**
	 * <pre>
	 * 첫문자가 영문대문자 일 경우 영문소문자로 변환
	 * </pre>
	 * 
	 * @param value 입력문자열
	 * @return 변환된 문자열
	 */
	public static String toLower1stChar(String value)
	{
		String _return = value;
		char _1st = value.charAt(0);
		String _2nd = value.substring(1);
		if (_1st >= 'A' && _1st <= 'Z')
		{
			_return = String.valueOf(_1st).toLowerCase() + _2nd;
		}
		return _return;
	}

	/**
	 * <pre>
	 * 첫문자가 영문소문자 일 경우 영문대문자로 변환
	 * </pre>
	 * 
	 * @param value 입력문자열
	 * @return 변환된 문자열을 리턴한다
	 */
	public static String toUpper1stChar(String value)
	{
		String _return = value;

		try
		{
			char _1st = value.charAt(0);
			String _2nd = value.substring(1);
			if (_1st >= 'a' && _1st <= 'z')
			{
				_return = String.valueOf(_1st).toUpperCase() + _2nd;
			}
		}
		catch (Exception ex)
		{}
		return _return;
	}

	/**
	 * <pre>
	 * 문자열로 변환한다.
	 * </pre>
	 * 
	 * @param obj 입력
	 * @return 변환된 값
	 */
	public static String toString(Object obj)
	{
		return String.valueOf(obj);
	}

	/**
	 * <pre>
	 * Vector[String] 정보를 String[] 로 반환
	 * </pre>
	 * 
	 * @param arrayvalues Vector 정보
	 * @return 스트링 배열 형태
	 */
	public static String[] vector2strings(Vector<String> arrayvalues)
	{
		String[] _return = null;
		if (arrayvalues != null && arrayvalues.size() > 0)
		{
			_return = new String[arrayvalues.size()];
			arrayvalues.copyInto(_return);
		}
		return _return;
	}
}
