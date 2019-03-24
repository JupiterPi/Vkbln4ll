package jupiterpi.vkbln4ll.filetool;

import java.util.*;
import java.io.*;
import javax.swing.*;
import jupiterpi.vkbln4ll.*;

public class FileToolForVkbln4ll
{
	private String fileName;
	private ArrayList file = new ArrayList();

	private ConsoleOutput out = new ConsoleOutput();
	
	public FileToolForVkbln4ll (String fileName) throws IOException, CreatedNewFileException, EmptyFileException
	{
		this.fileName = fileName;

		File fileForCreating = new File (fileName);
		if (fileForCreating.createNewFile()) throw new CreatedNewFileException();
		
		BufferedReader Reader = new BufferedReader (new FileReader (fileName));
		boolean fileEnd = false;

		boolean empty = true;
		
		while (!fileEnd)
		{
			String line = Reader.readLine();
			if (line == null) fileEnd = true;
			else
			{
				file.add (line);
				empty = false;
			}
		}
		Reader.close();

		if (empty) throw new EmptyFileException();
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