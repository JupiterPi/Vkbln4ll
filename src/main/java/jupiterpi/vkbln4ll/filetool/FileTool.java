package jupiterpi.filetool;

import java.util.*;
import java.io.*;
import javax.swing.*;

public class FileTool
{
	private String fileName;
	private ArrayList file = new ArrayList();
	
	public FileTool (String fileName)
	{
		this.fileName = fileName;
		
		try
		{
			BufferedReader Reader = new BufferedReader (new FileReader (fileName));
			boolean fileEnd = false;
			
			while (!fileEnd)
			{
				String line = Reader.readLine();
				if (line == null) fileEnd = true;
				else file.add (line);
			}
			Reader.close();
		}
		catch (IOException x)
		{
			JOptionPane.showMessageDialog (null, "Can not load file " + fileName + ". ");
			System.exit (0);
		}
	}
	
	public ArrayList getFile ()
	{
		return file;
	}

	public String getFileForOutput ()
	{
		String returning = "";
		for (int i = 0; i < file.size(); i++)
		{
			if (i != file.size() - 1)
			{
				returning += file.get(i) + "\n";
			}
			else
			{
				returning += file.get(i);
			}
		}
		return returning;
	}

	public void setFile (ArrayList newFile)
	{
		this.file = newFile;
	}
	
	public String getLine (int line)
	{
		return (String) file.get(line);
	}
	
	public void setLine (int line, String text)
	{
		file.set (line, text);
	}
	
	public void writeToLine (int line, String text)
	{
		this.setLine (line, this.getLine (line) + text);
	}
	
	public void saveFile ()
	{
		String input;
		try
		{
			BufferedWriter Writer = new BufferedWriter (new FileWriter (fileName));
			for (int i = 0; i < file.size(); i++)
			{
				Writer.write (file.get (i) + "\r\n");
			}
			Writer.close();
		}
		catch (IOException x)
		{
			input = JOptionPane.showInputDialog (null, "Can not write to file " + fileName + ". Cancel process? (Y/n)");
			if (input.equals ("Y"))
				System.exit (0);
			else if (!input.equals ("n"))
				JOptionPane.showMessageDialog (null, "No valid input. Please redo!");
		}
	}
}