package s;
import java.net.*;
import java.io.*;
import java.util.*;
    
public class s
{
    static ArrayList<Cli> v=new ArrayList<>();
    
    public static void main(String args[]) throws IOException
    {
        ServerSocket ss=new ServerSocket(1111);
        
        while(true)
        {
            Socket soc=ss.accept();
            DataInputStream din=new DataInputStream(soc.getInputStream());
            DataOutputStream dout=new DataOutputStream(soc.getOutputStream());  
                
            String str=(String)din.readUTF();
            Cli cl=new Cli(soc,din,dout,str);
            Thread t=new Thread(cl);
            v.add(cl);
            t.start();
        }
    }
}

class Cli extends s implements Runnable 
{
    Socket soc;
    DataInputStream din;
    DataOutputStream dout;
    String name=new String();
    String in=new String();
    String temp=new String();
    int year,month,day,hour,min,am;
    String pm;
        
    Cli(Socket x,DataInputStream y, DataOutputStream z,String str)
    {
	soc=x;
	din=y;
	dout=z;
        name=str;
    }
    
    public void run()
    {
        Calendar cal = Calendar.getInstance();
        while(true)
        {
            try
            {
                year = cal.get(Calendar.YEAR);
                month = cal.get(Calendar.MONTH);
                day = cal.get(Calendar.DAY_OF_MONTH);
                hour = cal.get(Calendar.HOUR);
                min=cal.get(Calendar.MINUTE);
                am=cal.get(Calendar.AM_PM);
                pm=am==Calendar.AM ? "AM" : "PM";
                
                in=din.readUTF();
		System.out.println(in);
		for(Cli hi:v)
		{
                    hi.dout.writeUTF(in);
                }
                temp="*************************************** "+name+" left at "+hour+":"+min+" "+pm+"  "+day+"/"+month+"/"+year+" ***************************************";
                if(in.equals(temp))
		{
                    v.remove(this);
                    this.soc.close();
                    break;
		}
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        try
        {
            this.din.close();
            this.dout.close();
        }
	catch(IOException e)
	{
            e.printStackTrace();
        }
    }
}