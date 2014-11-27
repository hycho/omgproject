package kr.co.mvss.util;



import java.util.Random;

/**
 * 랜덤 처리와 관련된 메소드 모음
 * 
 * @author hun-jung, Park / 2010-11 / 초기 작성
 */
public class RandomUtil
{
	private static final Random RANDOM_OBJ = new Random();

	/*
	 * 숫자 0 은 없음 - 영문 O 와 혼동이 되므로 - 불특정 값을 가져 오는것이 목적이므로 꼭 0 이 있어야 할 이유는 없다
	 */
	private static final char[] CHARACTERS = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	private static final char[] NUMBERS = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	public static boolean getBoolean()
	{
		return RANDOM_OBJ.nextBoolean();
	}

	public static int getNumber(int limitno)
	{
		return RANDOM_OBJ.nextInt(limitno);
	}

	public static String getString(int valuelength, boolean isonlynumber)
	{
		StringBuffer _return = new StringBuffer();
		if (isonlynumber)
		{
			for (int i = 0; i < valuelength; i++)
			{
				_return.append(NUMBERS[RANDOM_OBJ.nextInt(NUMBERS.length)]);
			}
		}
		else
		{
			for (int i = 0; i < valuelength; i++)
			{
				_return.append(CHARACTERS[RANDOM_OBJ.nextInt(CHARACTERS.length)]);
			}
		}
		return _return.toString();
	}

	public static String getString(int valuelength)
	{
		return getString(valuelength, false);
	}
}
