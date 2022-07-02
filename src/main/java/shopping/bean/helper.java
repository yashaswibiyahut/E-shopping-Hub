package shopping.bean;

public class helper {
	public static String get10words(String description)
	{
		String[] str=description.split(description);
		if(str.length>10)
		{
			String res="";
			for(int i = 0;i<50;i++)
			{
				res=res+str[i]+" ";
			}
			return (res+"...");
		}
		else
		{
			return (description+"...");
		}
		
	}

}
