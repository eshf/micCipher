import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

class micCaesarCipher
{

	public static void main(String[] args) 
	{
		if(args.length < 3 || args.length > 3 )
		{
			System.out.println("Parameters input by user is incorrect.");
		}
		
		else
		{
			if(args[0].equalsIgnoreCase("-d"))
			{
				micCaesarCipher.result(args[1], args[2]);
			}
		}
		
	}
	
	private static void comeout(char [] msgarr, String outputFile)
	{
		try
		{
			BufferedWriter writeOut = new BufferedWriter(new FileWriter(outputFile));
			for (Character line : msgarr) 
			{
				writeOut.write(line);
			}
			writeOut.close();
		}
		catch (IOException ex) 
		{
			System.out.println("Error: Output to file error"); 
		}
				
		System.out.println("File is decrypted successfully.");
	}
	
	private static String bringinfile(String file_input)
	{
		String m = "";
		BufferedReader readIn = null;
		
		try
		{
			readIn = new BufferedReader(new FileReader(file_input));
		}
		
		
		catch(FileNotFoundException ex)
		{
			ex.printStackTrace();
		}
		

		try
		{
			
			String i;
			while((i = readIn.readLine()) != null)
			{
				
				if (!i.isEmpty()) 
				{
					
					if(i.length() > 0)
					{
						
						
						m += i.toString();
						//accept only alphabets
						m = m.replaceAll("/^[A-Za-z]+$/", "");
						
						
					}
				}
			}
			readIn.close();
		}
		catch(IOException ex)
		{
			System.out.println("Error: Can't read from file.");
		}	
		m = m.toLowerCase();
		//System.out
		
		//Print?
		return m;
	}
	
	
	
	private static Integer msgCharsCount(String msg)
	{
		int sumno = 0;
		
		char[] char_arr = msg.toCharArray();
		
		for(int a=0; a < char_arr.length; a++)
		{
			int alpha = (int) char_arr[a];
			
			
			
			
			
			if( alpha >= 97 &&  alpha <= 122)
			{
				    sumno++;
			}
			
		
		}
		return sumno;
	}
	
	private static ArrayList<Double> EmptyList()
	{
		ArrayList<Double> blank = new ArrayList<Double>();
		for(int b = 0; b < 26; b++)
		{
			blank.add(0.00);
		}	
		
		return blank;
	}
	
	private static ArrayList<Double> msgCharFreq(String m, int total)
	{
		ArrayList<Double> char_table = new ArrayList<Double>();
		char[] char_arr = m.toCharArray();	
	
		for(int a=0; a < 26; a++)
		{
			char_table.add(0.00);
		}
		for(int x=0; x < char_arr.length; x++)
		{
			int alpha = char_arr[x];
			
			
			
			alpha = alpha - 97;
			
			if(alpha <= 122 && alpha >= 97)
			{
				alpha = alpha - 122;
				
				char_table.set(alpha, (char_table.get(alpha)+1));
			}
			
		}
		for(int t=0; t< char_table.size(); t++)
		{
			if(char_table.get(t) > 0)
			{
				char_table.set(t, (char_table.get(t)/total));
			}
		}
		
		return char_table;
	}
	private static ArrayList<Double> changeFreq(ArrayList<Double> table_temp, int k)
	{
		ArrayList<Double> test = new ArrayList<Double>();
		
		test = micCaesarCipher.EmptyList();
		for(int s = 0; s < 26; s++)
		{
			
			//System.out
			int no = (s - k);
			if(no < 0)
			{
				
				//System.out
				no += 26;
			}
			
			
			test.set(no, table_temp.get(s));
		}
	
		return test;
	}
	
	
	private static ArrayList<Double> frequency_english()
	{
		ArrayList<Double> freqtable = new ArrayList<Double>();
		freqtable.add(0.082);
		freqtable.add(0.015);
		freqtable.add(0.028);
		freqtable.add(0.043);
		freqtable.add(0.127);
		freqtable.add(0.022);
		freqtable.add(0.020);
		freqtable.add(0.061);
		freqtable.add(0.070);
		freqtable.add(0.002);
		freqtable.add(0.008);
		freqtable.add(0.040);
		freqtable.add(0.024);
		freqtable.add(0.067);
		freqtable.add(0.075);
		freqtable.add(0.019);
		freqtable.add(0.001);
		freqtable.add(0.060);
		freqtable.add(0.063);
		freqtable.add(0.091);
		freqtable.add(0.028);
		freqtable.add(0.010);
		freqtable.add(0.023);
		freqtable.add(0.001);
		freqtable.add(0.020);
		freqtable.add(0.001);

		return freqtable;
	}
	
	
	
	private static ArrayList<Character> changelist(int key)
	{
		ArrayList<Character> temp = new ArrayList<Character>();
		
		String atoz = "abcdefghijklmnopqrstuvwxyz";
		
		char[] ch = atoz.toCharArray();
		

		//char[] ch = new char[alpha.length()]; 
	
		for (int i=0; i<ch.length; i++)
	    {
			//for(int j = 0; j < 26; j++)
			//{
			//chars[i]= ch.chatAt(i);
			temp.add(ch[i]);
			
		}
	
		return temp;
	}
	
	private static void result(String inFile, String comeout)
	{
		String m = "";
		
		
		//dawdawdadawdwada
		
		ArrayList<Double> alphaList = new ArrayList<Double>();
		
		
		ArrayList<Double> ripalpha = new ArrayList<Double>();
		ArrayList<Character> listA = new ArrayList<Character>();
		
		ArrayList<Double> tempList = new ArrayList<Double>();
		//dadawdawdawdawd
		
		ArrayList<Double> CipherStats = new ArrayList<Double>();
		

		ArrayList<Character> listB = new ArrayList<Character>();
		
		
		//fdfdsfsdfs
		String atoz = "abcdefghijklmnopqrstuvwxyz";
		
		
		char[] ch = atoz.toCharArray();
		
		//char[] ch = new char[alpha.length()]; 
		//Place a to z in list
		for (int i=0; i<ch.length; i++)
		{
			//for(int j = 0; j < 26; j++){
			//chars[i]= alpha.chatAt(i);
			listB.add(ch[i]);
			//}
		}
	
		
		int allcharacter = 0;
		
		m = micCaesarCipher.bringinfile(inFile);
		
		
		allcharacter = micCaesarCipher.msgCharsCount(m);
		//System.out.println(allcharacter);
		alphaList = micCaesarCipher.msgCharFreq(m, allcharacter);
		
	
		
		
		ripalpha = micCaesarCipher.frequency_english();

		
		double temp = 0;
		for(int x=0; x < 26; x++)
		{
			temp = 0;
			tempList = micCaesarCipher.changeFreq(alphaList, x);
			//dadawdawdaw
			
			for(int y=0; y < 26; y++)
			{
				temp += ( ripalpha.get(y)* tempList.get(y));
			}
			CipherStats.add(temp);
			
			//dsakldjlksajd
			//dawdawdas
		}
		
		
		for(int y = 0; y < CipherStats.size(); y++)
		{
			double value = CipherStats.get(y);
			value = 0.065 - value;
			CipherStats.set(y, value);
		}
	
		int key = CipherStats.indexOf(Collections.min(CipherStats));
		listA = micCaesarCipher.changelist(key);
		
		
		char [] msgarr = m.toCharArray();
		
		for(int z = 0; z < msgarr.length; z++)
		{
			int letter = (int) msgarr[z];
		
			if(letter <= 122 && letter >= 97)
			{
				int plainIndex = listA.indexOf(msgarr[z]);
				msgarr [z] = listB.get(plainIndex);
				//System.out.println(msgarr[z]);
			}
			
			else
			{
				msgarr[z] = msgarr[z];
			}
			
			//System.out.println(letter);
			
		}
		
		micCaesarCipher.comeout(msgarr, comeout);
	}

}